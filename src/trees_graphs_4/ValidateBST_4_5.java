package trees_graphs_4;

import java.util.ArrayList;
import java.util.List;

import static java.util.Arrays.asList;
import static java.util.Collections.emptyList;

public class ValidateBST_4_5 {

    public static void main(String[] args) {
        TreeNode root = new MinimalTree_4_2().binarySearchTreee(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(new ValidateBST_4_5().validateBST(root));

        root = TreeNode.tree(asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8), 0);
        System.out.println(new ValidateBST_4_5().validateBST(root));
    }

    public boolean validateBST(TreeNode root) {
        return validateBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }


    private boolean validateBST(TreeNode node, int lesser, int bigger) {
        if (node == null)
            return true;
        if (node.val < lesser || node.val > bigger)
            return false;


        boolean left = validateBST(node.left, lesser, node.val);
        boolean right = validateBST(node.right, node.val, bigger);
        return left && right;
    }

    private boolean validateBST(TreeNode node, List<TreeNode> lesser, List<TreeNode> bigger) {
        if (node == null)
            return true;
        if (lessThan(node, lesser) || moreThan(node, bigger))
            return false;

        List<TreeNode> leftBigger =  new ArrayList<>(bigger);
        leftBigger.add(node);
        List<TreeNode> righLesser =  new ArrayList<>(lesser);
        righLesser.add(node);

        boolean left = validateBST(node.left, new ArrayList<>(lesser), leftBigger);
        boolean right = validateBST(node.right, righLesser, new ArrayList<>(bigger));
        return left && right;
    }

    private boolean lessThan(TreeNode node, List<TreeNode> nodes) {
        for (TreeNode treeNode : nodes) {
            if (node.val < treeNode.val)
                return true;
        }
        return false;
    }
    private boolean moreThan(TreeNode node, List<TreeNode> nodes) {
        for (TreeNode treeNode : nodes) {
            if (node.val > treeNode.val)
                return true;
        }
        return false;
    }
}
