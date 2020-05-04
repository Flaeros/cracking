package recursion_dynamic_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Permutations_8_7 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Permutations_8_7().permutate("abc").toArray(new String[0])));
    }

    List<String> permutate(String s) {
        if (s == null)
            return null;

        List<String> permutations = new ArrayList<>();

        if (s.length() == 0) {
            permutations.add("");
            return permutations;
        }

        char c = s.charAt(0);
        String remainder = s.substring(1);
        List<String> remPerms = permutate(remainder);
        for (String remPerm : remPerms) {
            for (int i = 0; i <= remPerm.length(); i++) {
                String word = insertAtPos(remPerm, c, i);
                permutations.add(word);
            }
        }
        return permutations;
    }

    private String insertAtPos(String word, char c, int pos) {
        String start = word.substring(0, pos);
        String end = word.substring(pos);
        return start + c + end;
    }
}
