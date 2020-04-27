package bitmap_5;

public class PairwiseSwapBits_5_7 {

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(0xaaaaaaaa));
        System.out.println(Integer.toBinaryString(0x55555555));
        System.out.println(Integer.toBinaryString(new PairwiseSwapBits_5_7().pairwiseSwap(29)));
    }

    int pairwiseSwap(int n) {
        System.out.println(Integer.toBinaryString(n));
        return (((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1));
    }
}
