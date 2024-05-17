package LeetCode75.Java.TwoPointers;

import java.util.Arrays;

public class MoveZeroes {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void moveZeroes(int[] nums) {
        int caretIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[caretIndex++] = nums[i];
            }
        }

        for (int i = caretIndex; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
