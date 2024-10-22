package com.example.javaadv1.start;

import com.example.javaadv1.util.MyLogger;

public class StartTest1Main {
    public static void main(String[] args) {
        MyLogger.log("main() start");

        Thread thread = new Thread(new CountRunnable());
        thread.start();

        MyLogger.log("main() end");
    }


    static class CountRunnable implements Runnable {
        @Override
        public void run() {
            for (int i=1;i<=5;i++) {
                MyLogger.log("Count: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
