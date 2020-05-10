package sorting_searching_10;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class GroupAnagrams_10_2 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new GroupAnagrams_10_2().groupAnagrams(new String[]{"abc", "zxc", "qwe", "bca", "wqe", "cxz"})));
    }

    public String[] groupAnagrams(String[] a) {
        Map<String, Set<String>> map = new HashMap<>();
        for (String s : a) {
            String key = new String(sortChars(s));
            Set<String> set = map.getOrDefault(key, new HashSet<>());
            set.add(s);
            map.put(key, set);
        }

        int i = 0;
        for (String key : map.keySet()) {
            Set<String> strings = map.get(key);
            for (String string : strings) {
                a[i++] = string;
            }
        }
        return a;
    }

    public String[] groupAnagrams2(String[] a) {
        Arrays.sort(a, compare());
        return a;
    }

    private Comparator<String> compare() {
        return (s1, s2) -> new String(sortChars(s1)).compareTo(new String(sortChars(s2)));
    }

    private char[] sortChars(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return chars;
    }
}
