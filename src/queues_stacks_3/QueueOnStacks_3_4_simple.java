package queues_stacks_3;

import java.util.Stack;

public class QueueOnStacks_3_4_simple {
    public static void main(String[] args) {

        QueueOnStacks_3_4_simple q = new QueueOnStacks_3_4_simple();

        q.add(0);
        q.add(1);
        q.add(2);
        q.add(3);

        System.out.println("q.remove() = " + q.remove());
        System.out.println("q.peek() = " + q.peek());
        q.add(4);
        System.out.println("q.peek() = " + q.peek());
        System.out.println("q.remove() = " + q.remove());
    }


    Stack<Integer> main = new Stack<>();
    Stack<Integer> util = new Stack<>();

    public void add(int o) {
        while(!main.isEmpty())
            util.push(main.pop());
        main.push(o);
        while(!util.isEmpty())
            main.push(util.pop());
    }

    
    public int remove() {
        return main.pop();
    }

    
    public boolean isEmpty() {
        return main.isEmpty();
    }

    
    public int peek() {
        return main.peek();
    }
}
