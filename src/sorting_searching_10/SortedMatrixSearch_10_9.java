package sorting_searching_10;

public class SortedMatrixSearch_10_9 {

    public static void main(String[] args) {
        System.out.println(new SortedMatrixSearch_10_9().findElement(new int[][]{
                {10, 15, 20, 25},
                {15, 20, 30, 35},
                {21, 25, 35, 45},
                {25, 30, 40, 50}}, 21));

    }

    boolean findElement(int[][] matrix, int num) {
        int row = 0;
        int col = matrix[0].length - 1;

        while (col < matrix.length && col >= 0) {
            System.out.println(row + " " + col);
            if (matrix[row][col] == num) {
                return true;
            } else if (matrix[row][col] > num) {
                col--;
            } else {
                row++;
            }
        }

        return false;
    }
}
