package com.example.javaadv1.bounded;

import com.example.javaadv1.util.MyLogger;

public class ProducerTask implements Runnable {
    private final BoundedQueue queue;
    private final String data;

    public ProducerTask(BoundedQueue queue, String data) {
        this.queue = queue;
        this.data = data;
    }

    @Override
    public void run() {
        MyLogger.log("[생산 시도] " + data + " -> " + queue);
        queue.put(data);
        MyLogger.log("[생산 완료] " + data + " -> " + queue);
    }
}
