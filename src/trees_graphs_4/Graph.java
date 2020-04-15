package trees_graphs_4;

import java.util.ArrayList;
import java.util.List;

public class Graph {
    public Node[] nodes;

    public static Graph graph(int[][] matrix) {
        Node[] nodes = new Node[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            nodes[i] = new Node(i);
        }

        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            Node node = nodes[i];

            List<Node> children = new ArrayList<>();
            for (int j = 0; j < ints.length; j++) {
                int link = ints[j];
                if (link == 1) {
                    children.add(nodes[j]);
                }
            }
            node.children = children.toArray(new Node[0]);
        }

        Graph g = new Graph();
        g.nodes = nodes;
        return g;
    }
}