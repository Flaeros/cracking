package threads_locks_15;

import java.util.concurrent.Semaphore;

public class MethodOrder_15_3 {

    public static void main(String[] args) {
        Foo foo = new Foo();

        new Thread(foo::third).start();
        new Thread(foo::second).start();
        new Thread(foo::first).start();
    }

    static class Foo {

        Semaphore sem1, sem2;

        public Foo() {
            try {
                sem1 = new Semaphore(1);
                sem2 = new Semaphore(1);

                sem1.acquire();
                sem2.acquire();
            } catch (InterruptedException e) {

            }
        }

        public void first() {
            System.out.println("first");
            sem1.release();
        }

        public void second() {
            try {
                sem1.acquire();
                sem1.release();
                System.out.println("second");
                sem2.release();
            } catch (InterruptedException e) {

            }
        }

        public void third() {
            try {
                sem2.acquire();
                sem2.release();
                System.out.println("third");
            } catch (InterruptedException e) {

            }
        }
    }
}
