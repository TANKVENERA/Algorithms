package belski.leetcode;

import java.util.Stack;

public class ValidParentheses_20 {

    public static void main(String[] args) {
        System.out.println(isValid("]"));
    }

    public static boolean isValid(String s) {
        char[] income = s.toCharArray();

        final Stack<Character> toCheck = new Stack<>();

        for (int i = 0; i < income.length; i++) {
            if (income[i] == '(' || income[i] == '{' || income[i] == '[') {
                toCheck.push(income[i]);
            }
            else if (!toCheck.isEmpty() && (toCheck.peek() == '(' && income[i] == ')' ||
                    toCheck.peek() == '{' && income[i] == '}' ||
                    toCheck.peek() == '[' && income[i] == ']')) {
                toCheck.pop();
            }
            else {
                return false;
            }
        }
        return toCheck.isEmpty();
    }
}
