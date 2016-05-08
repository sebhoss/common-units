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
 * Yottabyte as specified in ISO IEC 80000-13:2008 (1 Yottabyte = 1 000 000 000 000 000 000 000 000 Byte).
 */
public class Yottabyte extends StorageUnit<Yottabyte> {

    private static final long serialVersionUID = 2482152459842042316L;

    Yottabyte(final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabyte contains.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte valueOf(final BigInteger numberOfBytes) {
        return new Yottabyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabytes contains.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte valueOf(final long numberOfBytes) {
        return new Yottabyte(BigInteger.valueOf(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the yottabytes contains.
     * @return A new Yottabyte unit with the given value.
     */
    public static Yottabyte valueOf(final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Yottabyte add(final long bytesToAdd) {
        return new Yottabyte(bytes.add(BigInteger.valueOf(bytesToAdd)));
    }

    @Override
    public Yottabyte add(final StorageUnit<?> storageAmount) {
        return new Yottabyte(bytes.add(storageAmount.bytes));
    }

    @Override
    public Yottabyte divide(final long divisor) {
        return new Yottabyte(bytes.divide(BigInteger.valueOf(divisor)));
    }

    @Override
    public Yottabyte multiply(final long factor) {
        return new Yottabyte(bytes.multiply(BigInteger.valueOf(factor)));
    }

    @Override
    public Yottabyte subtract(final long bytesToSubtract) {
        return new Yottabyte(bytes.subtract(BigInteger.valueOf(bytesToSubtract)));
    }

    @Override
    public Yottabyte subtract(final StorageUnit<?> storageAmount) {
        return new Yottabyte(bytes.subtract(storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_YOTTABYTE;
    }

    @Override
    protected String getSymbol() {
        return "YB"; //$NON-NLS-1$
    }

}