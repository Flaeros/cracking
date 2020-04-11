package linked_lists_2;

import static java.util.Arrays.asList;

public class Intersection_2_7 {

    public static void main(String[] args) {
        LinkedNode a = LinkedNode.nodes(asList(7, 1, 6));
        LinkedNode b = LinkedNode.nodes(asList(5, 9, 2));
        LinkedNode c = LinkedNode.nodes(asList(3, 8, 4));

        a.next.next = c;
        b.next.next = c;

        System.out.println(new Intersection_2_7().intersectionRec(a, b).val);

        a = LinkedNode.nodes(asList(7, 1, 6, 9, 2));
        b = LinkedNode.nodes(asList(5));
        c = LinkedNode.nodes(asList(3));

        a.next.next.next.next.next = c;
        b.next = c;

        System.out.println(new Intersection_2_7().intersectionRec(a, b).val);
    }

    private LinkedNode intersectionRec(LinkedNode a, LinkedNode b) {
        if (a.next == null && b.next == null) {
            if (a == b)
                return a;
            else
                return null;
        }

        LinkedNode intersection = intersectionRec(a.next == null ? a : a.next, b.next == null ? b : b.next);
        if (intersection == null)
            return null;

        if (a == b)
            return a;

        return intersection;
    }

    private LinkedNode intersectionN2(LinkedNode a, LinkedNode b) {
        while (a.next != null) {
            LinkedNode bPtr = b;
            while (bPtr.next != null) {
                if (a == bPtr)
                    return a;
                bPtr = bPtr.next;
            }
            a = a.next;
        }
        return null;
    }
}
