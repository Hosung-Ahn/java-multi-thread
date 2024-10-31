package com.example.javaadv1.bounded;

import com.example.javaadv1.util.MyLogger;

public class ConsumerTask implements Runnable {
    private final BoundedQueue queue;

    public ConsumerTask(BoundedQueue queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        MyLogger.log("[소비 시도] " + queue);
        String data = queue.take();
        MyLogger.log("[소비 완료] " + data + " <- " + queue);
    }
}
