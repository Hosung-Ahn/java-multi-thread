package com.example.javaadv1.control.interrupt;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

public class ThreadStopMainV1 {

    public static void main(String[] args) {
        MyTask myTask = new MyTask();
        Thread thread = new Thread(myTask, "work");


        ThreadUtils.sleep(1000);
        thread.start();
        thread.interrupt();
        MyLogger.log("스레드 밖에서 본 인터럽트 상태 : " + thread.isInterrupted());

        ThreadUtils.sleep(10000);
    }

    static class MyTask implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    MyLogger.log("run()");
                    Thread.sleep(3000);
                }
            } catch (InterruptedException e) {
                MyLogger.log("스레드 안에서 본 인터럽트 상태 : " + Thread.currentThread().isInterrupted());
                MyLogger.log("state : " + Thread.currentThread().getState());
                MyLogger.log("interrupted");
            }


            MyLogger.log("run over");
        }
    }
}
