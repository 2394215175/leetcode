package com.dengwn.leetcode;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * 基于一个ReentrantLock和三个condition实现连续打印abcabc...
 *
 * @author lixiaoxi
 */
public class SyncPrinter {

    static Thread t1 = null;
    static Thread t2 = null;

    public static void main(String[] args) throws InterruptedException {
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<String> list2 = Arrays.asList("A", "B", "C");
        t1 = new Thread(() -> list1.forEach(item -> {
            System.out.print(item);
            LockSupport.unpark(t2);
            LockSupport.park();
        }));
        t2 = new Thread(() -> list2.forEach(item -> {
            LockSupport.park();
            System.out.print(item);
            LockSupport.unpark(t1);
        }));

        t1.start();
        t2.start();

    }

}
