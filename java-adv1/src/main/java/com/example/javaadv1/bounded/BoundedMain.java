package com.example.javaadv1.bounded;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

import java.util.ArrayList;
import java.util.List;

public class BoundedMain {
    public static void main(String[] args) {
        // 1. BoundedQueue 선택
        BoundedQueue queue = new BoundedQueueV3(2);

        // 2. 생산자, 소비자 실행 순서 선택
        producerFirst(queue);
//        consumerFirst(queue);
    }

    private static void producerFirst(BoundedQueue queue) {
        MyLogger.log("[생산자 우선 시작] " + queue.getClass().getSimpleName());
        List<Thread> threads = new ArrayList<>();

        startProducer(queue, threads);
        printAllState(threads);
        startConsumer(queue, threads);
        printAllState(threads);

        MyLogger.log("[생산자 우선 종료] " + queue.getClass().getSimpleName());
    }

    private static void consumerFirst(BoundedQueue queue) {
        MyLogger.log("[소비자 우선 시작] " + queue.getClass().getSimpleName());
        List<Thread> threads = new ArrayList<>();

        startConsumer(queue, threads);
        printAllState(threads);
        startProducer(queue, threads);
        printAllState(threads);

        MyLogger.log("[소비자 우선 종료] " + queue.getClass().getSimpleName());
    }

    private static void startProducer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        MyLogger.log("[생산자 시작]");
        for (int i = 0; i < 3; i++) {
            ProducerTask producerTask = new ProducerTask(queue, "data-" + i);
            Thread thread = new Thread(producerTask);
            threads.add(thread);
            thread.start();
            ThreadUtils.sleep(100);
        }
    }

    private static void startConsumer(BoundedQueue queue, List<Thread> threads) {
        System.out.println();
        MyLogger.log("[소비자 시작]");
        for (int i = 0; i < 3; i++) {
            ConsumerTask consumerTask = new ConsumerTask(queue);
            Thread thread = new Thread(consumerTask);
            threads.add(thread);
            thread.start();
            ThreadUtils.sleep(100);
        }
    }

    private static void printAllState(List<Thread> threads) {
        System.out.println();
        MyLogger.log("[모든 스레드 상태 출력]");
        for (Thread thread : threads) {
            MyLogger.log(thread.getName() + ": " + thread.getState().name());
        }
    }
}
