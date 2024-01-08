package Java.Stack;

import java.util.Stack;

public class RemovingStarsFromAString {
    public static void main(String[] args) {
        System.out.println(removeStars("erase*****"));
    }

    public static String removeStars(String s) {
        Stack<Character> res = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                res.push(c);
            } else {
                res.pop();
            }
        }
        StringBuilder temp = new StringBuilder();
        for (char c : res) {
            temp.append(c);
        }

        return temp.toString();

    }
}
