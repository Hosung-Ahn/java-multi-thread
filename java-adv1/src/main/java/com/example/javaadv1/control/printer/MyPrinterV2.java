package com.example.javaadv1.control.printer;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV2 {
    public static void main(String[] args) {
        Printer printer = new Printer();
        Thread thread = new Thread(printer, "printer");
        thread.start();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("문서를 입력하세요. 종 (q) : ");
            String job = scanner.nextLine();

            if (job.equals("q")) {
                thread.interrupt();
                break;
            }

            printer.jobQueue.add(job);
        }

    }

    static class Printer implements Runnable {
        Queue<String> jobQueue = new ConcurrentLinkedQueue<>();

        @Override
        public void run() {
            while (!Thread.interrupted()) {
                if (jobQueue.isEmpty()) {
                    continue;
                }

                String job = jobQueue.poll();

                try {
                    MyLogger.log("출력 시작 : " + job + ", 대기 문서 : " + jobQueue);
                    Thread.sleep(3000);
                    MyLogger.log("출력 완료");
                } catch (InterruptedException e) {
                    MyLogger.log("인터럽트 발생");
                    break;
                }
            }
        }
    }
}
