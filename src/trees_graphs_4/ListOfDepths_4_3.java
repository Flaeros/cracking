package trees_graphs_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ListOfDepths_4_3 {

    public static void main(String[] args) {
        TreeNode root = new MinimalTree_4_2().binarySearchTreee(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});

        System.out.println(printDim(new ListOfDepths_4_3().listOfDepths(root)));
    }

    public List<List<TreeNode>> listOfDepths(TreeNode root) {
        List<List<TreeNode>> result = new ArrayList<>();
        Queue<TreeNode> nodesQ = new LinkedList<>();
        Queue<Integer> depthQ = new LinkedList<>();

        nodesQ.offer(root);
        depthQ.offer(0);

        while (!nodesQ.isEmpty()) {
            TreeNode node = nodesQ.poll();
            Integer depth = depthQ.poll();
            List<TreeNode> level = getOrDefault(result, depth);
            level.add(node);

            if (node.left != null) {
                nodesQ.offer(node.left);
                depthQ.offer(depth + 1);
            }

            if (node.right != null) {
                nodesQ.offer(node.right);
                depthQ.offer(depth + 1);
            }
        }

        return result;
    }

    private List<TreeNode> getOrDefault(List<List<TreeNode>> result, Integer depth) {
        if (depth <= result.size() - 1)
            return result.get(depth);
        List<TreeNode> newList = new ArrayList<>();
        result.add(newList);
        return newList;
    }


    public static String printDim(List<List<TreeNode>> nodes) {
        StringBuilder builder = new StringBuilder();
        for (List<TreeNode> node : nodes) {
            builder.append(Arrays.toString(node.toArray(new TreeNode[0])));
            builder.append("\n");
        }
        return builder.toString();
    }
}
