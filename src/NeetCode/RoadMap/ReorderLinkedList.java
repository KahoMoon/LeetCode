package NeetCode.RoadMap;

import java.util.HashMap;
import java.util.Map;

import static NeetCode.RoadMap.ListNode.createFromList;
import static NeetCode.RoadMap.ListNode.printList;

public class ReorderLinkedList {
    public static void main(String[] args) {
        ListNode head = createFromList(new int[]{2,4,6,8});
        printList(head);
        reorderList(head);
        printList(head);
    }

    public static void reorderList(ListNode head) {
        Map<Integer, ListNode> map = new HashMap<>();

        ListNode curr = head;
        int size = 0;
        while (curr != null) {
            map.put(curr.val, curr);
            curr = curr.next;
            size++;
        }

        //map.forEach((key, value) -> System.out.println(key + ":" + value));
        //0, 6, 1, 5, 2, 4, 3
        //0, 1, 2, 3, 4, 5, 6
        int i = 0;
        int offset = 1;
        curr = map.get(head.val);
        i++;
        for (; i < size; i++) {
            if (i % 2 == 0) {
                curr.next = map.get(offset - 1);
                curr = curr.next;
            } else {
                curr.next = map.get(size - offset);
                offset++;
                curr = curr.next;
            }
        }
        curr.next = null;
    }
}
