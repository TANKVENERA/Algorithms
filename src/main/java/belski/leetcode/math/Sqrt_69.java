package belski.leetcode.math;

public class Sqrt_69 {

    public static int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int left = 1;
        int right = x;

        while (left <= right) {
            int  middle = left + (right - left) / 2;

            if (middle * middle == x){
                return middle;
            }
            else if ((long)middle * middle > x) {
                right = middle - 1;
            }
            else {
                left = middle + 1;
            }


        }
        return right;
    }

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
