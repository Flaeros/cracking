package trees_graphs_4;

public class Node {
    public String name;
    public Node[] children;
    public boolean visited;

    public Node(int name) {
        this.name = String.valueOf(name);
    }
}