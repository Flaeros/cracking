package recursion_dynamic_8;

import java.util.Arrays;

public class RobotInAGrid_8_2 {
    public static void main(String[] args) {
        System.out.println(new RobotInAGrid_8_2().findPath(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1}

        }));

        System.out.println(new RobotInAGrid_8_2().findPath(new int[][]{
                {1, 1, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {1, 0, 1, 1, 1},
                {1, 0, 1, 1, 1}

        }));
    }

    int[][] offsets = new int[][]{
            {-1, 0}, {0, -1}
    };

    String findPath(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (grid[i][j] == 0)
                    continue;
                for (int[] offset : offsets) {
                    if (inBound(i, j, r, c, offset)) {
                        int offsetVal = grid[i + offset[0]][j + offset[1]];
                        if (grid[i][j] <= offsetVal)
                            grid[i][j] = offsetVal + 1;
                    }
                }
            }
        }

        System.out.println(printDim(grid));

        StringBuilder sb = new StringBuilder();
        int i = r - 1;
        int j = c - 1;
        while (i > 0 || j > 0) {
            for (int[] offset : offsets) {
                if (inBound(i, j, r, c, offset)) {
                    int offsetVal = grid[i + offset[0]][j + offset[1]];
                    if (offsetVal > 0) {
                        if (offset[0] == -1) {
                            sb.append("D");
                            i--;
                        } else {
                            sb.append("R");
                            j--;
                        }
                        break;
                    }
                }
            }
        }

        return sb.reverse().toString();
    }

    private boolean inBound(int i, int j, int r, int c, int[] offset) {
        if (i + offset[0] < 0 || i + offset[0] > r - 1)
            return false;
        if (j + offset[1] < 0 || j + offset[1] > c - 1)
            return false;
        return true;
    }

    public static String printDim(int[][] arr) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            builder.append(Arrays.toString(arr[i]));
            builder.append("\n");
        }
        return builder.toString();
    }

}
