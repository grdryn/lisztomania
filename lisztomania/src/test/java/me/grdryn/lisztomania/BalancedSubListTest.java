package me.grdryn.lisztomania;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class BalancedSubListTest {

    @Test
    public void testHundredPercent() {
        final int percent = 100;
        final List<Integer> originalList = Arrays.asList(0, 1, 2, 3, 4, 5, 6,
                7, 8, 9);

        final BalancedSubList<Integer> listUnderTest = new BalancedSubList<Integer>(
                originalList, percent);

        assertEquals(originalList, listUnderTest);
    }

}
