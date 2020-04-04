package arrays_strings;

public class CheckPermutation_1_2 {

    public static void main(String[] args) {
        //System.out.println(Arrays.toString(new IsUnique_1_1().createTargetArray(new int[]{0,1,2,3,4}, new int[] {0,1,2,2,1})));
        System.out.println(new CheckPermutation_1_2().checkPermutation("abcdb", "bcbda"));
        System.out.println(new CheckPermutation_1_2().checkPermutation("abcde", "cabda"));

    }

    /**
     * giving the sorting is O(nlogn) the same O for solution
     */
    public boolean checkPermutation (String one, String other) {
        if(one.length() != other.length())
            return false;

        String oneSorted = getSorted(one);
        String otherSorted = getSorted(other);
        for (int i = 0; i < one.length(); i++) {
            if (oneSorted.charAt(i) != otherSorted.charAt(i))
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
