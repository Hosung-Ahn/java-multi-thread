package com.example.javaadv1.start;

import com.example.javaadv1.util.MyLogger;

public class MainThreadMainV1 {
    public static void main(String[] args) {
        MyLogger.log("main() start");
        HelloRunnable helloRunnable = new HelloRunnable();

        for (int i=0;i<100;i++) {
            Thread thread = new Thread(helloRunnable);
            thread.start();
        }

        MyLogger.log("main() end");
    }
}
