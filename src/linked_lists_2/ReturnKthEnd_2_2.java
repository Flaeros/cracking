package linked_lists_2;

import java.util.concurrent.atomic.AtomicInteger;

import static java.util.Arrays.asList;

public class ReturnKthEnd_2_2 {
    public static void main(String[] args) {
        LinkedNode nodes = LinkedNode.nodes(asList(3, 7, 1, 4, 2, 5, 3, 4, 3, 0, 1, 4, 5, 1, 2));
        System.out.println(new ReturnKthEnd_2_2().returnKthFrom2P(nodes, 3).val);
        System.out.println(new ReturnKthEnd_2_2().returnKthFrom2P(nodes, 15).val);
        System.out.println(new ReturnKthEnd_2_2().returnKthFrom2P(nodes, 1).val);
    }

    public LinkedNode returnKthFrom2P(LinkedNode root, int k) {
        LinkedNode first = root;
        LinkedNode second = root;

        for (int i = 0; i < k; i++) {
            if (second == null)
                return null;
            second = second.next;
        }

        while (second != null) {
            second = second.next;
            first = first.next;
        }
        return first;
    }

    public LinkedNode returnKthFromEnd(LinkedNode root, int k) {
        return returnKthFromEnd(root, k, new AtomicInteger(0));
    }

    public LinkedNode returnKthFromEnd(LinkedNode root, int k, AtomicInteger idx) {
        if (root == null)
            return null;

        LinkedNode linkedNode = returnKthFromEnd(root.next, k, idx);
        idx.incrementAndGet();
        if (idx.get() == k)
            return root;
        return linkedNode;
    }

    public LinkedNode returnKthFromEndCount(LinkedNode root, int k) {
        int size = 0;
        LinkedNode node = root;
        while (node != null) {
            size++;
            node = node.next;
        }

        node = root;
        int count = 0;
        while (node != null) {
            count++;

            if (size - count == k)
                return node;
            node = node.next;
        }

        return null;
    }
}
//8, #25, #41, #67, #126
