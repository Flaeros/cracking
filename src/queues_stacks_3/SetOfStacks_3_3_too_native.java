package queues_stacks_3;

public class SetOfStacks_3_3_too_native {

    public static void main(String[] args) {

        SetOfStacks_3_3_too_native stacks = new SetOfStacks_3_3_too_native();

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


    static int initialCapacity = 1;
    static int maxCapacity = 2;

    int size = 0;
    int currentSize = 0;
    int currentArray = 0;
    int currentIndex = 0;

    int[][] array = new int[initialCapacity][maxCapacity];

    void push(int val) {
        if (currentSize == maxCapacity)
            extend();
        if (currentSize > 0)
            currentIndex++;
        array[currentArray][currentIndex] = val;

        currentSize++;
        size++;
    }

    int pop() {
        if (isEmpty())
            return 0;

        int val = array[currentArray][currentIndex];
        array[currentArray][currentIndex] = 0;
        currentSize--;
        size--;

        shift();

        if (currentIndex > 0)
            currentIndex--;

        return val;
    }

    int peek() {
        return array[currentArray][currentIndex];
    }

    boolean isEmpty() {
        return size == 0;
    }

    private void shift() {
        if (currentArray == 0)
            return;

        if (currentIndex == 0 && currentSize == 0) {
            currentArray--;
            currentIndex = maxCapacity - 1;
            currentSize = maxCapacity;
        }
    }

    private void extend() {
        if (currentArray == array.length - 1) {
            int[][] newArray = new int[array.length + 2][maxCapacity];
            for (int i = 0; i < array.length; i++) {
                for (int j = 0; j < maxCapacity; j++) {
                    newArray[i][j] = array[i][j];
                }
            }
            array = newArray;
            currentArray++;
            currentIndex = 0;
            currentSize = 0;
        } else {
            currentArray++;
            currentIndex = 0;
            currentSize = 0;
        }
    }
}
