package trees_graphs_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class BSTSequences_4_9 {

    public static void main(String[] args) {
        TreeNode root = new MinimalTree_4_2().binarySearchTreee(new int[]{1, 2, 3, 4});
        System.out.println(printDim(new BSTSequences_4_9().allSequences(root)));
    }

    ArrayList<LinkedList<Integer>> allSequences(TreeNode root) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<>();
        if (root == null) {
            result.add(new LinkedList<>());
            return result;
        }

        LinkedList<Integer> prefix = new LinkedList<>();
        prefix.add(root.val);

        ArrayList<LinkedList<Integer>> leftSeq = allSequences(root.left);
        ArrayList<LinkedList<Integer>> rightSeq = allSequences(root.right);


        for (LinkedList<Integer> left : leftSeq) {
            for (LinkedList<Integer> right : rightSeq) {
                ArrayList<LinkedList<Integer>> weaved = new ArrayList<>();
                weaveLists(left, right, weaved, prefix);
                result.addAll(weaved);
            }
        }

        return result;
    }

    private void weaveLists(LinkedList<Integer> first, LinkedList<Integer> second,
                            ArrayList<LinkedList<Integer>> results, LinkedList<Integer> prefix) {
        /* One list is empty. Add remainder to [a cloned] prefix and store result. */
        if (first.size() == 0 || second.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(first);
            result.addAll(second);
            results.add(result);
            return;
        }

        /* Recurse with head of first added to the prefix. Removing the head will damage
                first, so we'll need to put it back where we found it afterwards. */
        int headFirst = first.removeFirst();
        prefix.addLast(headFirst);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        first.addFirst(headFirst);

        /* Do the same thing with second, damaging and then restoring the list.*/
        int headSecond = second.removeFirst();
        prefix.addLast(headSecond);
        weaveLists(first, second, results, prefix);
        prefix.removeLast();
        second.addFirst(headSecond);

    }

    public static String printDim(ArrayList<LinkedList<Integer>> values) {
        StringBuilder builder = new StringBuilder();
        for (List<Integer> value : values) {
            builder.append(Arrays.toString(value.toArray(new Integer[0])));
            builder.append("\n");
        }
        return builder.toString();
    }
}
