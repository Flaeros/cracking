package arrays_strings_1;

import java.util.Arrays;

public class RotateMatrix_1_7 {
    public static void main(String[] args) {

        int[][] mx = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 14, 15}};
        System.out.println(printDim(mx));
        System.out.println(printDim(new RotateMatrix_1_7().rotateMatrix(mx)));


        mx = new int[][]{
                {0, 1, 2, 3, 4},
                {5, 6, 7, 8, 9},
                {10, 11, 12, 13, 14},
                {15, 16, 17, 18, 19},
                {20, 21, 22, 23, 24}};
        System.out.println(printDim(mx));
        System.out.println(printDim(new RotateMatrix_1_7().rotateMatrix(mx)));

    }

    public static String printDim(int[][] rotateMatrix) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < rotateMatrix.length; i++) {
            builder.append(Arrays.toString(rotateMatrix[i]));
            builder.append("\n");
        }
        return builder.toString();
    }

    private int[][] rotateMatrix(int[][] mx) {
        int N = mx.length;

        int temp;

        for (int innerCircleIdx = 0; innerCircleIdx < N / 2; innerCircleIdx++) {

            int lastCircleReplaceIdx = N - innerCircleIdx - 1;

            for (int innerReplaceIdx = innerCircleIdx; innerReplaceIdx < lastCircleReplaceIdx; innerReplaceIdx++) {
                int i = innerReplaceIdx;
                int j = innerCircleIdx;
                int current = mx[i][j];

                for (int k = 0; k < 4; k++) {
                    int nextI = j;
                    int nextJ = N - 1 - i;

                    temp = mx[nextI][nextJ];
                    mx[nextI][nextJ] = current;
                    current = temp;

                    i = nextI;
                    j = nextJ;
                }
            }
        }

        return mx;
    }
}
