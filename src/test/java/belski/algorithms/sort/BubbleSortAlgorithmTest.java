package belski.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BubbleSortAlgorithmTest {
    private static final int[] ARRAY_TO_BE_SORTED = { 3, 1, 4, 2, 0 };
    private static final int[] EXPECTED = { 0, 1, 2, 3, 4 };

    final BubbleSortAlgorithm bubbleSortAlgorithm = new BubbleSortAlgorithm();

    @Test
    public void shouldSort() {
        final int[] actual = bubbleSortAlgorithm.sort(ARRAY_TO_BE_SORTED);
        Assertions.assertArrayEquals(EXPECTED, actual);
    }
}
