package trees_graphs_4;

import java.util.List;

public class Node {
    public String name;
    public List<Node> children;
    public List<Node> parents;
    public boolean visited;

    public Node(int name) {
        this.name = String.valueOf(name);
    }

    public Node(char name) {
        this.name = String.valueOf(name);
    }
}
