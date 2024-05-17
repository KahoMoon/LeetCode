package LeetCode75.Java.ArraysAndStrings;

public class MergeStringsAlternately {

    public static void main(String[] args) {
        System.out.println(mergeAlternately("ab", "pqrs"));
    }

    public static String mergeAlternately(String word1, String word2) {
        int shorterLength = Math.min(word1.length(), word2.length());
        StringBuilder compiled = new StringBuilder();
        int firstIndex = 0;
        int secondIndex = 0;
        for (int i = 0; i < shorterLength * 2; i++) {
            if (i % 2 == 0) {
                compiled.insert(i, word1.charAt(firstIndex++));
            } else {
                compiled.insert(i, word2.charAt(secondIndex++));
            }
        }

        //System.out.println(compiled.toString());

        if (word1.length() > word2.length()) {
            for (int i = firstIndex + secondIndex; i < word1.length() + word2.length(); i++) {
                compiled.insert(i, word1.charAt(firstIndex++));
            }
        } else if (word1.length() < word2.length()) {
            for (int i = secondIndex + firstIndex; i < word1.length() + word2.length(); i++) {
                compiled.insert(i, word2.charAt(secondIndex++));
            }
        }

        return compiled.toString();
    }

}
