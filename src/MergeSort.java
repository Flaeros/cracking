import java.util.Arrays;

public class MergeSort {


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MergeSort().sort(new int[]{4, 1, 7})));
        System.out.println(Arrays.toString(new MergeSort().sort(new int[]{4, 1, 7, 4, 8, 4, 9, 2, 4, 9})));
    }

    private int[] sort(int[] ints) {
        mergeSort(ints, 0, ints.length - 1);
        return ints;
    }

    private void mergeSort(int[] ints, int low, int high) {
        if (high <= low)
            return;

        int mid = (low + high) / 2;
        mergeSort(ints, low, mid);
        mergeSort(ints, mid + 1, high);
        merge(ints, low, mid, high);
    }

    private void merge(int[] ints, int low, int mid, int high) {
        int leftSize = mid - low + 1;
        int rightSize = high - mid;

        int[] left = new int[leftSize];
        int[] right = new int[rightSize];

        for (int i = 0; i < leftSize; ++i) {
            left[i] = ints[low + i];
        }

        for (int i = 0; i < rightSize; ++i) {
            right[i] = ints[mid + 1 + i];
        }

        int lowPtr = 0;
        int highPtr = 0;
        int workPtr = low;

        while (lowPtr < leftSize && highPtr < rightSize) {
            if (left[lowPtr] <= right[highPtr]) {
                ints[workPtr++] = left[lowPtr++];
            } else {
                ints[workPtr++] = right[highPtr++];
            }
        }

        while (lowPtr < leftSize)
            ints[workPtr++] = left[lowPtr++];

        while (highPtr < rightSize)
            ints[workPtr++] = right[highPtr++];
    }
}
