package freeCodeCamp_HowToRockTheCodingInterview.Java;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSumOp(new int[]{2,5,5,11}, 10)));
    }

//    Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
//
//    You may assume that each input would have exactly one solution, and you may not use the same element twice.
//
//    You can return the answer in any order.

    public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int x = 1; x < nums.length; x++) {
                if (nums[i] + nums[x] == target && i != x) {
                    res[0] = i;
                    res[1] = x;
                    return res;
                }
            }
        }

        return new int[0];
    }

    public static int[] twoSumOp(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }

        return new int[0];
    }

}
