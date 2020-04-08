package linked_lists_2;

import java.util.List;

public class LinkedNode {
    int val;
    public LinkedNode next;

    LinkedNode(int x) {
        val = x;
    }

    public static LinkedNode nodes(List<Integer> values) {
        LinkedNode root = null;
        for (Integer value : values) {
            LinkedNode linkedNode = new LinkedNode(value);
            if (root == null)
                root = linkedNode;
            else
                root.appendToTail(value);

        }
        return root;
    }

    public static String printNodes(LinkedNode root) {
        LinkedNode node = root;
        StringBuilder builder = new StringBuilder();
        while (node != null) {
            builder.append(node.val);
            builder.append(" ");
            node = node.next;
        }
        return builder.toString();
    }

    void appendToTail(int d) {
        LinkedNode end = new LinkedNode(d);
        LinkedNode n = this;

        while (n.next != null) {
            n = n.next;
        }

        n.next = end;
    }

    LinkedNode deleteNode(LinkedNode head, int d) {
        LinkedNode n = head;

        if (n.val == d) {
            return head.next;
        }

        while (n.next != null) {
            if (n.next.val == d) {
                n.next = n.next.next;
                return head;
            }
            n = n.next;
        }
        return head;
    }
}
