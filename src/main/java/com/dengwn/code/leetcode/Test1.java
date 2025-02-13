package com.dengwn.code.leetcode;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/**
 *
 * @author dengwenning
 * @since 2025/2/6
 **/
public class Test1 {
    public static void main(String[] args) {
        Test1 tIA = new Test1();
        tIA.doIt();
    }

    public AtomicIntegerFieldUpdater<DataDemo> updater(String name) {
        return AtomicIntegerFieldUpdater.newUpdater(DataDemo.class, name);
    }

    public void doIt() {
        DataDemo data = new DataDemo();
        AtomicIntegerFieldUpdater<DataDemo> publicVar = updater("publicVar");
        int i = publicVar.get(data);
        System.out.println(i);
        int add = publicVar.getAndAdd(data, 2);
        System.out.println("publicVar = " + add);
        /*
         * 由于在DataDemo类中属性value2/value3,在TestAtomicIntegerFieldUpdater中不能访问
         * */
//        System.out.println("protectedVar = "+updater("protectedVar").getAndAdd(data,2));
//        System.out.println("privateVar = "+updater("privateVar").getAndAdd(data,2));

        //System.out.println("staticVar = "+updater("staticVar").getAndIncrement(data));//报java.lang.IllegalArgumentException
        /*
         * 下面报异常：must be integer
         * */
        System.out.println("integerVar = "+updater("integerVar").getAndIncrement(data));
        System.out.println("longVar = "+updater("longVar").getAndIncrement(data));
    }

}

class DataDemo {
    public volatile int publicVar = 3;
    protected volatile int protectedVar = 4;
    private volatile int privateVar = 5;

    public volatile static int staticVar = 10;
    //public  final int finalVar = 11;

    public volatile Integer integerVar = 19;
    public volatile Long longVar = 18L;

}