package belski.leetcode.hashmap;

import java.util.HashMap;

public class RansomNote_383 {

    public boolean canConstructV1(String ransomNote, String magazine) {
        final char[] charArray = magazine.toCharArray();

        for (char c : charArray) {
            final String element = String.valueOf(c);
            if (ransomNote.contains(element)) {
                ransomNote = ransomNote.replaceFirst(element, "");
                if (ransomNote.length() == 0) {
                    return true;
                }
            }
        }

        return ransomNote.length() == 0;
    }

    public boolean canConstructV2(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : magazine.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (char c : ransomNote.toCharArray()) {
            if (!map.containsKey(c) || map.get(c) < 1) {
                return false;
            }
            map.put(c, map.get(c) - 1);
        }

        return true;
    }

    public static void main(String[] args) {
        RansomNote_383 ransomNote_383 = new RansomNote_383();
        System.out.println(ransomNote_383.canConstructV2("aa", "baac"));
    }
}
