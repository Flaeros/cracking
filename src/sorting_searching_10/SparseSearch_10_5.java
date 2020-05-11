package sorting_searching_10;

public class SparseSearch_10_5 {
    public static void main(String[] args) {
        System.out.println(new SparseSearch_10_5().sparseSearch("ball", new String[]{"at", "", "", "ball", "", "", "car", "", "", "", "dad"}));
    }

    public int sparseSearch(String s, String[] a) {
        int low = 0;
        int high = a.length - 1;

        while (low <= high) {
            int mid = getMid(a, low, high);
            if (s.equals(a[mid])) {
                return mid;
            } else if (s.compareTo(a[mid]) > 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1;
    }

    private int getMid(String[] a, int low, int high) {
        int mid = (low + high) / 2;
        if (a[mid].isEmpty()) {
            while (a[mid].isEmpty() && mid < high) {
                mid++;
            }
        }
        if (a[mid].isEmpty()) {
            while (a[mid].isEmpty() && mid > low) {
                mid--;
            }
        }
        return mid;
    }
}
