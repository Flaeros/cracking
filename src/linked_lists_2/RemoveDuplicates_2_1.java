package linked_lists_2;


import java.util.HashSet;
import java.util.Set;

import static java.util.Arrays.asList;
import static linked_lists_2.LinkedNode.printNodes;

/**
 * Write code to remove duplicates from an unsorted linked list.
 * FOLLOW UP
 * How would you solve this problem if a temporary buffer is not allowed?
 */
public class RemoveDuplicates_2_1 {

    public static void main(String[] args) {
        LinkedNode nodes = LinkedNode.nodes(asList(3, 7, 1, 4, 2, 5, 3, 4, 3, 0, 1, 4, 5, 1, 2));
        System.out.println(printNodes(nodes));
        System.out.println(printNodes(new RemoveDuplicates_2_1().removeDupsN2(nodes)));
        System.out.println(printNodes(new RemoveDuplicates_2_1().removeDupsN(nodes)));
    }

    public LinkedNode removeDupsN2(LinkedNode root) {
        LinkedNode first = root;
        while (first != null) {
            LinkedNode second = first;
            while (second.next != null) {
                if (second.next.val == first.val) {
                    second.next = second.next.next;
                } else {
                    second = second.next;
                }

                }
            first = first.next;
        }

        return root;
    }

    public LinkedNode removeDupsN(LinkedNode root) {
        Set<Integer> existing = new HashSet<>();
        LinkedNode node = root;
        LinkedNode parent = null;

        while (node != null) {
            if (existing.contains(node.val)) {
                parent.next = node.next;
            } else {
                existing.add(node.val);
                parent = node;
            }
            node = node.next;
        }
        return root;
    }
}
