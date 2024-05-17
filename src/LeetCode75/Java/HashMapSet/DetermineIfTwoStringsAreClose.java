package LeetCode75.Java.HashMapSet;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class DetermineIfTwoStringsAreClose {
    public static void main(String[] args) {
        System.out.println(closeStrings("uau", "ssx"));
    }

    /*conditions for two strings to be close
    * same length
    * same characters
    * same number of occurrences*/
    public static boolean closeStrings(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }

        HashMap<Character, Integer> word1Map = new HashMap<>();
        for (char i : word1.toCharArray()) {
            if (word1Map.containsKey(i)) {
                word1Map.replace(i, word1Map.get(i) + 1);
            } else {
                word1Map.put(i, 1);
            }
        }
        HashMap<Character, Integer> word2Map = new HashMap<>();
        for (char i : word2.toCharArray()) {
            if (word2Map.containsKey(i)) {
                word2Map.replace(i, word2Map.get(i) + 1);
            } else {
                word2Map.put(i, 1);
            }
        }

        Object[] temp = word1Map.values().toArray();
        Arrays.sort(temp);

        Object[] temp1 = word2Map.values().toArray();
        Arrays.sort(temp1);

        return Arrays.equals(temp, temp1) && (word1Map.keySet().equals(word2Map.keySet()));
    }
}
