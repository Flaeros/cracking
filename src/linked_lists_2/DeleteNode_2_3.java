package linked_lists_2;

import static java.util.Arrays.asList;
import static linked_lists_2.LinkedNode.printNodes;

public class DeleteNode_2_3 {

    public static void main(String[] args) {
        LinkedNode nodes = LinkedNode.nodes(asList(3, 7, 1, 4, 2, 5, 3));
        System.out.println(printNodes(nodes));
        new DeleteNode_2_3().deleteNode(nodes.next.next);
        System.out.println(printNodes(nodes));

    }

    public void deleteNode(LinkedNode root) {
       if (root == null || root.next == null)
           return;

        root.val = root.next.val;
        root.next = root.next.next;
    }
}
