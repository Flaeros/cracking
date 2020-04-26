package bitmap_5;

public class NextNumber_5_4 {
    public static void main(String[] args) {
        System.out.println("13948 bits: " + Integer.bitCount(13948));
        System.out.println("13948 binary: " + Integer.toBinaryString(13948));
        System.out.println("13948 next: " + new NextNumber_5_4().getNextNumber(13948));
        System.out.println("13948 next bits: " + Integer.bitCount(new NextNumber_5_4().getNextNumber(13948)));
        System.out.println("13948 next binary: " + Integer.toBinaryString(new NextNumber_5_4().getNextNumber(13948)));
        System.out.println("13948 prev: " + new NextNumber_5_4().getPrevNumber(13948));
        System.out.println("13948 prev bits: " + Integer.bitCount(new NextNumber_5_4().getPrevNumber(13948)));
        System.out.println("13948 prev binary: " + Integer.toBinaryString(new NextNumber_5_4().getPrevNumber(13948)));
    }

    int getNextNumber(int number) {
        int c = number;
        int c0 = 0;
        int c1 = 0;


        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        if (c1 + c0 == 0 || c1 + c0 == 31)
            return -1;

        int p = c0 + c1;

        number |= (1 << p);
        number &= ~((1 << p) - 1);
        number |= (1 << (c1 - 1)) - 1;

        return number;
    }

    int getPrevNumber(int number) {
        int c = number;
        int c0 = 0;
        int c1 = 0;

        while ((c & 1) == 1) {
            c1++;
            c >>= 1;
        }

        while ((c & 1) == 0 && c != 0) {
            c0++;
            c >>= 1;
        }

        int mask = 1 << c0 + c1 - 1;
        number |= mask;
        mask = ~(1 << c0 + c1);
        number &= mask;

        return number;
    }
}
