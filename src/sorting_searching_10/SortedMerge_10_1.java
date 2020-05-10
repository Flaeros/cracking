package sorting_searching_10;

import java.util.Arrays;

public class SortedMerge_10_1 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortedMerge_10_1().sortedMerge(new int[]{4, 5, 6, 0, 0, 0}, new int[]{1, 2, 3})));
        System.out.println(Arrays.toString(new SortedMerge_10_1().sortedMerge(new int[]{1, 3, 5, 7, 0, 0, 0}, new int[]{2, 4, 6})));
        System.out.println(Arrays.toString(new SortedMerge_10_1().sortedMerge(new int[]{1, 2, 3, 0, 0, 0}, new int[]{4, 5, 6})));
    }

    public int[] sortedMerge(int[] a, int[] b) {
        int lastA = a.length - b.length - 1;
        int lastB = b.length - 1;
        int last = a.length-1;
        while (lastB >= 0) {
            if (lastA >= 0 && a[lastA] > b[lastB]) {
                a[last--] = a[lastA--];
            } else {
                a[last--] = b[lastB--];
            }
        }
        return a;
    }

    public int[] sortedMerge2(int[] a, int[] b) {
        int pos = 0;
        for (int num : b) {
            while (num > a[pos] && a[pos] != 0) {
                pos++;
            }
            insertShift(a, num, pos);
        }

        return a;
    }

    private void insertShift(int[] a, int num, int pos) {
        for (int i = a.length - 1; i >= pos && i > 1; i--) {
            a[i] = a[i - 1];
        }
        a[pos] = num;
    }

}
