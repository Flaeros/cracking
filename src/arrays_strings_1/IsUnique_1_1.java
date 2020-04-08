package arrays_strings_1;

import java.util.HashMap;
import java.util.Map;

/**
 * If string has all unique characters
 */
public class IsUnique_1_1 {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new IsUnique_1_1().createTargetArray(new int[]{0,1,2,3,4}, new int[] {0,1,2,2,1})));
        System.out.println(new IsUnique_1_1().isUnique("abcdb"));
        System.out.println(new IsUnique_1_1().isUnique("abcde"));

        System.out.println(new IsUnique_1_1().isUniqueInPlace("abcdb"));
        System.out.println(new IsUnique_1_1().isUniqueInPlace("abcde"));
    }

    public boolean isUnique(String s) {
        Map<Character, Boolean> uniqueChars = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            uniqueChars.merge(s.charAt(i), true, (a, b) -> false);
        }
        return uniqueChars.values().stream().reduce((a, b) -> a & b).get();
    }

    public boolean isUniqueInPlace(String s) {
        //imagine in-place sort
        String sorted = getSorted(s);
        for (int i = 0; i < sorted.length() - 1; i++) {
            if (sorted.charAt(i) == sorted.charAt(i + 1))
                return false;
        }
        return true;
    }

    private String getSorted(String s) {
        return s.chars().sorted().collect(StringBuilder::new,
                StringBuilder::appendCodePoint, StringBuilder::append)
                .toString();
    }
}
