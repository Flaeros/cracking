package arrays_strings;

/**
 * Check if given string is a permutation of palindrome
 */
public class PalindromePermutation_1_4 {
    public static void main(String[] args) {

        System.out.println(new PalindromePermutation_1_4().palindromePermutationBitwise("tactcoa"));
        System.out.println(new PalindromePermutation_1_4().palindromePermutationBitwise("tact coa"));
        System.out.println(new PalindromePermutation_1_4().palindromePermutationBitwise("tactca"));

        System.out.println(new PalindromePermutation_1_4().palindromePermutationCharTable("tactcoa"));
        System.out.println(new PalindromePermutation_1_4().palindromePermutationCharTable("tact coa"));
        System.out.println(new PalindromePermutation_1_4().palindromePermutationCharTable("tactca"));

    }

    /**
     * hashtable as bit vector
     * O(N)
     */
    public boolean palindromePermutationBitwise(String one) {
        int table = 0;

        for (int i = 0; i < one.length(); i++) {
            int numericValue = Character.getNumericValue(one.charAt(i));

            int mask = 1 << numericValue;

            if ((table & mask) == 0) {
                table |= mask;
            } else {
                table &= ~mask;
            }
        }

        return table == 0 || (((table - 1) & table) == 0);
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
        if (one.length() % 2 == 0)
            return odds == 0;

        return odds == 1;
    }
}
