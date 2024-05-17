package LeetCode75.Java.LinkedList;

import LeetCode75.Java.ListNode;

import java.util.ArrayList;

public class MaximumTwinSumOfALinkedList {
    public static void main(String[] args) {
        ListNode third = new ListNode(1);
        ListNode second = new ListNode(2, third);
        ListNode first = new ListNode(4, second);
        ListNode zero = new ListNode(5, first);

        pairSum(zero);
    }

    public static int pairSum(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        while (head != null) {
            arr.add(head.val);
            head = head.next;
        }

        int max = -999;
        for (int i = arr.size() / 2; i < arr.size(); i++) {
            int curr = arr.get(i);
            int twin = arr.get(arr.size() - 1 - i);

            max = Math.max(max, curr + twin);
        }

        return max;
    }
}
