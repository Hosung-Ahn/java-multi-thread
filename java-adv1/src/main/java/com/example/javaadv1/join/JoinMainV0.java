package com.example.javaadv1.join;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

public class JoinMainV0 {
    public static void main(String[] args) throws InterruptedException {
        MyLogger.log("main() start");


        Job task = new Job(1, 50);
        Thread thread1 = new Thread(task);
        thread1.start();
        thread1.join();

        MyLogger.log("result : " + task.result);

        MyLogger.log("main() end");
    }

    static class Job implements Runnable {
        public int start;
        public int end;
        public int result = 0;

        public Job(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public void run() {
            for (int i=start;i<=end;i++) {
                result += i;
            }
            MyLogger.log("result: " + result);
        }
    }
}
