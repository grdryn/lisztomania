/*
 *    Copyright 2014 Gerard Ryan.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package me.grdryn.lisztomania;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.java.quickcheck.Generator;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BalancedSubListTest {

    private static final Logger logger = LoggerFactory
            .getLogger(BalancedSubListTest.class);

    @Test
    public void testHundredPercent() {
        final int percent = 100;
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9);

        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, percent);

        logger.trace("Original: {} :: sublist: {}", originalList, listUnderTest);

        assertEquals(originalList, listUnderTest);
    }

    @Test
    public void testFiftyPercentListSizeGreaterThanTwo() {
        final int percent = 50;

        for (final List<Integer> originalList : someLists(integers(), 2)) {

            final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                    originalList, percent);

            assertFalse("50% sublist should not equal original",
                    originalList.equals(listUnderTest));

            assertEquals(String.format(
                    "Failed with original %s and sublist %s", originalList,
                    listUnderTest),
                    Math.round(originalList.size() / 2.0), listUnderTest.size());
        }
    }

    @Test
    public void testListSizeOne() {
        final Generator<Integer> integerGenerator = integers(1, 100);
        for (final List<Integer> originalList : someLists(integers(), 1, 1)) {
            final int percentage = integerGenerator.next();

            final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                    originalList, percentage);

            assertEquals("Sublist should be 1 when list size is 1", 1,
                    listUnderTest.size());
        }
    }

    @Test
    public void testZeroPercentGivesOne() {
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9);

        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, 0);

        logger.trace("Original: {} :: sublist: {}", originalList, listUnderTest);

        assertEquals(1, listUnderTest.size());
    }

    @Test
    public void testSublistBalancedWhenOriginalListSizeIsEven() {
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9);

        final List<Integer> expectedBalancedList = Arrays.asList(0, 2, 4, 6, 8);

        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, 50);

        assertEquals(expectedBalancedList, listUnderTest);
    }

    @Test
    public void testSublistBalancedWhenOriginalListSizeIsOdd() {
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12);

        final List<Integer> expectedBalancedList = Arrays.asList(0, 2, 4, 6, 8,
                10, 12);

        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, 50);

        assertEquals(expectedBalancedList, listUnderTest);
    }

    @Test
    public void testConstructorWithShiftParam() {
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12);

        final List<Integer> expectedBalancedList = Arrays.asList(1, 3, 5, 7, 9,
                11, 0);

        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, 50, 1);

        assertEquals(expectedBalancedList, listUnderTest);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testEmptyList() {
        final List<Integer> originalList = new ArrayList<>();
        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, 50);

        assertEquals(-1, listUnderTest.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testNegativePercentage() {
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12);
        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, -50);

        assertEquals(-1, listUnderTest.size());
    }

    @Test(expected = IllegalArgumentException.class)
    public void percentageGreaterThan100() {
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9, 10, 11, 12);
        final BalancedPercentageSubList<Integer> listUnderTest = new BalancedPercentageSubList<>(
                originalList, 101);

        assertEquals(-1, listUnderTest.size());
    }
}
