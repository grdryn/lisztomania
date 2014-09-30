package me.grdryn.lisztomania;

import static net.java.quickcheck.generator.CombinedGeneratorsIterables.someLists;
import static net.java.quickcheck.generator.PrimitiveGenerators.doubles;
import static net.java.quickcheck.generator.PrimitiveGenerators.integers;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.greaterThanOrEqualTo;
import static org.hamcrest.Matchers.isIn;

import java.util.List;

import org.junit.Test;

public class RandomPercentageSubListTest {

    @Test
    public void testRandomPercentageSubList() {

        for (final List<Integer> originalList : someLists(integers(), 2)) {

            final double percentage = doubles(0.0, 100.0).next();

            final List<Integer> listUnderTest = new RandomPercentageSubList<>(
                    originalList, percentage);

            assertThat(originalList.size(),
                    greaterThanOrEqualTo(listUnderTest.size()));

            for (final int elem : listUnderTest) {
                assertThat(elem, isIn(originalList));
            }
        }
    }

}
