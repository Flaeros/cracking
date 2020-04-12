package queues_stacks_3;

import java.util.Arrays;

public class ThreeStacks_3_1 {


    public static void main(String[] args) {

        ThreeStacks_3_1 stacks = new ThreeStacks_3_1();

        stacks.push(0, 1);
        stacks.push(0, 2);
        stacks.push(0, 3);
        stacks.push(0, 4);
        stacks.push(0, 5);

        stacks.push(1, 6);
        System.out.println("stack 1 pop = " + stacks.pop(1));
        System.out.println("stack 1 pop = " + stacks.pop(1));

        stacks.push(1, 6);
        stacks.push(1, 7);
        stacks.push(1, 8);
        stacks.push(1, 9);
        stacks.push(1, 10);


        stacks.push(2, 11);
        stacks.push(2, 12);
        stacks.push(2, 13);
        stacks.push(2, 14);
        stacks.push(2, 15);
        stacks.push(2, 16);


        System.out.println("stacks = " + Arrays.toString(stacks.array));
    }

    static int initialCapacity = 10;
    int array[] = new int[initialCapacity];

    int stackCount = 3;
    StackInfo[] stackInfo = new StackInfo[3];


    public ThreeStacks_3_1() {
        stackInfo[0] = new StackInfo(0, 0, 0);
        stackInfo[1] = new StackInfo(4, 4, 0);
        stackInfo[2] = new StackInfo(7, 7, 0);
    }

    void push(int stackNum, int val) {
        if (reachedCapacity()) {
            extend();
        }

        if (stackInfo[stackNum].currIdx == stackInfo[stackNum].beginIdx)
            array[stackInfo[stackNum].currIdx] = val;
        else
            array[stackInfo[stackNum].currIdx++] = val;
        stackInfo[stackNum].size++;
    }

    int pop(int stackNum) {
        if (stackInfo[stackNum].size > 0) {
            stackInfo[stackNum].size--;

            if (stackInfo[stackNum].currIdx == stackInfo[stackNum].beginIdx)
                return array[stackInfo[stackNum].currIdx];
            else
                return array[stackInfo[stackNum].currIdx--];

        }
        return 0;
    }

    int peek(int stackNum) {
        if (stackInfo[stackNum].size > 0)
            return array[stackInfo[stackNum].currIdx];
        return 0;
    }

    boolean isEmpty() {
        return getSize() == 0;
    }

    private boolean reachedCapacity() {
        return stackInfo[0].currIdx + 1 == stackInfo[1].beginIdx ||
                stackInfo[1].currIdx + 1 == stackInfo[2].beginIdx ||
                stackInfo[2].currIdx == array.length;
    }

    private int getSize() {
        return stackInfo[0].size + stackInfo[1].size + stackInfo[2].size;
    }

    void extend() {
        if (stackInfo[0].currIdx + 1 >= stackInfo[1].beginIdx)
            extend(0);
        if (stackInfo[1].currIdx + 1 >= stackInfo[2].beginIdx)
            extend(1);
        if (stackInfo[2].currIdx >= array.length)
            extend(2);
    }

    void extend(int stackNum) {
        int extension = 2 * (stackInfo[stackNum].currIdx - stackInfo[stackNum].beginIdx);
        if (extension == 0)
            extension = initialCapacity;

        int newLength = array.length + extension;

        int[] newArray = new int[newLength];
        for (int i = 0; i < stackCount; i++) {
            StackInfo oldStackInfo = stackInfo[i];
            StackInfo newStackInfo;
            if (i > stackNum)
                newStackInfo = new StackInfo(oldStackInfo.beginIdx + extension, oldStackInfo.currIdx + extension, oldStackInfo.size);
            else
                newStackInfo = new StackInfo(oldStackInfo.beginIdx, oldStackInfo.currIdx, oldStackInfo.size);

            for (int j = oldStackInfo.beginIdx, k = newStackInfo.beginIdx; j < oldStackInfo.currIdx && k < newStackInfo.currIdx; j++, k++) {
                newArray[k] = array[j];
            }
            stackInfo[i] = newStackInfo;
        }

        array = newArray;
    }


    static class StackInfo {
        int beginIdx;
        int currIdx;
        int size;

        public StackInfo(int beginIdx, int currIdx, int size) {
            this.beginIdx = beginIdx;
            this.currIdx = currIdx;
            this.size = size;
        }
    }
}