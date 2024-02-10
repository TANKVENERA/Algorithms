package belski.algorithms.sort;

public class SelectionSortAlgorithm {

    public int[] sortInDecreaseOrder(int[] arrayToBeSorted) {
        for (int i = 0; i < arrayToBeSorted.length; i++) {

            int biggestItemIndex = i;

            for (int j = i + 1; j < arrayToBeSorted.length; j++) {
                if (arrayToBeSorted[biggestItemIndex] < arrayToBeSorted[j]) {
                    biggestItemIndex = j;
                }
            }

            int temp = arrayToBeSorted[i];
            arrayToBeSorted[i] = arrayToBeSorted[biggestItemIndex];
            arrayToBeSorted[biggestItemIndex] = temp;
        }

        return arrayToBeSorted;
    }
}
