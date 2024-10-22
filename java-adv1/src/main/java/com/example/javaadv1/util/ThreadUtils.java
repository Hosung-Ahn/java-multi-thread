package com.example.javaadv1.util;

public abstract class ThreadUtils {
    public static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            MyLogger.log("인터럽터 발생 : " + e.getMessage());
        }
    }
}
