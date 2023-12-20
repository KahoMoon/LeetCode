package Java.TwoPointers;

public class IsSubsequence {
    public static void main(String[] args) {
        System.out.println(isSubsequence("b", "abc"));
    }

    public static boolean isSubsequence(String s, String t) {

        if (s.length() == 0) {
            return true;
        }
        if (t.length() == 0) {
            return false;
        }

        int sPointer = 0;
        for (char c : t.toCharArray()) {
            if (s.charAt(sPointer) == c) {
                sPointer++;
                if (sPointer == s.length()) {
                    return true;
                }
            }
        }

        return false;
    }
}
