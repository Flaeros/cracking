package trees_graphs_4;

public class FIndSuccessor_4_6 {

    public static void main(String[] args) {
        TreeNodeP root = new FIndSuccessor_4_6().binarySearchTreeP(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        TreeNodeP node = root.left.right;
        System.out.println(node + "-" + new FIndSuccessor_4_6().findSuccessor(node));
        node = root.right.right.right;
        System.out.println(node + "-" + new FIndSuccessor_4_6().findSuccessor(node));
        node = root.right.right;
        System.out.println(node + "-" + new FIndSuccessor_4_6().findSuccessor(node));
    }

    TreeNodeP findSuccessor(TreeNodeP node) {
        if (node.right != null)
            return leftMostChild(node.right);

        TreeNodeP q = node;
        TreeNodeP x = node.parent;

        while (x != null && x.left != q) {
            q = x;
            x = x.parent;
        }

        return x;
    }

    private TreeNodeP leftMostChild(TreeNodeP node) {
        while (node.left != null)
            node = node.left;
        return node;
    }

    TreeNodeP binarySearchTreeP(int[] sortedArray) {
        return add(sortedArray, 0, sortedArray.length - 1, null);
    }

    private TreeNodeP add(int[] array, int low, int high, TreeNodeP parent) {
        if (low > high) {
            return null;
        }

        int peek = (high + low) / 2;
        TreeNodeP root = new TreeNodeP(array[peek]);
        root.parent = parent;
        root.left = add(array, low, peek - 1, root);
        root.right = add(array, peek + 1, high, root);
        return root;
    }

    static class TreeNodeP {
        TreeNodeP parent;
        int val;
        public TreeNodeP left;
        public TreeNodeP right;

        TreeNodeP(int x) {
            this.val = x;
        }

        @Override
        public String toString() {
            return String.valueOf(val);
        }
    }
}
