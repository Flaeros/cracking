package trees_graphs_4;

public class MinimalTree_4_2 {

    public static void main(String[] args) {
        TreeNode graph = new MinimalTree_4_2().binarySearchTreee(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9});
        System.out.println("root = " + graph.val);
    }

    TreeNode binarySearchTreee(int[] sortedArray) {
        return add(sortedArray, 0, sortedArray.length - 1);
    }

    private TreeNode add(int[] array, int low, int high) {
        if (low > high) {
            return null;
        }

        int peek = (high + low) / 2;
        TreeNode root = new TreeNode(array[peek]);
        root.left = add(array, low, peek - 1);
        root.right = add(array, peek + 1, high);
        return root;
    }
}
