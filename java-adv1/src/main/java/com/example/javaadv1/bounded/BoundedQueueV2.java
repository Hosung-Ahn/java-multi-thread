package com.example.javaadv1.bounded;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

import java.util.ArrayDeque;
import java.util.Queue;

public class BoundedQueueV2 implements BoundedQueue{
    private final Queue<String> queue = new ArrayDeque<>();
    private final int max;

    public BoundedQueueV2(int max) {
        this.max = max;
    }

    @Override
    public synchronized void put(String data) {
        while (queue.size() >= max) {
            MyLogger.log("[put] Queue is full");
            ThreadUtils.sleep(1000);
        }
        queue.offer(data);
    }

    @Override
    public synchronized String take() {
        while (queue.isEmpty()) {
            MyLogger.log("[take] Queue is empty");
            ThreadUtils.sleep(1000);
        }
        return queue.poll();
    }

    @Override
    public String toString() {
        return queue.toString();
    }
}
