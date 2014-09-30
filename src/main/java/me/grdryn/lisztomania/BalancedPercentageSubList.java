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

public class BalancedPercentageSubList<E> extends AbstractPercentageSubList<E> {

    public BalancedPercentageSubList(final List<E> originalList, final double percentage) {
        this(originalList, percentage, 0);
    }

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
