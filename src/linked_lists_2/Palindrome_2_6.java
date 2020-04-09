package linked_lists_2;

import java.util.Stack;

import static java.util.Arrays.asList;

public class Palindrome_2_6 {

    public static void main(String[] args) {
        System.out.println(new Palindrome_2_6().isPalindrome(LinkedNode.nodes(asList(7))));
        System.out.println(new Palindrome_2_6().isPalindrome(LinkedNode.nodes(asList(7, 1, 6))));
        System.out.println(new Palindrome_2_6().isPalindrome(LinkedNode.nodes(asList(7, 1, 6, 1, 7)))); // 1-1 6 7
        System.out.println(new Palindrome_2_6().isPalindrome(LinkedNode.nodes(asList(7, 1, 6, 6, 1, 7)))); // 1-6 2-6 null
    }


    private boolean isPalindrome(LinkedNode head) {
        int length = lengthOfList(head);
        Result p = isPalindromeRecurse(head, length);
        return p.result;
    }

    private Result isPalindromeRecurse(LinkedNode head, int length) {
        if (head == null || length <= 0) {
            return new Result(head, true);
        } else if (length == 1) {
            return new Result(head.next, true);
        }


        Result res = isPalindromeRecurse(head.next, length - 2);

        if (!res.result || res.node == null) {
            return res;
        }

        res.result = (head.val == res.node.val);

        res.node = res.node.next;

        return res;

    }

    static class Result {
        public LinkedNode node;
        public boolean result;

        public Result(LinkedNode node, boolean result) {
            this.node = node;
            this.result = result;
        }
    }

    int lengthOfList(LinkedNode n) {
        int size = 0;
        while (n != null) {
            size++;
            n = n.next;
        }
        return size;
    }


    private boolean isPalindromeStack(LinkedNode nodes) {
        LinkedNode slow = nodes;
        LinkedNode fast = nodes;
        Stack<LinkedNode> stack = new Stack<>();

        while (fast != null && fast.next != null) {
            stack.push(slow);
            slow = slow.next;
            fast = fast.next.next;
        }

        if (fast != null)
            slow = slow.next;

        while (!stack.isEmpty() || slow != null) {
            if (stack.pop().val != slow.val)
                return false;
            slow = slow.next;
        }
        return true;
    }

}
