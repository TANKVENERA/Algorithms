package belski.leetcode;

public class MaxSubArray_53 {

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-1, 10, -3}));
    }

    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int currentSum = maxSum;

        for (int i = 1; i < nums.length; i++) {
            currentSum = Math.max(nums[i], nums[i] + currentSum);
            maxSum = Math.max(maxSum, currentSum);

        }
        return maxSum;
    }
}
