package trees_graphs_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuildOrder_4_7 {

    public static void main(String[] args) {
        System.out.println(new BuildOrder_4_7().buildOrder(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'},
                new char[][]{{'d', 'g'}, {'f', 'c'}, {'f', 'b'}, {'f', 'a'},
                        {'c', 'a'}, {'b', 'a'}, {'b', 'e'}, {'a', 'e'}}));
        System.out.println(new BuildOrder_4_7().buildOrder(new char[]{'a', 'b', 'c', 'd', 'e', 'f', 'g'},
                new char[][]{{'d', 'g'}, {'f', 'c'}, {'f', 'b'}, {'f', 'a'},
                        {'c', 'a'}, {'b', 'a'}, {'b', 'e'}, {'a', 'e'}, {'e', 'b'}}));
    }

    public char[] buildOrder(char[] projects, char[][] dependencies) {
        Graph graph = buildDependencyGraph(projects, dependencies);
        char[] result = new char[projects.length];
        List<Node> nodes = new ArrayList<>(Arrays.asList(graph.nodes));

        int i = 0;
        while (true) {
            if (nodes.isEmpty())
                break;
            List<Node> roots = new ArrayList<>();
            for (Node node : nodes) {
                if (node.parents == null || node.parents.isEmpty()) {
                    roots.add(node);
                }
            }

            for (Node root : roots) {
                result[i++] = root.name.charAt(0);

                if (root.children != null)
                    root.children.forEach(e -> e.parents.remove(root));
            }

            nodes.removeAll(roots);

            if (roots.isEmpty() && !nodes.isEmpty())
                return new char[]{'c','y','c','l','e'};
        }

        return result;
    }

    private Graph buildDependencyGraph(char[] projects, char[][] dependencies) {
        Graph g = new Graph();
        g.nodes = new Node[projects.length];
        for (int i = 0; i < projects.length; i++) {
            g.nodes[i] = new Node(projects[i]);
        }

        for (char[] dependency : dependencies) {
            Node first = getNode(g.nodes, dependency[0]);
            Node second = getNode(g.nodes, dependency[1]);
            List<Node> children = getOrDefault(first);
            children.add(second);
            getOrDefaultParents(second);
            second.parents.add(first);
        }
        return g;
    }

    private List<Node> getOrDefaultParents(Node node) {

        List<Node> parents = node.parents;
        if (parents == null) {
            parents = new ArrayList<>();
            node.parents = parents;
        }
        return parents;
    }

    private List<Node> getOrDefault(Node node) {
        List<Node> children = node.children;
        if (children == null) {
            children = new ArrayList<>();
            node.children = children;
        }
        return children;
    }

    private Node getNode(Node[] nodes, char val) {
        for (Node node : nodes) {
            if (node.name.equals(String.valueOf(val)))
                return node;
        }
        return null;
    }

}
