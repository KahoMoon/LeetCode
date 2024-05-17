package LeetCode75.Java;

import java.util.*;

public class TreeNode {
    public static void main(String[] args) {
        printPreorder(createTreeFromList((ArrayList<Integer>) stringToList("5,3,6,2,4,null,7")));
    }

    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {};
    public TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
    public static void printInorder(TreeNode root) {

    }

    public static void printPreorder(TreeNode root) {
        if (root == null) {
            return;
        }
        System.out.println(root.val);
        printPreorder(root.left);
        printPreorder(root.right);
    }

    static public List<Integer> stringToList(String s) {
        String[] arr = s.split(",");
        List<Integer> temp = new ArrayList<>();
        for (String a : arr) {
            try {
                temp.add(Integer.valueOf(a));
            } catch (NumberFormatException e) {
                temp.add(null);
            }
        }
        return temp;
    }

    static public TreeNode createTreeFromList(ArrayList<Integer> arr) {
        if (arr.size() == 0) {
            return null;
        }

        return createTreeFromListHelper(new TreeNode(), 0, arr);
    }

    private static TreeNode createTreeFromListHelper(TreeNode node, int index, ArrayList<Integer> arr){
        if (index >= arr.size() || arr.get(index) == null) {
            return node;
        }

        node = new TreeNode(arr.get(index));

        node.left = createTreeFromListHelper(node.left, (index * 2) + 1, arr);
        node.right = createTreeFromListHelper(node.right, (index * 2) + 2, arr);

        return node;
    }


}
