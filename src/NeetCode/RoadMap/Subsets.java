package NeetCode.RoadMap;

import java.util.*;

public class Subsets {

    public static void main(String[] args) {
        System.out.println(subsets(new int[]{1,2,3}));
    }


    //Input: nums = [1,2,3]
    //
    //Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        Queue<List<Integer>> q = new LinkedList<>();
        q.add(new ArrayList<>());

        int numsIndex = 0;
        int i = 1;
        int levelCount = 2;
        boolean resCondition = levelCount == Math.pow(2, nums.length);
        while (!q.isEmpty()) {
            //visit the current subset node
            List<Integer> curr = q.poll();
            if (numsIndex == nums.length) {
                res.add(curr);
            }

            //adding the children subset nodes to the stack
            if (numsIndex < nums.length) {
                List<Integer> left = new ArrayList<>(curr);
                left.add(nums[numsIndex]);
                q.add(left);

                List<Integer> right = new ArrayList<>(curr);
                q.add(right);
            }

            i++;
            if (i >= levelCount) {
                levelCount *= 2;
                numsIndex++;
            }
        }

        return res;
    }
}
