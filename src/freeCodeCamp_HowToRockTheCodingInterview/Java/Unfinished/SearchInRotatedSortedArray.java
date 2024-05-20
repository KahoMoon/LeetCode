package freeCodeCamp_HowToRockTheCodingInterview.Java.Unfinished;

public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        System.out.println(search(new int[]{1,3,5}, 0));
    }

//    There is an integer array nums sorted in ascending order (with distinct values).
//
//    Prior to being passed to your function, nums is possibly rotated at an unknown pivot index k (1 <= k < nums.length) such that the resulting array is [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed). For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
//
//    Given the array nums after the possible rotation and an integer target, return the index of target if it is in nums, or -1 if it is not in nums.
//
//    You must write an algorithm with O(log n) runtime complexity.
    public static int search(int[] nums, int target) {
        int leftIndex = 0;
        int middleIndex = (nums.length - 1) / 2;
        int rightIndex = nums.length - 1;
        if (nums.length <= 3) {
            if (nums[leftIndex] == target) {
                return leftIndex;
            } else if (nums[middleIndex] == target) {
                return middleIndex;
            } else if (nums[rightIndex] == target) {
                return rightIndex;
            }
            return -1;
        }

        while (leftIndex < middleIndex) {
            int leftNum = nums[leftIndex];
            int middleNum = nums[middleIndex];
            int rightNum = nums[rightIndex];

            if (leftNum > middleNum) {
                rightIndex = middleIndex;
                middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            } else if (rightNum < middleNum) {
                leftIndex = middleIndex;
                middleIndex = leftIndex + ((rightIndex - leftIndex) / 2);
            }
        }
        int pivot = middleIndex + 1;

        leftIndex = 0;
        middleIndex = pivot;
        rightIndex = nums.length - 1;

        if (target > nums[rightIndex]) {
            rightIndex = middleIndex - 1;
            middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        } else if (target < nums[rightIndex]) {
            leftIndex = middleIndex;
            middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
        }

        while (leftIndex < middleIndex) {
            int middleNum = nums[middleIndex];
            if (nums[leftIndex] == target) {
                return leftIndex;
            }
            if (middleNum == target) {
                return middleIndex;
            }

            if (target < middleNum) {
                rightIndex = middleIndex;
                middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            } else {
                leftIndex = middleIndex;
                middleIndex = leftIndex + (rightIndex - leftIndex) / 2;
            }
        }

        return -1;
    }
}
