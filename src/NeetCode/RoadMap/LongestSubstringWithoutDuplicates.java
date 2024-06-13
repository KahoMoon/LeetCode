package NeetCode.RoadMap;

import java.util.HashSet;

public class LongestSubstringWithoutDuplicates {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }

    public static int lengthOfLongestSubstring(String s) {

        if (s.length() == 1) {
            return 1;
        }

        int maxLength = 0;
        HashSet<Character> set = new HashSet<>();
        int left, right;
        for (left = 0, right = 0; left < s.length() && right < s.length(); right++) {
            char curr = s.charAt(right);
            if (!set.contains(curr)) {
                set.add(curr);
            } else {
                maxLength = Math.max(maxLength, right - left);
                while (set.contains(curr)) {
                    set.remove(s.charAt(left));
                    left++;
                }
                right--;
            }
        }
        maxLength = Math.max(maxLength, right - left);

        return maxLength;
    }
}
