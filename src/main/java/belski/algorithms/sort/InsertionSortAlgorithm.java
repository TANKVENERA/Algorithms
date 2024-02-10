package belski.algorithms.sort;

public class InsertionSortAlgorithm {

    public int[] sort(int[] arrayTobeSorted) {

        for (int i = 1; i < arrayTobeSorted.length; i++) {
            int keyIndex = i;

            for (int j = i - 1; j >= 0; j--) {
                if (arrayTobeSorted[keyIndex] < arrayTobeSorted[j]) {
                    int temp = arrayTobeSorted[j];
                    arrayTobeSorted[j] = arrayTobeSorted[keyIndex];
                    arrayTobeSorted[keyIndex] = temp;

                    keyIndex = keyIndex - 1;
                }

            }

        }

        return arrayTobeSorted;
    }
}
