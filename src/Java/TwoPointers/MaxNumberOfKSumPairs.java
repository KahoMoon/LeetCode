package Java.TwoPointers;

import java.util.Arrays;

public class MaxNumberOfKSumPairs {
    public static void main(String[] args) {
        int[] nums = {4,4,1,3,1,3,2,2,5,5,1,5,2,1,2,3,5,4};
        System.out.println(maxOperations(nums, 2));
    }

    public static int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int opCount = 0;
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];

            if (currNum > k) {
                return opCount;
            }
            if (currNum == -1) {
                continue;
            }

            int foundIndex = linearSearch(nums, i + 1, k - currNum);
            if (foundIndex != -1) {
                opCount++;
                nums[i] = -1;
                nums[foundIndex] = -1;
            }
        }

        return opCount;
    }

    private static int linearSearch(int[] nums, int startIndex, int n) {
        for (int i = startIndex; i < nums.length; i++) {
            if (nums[i] == n) {
                return i;
            }
        }

        return -1;
    }

    private static int binarySearch(int[] arr, int l, int r, int x) {
        if (r >= l) {
            int mid = l + (r - l) / 2;

            // If the element is present
            // at the middle itself
            if (arr[mid] == x)
                return mid;

            // If element is smaller than
            // mid, then it can only be
            // present in left subarray
            if (arr[mid] > x)
                return binarySearch(arr, l,
                        mid - 1, x);

            // Else the element can only be
            // present in right subarray
            return binarySearch(arr, mid + 1,
                    r, x);
        }

        // Reach here when element is
        // not present in array
        return -1;
    }
}
