package hard_17;

public class AddWithoutPlus_17_1 {
    public static void main(String[] args) {
        System.out.println(new AddWithoutPlus_17_1().add(2, 3));
    }

    public int add(int a, int b) {
        if (b == 0)
            return a;
        int sum = a ^ b;
        int carry = (a & b) << 1;

        return add(sum, carry);
    }
}
