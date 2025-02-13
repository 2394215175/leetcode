package com.dengwn.code.leetcode;

import java.util.concurrent.locks.ReentrantLock;

public class LockInterruptiblyDemo {
    private static final ReentrantLock lock = new ReentrantLock();

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                System.out.println(Thread.currentThread().getName() + " 尝试获取锁...");
                lock.lockInterruptibly();  // 获取锁，允许被中断
                try {
                    System.out.println(Thread.currentThread().getName() + " 获取锁成功，执行任务...");
                    Thread.sleep(5000); // 模拟长时间执行
                } finally {
                    lock.unlock();
//                    System.out.println(Thread.currentThread().getName() + " 释放锁");
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断，无法获取锁");
            }
        }, "线程1");

        Thread t2 = new Thread(() -> {
            try {
                Thread.sleep(100); // 确保 t1 先执行
                System.out.println(Thread.currentThread().getName() + " 试图获取锁...");
                lock.lockInterruptibly();  // 允许中断
                try {
                    System.out.println(Thread.currentThread().getName() + " 获取锁成功");
                } finally {
                    lock.unlock();
                }
            } catch (InterruptedException e) {
                System.out.println(Thread.currentThread().getName() + " 被中断，放弃获取锁");
            }
        }, "线程2");

        t1.start();
        t2.start();

        // 主线程等待一会儿，然后中断 t2
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt(); // 中断 t2，让 t2 放弃获取锁
    }
}
