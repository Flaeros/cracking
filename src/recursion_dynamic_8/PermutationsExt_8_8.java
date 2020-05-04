package recursion_dynamic_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PermutationsExt_8_8 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new PermutationsExt_8_8().permutate("aabbc").toArray(new String[0])));
    }

    List<String> permutate(String s) {
        Map<Character, Integer> map = getFreqMap(s);

        List<String> result = new ArrayList<>();
        int remaining = s.length();
        getPermutations(map, "", remaining, result);


        return result;
    }

    private void getPermutations(Map<Character, Integer> map, String prefix, int remaining, List<String> result) {
        if (remaining == 0) {
            result.add(prefix);
            return;
        }

        for (Character c : map.keySet()) {
            Integer count = map.get(c);
            if (count > 0) {
                map.put(c, count - 1);
                getPermutations(map, prefix + c, remaining - 1, result);
                map.put(c, count);
            }

        }
    }

    private Map<Character, Integer> getFreqMap(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.merge(s.charAt(i), 1, (old, def) -> old + 1);
        }
        return map;
    }
}
