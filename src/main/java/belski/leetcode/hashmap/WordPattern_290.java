package belski.leetcode.hashmap;

import java.util.HashMap;
import java.util.Map;

public class WordPattern_290 {

    public static boolean wordPattern(String pattern, String s) {
        final String[] arr = s.split(" ");
        final char[] patternArr = pattern.toCharArray();
        final Map<String, String> map = new HashMap<>();

        if (patternArr.length != arr.length) {
            return false;
        }

        for (int i = 0; i < arr.length; i++) {
            final String currentWord = arr[i];
            final String currentLetter = String.valueOf(patternArr[i]);
            final boolean containsLetter = map.containsKey(currentLetter);

            if (containsLetter && map.get(currentLetter).equals(currentWord) ||
                    !containsLetter && !map.containsValue(currentWord)) {
                map.put(currentLetter, currentWord);
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(wordPattern("abba", "dog dog dog dog"));
    }
}
