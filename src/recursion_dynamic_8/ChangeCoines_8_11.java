package recursion_dynamic_8;

public class ChangeCoines_8_11 {
    public static void main(String[] args) {
        System.out.println(new ChangeCoines_8_11().makeChange(4));
        System.out.println(new ChangeCoines_8_11().makeChange(16));
        System.out.println(new ChangeCoines_8_11().makeChange(100));
    }

    int makeChange(int amount) {
        int[] denoms = new int[]{25, 10, 5, 1};
        int[][] memo = new int[amount + 1][denoms.length];
        return waysToChange(amount, denoms, memo, 0);
    }

    int waysToChange(int amount, int[] denoms, int[][] memo, int index) {
        if (memo[amount][index] > 0)
            return memo[amount][index];

        if (index >= denoms.length - 1)
            return 1;

        int denomAmount = denoms[index];
        int ways = 0;

        for (int i = 0; i * denomAmount <= amount; i++) {
            int remaining = amount - i * denomAmount;
            ways += waysToChange(remaining, denoms, memo, index + 1);
        }

        return ways;
    }
}
