 package com.example.javaadv1.bounded;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV3 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV3(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() >= max) {
            MyLogger.log("[put] Queue is full");
            try {
                wait(); // RUNNABLE -> WAITING
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        queue.offer(data);
        notifyAll(); // WAITING -> BLOCKED
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            MyLogger.log("[take] Queue is empty");
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        notifyAll();
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
