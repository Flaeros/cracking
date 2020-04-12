package queues_stacks_3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class SetOfStacks_3_3 {

    public static void main(String[] args) {

        SetOfStacks_3_3 stacks = new SetOfStacks_3_3();

        stacks.push(1);
        stacks.push(2);
        stacks.push(3);
        stacks.push(4);
        System.out.println("peek = " + stacks.peek());
        stacks.push(5);
        stacks.push(6);
        stacks.push(7);
        System.out.println("peek = " + stacks.peek());
        stacks.pop();
        System.out.println("peek = " + stacks.peek());
        stacks.pop();
        stacks.pop();
        System.out.println("peek = " + stacks.peek());
    }


    static int maxCapacity = 2;

    int currentStack = 0;

    List<Stack<Integer>> stacks = new ArrayList<>();

    public SetOfStacks_3_3() {
        stacks.add(new Stack<>());
    }

    void push(int val) {
        if (stacks.size() < currentStack) {
            currentStack++;
            stacks.add(new Stack<>());
        }

        Stack<Integer> stack = stacks.get(currentStack);
        if (stack.size() == maxCapacity) {
            stack = new Stack<>();
            currentStack++;
            stacks.add(stack);
        }
        stack.push(val);
    }

    int pop() {
        if (stacks.isEmpty())
            return 0;
        Stack<Integer> stack = stacks.get(currentStack);
        if (stack.isEmpty()) {
            if (currentStack == 0)
                return 0;
            stack = stacks.get(--currentStack);
        }
        return stack.pop();
    }

    int peek() {
        if (stacks.isEmpty())
            return 0;
        Stack<Integer> stack = stacks.get(currentStack);

        if (stack.isEmpty()) {
            if (currentStack == 0)
                return 0;
            stack = stacks.get(--currentStack);
        }
        return stack.peek();
    }

    boolean isEmpty() {
        return stacks.isEmpty() || stacks.get(0).isEmpty();
    }
}
