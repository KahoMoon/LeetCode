package freeCodeCamp_HowToRockTheCodingInterview.Java.Unfinished;

import java.util.*;

public class ThreeSum {

//    Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
//
//    Notice that the solution set must not contain duplicate triplets.

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1,0,1,2,-1,-4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> set = new HashSet<>();

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }

        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int first = nums[i];
                int second = nums[j];
                int third = -(first + second);

                boolean condition = map.containsKey(third) && map.get(third) != i && map.get(third) != j && i != j;
                if (condition) {
                    List<Integer> list = new ArrayList<>();
                    list.add(first);
                    list.add(second);
                    list.add(third);

                    Collections.sort(list);
                    set.add(list);
                }
            }
        }

        return new ArrayList<>(set);
    }

}
