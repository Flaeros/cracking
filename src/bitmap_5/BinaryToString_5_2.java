package bitmap_5;

import java.math.BigDecimal;

public class BinaryToString_5_2 {
    public static void main(String[] args) {
        System.out.println(new BinaryToString_5_2().binaryToString(BigDecimal.valueOf(0.25)));
    }

    /**
     * doesn't work
     */
    String binaryToString(BigDecimal num) {
        if (num.compareTo(BigDecimal.ONE) >= 0 || num.compareTo(BigDecimal.ZERO) <= 0)
            return "wrong input";

        StringBuilder result = new StringBuilder();
        result.append(".");
        while (num.compareTo(BigDecimal.ZERO) > 0) {
            System.out.println("num = " + num);
            System.out.println(num);
            if (result.length() >= 32)
                return "too big number";

            BigDecimal r = num.multiply(BigDecimal.valueOf(2));

            if (r.compareTo(BigDecimal.ONE) >= 0) {
                result.append(1);
                num = r.subtract(BigDecimal.ONE);
            } else {
                result.append(0);
                num = r;
            }
        }


        return result.toString();
    }
}
