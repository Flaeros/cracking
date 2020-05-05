package recursion_dynamic_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EightQueens_8_12 {
    static int GRID_SIZE = 8;

    public static void main(String[] args) {
        List<Integer[]> results = new EightQueens_8_12().placeQueens();
        System.out.println(printDim(results));

        for (Integer[] result : results) {
            System.out.println(printResult(result));
        }
    }

    private List<Integer[]> placeQueens() {
        List<Integer[]> result = new ArrayList<>();
        placeQueens(0, new Integer[GRID_SIZE], result);
        return result;
    }

    void placeQueens(int row, Integer[] columns, List<Integer[]> results) {
        if (row == GRID_SIZE) {
            results.add(columns.clone());
        } else {
            for (int col = 0; col < GRID_SIZE; col++) {
                if (isValid(columns, row, col)) {
                    columns[row] = col;
                    placeQueens(row + 1, columns, results);
                }
            }
        }
    }

    private boolean isValid(Integer[] columns, int row1, int col1) {
        for (int row2 = 0; row2 < row1; row2++) {
            int col2 = columns[row2];

            if (col1 == col2)
                return false;

            int colDistance = Math.abs(col1 - col2);
            int rowDistance = row1 - row2;
            if (colDistance == rowDistance)
                return false;
        }
        return true;
    }

    private static String printResult(Integer[] result) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (result[i] == j) {
                    sb.append("Q, ");
                } else {
                    sb.append("_, ");
                }
            }
            sb.append("\n");
        }
        sb.append("\n");
        return sb.toString();
    }

    public static String printDim(List<Integer[]> mx) {
        StringBuilder builder = new StringBuilder();
        for (Integer[] integers : mx) {
            builder.append(Arrays.toString(integers));
            builder.append("\n");
        }
        return builder.toString();
    }

}
