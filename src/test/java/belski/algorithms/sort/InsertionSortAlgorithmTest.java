package belski.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class InsertionSortAlgorithmTest {
    private static final int[] ARRAY_TO_BE_SORTED = { 12, 11, 13, 5, 6 };
    private static final int[] EXPECTED = { 5, 6, 11, 12, 13 };

    final InsertionSortAlgorithm insertionSortAlgorithm = new InsertionSortAlgorithm();

    @Test
    public void shouldSort() {
        final int[] actual = insertionSortAlgorithm.sort(ARRAY_TO_BE_SORTED);
        Assertions.assertArrayEquals(EXPECTED, actual);
    }
}
