package me.grdryn.lisztomania;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BalancedSubListTest {

    @Test
    public void testHundredPercent() {
        final int percent = 100;
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9);

        final BalancedSubList<Integer> listUnderTest = new BalancedSubList<>(
                originalList, percent);

        System.out.println("Sublist: " + listUnderTest);
        assertEquals(originalList, listUnderTest);
    }

    @Test
    public void testFiftyPercentListSizeGreaterThanTwo() {
        final int percent = 50;

        for (final List<Integer> originalList : someLists(integers(), 2)) {

            final BalancedSubList<Integer> listUnderTest = new BalancedSubList<>(
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
    public void testZeroPercentGivesOne() {
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9);

        final BalancedSubList<Integer> listUnderTest = new BalancedSubList<>(
                originalList, 0);
        System.out.println("Sublist: " + listUnderTest);
        assertEquals(1, listUnderTest.size());
    }

}
