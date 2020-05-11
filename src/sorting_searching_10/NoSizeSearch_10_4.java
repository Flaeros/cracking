package sorting_searching_10;

public class NoSizeSearch_10_4 {
    public static void main(String[] args) {
        System.out.println(new NoSizeSearch_10_4().findElement(new Listy(new int[]{1, 2, 3, 4, 5, 6, 7}), 3));
    }

    int findElement(Listy listy, int val) {
        int low = 0;
        int high = 1;

        while (listy.elementAt(high) != -1) {
            high *= 2;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int element = listy.elementAt(mid);
            if (element == -1) {
                high = mid - 1;
            } else if (element == val) {
                return mid;
            } else if (element > val) {
                high = mid -1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    static class Listy {
        int[] arr;

        public Listy(int[] arr) {
            this.arr = arr;
        }

        int elementAt(int i) {
            if (i >= arr.length)
                return -1;
            else
                return arr[i];
        }
    }
}
