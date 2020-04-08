package linked_lists_2;

import static java.util.Arrays.asList;

public class ReturnKthEnd_2_2 {
    public static void main(String[] args) {
        LinkedNode nodes = LinkedNode.nodes(asList(3, 7, 1, 4, 2, 5, 3, 4, 3, 0, 1, 4, 5, 1, 2));
        System.out.println(new ReturnKthEnd_2_2().returnKthFromEnd(nodes, 3).val);
        System.out.println(new ReturnKthEnd_2_2().returnKthFromEnd(nodes, 14).val);
        System.out.println(new ReturnKthEnd_2_2().returnKthFromEnd(nodes, 0).val);
    }

    public LinkedNode returnKthFromEnd(LinkedNode root, int k) {
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
