package sorting_searching_10;

import java.util.Random;

public class MissingInt_10_6 {
    public static void main(String[] args) {
        System.out.println(new MissingInt_10_6().missingInt(new File()));
    }

    int missingInt(File file) {
        long numberOfInts = ((long) Integer.MAX_VALUE) + 1;
        byte[] bitField = new byte[(int) (numberOfInts / 8)];

        int num = file.nextInt();
        while (num != -1) {
            bitField[num / 8] |= 1 << (num % 8);
            num = file.nextInt();
        }

        for (int i = 0; i < bitField.length; i++) {
            for (int j = 0; j < 8; j++) {
                if ((bitField[i] & (1<<j)) == 0) {
                    return i * 8 + j;
                }
            }
        }

        return -1;
    }

    static class File {
        public static final int MAX_VALUE = Integer.MAX_VALUE/100;
        int[] integers = new int[MAX_VALUE];
        int i = 0;

        public File() {
            for (int i = 0; i < MAX_VALUE; i++) {
                integers[i] = i;
            }
            Random random = new Random();
            int rand = random.nextInt(MAX_VALUE);
            integers[rand] = 0;
        }

        int nextInt() {
            if (i == MAX_VALUE)
                return -1;
            return integers[i++];
        }

    }
}
