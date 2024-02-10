package belski.algorithms.sort;

import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TreeSortAlgorithmTest {

    private static final int[] ARRAY_TO_BE_SORTED = { 6, 4, 5, 3 };
    private static final List<Integer> EXPECTED = List.of(3, 4, 5, 6);

    final TreeSortAlgorithm treeSortAlgorithm = new TreeSortAlgorithm();

    @Test
    public void shouldSort() {

        treeSortAlgorithm.insertToPresortingOrder(ARRAY_TO_BE_SORTED);
        treeSortAlgorithm.recordInAscendingOrder(treeSortAlgorithm.root);
        Assertions.assertEquals(EXPECTED, treeSortAlgorithm.result);
    }

}
