package trees_graphs_4;

import static java.util.Arrays.asList;

public class CheckSubtree_4_10 {

    public static void main(String[] args) {
        TreeNode root = TreeNode.tree(asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8));
        System.out.println(new CheckSubtree_4_10().checkSubTree(root, root.right.right));
        TreeNode other = TreeNode.tree(asList(1, 2, 3, 4, 5));
        System.out.println(new CheckSubtree_4_10().checkSubTree(root, other));
    }

    boolean checkSubTree(TreeNode big, TreeNode small) {
        if (big == null || small == null) {
            return big == null && small == null;
        }
        if (big == small)
            return checkSubTree(big.right, small.right) && checkSubTree(big.left, small.left);

        return checkSubTree(big.right, small) || checkSubTree(big.left, small);
    }
}
