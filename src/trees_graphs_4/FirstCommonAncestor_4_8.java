package trees_graphs_4;

import static java.util.Arrays.asList;

public class FirstCommonAncestor_4_8 {
    public static void main(String[] args) {
        TreeNode root = TreeNode.tree(asList(1, 2, 3, 4, 5, null, 6, 7, null, null, null, null, null, null, 8), 0);
        System.out.println(new FirstCommonAncestor_4_8().findAncestor(root, root.left.left.left, root.left.right).val);

        TreeNodeP rootP = new FIndSuccessor_4_6().binarySearchTreeP(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println(new FirstCommonAncestor_4_8().findAncestor(rootP.left.left, rootP.left.right.right).val);
    }

    TreeNode findAncestor(TreeNode root, TreeNode first, TreeNode second) {
        if (!covers(root, first) || !covers(root, second))
            return null;
        return findAncestorHelper(root, first, second);
    }


    TreeNode findAncestorHelper(TreeNode root, TreeNode first, TreeNode second) {
        if (root == null || root == first || root == second)
            return root;

        boolean firstLeft = covers(root.left, first);
        boolean secondLeft = covers(root.left, second);

        if (firstLeft != secondLeft)
            return root;

        TreeNode childSide = firstLeft ? root.left : root.right;

        return findAncestorHelper(childSide, first, second);
    }

    boolean covers(TreeNode root, TreeNode node) {
        if (root == null)
            return false;
        if (root == node)
            return true;
        return covers(root.left, node) || covers(root.right, node);
    }

    TreeNodeP findAncestor(TreeNodeP first, TreeNodeP second) {
        int delta = depth(first) - depth(second);
        if (delta > 0)
            while (delta != 0) {
                first = first.parent;
                delta--;
            }
        else
            while (delta != 0) {
                second = second.parent;
                delta++;
            }

        while (first != second) {
            first = first.parent;
            second = second.parent;
        }
        return first;
    }

    private int depth(TreeNodeP first) {
        int depth = 0;
        while (first != null) {
            depth++;
            first = first.parent;
        }
        return depth;
    }
}
