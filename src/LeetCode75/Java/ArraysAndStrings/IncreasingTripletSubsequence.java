package LeetCode75.Java.ArraysAndStrings;

public class IncreasingTripletSubsequence {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int[] nums1 = {3,2,1};
        System.out.println(increasingTriplet(nums1));
    }

    public static boolean increasingTriplet(int[] nums) {

        if (nums.length < 3) {
            return false;
        }

        int firstNum = Integer.MAX_VALUE;
        int lastNum = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= firstNum) {
                firstNum = nums[i];
            } else if (nums[i] <= lastNum) {
                lastNum = nums[i];
            } else {
                return true;
            }
        }

        return false;
    }

}
