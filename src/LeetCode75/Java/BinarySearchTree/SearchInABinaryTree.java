package LeetCode75.Java.BinarySearchTree;

import LeetCode75.Java.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class SearchInABinaryTree {
    public static void main(String[] args) {

    }

    public static TreeNode searchBST(TreeNode root, int val) {

        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.val == val) {
                return curr;
            }

            if (curr.left != null) {
                q.add(curr.left);
            }
            if (curr.right != null) {
                q.add(curr.right);
            }
        }

        return null;
    }
}
