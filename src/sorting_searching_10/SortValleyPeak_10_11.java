package sorting_searching_10;

import java.util.Arrays;

public class SortValleyPeak_10_11 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new SortValleyPeak_10_11().sortValleyPeak(new int[]{9, 1, 0, 4, 8, 7})));
    }

    int[] sortValleyPeak(int[] a) {
        for (int i = 1; i < a.length; i += 2) {
            int biggestIndex = maxIndex(a, i);
            if (i != biggestIndex) {
                swap(a, i, biggestIndex);
            }
        }
        return a;
    }

    int maxIndex(int[] arr, int i) {
        int a = i - 1;
        int b = i;
        int c = i - 1;
        int len = arr.length;


        int aValue = a >= 0 && a < len ? arr[a] : Integer.MIN_VALUE;
        int bValue = b >= 0 && b < len ? arr[b] : Integer.MIN_VALUE;
        int cValue = c >= 0 && c < len ? arr[c] : Integer.MIN_VALUE;

        int max = Math.max(aValue, Math.max(bValue, cValue));

        if (aValue == max)
            return a;
        if (bValue == max)
            return b;
        return c;
    }

    void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }

}
