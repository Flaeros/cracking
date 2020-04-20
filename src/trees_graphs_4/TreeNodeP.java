package trees_graphs_4;

public class TreeNodeP {
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
