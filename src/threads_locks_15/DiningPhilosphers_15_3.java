package threads_locks_15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosphers_15_3 {

    public static void main(String[] args) {
        List<Philosopher> philosophers = new ArrayList<>();

        ChopStick first = new ChopStick(0);
        ChopStick prev = first;
        ChopStick next;

        int count = 2;
        for (int i = 0; i < count; i++) {
            next = new ChopStick(i + 1);
            Philosopher philosopher = new Philosopher(i, prev, next);
            philosophers.add(philosopher);
            prev = next;
        }

        Philosopher last = new Philosopher(count, prev, first);
        philosophers.add(last);


        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    static class ChopStick {
        private Lock lock;
        private int name;

        public ChopStick(int name) {
            this.name = name;
            lock = new ReentrantLock();
        }

        public void pickUp() {
            System.out.println("pickup stick " + name);
            lock.lock();
        }

        public void putDown() {
            lock.unlock();
        }
    }

    static class Philosopher extends Thread {
        private int bites = 10;

        private ChopStick left, right;
        private int index;

        public Philosopher(int index, ChopStick left, ChopStick right) {
            this.index = index;

            if (left.name < right.name) {
                this.left = left;
                this.right = right;
            } else {
                this.left = right;
                this.right = left;
            }
        }

        public void eat() {
            System.out.println("eat " + index);
            pickUp();
            chew();
            putDown();
        }

        public void pickUp() {
            left.pickUp();
            right.pickUp();
        }

        public void chew() {
        }

        public void putDown() {
            right.putDown();
            left.putDown();
        }

        public void run() {
            for (int i = 0; i < bites; i++) {
                eat();
            }
        }
    }
}
