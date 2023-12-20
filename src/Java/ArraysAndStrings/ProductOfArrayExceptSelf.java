package Java.ArraysAndStrings;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(nums)));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] answer = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            answer[i] = getProduct(0, i - 1, nums) * getProduct(i + 1, nums.length - 1, nums);
        }

        return answer;
    }

    private static int getProduct(int firstIndex, int endIndex, int[] nums) {
        if (firstIndex == endIndex) {
            return nums[firstIndex];
        }
        if (firstIndex < 0) {
            firstIndex = 0;
        }
        if (endIndex >= nums.length) {
            endIndex = 0;
        }

        int product = 1;
        for (int i = firstIndex; i <= endIndex; i++) {
            product *= nums[i];
        }

        return product;
    }

}
