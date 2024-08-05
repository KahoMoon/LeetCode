package NeetCode.RoadMap;

import java.util.*;

public class CombinationTargetSum {
    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{3,4,5}, 16));
    }

    public static List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i : nums) {
            ArrayList<Integer> path = new ArrayList<>();
            path.add(i);
            dfs(nums, target, i, i, path, res);
        }



        return res;
    }

    private static void dfs(int[] nums, int target, int currNum, int currSum, List<Integer> path,  List<List<Integer>> res) {
        //System.out.println(currNum + " " + currSum + " " + path + " " + res);

        if (currSum == target) {
            res.add(new ArrayList<>(path));
        } else if (currSum > target) {
            return;
        } else {
            int tempSum = currSum;
            for (int i : nums) {
                if (i >= currNum){
                    path.add(i);
                    dfs(nums, target, i, tempSum + i, path, res);

                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
