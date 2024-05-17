package LeetCode75.Java.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;

public class MaxConsecutiveOnesIII {
    public static void main(String[] args) {
        int[] nums = {1,1,1,0,0,0,1,1,1,1,0};
        System.out.println(longestOnes(nums, 2));
    }

    public static int longestOnes(int[] nums, int k) {
        int longestConsecutive = 0;
        int left = 0, right = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                if (k > 0) {
                    right++;
                    k--;
                    longestConsecutive = Math.max(longestConsecutive, right - left);
                } else {
                    while (nums[left] == 1) {
                        left++;
                    }
                    left++;
                    right++;
                    longestConsecutive = Math.max(longestConsecutive, right - left);
                }
            } else {
                right++;
                longestConsecutive = Math.max(longestConsecutive, right - left);
            }
        }
        return longestConsecutive;
    }

}
