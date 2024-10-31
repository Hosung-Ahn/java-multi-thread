package com.example.javaadv1.bounded;

import com.example.javaadv1.util.MyLogger;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV1 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV1(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        if (queue.size() >= max) {
            MyLogger.log("[put] Queue is full");
            return;
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        if (queue.isEmpty()) {
            MyLogger.log("[take] Queue is empty");
            return null;
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
