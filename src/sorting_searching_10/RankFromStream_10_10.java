package sorting_searching_10;

public class RankFromStream_10_10 {

    public static void main(String[] args) {
        Stream stream = new Stream();
        int[] nums = new int[]{20, 15, 25, 10, 23, 5, 13, 24};
        for (int num : nums)
            stream.trackNumber(num);

        System.out.println(stream.getRankOfNumber(25));
        System.out.println(stream.getRankOfNumber(15));
        System.out.println(stream.getRankOfNumber(20));
    }

    static class Stream {
        RankNode root;

        void trackNumber(int number) {
            if (root == null) {
                root = new RankNode(number);
            } else {
                root.insert(number);
            }
        }

        int getRankOfNumber(int number) {
            return root.getRank(number);
        }

    }

    static class RankNode {
        int value;
        int leftCount;
        RankNode left, right;

        public RankNode(int number) {
            value = number;
        }

        public void insert(int number) {
            if (number < value) {
                if (left == null)
                    left = new RankNode(number);
                else
                    left.insert(number);
                leftCount++;
            } else {
                if (right == null)
                    right = new RankNode(number);
                else
                    right.insert(number);
            }
        }

        public int getRank(int number) {
            if (number == value)
                return leftCount;
            else if (number < value) {
                if (left == null)
                    return -1;
                return left.getRank(number);
            } else {

                int rightRank = right == null ? -1 : right.getRank(number);
                if (rightRank == -1)
                    return -1;
                return leftCount + 1 + rightRank;
            }
        }
    }
}
