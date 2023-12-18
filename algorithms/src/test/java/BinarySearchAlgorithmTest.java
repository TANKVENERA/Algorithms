import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import searching.BinarySearchAlgorithm;

public class BinarySearchAlgorithmTest {
    private static final int[] SORTED_ARRAY = { 1, 2, 3, 5, 7, 11, 22, 33, 55, 56 };

    final BinarySearchAlgorithm binarySearchAlgorithm = new BinarySearchAlgorithm();

    @Test
    public void shouldFindNumber_1() {

        final boolean actual = binarySearchAlgorithm.isTargetNumberFound(1, SORTED_ARRAY);

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindNumber_22() {

        final boolean actual = binarySearchAlgorithm.isTargetNumberFound(22, SORTED_ARRAY);

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldFindNumber_56() {

        final boolean actual = binarySearchAlgorithm.isTargetNumberFound(56, SORTED_ARRAY);

        Assertions.assertTrue(actual);
    }

    @Test
    public void shouldNotFindNumber_0() {

        final boolean actual = binarySearchAlgorithm.isTargetNumberFound(1, SORTED_ARRAY);

        Assertions.assertFalse(actual);
    }

    @Test
    public void shouldNotFindNumber_57() {

        final boolean actual = binarySearchAlgorithm.isTargetNumberFound(1, SORTED_ARRAY);

        Assertions.assertFalse(actual);
    }
}
