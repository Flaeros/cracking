package recursion_dynamic_8;

public class MagicNumber_8_3 {
    public static void main(String[] args) {
        System.out.println(new MagicNumber_8_3().findMagicNumber(new int[]{-5, -3, 0, 1, 4, 7, 10}));
        System.out.println(new MagicNumber_8_3().findMagicNumber(new int[]{-5, -3, 0, 1, 7, 10}));
        //System.out.println(new MagicNumber_8_3().findMagicNumberDistinct(new int[]{2, 2, 2, 4, 7, 10}));
        //System.out.println(new MagicNumber_8_3().findMagicNumberDistinct(new int[]{-1, -1, 0, 1, 1, 5, 10}));
    }

    public int findMagicNumber(int[] arr) {
        return findMagicNumber(arr, 0, arr.length);
    }


    private int findMagicNumber(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int midIndex = low + (high - low) / 2;
        int midVal = arr[midIndex];

        System.out.println("midVal = " + midVal);


        if (arr[midIndex] == midIndex)
            return midIndex;

        int leftIndex = Math.min(midIndex - 1, midVal);
        int leftVal = findMagicNumber(arr, low, leftIndex);
        if (leftVal > 0)
            return leftVal;

        int rightIndex = Math.max(midIndex + 1, midVal);
        int rightVal = findMagicNumber(arr, rightIndex, high);

        return rightVal;
    }

    public int findMagicNumberDistinct(int[] arr) {
        return findMagicNumberDistinct(arr, 0, arr.length);
    }

    private int findMagicNumberDistinct(int[] arr, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = low + (high - low) / 2;


        System.out.println("arr[mid] = " + arr[mid]);

        if (arr[mid] == mid) {
            return mid;
        } else if (arr[mid] < mid) {
            return findMagicNumberDistinct(arr, mid + 1, high);
        } else {
            return findMagicNumberDistinct(arr, low, mid - 1);
        }
    }
}
