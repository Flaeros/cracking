package trees_graphs_4;

import java.util.Arrays;

import static java.util.Arrays.asList;

public class CheckBinaryTreeBalanced_4_4 {

    public static void main(String[] args) {
        TreeNode root = new MinimalTree_4_2().binarySearchTreee(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(new CheckBinaryTreeBalanced_4_4().checkBalanced(root));

        root = TreeNode.tree(asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8), 0);
        System.out.println(new CheckBinaryTreeBalanced_4_4().checkBalanced(root));
    }

    public boolean checkBalanced(TreeNode root) {
        return checkBalancedTree(root).balanced;
    }

    public TreeInfo checkBalancedTree(TreeNode root) {
        if(root == null) {
            return new TreeInfo(true, 0);
        }

        TreeInfo leftTreeInfo = checkBalancedTree(root.left);
        TreeInfo rightTreeInfo = checkBalancedTree(root.right);
        boolean balanced = leftTreeInfo.balanced && rightTreeInfo.balanced
                && Math.abs(leftTreeInfo.depth - rightTreeInfo.depth) <= 1;
        return new TreeInfo(balanced, Math.max(leftTreeInfo.depth, rightTreeInfo.depth) + 1);
    }

    static class TreeInfo {
        boolean balanced;
        int depth;

        public TreeInfo(boolean balanced, int depth) {
            this.balanced = balanced;
            this.depth = depth;
        }
    }
}
