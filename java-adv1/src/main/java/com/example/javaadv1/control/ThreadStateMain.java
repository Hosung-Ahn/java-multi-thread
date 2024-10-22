package com.example.javaadv1.control;

import com.example.javaadv1.util.MyLogger;

public class ThreadStateMain {
    public static void main(String[] args) {
        MyLogger.log("main() start");

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable, "myThread");
        MyLogger.log("thread state: " + thread.getState());
        thread.start();

        MyLogger.log("main() end");
    }

    static class MyRunnable implements Runnable {
        @Override
        public void run() {
            MyLogger.log("run()");
        }
    }
}
