package arrays_strings_1;

import static arrays_strings_1.RotateMatrix_1_7.printDim;

public class ZeroMatrix_1_8 {

    public static void main(String[] args) {

        int[][] mx = {
                {0, 1, 2, 3},
                {4, 5, 6, 7},
                {8, 9, 10, 11},
                {12, 13, 0, 15},
                {16, 17, 18, 19}
        };
        System.out.println(printDim(mx));
        System.out.println(printDim(new ZeroMatrix_1_8().zeroMatrix(mx)));


        mx = new int[][]{
                {0, 1, 2, 3, 4, 0},
                {5, 6, 7, 8, 9, 26},
                {10, 0, 12, 13, 14, 27},
                {15, 16, 0, 18, 19, 28},
                {20, 21, 22, 23, 24, 29}};
        System.out.println(printDim(mx));
        System.out.println(printDim(new ZeroMatrix_1_8().zeroMatrix(mx)));

    }

    private int[][] zeroMatrix(int[][] mx) {
        int M = mx.length;
        int N = mx[0].length;

        int[] zeroI = new int[M];
        int[] zeroJ = new int[N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j <N; j++) {
                if (mx[i][j] == 0) {
                    zeroI[i] = 1;
                    zeroJ[j] = 1;
                }
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (zeroI[i] == 1 || zeroJ[j] == 1)
                    mx[i][j] = 0;
            }
        }

        return mx;
    }

}
