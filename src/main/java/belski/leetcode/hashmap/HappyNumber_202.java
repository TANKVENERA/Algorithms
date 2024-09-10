package belski.leetcode.hashmap;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber_202 {

    public static boolean isHappy(int n) {
        int powSum = 0;
        Set<Integer> set = new HashSet<>();

        while (true) {
            powSum = 0;
            while (n > 0) {
                int digit = n % 10;
                powSum = powSum + (digit * digit);
                n = n / 10;
            }
            if (set.contains(powSum)) {
                return false;
            }
            if (powSum == 1) {
                return true;
            }
            set.add(powSum);
            n = powSum;

        }
    }

    public static void main(String[] args) {
        System.out.println(isHappy(5439));
    }
}
