package threads_locks_15;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DiningPhilosphers_15_3 {

    public static void main(String[] args) {
        List<Philosopher> philosophers = new ArrayList<>();

        ChopStick prev = null;
        ChopStick next = new ChopStick("0");
        Philosopher first = new Philosopher("0", prev, next);
        philosophers.add(first);
        prev = next;

        for (int i = 0; i < 2; i++) {
            next = new ChopStick(String.valueOf(i + 1));
            Philosopher philosopher = new Philosopher("" + i, prev, next);
            philosophers.add(philosopher);
            prev = next;
        }
        first.left=prev;

        for (Philosopher philosopher : philosophers) {
            philosopher.start();
        }
    }

    static class ChopStick {
        private Lock lock;
        private String name;

        public ChopStick(String name) {
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
        private String name;

        public Philosopher(String name, ChopStick left, ChopStick right) {
            this.name = name;
            this.left = left;
            this.right = right;
        }

        public void eat() {
            System.out.println("eat " + name);
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
