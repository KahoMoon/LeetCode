package NeetCode.RoadMap;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<Integer> tree = new ArrayList<>();
        q.add(root);

        while(!q.isEmpty()) {
            TreeNode right = null;
            int len = q.size();

            for (int i = 0; i < len; i++) {
                TreeNode curr = q.poll();

                if (curr != null) {
                    right = curr;
                    q.add(curr.left);
                    q.add(curr.right);
                }
            }

            if (right != null) {
                tree.add(right.val);
            }
        }

        return tree;
    }

}
