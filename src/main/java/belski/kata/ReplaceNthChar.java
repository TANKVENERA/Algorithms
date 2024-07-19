package belski.kata;

public class ReplaceNthChar {

    public static void main(String[] args) {
        System.out.println(replaceNth("Vader said: No, I am your father!", 2, 'a', 'o'));
    }

    public static String replaceNth(String text, int n, char oldValue, char newValue) {
        int counter = 0;
        if (n <= 0 ) {
            return text;
        }

        char[] array = text.toCharArray();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == oldValue) {
                counter++;
            }
           if (counter == n) {
               array[i] = newValue;
               counter = 0;
           }
        }
        return String.valueOf(array);
    }
}
