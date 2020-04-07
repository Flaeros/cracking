import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new QuickSort().sort(new int[]{4, 1, 7})));
        System.out.println(Arrays.toString(new QuickSort().sort(new int[]{4, 1, 7, 3, 8, 6, 9, 2, 5, 9})));
    }

    private int[] sort(int[] ints) {
        quickSort(ints, 0, ints.length - 1);
        return ints;
    }

    private void quickSort(int[] ints, int left, int right) {

        int partitionIndex = partition(ints, left, right);
        if (partitionIndex - 1 > left)
            quickSort(ints, left, partitionIndex - 1);
        if (partitionIndex + 1 < right)
            quickSort(ints, partitionIndex + 1, right);
    }

    private int partition(int[] ints, int left, int right) {
        int pivot = ints[right];
        int partPtr = left;

        for (int i = left; i < right; i++) {
            if (ints[i] < pivot) {
                int temp = ints[i];
                ints[i] = ints[partPtr];
                ints[partPtr++] = temp;
            }
        }

        int temp = ints[partPtr];
        ints[partPtr] = ints[right];
        ints[right] = temp;

        return partPtr;
    }
}
