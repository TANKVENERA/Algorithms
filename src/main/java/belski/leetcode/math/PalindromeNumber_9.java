package belski.leetcode.math;

import java.util.ArrayList;
import java.util.List;

public class PalindromeNumber_9 {

    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        List<Integer> list = new ArrayList<>();

        while (x > 0) {
            int digit = x % 10;
            list.add(digit);
            x = x / 10;
        }

        for (int i = 0; i < list.size() / 2; i++) {
            int firstDigit = list.get(i);
            int scndDigit = list.get(list.size() - i - 1);
            if (firstDigit != scndDigit) {
                return false;
            }
        }
        return true;
    }

    public static boolean isPalindromeV2(int x) {
        int original = x;
        int palindrome = 0;
        int decimalPlace = 10;

        while (x > 0) {
            palindrome = decimalPlace * palindrome + x % 10;
            x = x / 10;
        }

        return original == palindrome;
    }

    public static void main(String[] args) {
        System.out.println(isPalindromeV2(584));
    }
}
