package belski.algorithms.sort;

public class BubbleSortAlgorithm {

    public int[] sort(int[] arrayTobeSorted) {

        int i, j, temp;

        for (i = 0; i < arrayTobeSorted.length - 1; i++) {

            for (j = 0; j < arrayTobeSorted.length - i - 1; j++) {

                if (arrayTobeSorted[j] > arrayTobeSorted[j + 1]) {
                    temp = arrayTobeSorted[j];
                    arrayTobeSorted[j] = arrayTobeSorted[j + 1];
                    arrayTobeSorted[j + 1] = temp;
                }
            }
        }
        return arrayTobeSorted;
    }
}
