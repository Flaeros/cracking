package hard_17;

import java.util.Arrays;

public class RandomSet_17_3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new RandomSet_17_3().pickM(set(5), 3)));
        System.out.println(Arrays.toString(new RandomSet_17_3().pickM(set(20), 15)));
    }

    public int[] pickM(int[] original, int m) {
        int[] subset = new int[m];

        for (int i = 0; i < m; i++) {
            subset[i] = original[i];
        }

        for (int i = m; i < original.length; i++) {
            int k = rand(0, i);
            if (k < m)
                subset[k] = original[i];
        }
        return subset;
    }

    private static int rand(int lower, int higher) {
        int range = higher - lower + 1;
        return lower + (int) (Math.random() * range);
    }

    private static int[] set(int n) {
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = i;
        return cards;
    }
}
