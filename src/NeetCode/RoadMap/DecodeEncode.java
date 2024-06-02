package NeetCode.RoadMap;

import java.util.ArrayList;
import java.util.List;

public class DecodeEncode {

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("we");
        list.add("say");
        list.add(":");
        list.add("yes");
        list.add("!@#$%^&*()");
        System.out.println(encode(list));
        System.out.println(decode("2-we3-say1-:3-yes10-!@#$%^&*()"));

    }

    public static String encode(List<String> strs) {
        StringBuilder stringBuilder = new StringBuilder();
        for (String s : strs) {
            stringBuilder.append(s.length());
            stringBuilder.append("-");
            stringBuilder.append(s);
        }

        return stringBuilder.toString();
    }

    public static List<String> decode(String str) {
        List<String> res = new ArrayList<>();
        final char delimiter = '-';

        char[] charArr = str.toCharArray();
        for (int i = 0; i < charArr.length; i++) {
            char c = charArr[i];
            int numOfChar = getNumOfChar(charArr, i);
            if (condition(charArr, i)) {
                i += String.valueOf(numOfChar).length();
                i++;
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < numOfChar; j++) {
                    stringBuilder.append(charArr[i + j]);
                }
                res.add(stringBuilder.toString());
                i += numOfChar - 1;
            }

        }

        return res;
    }

    public static int getNumOfChar(char[] charArr, int i) {
        StringBuilder stringBuilder = new StringBuilder();
        while (Character.isDigit(charArr[i])) {
            stringBuilder.append(charArr[i]);
            i++;
        }

        return Integer.parseInt(stringBuilder.toString());
    }

    public static boolean condition(char[] charArr, int i) {
        char c = charArr[i];
        while (Character.isDigit(c)) {
            i++;
            c = charArr[i];
        }
        return c == '-';
    }

}
