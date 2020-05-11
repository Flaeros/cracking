package sorting_searching_10;

public class FindDuplicates_10_8 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0x1F));
        new FindDuplicates_10_8().checkDuplicates(new int[]{1, 1, 2, 3, 4, 5, 6, 7, 8, 15000, 15000, 17821});
    }

    void checkDuplicates(int[] a) {
        BitSet bs = new BitSet(32000);
        for (int i = 0; i < a.length; i++) {
            int num = a[i];
            int num0 = num - 1;
            if (bs.get(num0)) {
                System.out.println("num = " + num);
            } else {
                bs.add(num0);
            }
        }
    }

    static class BitSet {
        int[] bitset;

        public BitSet(int size) {
            bitset = new int[(size >> 5) + 1];
        }

        public boolean get(int pos) {
            int wordNumber = (pos >> 5); // divide by 32
            int bitNumber = (pos & 0x1F); // mod 32
            return (bitset[wordNumber] & (1 << bitNumber)) != 0;
        }

        public void add(int pos) {
            int wordNumber = (pos >> 5); // divide by 32
            int bitNumber = (pos & 0x1F); // mod 32
            bitset[wordNumber] |= 1 << bitNumber;
        }
    }
}
