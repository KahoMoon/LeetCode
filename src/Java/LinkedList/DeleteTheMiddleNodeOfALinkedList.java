package Java.LinkedList;

public class DeleteTheMiddleNodeOfALinkedList {
    public static void main(String[] args) {
        ListNode sixth = new ListNode(6);
        ListNode fifth = new ListNode(2, sixth);
        ListNode fourth = new ListNode(1, fifth);
        ListNode third = new ListNode(7, fourth);
        ListNode second = new ListNode(4, third);
        ListNode first = new ListNode(3, second);
        ListNode head = new ListNode(1, first);

        deleteMiddle(head);
    }

    public static ListNode deleteMiddle(ListNode head) {
        ListNode curr = head;
        int length = 0;
        while (curr != null) {
            length++;
            curr = curr.next;
        }

        if (length == 1) {
            return null;
        }

        ListNode left = null;
        curr = head;
        for (int i = 0; i < (length / 2); i++) {
            if (i == (length / 2) - 1) {
                left = curr;
                curr = curr.next;
                curr = curr.next;
                left.next = curr;
                break;
            }
            curr = curr.next;
        }

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val) {
            this.val = val;
        }
        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
