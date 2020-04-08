package arrays_strings_1;

public class StringRotation_1_9 {
    public static void main(String[] args) {
        System.out.println(new StringRotation_1_9().isStringRotation("waterbottle", "erbottlewat"));
    }

    public boolean isStringRotation(String one, String other) {
        return isSubstring(one, other + other);
    }

    public boolean isSubstring(String sub, String string) {
        int i = string.indexOf(sub);
        return i != -1;
    }
}
