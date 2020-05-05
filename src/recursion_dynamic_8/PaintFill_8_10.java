package recursion_dynamic_8;

import static arrays_strings_1.RotateMatrix_1_7.printDim;

public class PaintFill_8_10 {
    public static void main(String[] args) {
        int[][] screen = {
                {1, 1, 1, 0, 1},
                {0, 1, 1, 0, 0},
                {0, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}

        };
        new PaintFill_8_10().fillPaint(screen, 1, 3, 0, 2);
        System.out.println(printDim(screen));
        new PaintFill_8_10().fillPaint(screen, 2, 0, 0, 3);
        System.out.println(printDim(screen));
        new PaintFill_8_10().fillPaint(screen, 1, 1, 1, 0);
        System.out.println(printDim(screen));
    }

    public void fillPaint(int[][] screen, int r, int c, int prev, int val) {
        if (r < 0 || r > screen.length - 1)
            return;
        if (c < 0 || c > screen[0].length - 1)
            return;
        if (screen[r][c] != prev)
            return;

        screen[r][c] = val;

        fillPaint(screen, r - 1, c, prev, val);
        fillPaint(screen, r, c + 1, prev, val);
        fillPaint(screen, r + 1, c, prev, val);
        fillPaint(screen, r, c - 1, prev, val);
    }
}
