package recursion_dynamic_8;

import java.util.Stack;

public class HanoiTowers_8_6 {

    public static void main(String[] args) {
        int n = 3;
        int disks = 3;
        Tower[] towers = new Tower[n];
        for (int i = 0; i < n; i++) {
            towers[i] = new Tower(i);
        }

        for (int i = disks; i > 0; i--) {
            towers[0].add(i);
        }

        towers[0].moveDisks(disks, towers[1], towers[2]);
    }

    static class Tower {
        int id;
        Stack<Integer> disks;

        public Tower(int id) {
            this.id = id;
            disks = new Stack<>();
        }

        public void add(int disk) {
            if (!disks.isEmpty() && disks.peek() <= disk) {
                System.out.println("Error placing disk");
            }
            disks.push(disk);
        }

        public void moveTopTo(Tower tower) {
            int disk = disks.pop();
            System.out.println(String.format("%s: %s->%s", disk, id, tower.id));
            tower.add(disk);
        }

        public void moveDisks(int n, Tower buffer, Tower destination) {
            if (n > 0) {
                moveDisks(n - 1, destination, buffer);
                moveTopTo(destination);
                buffer.moveDisks(n - 1, this, destination);
            }
        }
    }
}
