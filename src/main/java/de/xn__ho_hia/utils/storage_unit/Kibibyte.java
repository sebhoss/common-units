/*
 * This is free and unencumbered software released into the public domain.
 *
 * Anyone is free to copy, modify, publish, use, compile, sell, or
 * distribute this software, either in source code form or as a compiled
 * binary, for any purpose, commercial or non-commercial, and by any
 * means.
 *
 * In jurisdictions that recognize copyright laws, the author or authors
 * of this software dedicate any and all copyright interest in the
 * software to the public domain. We make this dedication for the benefit
 * of the public at large and to the detriment of our heirs and
 * successors. We intend this dedication to be an overt act of
 * relinquishment in perpetuity of all present and future rights to this
 * software under copyright law.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF
 * MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT.
 * IN NO EVENT SHALL THE AUTHORS BE LIABLE FOR ANY CLAIM, DAMAGES OR
 * OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE,
 * ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 *
 * For more information, please refer to <http://unlicense.org>
 */
package de.xn__ho_hia.utils.storage_unit;

import java.math.BigInteger;

/**
 * Kibibyte as specified in ISO IEC 80000-13:2008 (1 Kibibyte = 1 024 Byte).
 */
public final class Kibibyte extends StorageUnit<Kibibyte> {

    private static final long serialVersionUID = 3798828851496657978L;

    Kibibyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kibibytes contains.
     * @return A new Kibibyte unit with the given value.
     */
    public static Kibibyte valueOf(final BigInteger numberOfBytes) {
        return new Kibibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kibibytes contains.
     * @return A new Kibibyte unit with the given value.
     */
    public static Kibibyte valueOf(final long numberOfBytes) {
        return valueOf(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the kibibytes contains.
     * @return A new Kibibyte unit with the given value.
     */
    public static Kibibyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Kibibyte add(final long bytesToAdd) {
        return new Kibibyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Kibibyte add(final StorageUnit<?> storageAmount) {
        return new Kibibyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Kibibyte divide(final long divisor) {
        return new Kibibyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Kibibyte multiply(final long factor) {
        return new Kibibyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Kibibyte subtract(final long bytesToSubtract) {
        return new Kibibyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Kibibyte subtract(final StorageUnit<?> storageAmount) {
        return new Kibibyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_KIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "KiB"; //$NON-NLS-1$
    }

}