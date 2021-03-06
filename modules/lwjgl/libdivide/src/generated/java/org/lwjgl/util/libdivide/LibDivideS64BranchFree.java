/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.util.libdivide;

import javax.annotation.*;

import java.nio.*;

import org.lwjgl.*;
import org.lwjgl.system.*;

import static org.lwjgl.system.MemoryUtil.*;
import static org.lwjgl.system.MemoryStack.*;

/**
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct libdivide_s64_branchfree_t {
 *     int64_t magic;
 *     uint8_t more;
 * }</code></pre>
 */
@NativeType("struct libdivide_s64_branchfree_t")
public class LibDivideS64BranchFree extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        MAGIC,
        MORE;

    static {
        Layout layout = __struct(
            __member(8),
            __member(1)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        MAGIC = layout.offsetof(0);
        MORE = layout.offsetof(1);
    }

    /**
     * Creates a {@link LibDivideS64BranchFree} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public LibDivideS64BranchFree(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** Returns the value of the {@code magic} field. */
    @NativeType("int64_t")
    public long magic() { return nmagic(address()); }
    /** Returns the value of the {@code more} field. */
    @NativeType("uint8_t")
    public byte more() { return nmore(address()); }

    // -----------------------------------

    /** Returns a new {@link LibDivideS64BranchFree} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static LibDivideS64BranchFree malloc() {
        return wrap(LibDivideS64BranchFree.class, nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@link LibDivideS64BranchFree} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static LibDivideS64BranchFree calloc() {
        return wrap(LibDivideS64BranchFree.class, nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@link LibDivideS64BranchFree} instance allocated with {@link BufferUtils}. */
    public static LibDivideS64BranchFree create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return wrap(LibDivideS64BranchFree.class, memAddress(container), container);
    }

    /** Returns a new {@link LibDivideS64BranchFree} instance for the specified memory address. */
    public static LibDivideS64BranchFree create(long address) {
        return wrap(LibDivideS64BranchFree.class, address);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static LibDivideS64BranchFree createSafe(long address) {
        return address == NULL ? null : wrap(LibDivideS64BranchFree.class, address);
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree.Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer malloc(int capacity) {
        return wrap(Buffer.class, nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree.Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer calloc(int capacity) {
        return wrap(Buffer.class, nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree.Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return wrap(Buffer.class, memAddress(container), capacity, container);
    }

    /**
     * Create a {@link LibDivideS64BranchFree.Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer create(long address, int capacity) {
        return wrap(Buffer.class, address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static LibDivideS64BranchFree.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : wrap(Buffer.class, address, capacity);
    }

    // -----------------------------------

    /** Returns a new {@link LibDivideS64BranchFree} instance allocated on the thread-local {@link MemoryStack}. */
    public static LibDivideS64BranchFree mallocStack() {
        return mallocStack(stackGet());
    }

    /** Returns a new {@link LibDivideS64BranchFree} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero. */
    public static LibDivideS64BranchFree callocStack() {
        return callocStack(stackGet());
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static LibDivideS64BranchFree mallocStack(MemoryStack stack) {
        return wrap(LibDivideS64BranchFree.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static LibDivideS64BranchFree callocStack(MemoryStack stack) {
        return wrap(LibDivideS64BranchFree.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree.Buffer} instance allocated on the thread-local {@link MemoryStack}.
     *
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer mallocStack(int capacity) {
        return mallocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree.Buffer} instance allocated on the thread-local {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer callocStack(int capacity) {
        return callocStack(capacity, stackGet());
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree.Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer mallocStack(int capacity, MemoryStack stack) {
        return wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link LibDivideS64BranchFree.Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static LibDivideS64BranchFree.Buffer callocStack(int capacity, MemoryStack stack) {
        return wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #magic}. */
    public static long nmagic(long struct) { return UNSAFE.getLong(null, struct + LibDivideS64BranchFree.MAGIC); }
    /** Unsafe version of {@link #more}. */
    public static byte nmore(long struct) { return UNSAFE.getByte(null, struct + LibDivideS64BranchFree.MORE); }

    // -----------------------------------

    /** An array of {@link LibDivideS64BranchFree} structs. */
    public static class Buffer extends StructBuffer<LibDivideS64BranchFree, Buffer> implements NativeResource {

        private static final LibDivideS64BranchFree ELEMENT_FACTORY = LibDivideS64BranchFree.create(-1L);

        /**
         * Creates a new {@link LibDivideS64BranchFree.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link LibDivideS64BranchFree#SIZEOF}, and its mark will be undefined.
         *
         * <p>The created buffer instance holds a strong reference to the container object.</p>
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected LibDivideS64BranchFree getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** Returns the value of the {@code magic} field. */
        @NativeType("int64_t")
        public long magic() { return LibDivideS64BranchFree.nmagic(address()); }
        /** Returns the value of the {@code more} field. */
        @NativeType("uint8_t")
        public byte more() { return LibDivideS64BranchFree.nmore(address()); }

    }

}