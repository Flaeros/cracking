package arrays_strings;

/**
 * Check the string are one edit away
 */
public class OneEditAway_1_5 {
    public static void main(String[] args) {

        System.out.println(new OneEditAway_1_5().oneEditAway("pale", "ple"));
        System.out.println(new OneEditAway_1_5().oneEditAway("pales", "pale"));
        System.out.println(new OneEditAway_1_5().oneEditAway("pale", "bale"));
        System.out.println(new OneEditAway_1_5().oneEditAway("pale", "bake"));
    }

    public boolean oneEditAway(String one, String other) {
        int bitOne = 0;
        int bitOther = 0;

        for (int i = 0; i < one.length(); i++) {
            bitOne |= 1 << Character.getNumericValue(one.charAt(i));
        }

        for (int i = 0; i < other.length(); i++) {
            bitOther |= 1 << Character.getNumericValue(other.charAt(i));
        }

        int diff = bitOne ^ bitOther;
        if (diff == 0)
            return false;


        boolean oneCharDiff = Math.abs(one.length() - other.length()) == 1;
        if (oneCharDiff && Integer.bitCount(diff) == 1)
            return true;
        if (Integer.bitCount(diff)  == 2)
            return true;
        return false;
    }
}
