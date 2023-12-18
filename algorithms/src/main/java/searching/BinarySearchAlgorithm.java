package searching;

public class BinarySearchAlgorithm {

    public boolean isTargetNumberFound(final int targetNumber, int[] sortedArray) {

        int leftPoint = 0;
        int rightPoint = sortedArray.length - 1;
        int middlePoint = (rightPoint - leftPoint)/2;

        while (sortedArray[middlePoint] != targetNumber) {

            if (leftPoint == rightPoint) {
                return false;
            }

            if (sortedArray[middlePoint] < targetNumber) {
                leftPoint = middlePoint + 1;

            }
            else {
                rightPoint = middlePoint - 1;

            }
            middlePoint = leftPoint + (rightPoint - leftPoint)/2;
        }

        return true;
    }
}
