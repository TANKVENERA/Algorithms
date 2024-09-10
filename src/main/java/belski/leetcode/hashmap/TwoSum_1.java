package belski.leetcode.hashmap;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum_1 {
    public static int[] twoSum(int[] nums, int target) {
        final HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        int[] res = new int[2];
        for (int firstIndex = 0; firstIndex < nums.length; firstIndex++) {
            int x = target - nums[firstIndex];
            Integer scndIndex = map.get(x);
            if (scndIndex != null && firstIndex != scndIndex) {
                res[0] = firstIndex;
                res[1] = scndIndex;
               break;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{5, 4, 3,2,7}, 6)));
    }
}
