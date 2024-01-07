package Java.PrefixSum;

import java.util.stream.IntStream;

public class FindPivotIndex {
    public static void main(String[] args) {
        int[] nums = {1,7,3,6,5,6};
        System.out.println(pivotIndex(nums));
    }

    public static int pivotIndex(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        int sum = IntStream.of(nums).sum();
        int currSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i - 1 >= 0) {
                currSum += nums[i - 1];
            }
            if ((currSum * 2) == sum - nums[i]) {
                return i;
            }
        }

        return -1;
    }
}
