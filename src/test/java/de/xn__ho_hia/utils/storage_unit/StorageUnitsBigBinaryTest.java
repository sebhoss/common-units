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

import org.junit.Assert;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import de.xn__ho_hia.utils.storage_unit.Exbibyte;
import de.xn__ho_hia.utils.storage_unit.Gibibyte;
import de.xn__ho_hia.utils.storage_unit.Kibibyte;
import de.xn__ho_hia.utils.storage_unit.Mebibyte;
import de.xn__ho_hia.utils.storage_unit.Pebibyte;
import de.xn__ho_hia.utils.storage_unit.StorageUnit;
import de.xn__ho_hia.utils.storage_unit.StorageUnits;
import de.xn__ho_hia.utils.storage_unit.Tebibyte;
import de.xn__ho_hia.utils.storage_unit.Yobibyte;
import de.xn__ho_hia.utils.storage_unit.Zebibyte;

/**
*
*
*/
@RunWith(Theories.class)
public class StorageUnitsBigBinaryTest {

    private static final BigInteger MULTIPLIER = BigInteger.valueOf(1024);

    /**
     *
     */
    @DataPoints
    public static Object[][] INPUT_RESULTS = {
            { BigInteger.ONE, Kibibyte.class },
            { MULTIPLIER, Kibibyte.class },
            { MULTIPLIER.pow(2), Mebibyte.class },
            { MULTIPLIER.pow(3), Gibibyte.class },
            { MULTIPLIER.pow(4), Tebibyte.class },
            { MULTIPLIER.pow(5), Pebibyte.class },
            { MULTIPLIER.pow(6), Exbibyte.class },
            { MULTIPLIER.pow(7), Zebibyte.class },
            { MULTIPLIER.pow(8), Yobibyte.class },
            { MULTIPLIER.pow(9), Yobibyte.class },
    };

    /**
     * @param input
     *            The number of bytes to wrap + the expected return class.
     */
    @SuppressWarnings({ "nls", "static-method", "unchecked" })
    @Theory
    public void shouldCreateCorrectBinaryUnit(final Object[] input) {
        // Given
        final BigInteger bytes = (BigInteger) input[0];
        final Class<? extends StorageUnit<?>> expectedClass = (Class<? extends StorageUnit<?>>) input[1];

        // When
        final StorageUnit<?> unit = StorageUnits.binaryValueOf(bytes);

        // Then
        Assert.assertEquals(
                bytes + " should result in " + expectedClass.getSimpleName() + " but got "
                        + unit.getClass().getSimpleName(),
                expectedClass, unit.getClass());
    }

}