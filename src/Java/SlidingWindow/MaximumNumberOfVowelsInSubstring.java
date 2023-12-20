package Java.SlidingWindow;

import java.util.HashSet;

public class MaximumNumberOfVowelsInSubstring {


    public static void main(String[] args) {
        String s = "weallloveyou";
        System.out.println(maxVowels(s, 7));
    }

    static HashSet<Character> vowels = new HashSet<>();
    private static void setUpVowels() {
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
    }
    public static int maxVowels(String s, int k) {
        setUpVowels();
        int maxVowelCount = 0;
        for (int i = 0; (i + k) <= s.length(); i++) {
            maxVowelCount = Math.max(maxVowelCount, countVowels(s, i, i + k - 1, k));
        }

        return maxVowelCount;
    }

    private static int countVowels(String s, int left, int right, int k) {
        int count = 0;
        for (int i = left; i <= right; i++) {
            if (isVowel(s.charAt(i))) {
                count++;
                if (count == k) {
                    return k;
                }
            }
        }
        return count;
    }

    private static boolean isVowel(char c) {
        return vowels.contains(c);
    }
}
