package LeetCode75.Java.LinkedList;

import LeetCode75.Java.ListNode;

import static LeetCode75.Java.ListNode.printLinkedList;

public class OddEvenLinkedList {
    public static void main(String[] args) {
        ListNode fourth = new ListNode(5);
        ListNode third = new ListNode(4, fourth);
        ListNode second = new ListNode(3, third);
        ListNode first = new ListNode(2, second);
        ListNode zero = new ListNode(1, first);

        oddEvenList(zero);
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode curr = head;
        ListNode oddCurr = null;
        ListNode oddHead = null;
        ListNode evenHead = null;
        ListNode evenCurr = null;
        int count = 0;
        while (curr != null) {
            printLinkedList(curr);
            if (count % 2 != 0) {
                if (oddCurr == null) {
                    oddCurr = curr;
                    oddHead = curr;
                    printLinkedList(oddHead);
                } else {
                    oddCurr.next = curr;
                    oddCurr = oddCurr.next;
                    printLinkedList(oddHead);
                }
            } else {
                if (evenHead == null) {
                    evenHead = curr;
                    evenCurr = curr;
                    printLinkedList(evenHead);
                } else {
                    evenCurr.next = curr;
                    evenCurr = evenCurr.next;
                    printLinkedList(evenHead);
                }
            }
            count++;
            curr = curr.next;
        }

        assert oddCurr != null;
        oddCurr.next = evenHead;

        System.out.println("sdfgsdg");
        printLinkedList(oddHead);

        return oddHead;
    }
}
