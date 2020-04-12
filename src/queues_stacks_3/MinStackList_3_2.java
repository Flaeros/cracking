package queues_stacks_3;

/**
 * Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 */
public class MinStackList_3_2 {

    public static void main(String[] args) {
        MinStackList_3_2 minStack = new MinStackList_3_2();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-1);
        // Returns -3.
        System.out.println("minStack = " + minStack.getMin());
        minStack.pop();
        minStack.top();
        // Returns 0.
        System.out.println("minStack = " + minStack.getMin());

    }


    /**
     * initialize your data structure here.
     */
    public MinStackList_3_2() {
    }

    Node head = null;

    static class Node {
        int val;
        int min;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void push(int x) {
        Node node = new Node(x);
        node.min = head == null ? x : Math.min(x, head.min);
        node.next = head;
        head = node;
    }

    public void pop() {
        if (head != null)
            head = head.next;
    }

    public int top() {
        if (head == null)
            return 0;

        return head.val;
    }

    public int getMin() {
        if (head == null)
            return 0;
        return head.min;
    }

}
