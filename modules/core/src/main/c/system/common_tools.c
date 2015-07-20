/*
 * Copyright LWJGL. All rights reserved.
 * License terms: http://lwjgl.org/license.php
 */
#include "common_tools.h"

JavaVM *jvm;

inline JNIEnv *getThreadEnv(void) {
	JNIEnv *env;
	(*jvm)->GetEnv(jvm, (void **)&env, JNI_VERSION_1_6);
	return env;
}

inline JNIEnv *attachCurrentThreadAsDaemon(void) {
    JNIEnv *env;
    (*jvm)->AttachCurrentThreadAsDaemon(jvm, (void **)&env, NULL);
    if ( env == NULL ) {
        fprintf(stderr, "[LWJGL] Failed to attach native thread to the JVM.");
        exit(1);
    }
    return env;
}

inline JNIEnv *attachCurrentThread(void) {
    JNIEnv *env;
    (*jvm)->AttachCurrentThread(jvm, (void **)&env, NULL);
    if ( env == NULL ) {
        fprintf(stderr, "[LWJGL] Failed to attach native thread to the JVM.");
        exit(1);
    }
    return env;
}

inline void detachCurrentThread(void) {
	if ( (*jvm)->DetachCurrentThread(jvm) != JNI_OK ) {
		fprintf(stderr, "[LWJGL] Failed to detach native thread from the JVM.");
		fflush(stderr);
	}
}

// Put JNIEnv in thread-local storage. getEnv() is ~2x faster than getThreadEnv().

// If getThreadEnv() returns NULL, getEnv() has been called in a foreign thread that must attach to the JVM to access JNI. Such threads are detached
// automatically using DllMain notifications (on Windows) or a pthread destructor (on Linux/OSX).

#ifdef LWJGL_WINDOWS
	#include <WindowsLWJGL.h>
	DWORD envTLS = TLS_OUT_OF_INDEXES;

	BOOL WINAPI DllMain(HINSTANCE hDLL, DWORD fdwReason, LPVOID lpvReserved) {
		UNUSED_PARAMS(hDLL, lpvReserved)
		if ( fdwReason == DLL_THREAD_DETACH && getThreadEnv() != NULL )
			detachCurrentThread();
		return TRUE;
	}

	static inline void envTLSInit(void) {
		envTLS = TlsAlloc();
		if ( envTLS == TLS_OUT_OF_INDEXES )
			fprintf(stderr, "Failed to allocate TLS for JNIEnv.");
	}

	static inline void envTLSDestroy(void) {
		TlsFree(envTLS);
	}

	JNIEnv* envTLSGet(void) {
		JNIEnv* env = getThreadEnv();
    	if ( env == NULL )
    	    env = attachCurrentThreadAsDaemon();

		TlsSetValue(envTLS, (LPVOID)env);
		return env;
	}

	inline JNIEnv* getEnv(void) {
		JNIEnv* env = (JNIEnv*)TlsGetValue(envTLS);
		if ( env == NULL )
			env = envTLSGet();
		return env;
	}
#else
	#include <pthread.h>
	pthread_key_t envTLS = 0;

	static void autoDetach(void* value) {
		UNUSED_PARAM(value)
		if ( getThreadEnv() != NULL )
            detachCurrentThread();
	}

	static inline void envTLSInit(void) {
		if ( pthread_key_create(&envTLS, autoDetach) != 0 )
			fprintf(stderr, "Failed to allocate TLS for JNIEnv.");
	}

	static inline void envTLSDestroy(void) {
		if ( envTLS ) {
			pthread_key_delete(envTLS);
			envTLS = 0;
		}
	}

	JNIEnv* envTLSGet(void) {
		JNIEnv* env = getThreadEnv();
    	if ( env == NULL )
            env = attachCurrentThreadAsDaemon();

    	pthread_setspecific(envTLS, env);
    	return env;
	}

	inline JNIEnv* getEnv(void) {
		JNIEnv* env = (JNIEnv*)pthread_getspecific(envTLS);
		if ( env == NULL )
			env = envTLSGet();
		return env;
	}
#endif

EXTERN_C_ENTER

JNIEXPORT jint JNICALL JNI_OnLoad(JavaVM *vm, void *reserved) {
	UNUSED_PARAM(reserved)

	jvm = vm;

    envTLSInit();
    return JNI_VERSION_1_6;
}

JNIEXPORT void JNICALL JNI_OnUnload(JavaVM *vm, void *reserved) {
	UNUSED_PARAMS(vm, reserved);
	envTLSDestroy();
}

EXTERN_C_EXIT