package freeCodeCamp_HowToRockTheCodingInterview.Java.Unfinished;

import java.util.HashSet;

public class ContainsDuplicates {

//    Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.

    public static void main(String[] args) {

    }

    public static boolean containsDuplicates(int[] nums) {
        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;
    }
}
