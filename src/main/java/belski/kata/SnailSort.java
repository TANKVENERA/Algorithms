package belski.kata;

public class SnailSort {
    public static int[] snail(int[][] array) {

        System.out.println(array[0].length);

        for (int i = 0; i < array[0].length; i++) {

        }

//        rotateMatrix(array[][])

         return   new int[3];
    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 7},
                {3, 6},
                {4, 5}
        };
        int totalLength = arr.length * arr[0].length;
        int counter = 0;
        int[] result = new int[arr.length * arr[0].length];
//        while (totalLength != counter) {
//            for (int i = 0; i < ; i++) {
//
//            }
//        }


          int[][] rotated = rotateMatrix(arr);
        System.out.println("###################");
        for (int i = 0; i < rotated.length; i++) {
            for (int j = 0; j <  rotated[0].length; j++) {
                System.out.print(rotated[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] rotateMatrix(int[][] income) {
        int[][] outcome = new int[income[0].length][income.length];
        for (int j = 0; j < income[0].length; j++) {
            for (int i = 0; i < income.length; i++) {
                outcome[j][i] = income[i][income[0].length -1 - j];
            }
        }

        return outcome;
    }
}
