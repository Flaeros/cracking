package recursion_dynamic_8;

import java.util.Arrays;

public class StepCount_8_1 {

    public static void main(String[] args) {
        System.out.println(new StepCount_8_1().countSteps(35));
    }

    int[] memo;

    public int countSteps(int n) {
        memo = new int[n + 1];
        Arrays.fill(memo, -1);
        return countWays(n);
    }

    private int countWays(int n) {
        if (n < 0)
            return 0;
        if (n == 0)
            return 1;

        if (memo[n] > -1) {
            return memo[n];
        }

        memo[n] = countWays(n - 1) + countWays(n - 2) + countWays(n - 3);
        return memo[n];
    }
}
