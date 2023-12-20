package Java.ArraysAndStrings;

import java.util.Stack;

public class ReverseVowelsOfString {

    public static void main(String[] args) {
        System.out.println(reverseVowels("aA"));
    }

    public static String reverseVowels(String s) {

        Stack<Character> vowels = new Stack<>();
        for (char c : s.toCharArray()) {
            if (isVowel(c)) {
                vowels.add(c);
            }
        }
        System.out.println(vowels);

        StringBuilder result = new StringBuilder(s);
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (isVowel(c)) {
                char temp = vowels.pop();
                result.setCharAt(i, temp);
            }
        }

        return result.toString();
    }

    private static boolean isVowel(char c) {
        c = Character.toLowerCase(c);
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
