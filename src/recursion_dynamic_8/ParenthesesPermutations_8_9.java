package recursion_dynamic_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ParenthesesPermutations_8_9 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new ParenthesesPermutations_8_9().permutate(3).toArray(new String[0])));
        System.out.println(Arrays.toString(new ParenthesesPermutations_8_9().permutateSet(3).toArray(new String[0])));
    }

    public List<String> permutate(int n) {
        ArrayList<String> list = new ArrayList<>();
        permutate(list, n, n, new char[n * 2], 0);
        return list;
    }

    public void permutate(List<String> list, int lefts, int rights, char[] str, int index) {
        if (lefts < 0 || rights < lefts)
            return;

        if (lefts == 0 && rights == 0) {
            list.add(new String(str));
        } else {
            str[index] = '(';
            permutate(list, lefts - 1, rights, str, index + 1);
            str[index] = ')';
            permutate(list, lefts, rights - 1, str, index + 1);
        }
    }

    public Set<String> permutateSet(int n) {
        Set<String> result = new HashSet<>();

        if (n == 1) {
            result.add("()");
            return result;
        }

        Set<String> permutate = permutateSet(n - 1);
        for (String s : permutate) {
            result.add("(" + s + ")");
            result.add(s + "()");
            result.add("()" + s);
        }

        return result;
    }

}
