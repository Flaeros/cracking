package system_design_9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.stream.Collectors;

import static java.util.Arrays.asList;

public class FindShortestPath_9_2 {

    public static void main(String[] args) {
        Map<Integer, Person> people = new HashMap<>();
        for (int i = 1; i <= 6; i++) {
            people.put(i, new Person(i));
        }

        people.get(1).friends = asList(people.get(2), people.get(3));
        people.get(2).friends = asList(people.get(1), people.get(3));
        people.get(3).friends = asList(people.get(1), people.get(2), people.get(5));
        people.get(4).friends = asList(people.get(5), people.get(6));
        people.get(5).friends = asList(people.get(3), people.get(4), people.get(6));
        people.get(6).friends = asList(people.get(4), people.get(5));

        LinkedList<Person> pathBiBFS = new FindShortestPath_9_2().findPathBiBFS(people, 1, 6);
        for (Person pathBiBF : pathBiBFS) {
            System.out.println(pathBiBF.id);
        }
    }

    LinkedList<Person> findPathBiBFS(Map<Integer, Person> people, int source, int destination) {
        BFSData sourceData = new BFSData(people.get(source));
        BFSData destData = new BFSData(people.get(destination));

        while (!sourceData.isFinished() && !destData.isFinished()) {
            /* Search out from source. */
            Person collision = searchlevel(people, sourceData, destData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.id);
            }

            /* Search out from destination. */
            collision = searchlevel(people, destData, sourceData);
            if (collision != null) {
                return mergePaths(sourceData, destData, collision.id);
            }
        }
        return null;
    }

    private Person searchlevel(Map<Integer, Person> people, BFSData primary, BFSData secondary) {
        /* We only want to search one level at a time. Count how many nodes are
         * currently in the primary's level and only do that many nodes. We'll continue
         * to add nodes to the end. */
        int count = primary.toVisit.size();
        for (int i = 0; i < count; i++) {
            /*Pull out first node. */
            PathNode pathNode = primary.toVisit.poll();
            int personId = pathNode.getPerson().id;

            /* Check if it's already been visited. */
            if (secondary.visited.containsKey(personId)) {
                return pathNode.getPerson();
            }

            /* Add friends to queue. */
            Person person = pathNode.getPerson();
            List<Integer> friends = person.getFriends();
            for (int friendId : friends) {
                if (!primary.visited.containsKey(friendId)) {
                    Person friend = people.get(friendId);
                    PathNode next = new PathNode(friend, pathNode);
                    primary.visited.put(friendId, next);
                    primary.toVisit.add(next);

                }

            }

        }
        return null;
    }

    LinkedList<Person> mergePaths(BFSData bfs1, BFSData bfs2, int connection) {
        PathNode end1 = bfs1.visited.get(connection); // end1 -> source
        PathNode end2 = bfs2.visited.get(connection); // end2 -> dest
        LinkedList<Person> pathOne = end1.collapse(false);
        LinkedList<Person> pathTwo = end2.collapse(true); // reverse
        pathTwo.removeFirst(); // remove connection
        pathOne.addAll(pathTwo); // add second path
        return pathOne;
    }


    static class Person {
        int id;
        List<Person> friends;

        public Person(int id) {
            this.id = id;
        }

        public List<Integer> getFriends() {
            return friends.stream().map(e -> e.id).collect(Collectors.toList());
        }
    }

    static class PathNode {
        private Person person;
        private PathNode previousNode;

        public PathNode(Person person, PathNode previousNode) {
            this.person = person;
            this.previousNode = previousNode;
        }

        Person getPerson() {
            return person;
        }

        public LinkedList<Person> collapse(boolean startWithRoot) {
            LinkedList<Person> path = new LinkedList<>();

            PathNode node = this;
            while (node != null) {
                if (startWithRoot) {
                    path.addLast(node.person);
                } else {
                    path.addFirst(node.person);
                }
                node = node.previousNode;
            }

            return path;
        }

    }

    static class BFSData {
        Queue<PathNode> toVisit = new LinkedList<>();
        Map<Integer, PathNode> visited = new HashMap<>();

        public BFSData(Person root) {
            PathNode sourcePath = new PathNode(root, null);
            toVisit.add(sourcePath);
            visited.put(root.id, sourcePath);
        }

        boolean isFinished() {
            return toVisit.isEmpty();
        }
    }
}
