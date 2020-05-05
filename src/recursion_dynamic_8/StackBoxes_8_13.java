package recursion_dynamic_8;

import java.util.List;

import static java.util.Arrays.asList;

public class StackBoxes_8_13 {

    public static void main(String[] args) {
        System.out.println(new StackBoxes_8_13().createStack(asList(
                new Box(1, 4, 2),
                new Box(4, 5, 3),
                new Box(3, 5, 4),
                new Box(1, 3, 2),
                new Box(1, 1, 2),
                new Box(1, 2, 2),
                new Box(6, 7, 6),
                new Box(5, 6, 4)
        )));
    }

    int createStack(List<Box> boxes) {
        boxes.sort(Box::compareTo);

        int[] memo = new int[boxes.size()];
        int stack = createStack(boxes, null, 0, memo);
        return stack;
    }

    private int createStack(List<Box> boxes, Box bottom, int offset, int[] memo) {
        if (offset >= boxes.size())
            return 0;

        Box newBottom = boxes.get(offset);
        int heightWithBottom = 0;

        if (bottom == null || newBottom.canBeAbove(bottom)) {
            if (memo[offset] == 0) {
                memo[offset] = createStack(boxes, newBottom, offset + 1, memo);
                memo[offset] += newBottom.height;
            }
            heightWithBottom = memo[offset];
        }

        int heightWithoutBottom = createStack(boxes, bottom, offset + 1, memo);

        return Math.max(heightWithBottom, heightWithoutBottom);
    }

    static class Box implements Comparable<Box> {
        int width;
        int height;
        int depth;

        public Box(int width, int height, int depth) {
            this.width = width;
            this.height = height;
            this.depth = depth;
        }

        boolean canBeAbove(Box o) {
            return o.width > width && o.height > height && o.depth > depth;
        }

        @Override
        public int compareTo(Box o) {
            return -1 * Integer.compare(this.height, o.height);
        }
    }
}
