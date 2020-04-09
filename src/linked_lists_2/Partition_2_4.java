package linked_lists_2;

import static java.util.Arrays.asList;

public class Partition_2_4 {

    public static void main(String[] args) {
        System.out.println(LinkedNode.printNodes(new Partition_2_4().partition(LinkedNode.nodes(asList(3, 7, 1, 4, 2)), 3)));
        System.out.println(LinkedNode.printNodes(new Partition_2_4().partition(LinkedNode.nodes(asList(3, 7, 1, 4, 2, 5, 3, 4, 3, 0, 1, 4, 5, 1, 2)), 5)));

    }

    private LinkedNode partition(LinkedNode node, int p) {
        LinkedNode lowRoot = null;
        LinkedNode lower = null;
        LinkedNode highRoot = null;
        LinkedNode higher = null;

        while (node != null) {
            LinkedNode next = node.next;
            node.next = null;


            if (node.val < p) {
                if (lowRoot == null) {
                    lowRoot = node;
                    lower = lowRoot;
                } else {
                    lower.next = node;
                    lower = node;
                }

            } else {
                if (highRoot == null) {
                    highRoot = node;
                    higher = highRoot;
                } else {
                    higher.next = node;
                    higher = node;
                }
            }
            node = next;
        }

        if (lowRoot == null)
            return highRoot;

        lower.next = highRoot;

        return lowRoot;
    }

}
