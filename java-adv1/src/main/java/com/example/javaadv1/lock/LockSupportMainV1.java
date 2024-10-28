package com.example.javaadv1.lock;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

import java.util.concurrent.locks.LockSupport;

public class LockSupportMainV1 {
    public static void main(String[] args) {
        MyLogger.log("main() start");

        Thread thread = new Thread(new ParkTest());

        thread.start();
        ThreadUtils.sleep(500);
        MyLogger.log("ParkTest state : " + thread.getState());
        LockSupport.unpark(thread);
//        thread.interrupt();
        MyLogger.log("main() end");
    }

    static class ParkTest implements Runnable {
        @Override
        public void run() {
            MyLogger.log("ParkTest run() start");
            LockSupport.park();
//            LockSupport.parkNanos(1000000000);
            MyLogger.log("ParkTest state : " + Thread.currentThread().getState());
            MyLogger.log("Park Test interrupted : " + Thread.currentThread().isInterrupted());
            MyLogger.log("ParkTest run() end");
        }
    }
}
