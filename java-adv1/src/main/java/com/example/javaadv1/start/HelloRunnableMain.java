package com.example.javaadv1.start;

public class HelloRunnableMain {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName() + " : main() start");

        System.out.println(Thread.currentThread().getName() + " thread 실행 전");
        HelloRunnable helloRunnable = new HelloRunnable();
        Thread thread = new Thread(helloRunnable);
        thread.start(); // 멀티 스레드 -> 실행 순서 보장 X
        System.out.println(Thread.currentThread().getName() + " thread 실행 후");

        System.out.println(Thread.currentThread().getName() + " : main() end");

    }
}
