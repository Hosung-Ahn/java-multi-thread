package com.example.javaadv1.sync;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

public class BackMain {
    public static void main(String[] args) throws InterruptedException {
        BackAccount account = new BackAccountV2(1000);

        Thread t1 = new Thread(new WithdrawTask(account, 800), "T1");
        Thread t2 = new Thread(new WithdrawTask(account, 800), "T2");


        t1.start();
        t2.start();

        ThreadUtils.sleep(500);
        MyLogger.log("T1 상태: " + t1.getState());
        MyLogger.log("T2 상태: " + t2.getState());

        t1.join();
        t2.join();

        MyLogger.log("최종 잔액: " + account.getBalance());

    }
}
