package bitmap_5;

public class Insertion_5_1 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(new Insertion_5_1().insert(Integer.parseInt("10000000000", 2), Integer.parseInt("10011", 2), 2, 6)));
        System.out.println(Integer.toBinaryString(new Insertion_5_1().insert(Integer.parseInt("1010101000110", 2), Integer.parseInt("10011", 2), 2, 6)));
    }

    int insert(int m, int n, int i, int j) {
        for (int k = i; k < j; k++) {
            m = resetBit(m, k);
        }

        n = n << i;
        return m | n;
    }

    int resetBit(int num, int pos) {
        int mask = ~(1 << pos);
        return num & mask;
    }
}
