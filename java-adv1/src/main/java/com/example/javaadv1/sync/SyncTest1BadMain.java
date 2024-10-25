package com.example.javaadv1.sync;

public class SyncTest1BadMain {
    public static void main(String[] args) throws InterruptedException {
        Counter counter = new Counter();
        Runnable task = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 10000; i++) {
                    counter.increase();
                }
            }
        };

        Thread thread1 = new Thread(task);
        Thread thread2 = new Thread(task);

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();
        System.out.println("count: " + counter.getCount());
    }

    static class Counter {
        private int count = 0;

        public synchronized int increase() {
            return ++count;
        }

        public int getCount() {
            return count;
        }
    }
}
