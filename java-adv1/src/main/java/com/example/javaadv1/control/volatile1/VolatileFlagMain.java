package com.example.javaadv1.control.volatile1;

public class VolatileFlagMain {
    public static void main(String[] args) {

    }

    static class MyTask implements Runnable {
        private volatile boolean running = true;

        public void terminate() {
            running = false;
        }

        @Override
        public void run() {
            while (running) {
                // 작업 처리
            }
        }
    }
}
