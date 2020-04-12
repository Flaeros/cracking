package queues_stacks_3;

import java.util.Stack;

public class SortStack_3_5 {
    public static void main(String[] args) {

        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(1);
        stack.push(2);
        stack.push(5);
        stack.push(8);
        stack.push(2);
        stack.push(8);
        stack.push(2);
        stack.push(9);

        stack = sortStack(stack);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " ");
        }
    }

    private static Stack<Integer> sortStack(Stack<Integer> stack) {
        Stack<Integer> second = new Stack<>();
        second.push(stack.pop());

        while (!stack.isEmpty()) {
            Integer current = stack.pop();
            while (!second.isEmpty() && current < second.peek()) {
                stack.push(second.pop());
            }
            second.push(current);
        }

        while (!second.isEmpty())
            stack.push(second.pop());

        return stack;
    }
}
