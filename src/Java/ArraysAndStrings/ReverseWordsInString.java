package Java.ArraysAndStrings;

import java.util.Stack;

public class ReverseWordsInString {

    public static void main(String[] args) {
        String test = "the sky is blue";
        System.out.println(reverseWords(test));
    }

    public static String reverseWords(String s) {

        Stack<String> result = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                int endIndex = findEndIndex(i, s.toCharArray());
                String currWord = getWordFromIndices(i, endIndex, s.toCharArray());
                result.add(currWord);
                i += currWord.length() - 1;
            }
        }

        StringBuilder finalWord = new StringBuilder();
        int size = result.size();
        for (int i = 0; i < size - 1; i++) {
            finalWord.append(result.pop());
            finalWord.append(' ');
        }
        finalWord.append(result.pop());

        return finalWord.toString();
    }

    private static int findEndIndex(int startIndex, char[] charArr) {

        int endIndex = startIndex;
        for (int i = startIndex; i < charArr.length; i++) {
            if (i == charArr.length - 1) {
                return endIndex;
            } else if (startIndex + 1 < charArr.length && charArr[i] != ' ') {
                endIndex++;
            } else {
                return endIndex - 1;
            }
        }

        return endIndex - 1;
    }

    private static String getWordFromIndices(int startIndex, int endIndex, char[] charArr) {
        StringBuilder result = new StringBuilder();
        for (int i = startIndex; i <= endIndex; i++) {
            result.append(charArr[i]);
        }

        return result.toString();
    }

}
