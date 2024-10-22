package com.example.javaadv1.join;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

public class JoinMainV0 {
    public static void main(String[] args) throws InterruptedException {
        MyLogger.log("main() start");

        Thread thread1 = new Thread(new Task());
        Thread thread2 = new Thread(new Task());
        Thread thread3 = new Thread(new Task());
        // 직렬 실행 -> 약 9초 소모
//         thread1.start();
//         thread1.join();
//         thread2.start();
//         thread2.join();
//         thread3.start();
//         thread3.join();

        // 병렬 실행 -> 약 3초 소모
        thread1.start();
        thread2.start();
        thread3.start();

        thread1.join();
        thread2.join();
        thread3.join();

        MyLogger.log("main() end");
    }

    static class Task implements Runnable {
        @Override
        public void run() {
            for (int i=1;i<=3;i++) {
                MyLogger.log("Task: " + i);
                ThreadUtils.sleep(1000);
            }
        }
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
