package linked_lists_2;

import static java.util.Arrays.asList;

public class SumLists_2_5 {

    public static void main(String[] args) {
        System.out.println(LinkedNode.printNodes(new SumLists_2_5().sumLists(LinkedNode.nodes(asList(7, 1, 6)), LinkedNode.nodes(asList(5, 9, 2)))));
        System.out.println(LinkedNode.printNodes(new SumLists_2_5().sumLists(LinkedNode.nodes(asList(7, 1)), LinkedNode.nodes(asList(5, 9, 2)))));

        System.out.println(LinkedNode.printNodes(new SumLists_2_5().sumListsReverse(LinkedNode.nodes(asList(6, 1, 7)), LinkedNode.nodes(asList(2, 9, 5)))));
        System.out.println(LinkedNode.printNodes(new SumLists_2_5().sumListsReverse(LinkedNode.nodes(asList(0, 1, 7)), LinkedNode.nodes(asList(2, 9, 5)))));
    }

    private LinkedNode sumListsReverse(LinkedNode a, LinkedNode b) {
        if (a == null && b == null) {
            return null;
        }

        LinkedNode linkedNode = sumListsReverse(a != null ? a.next : null, b != null ? b.next : null);

        int overhead = 0;
        if (linkedNode != null) {
            int val = linkedNode.val;
            int digit = val % 10;
            overhead = val / 10;
            linkedNode.val = digit;
        }

        int av = a != null ? a.val : 0;
        int bv = b != null ? b.val : 0;

        LinkedNode node = new LinkedNode(av + bv + overhead);
        node.next = linkedNode;
        return node;
    }

    private LinkedNode sumLists(LinkedNode a, LinkedNode b) {
        LinkedNode tail = null;
        LinkedNode head = null;

        int digit = 0;
        int overhead = 0;

        while (a != null || b != null) {
            int av = a != null ? a.val : 0;
            int bv = b != null ? b.val : 0;
            int sum = av + bv + overhead;

            digit = sum > 9 ? sum % 10 : sum;
            overhead = sum > 9 ? sum / 10 : 0;

            LinkedNode node = new LinkedNode(digit);

            if (head == null) {
                head = node;
            } else {
                tail.next = node;
            }

            tail = node;

            if (a != null)
                a = a.next;
            if (b != null)
                b = b.next;
        }

        return head;
    }
}
