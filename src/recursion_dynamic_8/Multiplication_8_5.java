package recursion_dynamic_8;

public class Multiplication_8_5 {

    public static void main(String[] args) {
        int smaller = 29;
        int bigger = 31;
        System.out.println(new Multiplication_8_5().multiply(smaller, bigger));
        System.out.println(smaller * bigger);
    }

    public int multiply(int smaller, int bigger) {
        if (smaller > bigger)
            return multiply(bigger, smaller);

        if (smaller == 0)
            return 0;
        if (smaller == 1)
            return bigger;

        int div = smaller >> 1;
        int multiply = multiply(div, bigger);

        if (smaller % 2 == 0) {
            return multiply + multiply;
        } else {
            return bigger + multiply + multiply;
        }
    }
}
