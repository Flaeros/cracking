package linked_lists_2;

import static java.util.Arrays.asList;

public class LoopDetection_2_8 {

    public static void main(String[] args) {
        LinkedNode a = LinkedNode.nodes(asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        loop(a, a);

        a = LinkedNode.nodes(asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        loop(a, a.next);

        a = LinkedNode.nodes(asList(1, 2, 3, 4, 5, 6, 7, 8, 9));
        loop(a, a.next.next);
    }

    private static void loop(LinkedNode root, LinkedNode loop) {
        root.next.next.next.next.next.next.next.next.next = loop;

        System.out.println(new LoopDetection_2_8().findLoop(root).val);
    }

    private LinkedNode findLoop(LinkedNode a) {
        LinkedNode slowPtr = a;
        LinkedNode fastPtr = a;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr)
                break;
        }

        if (slowPtr != fastPtr)
            return null;

        LinkedNode rootPtr = a;

        while (slowPtr != rootPtr) {
            slowPtr = slowPtr.next;
            rootPtr = rootPtr.next;
        }

        return rootPtr;
    }
}
