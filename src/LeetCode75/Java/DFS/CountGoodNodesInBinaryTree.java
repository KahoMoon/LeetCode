package LeetCode75.Java.DFS;

import LeetCode75.Java.TreeNode;
import com.sun.jdi.connect.Connector;

import java.util.*;

public class CountGoodNodesInBinaryTree {
    public static void main(String[] args) {
//        TreeNode root = new TreeNode(3);
//        root.left = new TreeNode(1);
//        root.left.left = new TreeNode(3);
//        root.right = new TreeNode(4);
//        root.right.left = new TreeNode(1);
//        root.right.right = new TreeNode(5);
        TreeNode root = new TreeNode(9);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(6);

        System.out.println(goodNodes(root));
    }

    public static int goodNodes(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }
        int[] numOfGoodNodes = {0};
        ArrayList<Integer> arr = new ArrayList<>();
        traversal(root, arr, numOfGoodNodes);

        return numOfGoodNodes[0];
    }

    private static void traversal(TreeNode node, ArrayList<Integer> arr, int[] goodNodes) {
        if (node == null) {
            return;
        }
        if (checkIfGood(node, arr)) {
            goodNodes[0]++;
        }
        arr.add(node.val);

        traversal(node.left, arr, goodNodes);
        traversal(node.right, arr, goodNodes);

        arr.remove((Integer) node.val);
    }

    private static boolean checkIfGood(TreeNode node, ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return true;
        }
        arr.sort(Comparator.naturalOrder());
        if (arr.get(arr.size() - 1) <= node.val) {
            return true;
        }
        return false;
    }
}
