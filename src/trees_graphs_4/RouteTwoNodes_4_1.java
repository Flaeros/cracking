package trees_graphs_4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Route Between Nodes: Given a directed graph,
 * design an algorithm to find out whether there is a
 * route between two nodes.
 */
public class RouteTwoNodes_4_1 {
    public static void main(String[] args) {
        Graph graph = Graph.graph(new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 0, 0}});
        System.out.println(new RouteTwoNodes_4_1().search(graph, graph.nodes[0], graph.nodes[2]));

        graph = Graph.graph(new int[][]{
                {0, 1, 0, 0},
                {0, 0, 1, 0},
                {1, 0, 0, 0},
                {0, 0, 0, 0}});
        System.out.println(new RouteTwoNodes_4_1().search(graph, graph.nodes[0], graph.nodes[3]));

    }

    boolean search(Graph g, Node start, Node end) {
        if (start == end)
            return true;

        Queue<Node> q = new LinkedList<>();

        q.offer(start);
        start.visited = true;

        while (!q.isEmpty()) {
            Node node = q.poll();

            for (Node child : node.children) {
                if (child.visited)
                    continue;
                if (child == end)
                    return true;

                child.visited = true;
                q.offer(child);
            }
        }
        return false;
    }
}
