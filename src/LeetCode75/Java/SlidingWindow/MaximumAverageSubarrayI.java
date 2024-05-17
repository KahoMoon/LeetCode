package LeetCode75.Java.SlidingWindow;

public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {0,1,1,3,3};
        System.out.println(findMaxAverage(nums, 4));
    }

    public static double findMaxAverage(int[] nums, int k) {
        if (nums.length == 1) {
            return nums[0];
        }
        double maxAverage = Integer.MIN_VALUE;
        for (int i = 0; i + k <= nums.length; i++) {
            double average = findAverage(nums, i, i + k, k);
            maxAverage = Math.max(maxAverage, average);
        }

        return maxAverage;
    }

    private static double findAverage(int[] nums, int left, int right, int n) {
        double count = 0;
        for (int i = left; i < right; i++) {
            count += nums[i];
        }

        return count / n;
    }
}
