package Java.BFS;

import Java.TreeNode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class MaximumLevelSumOfABinaryTree {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(7);
        root.right = new TreeNode(0);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(-8);
        System.out.println(maxLevelSum(root));
    }

    public static int maxLevelSum(TreeNode root) {
        /*traverse the tree from top to bottom
        * using bfs, loop through the values of each level and store them in array where index + 1 = level
        * find max()
        * use indexOf()
        * return*/

        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> sum = new ArrayList<>();
        ArrayList<Integer> sumCopy = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int nodesInLevel = q.size();
            int levelSum = 0;
            for (int i = 0; i < nodesInLevel; i++) {
                TreeNode curr = q.poll();
                assert curr != null;
                levelSum += curr.val;

                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
            sum.add(levelSum);
            sumCopy.add(levelSum);
        }
        sumCopy.sort(Comparator.naturalOrder());

        return sum.indexOf(sumCopy.get(sumCopy.size() - 1)) + 1;
    }
}
