package com.example.javaadv1.sync;

import com.example.javaadv1.util.MyLogger;
import com.example.javaadv1.util.ThreadUtils;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class BackAccountV4 implements BackAccount{
    private int balance;
    private final Lock lock = new ReentrantLock();

    public BackAccountV4(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean withdraw(int amount) {
        MyLogger.log("거래 시작 : " + getClass().getSimpleName());

        lock.lock(); // ReentrantLock으로 락 획득

        try {
            MyLogger.log("[검증 시작] 출금액 : " + amount + ", 잔액 : " + balance);
            if (balance < amount) {
                MyLogger.log("[검증 실패] 잔액 부족");
                return false;
            }
            MyLogger.log("[검증 성공] 출금 진행");

            ThreadUtils.sleep(1000); // 1초 대기
            balance -= amount;
        } finally {
            lock.unlock(); // ReentrantLock으로 락 해제
        }


        MyLogger.log("[거래 완료] 잔액 : " + balance);
        return true;
    }

    @Override
    public int getBalance() {
        return balance;
    }
}
