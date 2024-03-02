package Java.BinarySearchTree;

import Java.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;

import static Java.TreeNode.*;

public class DeleteNodeInABST {
    public static void main(String[] args) {
        ArrayList<Integer> arr = (ArrayList<Integer>) stringToList("5,3,6,2,4,null,7");
        TreeNode root = createTreeFromList(arr);
        printPreorder(deleteNode(root, 5));
    }

    public static TreeNode deleteNode(TreeNode root, int key) {

        if (root == null) {
            return null;
        }

        TreeNode[] keyNode = findNode(root, key, null);
        if (keyNode == null) {
            return root;
        }

        if (keyNode[1] != null && keyNode[0].left == null && keyNode[0].right == null) {
            if (keyNode[1].left == keyNode[0]) {
                keyNode[1].left = null;
            } else {
                keyNode[1].right = null;
            }
            return root;
        }

        if (hasChild(keyNode[0])) {
            if (keyNode[0].right != null) {
                keyNode[0].val = keyNode[0].right.val;
                keyNode[0].right = null;
            } else {
                keyNode[0].val = keyNode[0].left.val;
                keyNode[0].left = null;
            }
            return root;
        }

        TreeNode[] replacementNode = findSmallestChild(keyNode[0].right, keyNode[0]);
        replacementNode[1].left = null;
        try {
            keyNode[0].val = replacementNode[0].val;
        } catch (NullPointerException ignored){

        }

        return null;
    }

    public static TreeNode[] findSmallestChild(TreeNode node, TreeNode parent) {
        if (node != null && node.left != null) {
            TreeNode[] temp = findSmallestChild(node.left, node);
            if (temp != null && temp[0].left == null) {
                return temp;
            }
        }
        return new TreeNode[]{node, parent};
    }

    private static boolean hasChild(TreeNode node) {
        if (node.left != null || node.right != null) {
            return true;
        }
        return false;
    }

    public static TreeNode[] findNode(TreeNode node, int key, TreeNode parent) {
        if (node == null) {
            return null;
        }

        if (node.val == key) {
            return new TreeNode[]{node, parent};
        }
        if (node.left != null) {
            TreeNode[] temp = findNode(node.left, key, node);
            if (temp != null && temp[0].val == key) {
                return temp;
            }
        }
        if (node.right != null) {
            TreeNode[] temp = findNode(node.right, key, node);
            if (temp != null && temp[0].val == key) {
                return temp;
            }
        }

        return null;
    }

}
