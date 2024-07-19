package belski.leetcode;

public class FirstOccurrence_28 {

    public static void main(String[] args) {
        System.out.println(strStr("mississippi", "issip"));
    }

    public static int strStr(String haystack, String needle) {
        char[] stackArr = haystack.toCharArray();
        char[] needleArr = needle.toCharArray();
        int possibleFirstOcc = -1;

        for (int i = 0; i < stackArr.length;) {

            if (stackArr.length - i < needleArr.length) {
                return -1;
            } else {
                possibleFirstOcc = i;
                for (int j = 0; j < needleArr.length; j++) {
                    if (needleArr[j] != stackArr[i + j]) {
                        possibleFirstOcc = -1;
                        i++;
                        break;
                    }
                    if (j == needleArr.length - 1) {
                        return possibleFirstOcc;
                    }

                }
            }
        }
        return possibleFirstOcc;
    }
}
