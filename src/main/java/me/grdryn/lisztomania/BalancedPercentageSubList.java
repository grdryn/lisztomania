/*
 *    Copyright 2014 Gerard Ryan
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

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * = BalancedPercentageSubList
 *
 * Use this class to get a {@link List} of elements picked from an existing
 * {@link List}. The chosen elements are evenly spread across `originalList`,
 * with the number of chosen elements decided by the `percentage` parameter to
 * the constructor.
 *
 * For example, using the
 * {@link BalancedPercentageSubList#BalancedPercentageSubList(List, double)
 * first constructor} to get 50% of a {@link List} of 10 Integers would choose
 * every second element from the original List:
 *
 * [source,java]
 * --
 *
 * import java.util.List;
 * import me.grdryn.lisztomania.BalancedPercentageSubList;
 *
 * class MyClass {
 *
 *     public static void main(String[] args) {
 *         List<Integer> tenInts = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
 *         List<Integer> fiveInts = new BalancedPercentageSubList<>(tenInts, 50);
 *
 *         assert Arrays.asList(0, 2, 4, 6, 8) == fiveInts;
 *     }
 * }
 *
 * --
 *
 * == Specifying a shift/offset
 *
 * Alternatively, the
 * {@link BalancedPercentageSubList#BalancedPercentageSubList(List, double, int)
 * second constructor} can be used, where the third parameter `shift`, can be
 * specified. This parameter is used to get a different `percentage` of the
 * elements of the `originalList`.
 *
 * Adding a `shift` of 1 to the above example, would yield a List of the same
 * length, but would start at the second element:
 *
 * [source,java]
 * --
 *
 * import java.util.List;
 * import me.grdryn.lisztomania.BalancedPercentageSubList;
 *
 * class MyClass {
 *
 *     public static void main(String[] args) {
 *         List<Integer> tenInts = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
 *         List<Integer> fiveInts = new BalancedPercentageSubList<>(tenInts, 50, 1);
 *
 *         assert Arrays.asList(1, 3, 5, 7, 9) == fiveInts;
 *     }
 * }
 *
 * --
 *
 * @author Gerard Ryan
 */
public class BalancedPercentageSubList<E> extends AbstractPercentageSubList<E> {

    /**
     * Creates an instance from a `percentage` of the `originalList`.
     *
     * In the context of the
     * {@link BalancedPercentageSubList#BalancedPercentageSubList(List, double, int)
     * second constructor}, the `shift` is 0 here.
     *
     * @param originalList
     *            The {@link List} to choose elements from
     * @param percentage
     *            The percentage of elements from `originalList` to choose
     */
    public BalancedPercentageSubList(final List<E> originalList, final double percentage) {
        this(originalList, percentage, 0);
    }

    /**
     * Creates an instance from a `percentage` of `originalList` offset by
     * `shift`.
     *
     * The `shift` parameter is used to decide what element of `originalList` to
     * start picking from. This allows to get an offset sublist of elements.
     *
     * If, based on the `shift` parameter, and the percentage of elements to
     * choose, the end of the List is reached, it will wrap around to the
     * beginning again.
     *
     * @param originalList
     *            The {@link List} to choose elements from
     * @param percentage
     *            The percentage of elements from `originalList` to choose
     * @param shift
     *            What position of `originalList` to start choosing elements
     *            from
     */
    public BalancedPercentageSubList(final List<E> originalList, final double percentage,
            final int shift) {

        super(originalList, percentage);

        final List<E> shiftedList = new ArrayList<>(originalList);
        Collections.rotate(shiftedList, -shift);

        populateBackingList(shiftedList, percentage);
    }

    private void populateBackingList(final List<E> inList,
            final double percentage) {

        int i = 0;
        int indexOfInList = 0;

        while (backingList.size() < percentageSize) {
            backingList.add(inList.get(indexOfInList));
            indexOfInList = (int) Math.round((1 / (percentage / 100.0)) * ++i);
        }
    }
}
