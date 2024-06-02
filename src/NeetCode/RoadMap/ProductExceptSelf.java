package NeetCode.RoadMap;

import java.util.ArrayList;
import java.util.Arrays;

public class ProductExceptSelf {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,0})));
    }

    public static int[] productExceptSelf(int[] nums) {
        int[] firstNonZero = firstNonZero(nums);
        int product = firstNonZero[1];
        if (product == -21) {
            return new int[nums.length];
        }
        boolean hasZero = false;
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (i != firstNonZero[0]) {
                int curr = nums[i];
                if (curr != 0) {
                    product *= curr;
                } else {
                    hasZero = true;
                    arr.add(i);
                }
            }
        }

        if (hasZero && arr.size() == nums.length - 1 && nums.length != 2) {
            return new int[nums.length];
        }

        int[] res = new int[nums.length];
        if (!hasZero) {
            for (int i = 0; i < nums.length; i++) {
                int curr = nums[i];
                res[i] = product / curr;
            }
        } else {
            for (int n : arr) {
                res[n] = product;
            }
        }


        return res;
    }

    public static int[] firstNonZero(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != 0) {
                return new int[]{i, nums[i]};
            }
            i++;
        }

        return new int[]{-21,-21};
    }
}
