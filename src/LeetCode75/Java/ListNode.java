package LeetCode75.Java;

import java.util.ArrayList;

public class ListNode {
    public int val;
    public ListNode next;
    ListNode() {};
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printLinkedList(ListNode head) {
        ListNode iter = new ListNode(head.val, head.next);
        ArrayList<Integer> arr = new ArrayList<>();
        while (iter != null) {
            arr.add(iter.val);
            iter = iter.next;
        }
        System.out.println(arr);
    }
}
