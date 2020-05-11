package sorting_searching_10;

public class SearchInRotatedArray_10_3 {
    public static void main(String[] args) {
        System.out.println(new SearchInRotatedArray_10_3().search(new int[]{4, 5, 6, 0, 1, 2}, 5));
        System.out.println(new SearchInRotatedArray_10_3().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(new SearchInRotatedArray_10_3().search(new int[]{2, 3, 4, 5, 6, 7, 8, 9, 0, 1}, 1));
        System.out.println(new SearchInRotatedArray_10_3().search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
    }

    public int search(int[] nums, int target) {
        int low = 0;
        int len = nums.length;
        int high = len - 1;

        while (low < high) {
            int mid = (high + low) / 2;
            if (nums[mid] < nums[high]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        int shift = high;
        low = 0;
        high = len - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            int shiftedMid = (mid + shift) % len;

            if (nums[shiftedMid] == target) {
                return shiftedMid;
            } else if (nums[shiftedMid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }
}
