package trees_graphs_4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class RandomNode_4_11 {

    public static void main(String[] args) {
        RandomTree randomTree = new RandomTree();
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            numbers.add(i);
        }
        Collections.shuffle(numbers);
        numbers.forEach(randomTree::insert);
        System.out.println("random = " + randomTree.getRandomNode().data);
        System.out.println("random = " + randomTree.getRandomNode().data);
        System.out.println("random = " + randomTree.getRandomNode().data);
        System.out.println("random = " + randomTree.getRandomNode().data);
        System.out.println("5 = " + randomTree.find(5).data);
        System.out.println("1 = " + randomTree.find(1).data);
    }

    static class RandomTree {
        RandomTreeNode root;

        void insert(int i) {
            if (root == null) {
                root = new RandomTreeNode(i);
            } else {
                root.insert(i);
            }
        }

        RandomTreeNode find(int i) {
            return root.find(i);
        }

        void delete() {
            //lul
        }

        RandomTreeNode getRandomNode() {
            Random random = new Random();
            int index = random.nextInt(size());
            return root.getIthNode(index);
        }

        int size() {
            return root == null ? 0 : root.size();
        }
    }

    static class RandomTreeNode {
        int size = 0;
        int data = 0;
        RandomTreeNode left;
        RandomTreeNode right;

        public RandomTreeNode(int data) {
            this.data = data;
            size = 1;
        }

        public void insert(int i) {
            if (i > data) {
                if (right == null) {
                    right = new RandomTreeNode(i);
                } else {
                    right.insert(i);
                }
            } else {
                if (left == null) {
                    left = new RandomTreeNode(i);
                } else {
                    left.insert(i);
                }
            }
            size++;
        }

        public RandomTreeNode find(int i) {
            if (data == i)
                return this;
            if (i > data)
                return right == null ? null : right.find(i);
            return left == null ? null : left.find(i);
        }

        public int size() {
            return size;
        }

        public RandomTreeNode getIthNode(int index) {
            int leftSize = left == null ? 0 : left.size;
            if (index < leftSize) {
                return left.getIthNode(index);
            } else if (index == leftSize) {
                return this;
            } else {
                return right.getIthNode(index - leftSize - 1);
            }
        }
    }
}
