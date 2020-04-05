package arrays_strings;

/**
 * Check if given string is a permutation of palindrome
 */
public class PalindromePermutation_1_4 {
    public static void main(String[] args) {
        System.out.println(new PalindromePermutation_1_4().palindromePermutationBitwise("tactcoa"));
        System.out.println(new PalindromePermutation_1_4().palindromePermutationCharTable("tactcoa"));
        System.out.println(new PalindromePermutation_1_4().palindromePermutationCharTable("tact coa"));

    }

    /**
     * XOR all chars
     * O(N)
     */
    public boolean palindromePermutationBitwise(String one) {
        int result = 0;
        for (int i = 0; i < one.length(); i++) {
            result ^= one.charAt(i);
        }

        return result == 0;
    }

    public boolean palindromePermutationCharTable(String one) {
        int[] count = new int[128];
        for (int i = 0; i < one.length(); i++) {
            count[one.charAt(i)]++;
        }

        int odds = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i] % 2 != 0)
                odds++;
        }
        return odds % 2 != 0;
    }
}
