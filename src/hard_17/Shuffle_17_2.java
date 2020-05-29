package hard_17;

import java.util.Arrays;

public class Shuffle_17_2 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Shuffle_17_2().shuffle(cards(5))));
        System.out.println(Arrays.toString(new Shuffle_17_2().shuffle(cards(20))));
    }

    public int[] shuffle(int[] cards) {
        for (int i = 0; i < cards.length; i++) {
            int k = rand(0, i);
            int temp = cards[k];
            cards[k] = cards[i];
            cards[i] = temp;
        }
        return cards;
    }

    private static int rand(int lower, int higher) {
        int range = higher - lower + 1;
        return lower + (int) (Math.random() * range);
    }

    private static int[] cards(int n) {
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) cards[i] = i;
        return cards;
    }
}
