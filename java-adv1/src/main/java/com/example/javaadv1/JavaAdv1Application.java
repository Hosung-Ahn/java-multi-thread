package com.example.javaadv1;

import com.example.javaadv1.start.HelloThread;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JavaAdv1Application {

    public static void main(String[] args) {
        Thread thread = Thread.currentThread();
        System.out.println(thread.getName() + " : main() start");

        System.out.println(thread.getName() + " thread 실행 전");
        HelloThread helloThread = new HelloThread();
        helloThread.start(); // 멀티 스레드 -> 실행 순서 보장 X
        System.out.println(thread.getName() + " thread 실행 후");

        System.out.println(thread.getName() + " : main() end");
    }

}
