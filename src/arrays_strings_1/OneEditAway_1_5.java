package arrays_strings_1;

/**
 * Check the string are one edit away
 */
public class OneEditAway_1_5 {
    public static void main(String[] args) {

        System.out.println(new OneEditAway_1_5().oneEditAway("pale", "ple"));
        System.out.println(new OneEditAway_1_5().oneEditAway("pale", "pales"));
        System.out.println(new OneEditAway_1_5().oneEditAway("pale", "bale"));
        System.out.println(new OneEditAway_1_5().oneEditAway("pale", "bake"));
        System.out.println("- - - - -");
        System.out.println(new OneEditAway_1_5().oneEditAwayBit("pale", "ple"));
        System.out.println(new OneEditAway_1_5().oneEditAwayBit("pale", "pales"));
        System.out.println(new OneEditAway_1_5().oneEditAwayBit("pale", "bale"));
        System.out.println(new OneEditAway_1_5().oneEditAwayBit("pale", "bake"));
    }

    public boolean oneEditAway(String one, String other) {
        if (one.length() == other.length())
            return checkReplaced(one, other);
        if (one.length() > other.length())
            return checkAdded(one, other);
        if (other.length() > one.length())
            return checkAdded(other, one);
        return false;
    }

    private boolean checkAdded(String one, String other) {
        int onePos = 0;
        int otherPos = 0;

        while (onePos < one.length() && otherPos < other.length()) {
            if (one.charAt(onePos) != other.charAt(otherPos)) {
                if (onePos != otherPos) {
                    return false;
                }
            } else {
                otherPos++;
            }
            onePos++;
        }

        return true;
    }

    private boolean checkReplaced(String one, String other) {
        boolean oneEdit = false;
        for (int i = 0; i < one.length(); i++) {
            if (one.charAt(i) != other.charAt(i))
                if (oneEdit)
                    return false;
            oneEdit = true;
        }
        return oneEdit;
    }

    public boolean oneEditAwayBit(String one, String other) {
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
        if (Integer.bitCount(diff) == 2)
            return true;
        return false;
    }
}
