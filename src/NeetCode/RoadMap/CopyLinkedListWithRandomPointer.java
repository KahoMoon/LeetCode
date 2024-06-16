package NeetCode.RoadMap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class CopyLinkedListWithRandomPointer {

    class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<>();

        Node curr = head;
        while (curr.next != null) {
            map.put(curr, new Node(curr.val));
            curr = curr.next;
        }

        curr = head;
        while (curr.next != null) {
            Node copyCurr = map.get(curr);
            copyCurr.next = map.get(curr.next);
            copyCurr.random = map.get(curr.random);
            curr = curr.next;
        }

        return map.get(head);
    }
}
