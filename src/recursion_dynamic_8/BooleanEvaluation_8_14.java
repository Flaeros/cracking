package recursion_dynamic_8;

import java.util.HashMap;
import java.util.Map;

public class BooleanEvaluation_8_14 {
    public static void main(String[] args) {
        System.out.println(new BooleanEvaluation_8_14().numberOfWays("1^0|0|1", false));
        System.out.println(new BooleanEvaluation_8_14().numberOfWays("0&0&0&1^1|0", true));
    }

    int numberOfWays(String expr, boolean result) {
        Map<String, Integer> memo = new HashMap<>();
        return numberOfWays(expr, result, memo);
    }

    int numberOfWays(String expr, boolean result, Map<String, Integer> memo) {
        if (expr.length() == 0)
            return 0;
        if (expr.length() == 1)
            return stringToBool(expr) == result ? 1 : 0;

        if (memo.containsKey(expr + result))
            return memo.get(expr + result);

        int ways = 0;

        for (int i = 1; i < expr.length(); i++) {
            String left = expr.substring(0, i);
            char c = expr.charAt(i);
            String right = expr.substring(i + 1);

            int leftFalse = numberOfWays(left, false, memo);
            int leftTrue = numberOfWays(left, true, memo);
            int rightFalse = numberOfWays(right, false, memo);
            int rightTrue = numberOfWays(right, true, memo);

            int total = (leftFalse + leftTrue) * (rightFalse + rightTrue);

            int totalTrue = 0;

            if (c == '^') {
                totalTrue += leftFalse * rightTrue + leftTrue * rightFalse;
            } else if (c == '&') {
                totalTrue = leftTrue * rightTrue;
            } else if (c == '|') {
                totalTrue += leftFalse * rightTrue + leftTrue * rightFalse + leftTrue * rightTrue;
            }

            int subWays = result ? totalTrue : total - totalTrue;
            ways += subWays;
        }

        memo.put(expr + result, ways);
        return ways;
    }

    private boolean stringToBool(String expr) {
        return expr.equals("1");
    }
}
