package queues_stacks_3;

import java.util.Stack;

public class QueueOnStacks_3_4 {
    public static void main(String[] args) {

        QueueOnStacks_3_4 q = new QueueOnStacks_3_4();

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


    Stack<Integer> newest = new Stack<>();
    Stack<Integer> oldest = new Stack<>();

    public void add(int o) {
        newest.push(o);
    }

    private void shift() {
        if (oldest.isEmpty()) {
            while (!newest.isEmpty())
                oldest.push(newest.pop());
        }
    }
    
    public int remove() {
        shift();
        return oldest.pop();
    }

    public int peek() {
        shift();
        return oldest.peek();
    }
    
    public boolean isEmpty() {
        return newest.isEmpty() && oldest.isEmpty();
    }

    public int size() {
        return newest.size() + oldest.size();
    }
}
