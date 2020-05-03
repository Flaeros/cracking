package recursion_dynamic_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class PowerSet_8_4 {

    public static void main(String[] args) {
        List<List<Integer>> res = new PowerSet_8_4().powerSet(List.of(1, 2, 3, 4, 5));
        res.sort(Comparator.comparingInt(List::size));
        System.out.println(res);

        res = new PowerSet_8_4().powerSetBinary(List.of(1, 2, 3, 4, 5));
        res.sort(Comparator.comparingInt(List::size));
        System.out.println(res);
    }

    public List<List<Integer>> powerSetBinary(List<Integer> set) {
        int max = 1 << set.size();

        List<List<Integer>> allSubSets = new ArrayList<>();
        for (int i = 0; i < max; i++) {
            List<Integer> subset = generateSubSet(set, i);
            allSubSets.add(subset);
        }
        return allSubSets;
    }

    private List<Integer> generateSubSet(List<Integer> set, int mask) {
        List<Integer> subset = new ArrayList<>();
        int index = 0;
        for (int i = mask; i > 0; i >>= 1) {
            if ((i & 1) == 1) {
                subset.add(set.get(index));
            }
            index++;
        }
        return subset;
    }

    public List<List<Integer>> powerSet(List<Integer> set) {
        return powerSet(set, 0);
    }

    private List<List<Integer>> powerSet(List<Integer> set, int index) {
        List<List<Integer>> allSubSets;
        if (set.size() == index) {
            allSubSets = new ArrayList<>();
            allSubSets.add(new ArrayList<>());
        } else {
            allSubSets = powerSet(set, index + 1);
            Integer val = set.get(index);

            List<List<Integer>> newSubSets = new ArrayList<>();
            for (List<Integer> subset : allSubSets) {
                List<Integer> copy = new ArrayList<>();
                copy.add(val);
                copy.addAll(subset);
                newSubSets.add(copy);
            }
            allSubSets.addAll(newSubSets);
        }
        return allSubSets;
    }

    public static String printDim(List<List<Integer>> values) {
        StringBuilder builder = new StringBuilder();
        for (List<Integer> value : values) {
            builder.append(Arrays.toString(value.toArray(new Integer[0])));
            builder.append("\n");
        }
        return builder.toString();
    }
}
