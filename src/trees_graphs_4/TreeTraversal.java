package trees_graphs_4;

public class TreeTraversal {
    public static void main(String[] args) {
        TreeNode root = new MinimalTree_4_2().binarySearchTreee(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("preOrder");
        new TreeTraversal().preOrder(root);
        System.out.println();
        System.out.println("inOrder");
        new TreeTraversal().inOrder(root);
        System.out.println();
        System.out.println("postOrder");
        new TreeTraversal().postOrder(root);
    }

    public void preOrder(TreeNode root) {
        if (root == null)
            return;

        System.out.print(root.val + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(TreeNode root) {
        if (root == null)
            return;

        inOrder(root.left);
        System.out.print(root.val + " ");
        inOrder(root.right);
    }

    public void postOrder(TreeNode root) {
        if (root == null)
            return;

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.val + " ");
    }
}
