package Java.BFS;

import Java.TreeNode;
import com.sun.source.tree.Tree;
import org.w3c.dom.ls.LSOutput;

import java.lang.reflect.Array;
import java.util.*;

public class BinaryTreeRightSideView {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(4);
        System.out.println(rightSideView(root));
    }

    public static List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        ArrayList<Integer> rightNodes = new ArrayList<>();
        q.add(root);

        while (!q.isEmpty()) {
            int level = q.size();
            for (int i = 0; i < level; i++) {
                TreeNode curr = q.poll();
                if (curr == null) {
                    continue;
                }
                if (i == level - 1) {
                    rightNodes.add(curr.val);
                }
                if (curr.left != null) {
                    q.add(curr.left);
                }
                if (curr.right != null) {
                    q.add(curr.right);
                }
            }
        }

        return rightNodes;
    }
}
