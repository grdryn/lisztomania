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
import java.util.List;
import java.util.Random;

/**
 * = RandomPercentageSubList
 *
 * Use this class to get a {@link List} of elements picked from an existing
 * {@link List}. The chosen elements are randomly selected from `originalList`,
 * with the number of chosen elements decided by the `percentage` parameter to
 * the {@link RandomPercentageSubList#RandomPercentageSubList(List, double)
 * constructor}.
 *
 * For example, choosing to get 40% from a {@link List} of 10 elements would
 * produce a {@link List} of 4 elements, each chosen from the `originalList`:
 *
 * [source,java]
 * --
 *
 * import java.util.List;
 * import me.grdryn.lisztomania.RandomPercentageSubList;
 *
 * class MyClass {
 *
 *     public static void main(String[] args) {
 *         List<Integer> tenItems = Arrays.asList(34, -5, 7, 2, 1, 0, 57, -1, 3, 10);
 *         List<Integer> fiveAtRandom = new RandomPercentageSubList<>(tenItems, 40);
 *
 *         assert fiveAtRandom.size() == 5;
 *
 *         for (Integer item : fiveAtRandom) {
 *             assert tenItems.contains(item);
 *         }
 *     }
 * }
 *
 * --
 *
 * @author Gerard Ryan
 */
public class RandomPercentageSubList<E> extends AbstractPercentageSubList<E> {

    /**
     * Creates a List of elements from `originalList` at random, of `percentage`
     * percent of the `originalList.
     *
     * @param originalList
     *            The {@link List} to choose elements from
     * @param percentage
     *            The percentage of elements from `originalList` to choose
     */
    public RandomPercentageSubList(final List<E> originalList,
            final double percentage) {

        super(originalList, percentage);

        populateBackingList(originalList, percentage);

    }

    private void populateBackingList(final List<E> inList,
            final double percentage) {

        final Random random = new Random();

        final ArrayList<E> temp = new ArrayList<>(inList);
        while (backingList.size() < percentageSize) {
            backingList.add(temp.remove(random.nextInt(temp.size())));
        }
    }
}
