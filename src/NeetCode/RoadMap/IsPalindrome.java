package NeetCode.RoadMap;

public class IsPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("race a car"));
    }

    public static boolean isPalindrome(String s) {
        int first = 0;
        int second = s.length() - 1;

        char[] arr = s.toCharArray();
        while(first <= second) {
            if (!Character.isLetterOrDigit(arr[first])) {
                first++;
                continue;
            }
            if (!Character.isLetterOrDigit(arr[second])) {
                second--;
                continue;
            }
            if (Character.toLowerCase(arr[first]) != Character.toLowerCase(arr[second])) {
                return false;
            }
            first++;
            second--;
        }

        return true;
    }
}
