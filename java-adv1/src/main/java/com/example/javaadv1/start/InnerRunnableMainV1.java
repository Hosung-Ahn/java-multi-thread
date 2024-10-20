package com.example.javaadv1.start;

import com.example.javaadv1.util.MyLogger;

public class InnerRunnableMainV1 {
    public static void main(String[] args) {
        MyLogger.log("main() start");

        Runnable runnable = new MyRunnable();
        Thread thread = new Thread(runnable);
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
