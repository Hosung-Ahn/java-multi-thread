package com.example.javaadv1.control;

import com.example.javaadv1.start.HelloRunnable;
import com.example.javaadv1.util.MyLogger;

public class ThreadInfoMain {
    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        MyLogger.log("Thread name: " + thread.getName());
        MyLogger.log("Thread ID: " + thread.getId());
        MyLogger.log("Thread priority: " + thread.getPriority());
        MyLogger.log("Thread state: " + thread.getState());
        MyLogger.log("Thread group: " + thread.getThreadGroup());
        MyLogger.log("Thread : " + thread);

//        Thread myThread = new Thread(new HelloRunnable(), "HelloRunnable");
//        MyLogger.log("myThread name: " + myThread.getName());
//        MyLogger.log("myThread ID: " + myThread.getId());
//        MyLogger.log("myThread priority: " + myThread.getPriority());
//        MyLogger.log("myThread state: " + myThread.getState());
//        MyLogger.log("myThread group: " + myThread.getThreadGroup());
    }
}
