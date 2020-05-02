package recursion_dynamic_8;

public class RobotInGridExt {
    public static void main(String[] args) {
        System.out.println(new RobotInGridExt().findPath(new int[][]{
                {1, 1, 0, 0, 0},
                {1, 1, 1, 0, 0},
                {0, 0, 1, 1, 0},
                {0, 0, 0, 1, 1}

        }));
        System.out.println(new RobotInGridExt().findPath(new int[][]{
                {1, 1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {0, 1, 0, 1, 0, 1},
                {1, 1, 1, 1, 0, 1},
                {1, 0, 0, 1, 0, 1},
                {1, 0, 1, 1, 0, 1},
                {1, 0, 1, 0, 0, 1},
                {1, 0, 1, 1, 1, 1},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 1, 0, 0},
                {1, 0, 0, 0, 0, 0},
                {1, 1, 1, 1, 1, 1}
        }));
        System.out.println(new RobotInGridExt().findPath(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1}
        }));

        System.out.println(new RobotInGridExt().findPath(new int[][]{
                {1, 1, 1},
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 0},
                {1, 1, 1}
        }));
    }

    int[][] offsets = new int[][]{
                    {-1, 0},
            {0, -1},          {0, 1},
                    {1, 0}
    };

    int[][] memo;
    int r;
    int c;

    String findPath(int[][] grid) {
        r = grid.length;
        c = grid[0].length;
        memo = new int[r][c];

        traverse(0, 0, 0, grid);

        //debug
        System.out.println();
        System.out.println(printDim(memo));

        return getPath();
    }

    private void traverse(int i, int j, int sum, int[][] grid) {
        if (memo[i][j] != 0 || grid[i][j] == 0)
            return;

        sum++;
        memo[i][j] = sum;

        for (int[] offset : offsets) {
            if (inBound(i + offset[0], j + offset[1])) {
                traverse(i + offset[0], j + offset[1], sum, grid);
            }
        }
    }

    private String getPath() {
        StringBuilder sb = new StringBuilder();
        int i = r - 1;
        int j = c - 1;
        while (i > 0 || j > 0) {
            for (int[] offset : offsets) {
                if (inBound(i + offset[0], j + offset[1])) {
                    int offsetVal = memo[i + offset[0]][j + offset[1]];
                    if (offsetVal + 1 == memo[i][j]) {
                        if (offset[0] == -1 && offset[1] == 0) {
                            sb.append("D");
                            i--;
                        } else if (offset[0] == 0 && offset[1] == -1) {
                            sb.append("R");
                            j--;
                        } else if (offset[0] == 0 && offset[1] == 1) {
                            sb.append("L");
                            j++;
                        } else if (offset[0] == 1 && offset[1] == 0) {
                            sb.append("U");
                            i++;
                        }
                        break;
                    }
                }
            }
        }

        return sb.reverse().toString();
    }

    private boolean inBound(int i, int j) {
        if (i < 0 || i > r - 1)
            return false;
        if (j < 0 || j > c - 1)
            return false;
        return true;
    }

    public static String printDim(int[][] arr) {
        StringBuilder builder = new StringBuilder();
        for (int[] ints : arr) {
            for (int val : ints) {
                if (val < 10) {
                    builder.append("0");
                    builder.append(val);
                    builder.append(" ");
                } else {
                    builder.append(val);
                    builder.append(" ");
                }
            }
            builder.append("\n");
        }
        return builder.toString();
    }

}
