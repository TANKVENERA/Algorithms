package belski.algorithms.sort;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SelectionSortAlgorithmTest {

    private static final int[] ARRAY_TO_BE_SORTED = { 3, 1, 4, 2, 5, 5, 5, 5 };
    private static final int[] EXPECTED = { 5, 5, 5, 5, 4, 3, 2, 1 };

    final SelectionSortAlgorithm selectionSortAlgorithm = new SelectionSortAlgorithm();

    @Test
    public void shouldSort() {
        final int[] actual = selectionSortAlgorithm.sortInDescendingOrder(ARRAY_TO_BE_SORTED);
        Assertions.assertArrayEquals(EXPECTED, actual);
    }
}
