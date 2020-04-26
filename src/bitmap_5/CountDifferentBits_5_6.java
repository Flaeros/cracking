package bitmap_5;

public class CountDifferentBits_5_6 {

    public static void main(String[] args) {
        System.out.println(new CountDifferentBits_5_6().countDifferentBits(29, 15));
    }

    int countDifferentBits(int n, int m) {
        int count = 0;
        for (int c = n ^ m; c != 0; c >>= 1)
            if ((c & 1) == 1)
                count++;
        return count;
    }
}
