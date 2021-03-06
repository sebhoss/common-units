/*
 * This file is part of storage-units. It is subject to the license terms in the LICENSE file found in the top-level
 * directory of this distribution and at http://creativecommons.org/publicdomain/zero/1.0/. No part of storage-units,
 * including this file, may be copied, modified, propagated, or distributed except according to the terms contained
 * in the LICENSE file.
 */
package de.xn__ho_hia.storage_unit;

import static de.xn__ho_hia.quality.null_analysis.Nullsafe.addNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.asBigInteger;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.divideNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.multiplyNullsafe;
import static de.xn__ho_hia.quality.null_analysis.Nullsafe.subtractNullsafe;

import java.math.BigInteger;
import java.util.function.Function;

import org.eclipse.jdt.annotation.NonNull;

/**
 * Gibibyte as specified in ISO IEC 80000-13:2008 (1 Gibibyte = 1 073 741 824 Byte).
 */
public final class Gibibyte extends StorageUnit<Gibibyte> {

    private static final long serialVersionUID = -1104749948510944566L;

    Gibibyte(@NonNull final BigInteger bytes) {
        super(bytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Gibibyte contains.
     * @return A new Gibibyte unit with the given value.
     */
    @NonNull
    public static Gibibyte valueOf(@NonNull final BigInteger numberOfBytes) {
        return new Gibibyte(numberOfBytes);
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Gibibyte contains.
     * @return A new Gibibyte unit with the given value.
     */
    @NonNull
    public static Gibibyte valueOf(final long numberOfBytes) {
        return new Gibibyte(asBigInteger(numberOfBytes));
    }

    /**
     * @param numberOfBytes
     *            The amount of bytes the Gibibyte contains.
     * @return A new Gibibyte unit with the given value.
     */
    @NonNull
    public static Gibibyte valueOf(@NonNull final Long numberOfBytes) {
        return valueOf(numberOfBytes.longValue());
    }

    @Override
    public Gibibyte add(final long bytesToAdd) {
        return new Gibibyte(addNullsafe(bytes, asBigInteger(bytesToAdd)));
    }

    @Override
    public Gibibyte add(final StorageUnit<?> storageAmount) {
        return new Gibibyte(addNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    public Gibibyte divide(final long divisor) {
        return new Gibibyte(divideNullsafe(bytes, asBigInteger(divisor)));
    }

    @Override
    public Gibibyte multiply(final long factor) {
        return new Gibibyte(multiplyNullsafe(bytes, asBigInteger(factor)));
    }

    @Override
    public Gibibyte subtract(final long bytesToSubtract) {
        return new Gibibyte(subtractNullsafe(bytes, asBigInteger(bytesToSubtract)));
    }

    @Override
    public Gibibyte subtract(final StorageUnit<?> storageAmount) {
        return new Gibibyte(subtractNullsafe(bytes, storageAmount.bytes));
    }

    @Override
    protected BigInteger getNumberOfBytesPerUnit() {
        return StorageUnit.BYTES_IN_A_GIBIBYTE;
    }

    @Override
    protected String getSymbol() {
        return "GiB"; //$NON-NLS-1$
    }

    @Override
    protected Function<@NonNull BigInteger, @NonNull StorageUnit<?>> converter() {
        return StorageUnits::binaryValueOf;
    }

}
