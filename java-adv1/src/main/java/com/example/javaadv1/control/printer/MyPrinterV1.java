package com.example.javaadv1.control.printer;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;
import org.springframework.aop.target.ThreadLocalTargetSource;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV1 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("문서를 입력하세요. 종 (q) : ");
            String job = scanner.nextLine();

            if (job.equals("q")) {
                printer.running = false;
                break;
            }

            printer.jobQueue.add(job);
        }

    }

    static class Printer implements Runnable {
        volatile boolean running = true;
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (running) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                String job = jobQueue.poll();
                MyLogger.log("출력 시작 : " + job + ", 대기 문서 : " + jobQueue);
                ThreadUtils.sleep(3000);
                MyLogger.log("출력 완료");
            }
        }
    }
}
