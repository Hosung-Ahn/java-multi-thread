package com.example.javaadv1.start;

public class HelloThread extends Thread{
    @Override
    public void run() {
        // 현재 실행 중인 스레드의 이름을 출력
        System.out.println(Thread.currentThread().getName());
    }
}
