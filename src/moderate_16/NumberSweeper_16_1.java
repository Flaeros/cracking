package moderate_16;

public class NumberSweeper_16_1 {

    public static void main(String[] args) {
        new NumberSweeper_16_1().swap(9, 5);
        new NumberSweeper_16_1().swap(5, 9);
        new NumberSweeper_16_1().swapXor(9, 5);
        new NumberSweeper_16_1().swapXor(5, 9);
    }

    private void swap(int a, int b) {
        a = a - b;
        b = b + a;
        a = b - a;

        System.out.println(a + " " + b);
    }

    private void swapXor(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;

        System.out.println(a + " " + b);
    }
}
