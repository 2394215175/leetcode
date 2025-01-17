package com.dengwn.code.leetcode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 *
 * @author dengwenning
 * @since 2025/1/16
 **/
public class Question2 {
    // 共享的线程安全容器
    private static final Queue<Character> container = new LinkedList<>();
    private static final Lock lock = new ReentrantLock();
    private static final Condition condition = lock.newCondition();
    private static boolean isThread1Turn = true;

    // 线程1：将字符串a每隔1秒挨个添加到容器中
    static class Thread1 implements Runnable {
        private char[] data;

        public Thread1(String data) {
            this.data = data.toCharArray();
        }

        @Override
        public void run() {
            for (char c : data) {
                lock.lock();
                try {
                    // 如果不是线程1的回合，则等待
                    while (!isThread1Turn) {
                        condition.await();
                    }
                    container.add(c);
                    isThread1Turn = false; // 切换到线程2的回合
                    condition.signalAll(); // 唤醒其他线程
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
                try {
                    // 每隔1秒添加一个字符
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // 线程2：将字符串b每隔1秒挨个添加到容器中
    static class Thread2 implements Runnable {
        private char[] data;

        public Thread2(String data) {
            this.data = data.toCharArray();
        }

        @Override
        public void run() {
            for (char c : data) {
                lock.lock();
                try {
                    // 如果不是线程2的回合，则等待
                    while (isThread1Turn) {
                        condition.await();
                    }
                    container.add(c);
                    isThread1Turn = true; // 切换到线程1的回合
                    condition.signalAll(); // 唤醒其他线程
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(1000); // 每隔1秒添加一个字符
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    // 线程3：监听容器变化，输出容器元素
    static class Thread3 implements Runnable {
        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (!container.isEmpty()) {
                        char c = container.poll();
                        System.out.print(c);
                    }
                } finally {
                    lock.unlock();
                }
                try {
                    Thread.sleep(500); // 每隔0.5秒检查一次容器
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    public static void main(String[] args) {
        Thread t1 = new Thread(new Thread1("hloaiaa"));
        Thread t2 = new Thread(new Thread2("el,lbb"));
        Thread t3 = new Thread(new Thread3());

        t1.start();
        t2.start();
        t3.start();

        // 等待线程1和线程2执行完毕
        try {
            t1.join();
            t2.join();
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}
