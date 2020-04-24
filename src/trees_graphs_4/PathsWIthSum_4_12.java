package trees_graphs_4;

import java.util.HashMap;
import java.util.Map;

import static java.util.Arrays.asList;

public class PathsWIthSum_4_12 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree(asList(-1, 2, 4, 3, -2, 5, 1, -2, -1, 6, 2, 0, 4, 3, -2));
        System.out.println("paths = " + new PathsWIthSum_4_12().countPathsWithSum(root, 3));
    }

    Map<Integer, Integer> map =  new HashMap<>();

    int countPathsWithSum(TreeNode root, int targetSum) {
        map.put(0, 1);
        return countPathsWithSum(root, targetSum, 0);
    }

    private int countPathsWithSum(TreeNode node, int targetSum, int runningSum) {
        if(node == null)
            return 0;

        runningSum += node.val;
        int sum = runningSum - targetSum;
        int totalPaths = map.getOrDefault(0, sum);

        addCount(runningSum, 1);

        totalPaths += countPathsWithSum(node.left, targetSum, runningSum);
        totalPaths += countPathsWithSum(node.right, targetSum, runningSum);

        addCount(runningSum, -1);

        return totalPaths;
    }

    private void addCount(int key, int delta) {
        Integer runningCount = map.getOrDefault(key, 0);
        if (runningCount > 0) {
            map.put(key, runningCount + delta);
        }
    }
}
