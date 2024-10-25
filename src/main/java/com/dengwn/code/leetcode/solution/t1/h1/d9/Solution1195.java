package com.dengwn.code.leetcode.solution.t1.h1.d9;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

/**
 * @author: dengwn
 * @date: 2023-04-25
 **/
public class Solution1195 {
    public static void main(String[] args) throws InterruptedException {
        FizzBuzz fizzBuzz = new FizzBuzz(100);
        fizzBuzz.buzz(new Runnable() {
            @Override
            public void run() {
                System.out.println("buzz");
            }
        });
    }
}

class FizzBuzz {
    private int n;
    private AtomicInteger i = new AtomicInteger(1);

    public FizzBuzz(int n) {
        this.n = n;
    }

    // printFizz.run() outputs "fizz".
    public void fizz(Runnable printFizz) throws InterruptedException {
        while (i.get() < n) {
            if (i.get() % 3 == 0 && i.get() % 5 != 0) {
                printFizz.run();
                i.incrementAndGet();
            } else {
                Thread.yield();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        while (i.get() < n) {
            if (i.get() % 5 == 0 && i.get() % 3 != 0) {
                printBuzz.run();
                i.incrementAndGet();
            } else {
                Thread.yield();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        while (i.get() < n) {
            if (i.get() % 3 == 0 && i.get() % 5 == 0) {
                printFizzBuzz.run();
                i.incrementAndGet();
            } else {
                Thread.yield();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        while (i.get() < n) {
            if (i.get() % 3 != 0 && i.get() % 5 != 0) {
                printNumber.accept(i.get());
                i.incrementAndGet();
            } else {
                Thread.yield();
            }
        }
    }
}
