package Java.LinkedList;

import Java.ListNode;

import java.util.ArrayList;

import static Java.ListNode.printLinkedList;

public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode fourth = new ListNode(5);
        ListNode third = new ListNode(4, fourth);
        ListNode second = new ListNode(3, third);
        ListNode first = new ListNode(2, second);
        ListNode zero = new ListNode(1, first);

        reverseList(zero);
    }

    public static ListNode reverseList(ListNode head) {
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode iter = head;
        while (iter != null) {
            arr.add(iter.val);
            iter = iter.next;
        }

        if (arr.size() == 0 || arr.size() == 1) {
            return head;
        }

        head = new ListNode(arr.get(arr.size() - 1));
        ListNode prev = head;
        for (int i = arr.size() - 2; i >= 0; i--) {
            ListNode curr = new ListNode(arr.get(i));
            prev.next = curr;
            prev = curr;
        }

        printLinkedList(head);

        return head;
    }
}
