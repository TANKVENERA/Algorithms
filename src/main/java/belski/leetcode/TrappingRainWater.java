package belski.leetcode;

import java.time.LocalDate;

public class TrappingRainWater {
    public static void main(String[] args) throws InterruptedException {

        final LocalDate date_1 = LocalDate.of(2025, 0, 2);

        int[] arr_1 = new int[] { 3, 0, 0, 2 };
        int[] arr_2 = new int[] { 4, 2, 3 };
        int[] arr_3 = new int[] { 4, 2, 0, 3, 2, 5 };
        int[] arr_4 = new int[] { 3, 2, 5, 4 };
        int[] arr_5 = new int[] { 7, 1, 4, 6 };
        int[] arr_6 = new int[] { 6, 8, 5, 0, 0, 6, 5 };
        System.out.println(trap(arr_1));
        Thread.sleep(2);
        System.out.println(trap(arr_2));
        Thread.sleep(2);
        System.out.println(trap(arr_3));
        Thread.sleep(2);
        System.out.println(trap(arr_4));
        Thread.sleep(2);
        System.out.println(trap_v2(arr_1));
        Thread.sleep(2);
        System.out.println(trap(arr_5));
        System.out.println(trap(arr_6));

    }

    public static int trap(int[] height) {
        int leftEdge = 0;
        int totalWater = 0;
        int possibleWater = 0;
        for (int i = 0; i < height.length; i++) {

            if (height[i] < leftEdge) {
                possibleWater = possibleWater + (leftEdge - height[i]);

                int collectedWater = 0;
                for (int j = i - 1; height[i] > height[j]; j--) {
                    collectedWater = collectedWater + (height[i] - height[j]);
                    height[j] = height[i];
                }
                possibleWater = possibleWater - collectedWater;
                totalWater = totalWater + collectedWater;

            } else if (height[i] >= leftEdge) {
                totalWater = totalWater + possibleWater;
                possibleWater = 0;
                leftEdge = height[i];
            }
        }

        return totalWater;
    }

    public static int trap_v2(int[] height) {

        int answer = 0;
        int left = 0;
        int right = height.length - 1;
        int leftMax = height[left];
        int rightMax = height[right];
        while (left < right) {

            if (leftMax < rightMax) {
                left++;
                leftMax = Math.max(leftMax, height[left]);
                answer += leftMax - height[left];
            } else {
                right--;
                rightMax = Math.max(rightMax, height[right]);
                answer += rightMax - height[right];
            }
        }

        return answer;
    }
}
