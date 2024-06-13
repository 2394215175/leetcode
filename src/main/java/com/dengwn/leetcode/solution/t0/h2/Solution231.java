package com.dengwn.leetcode.solution.t0.h2;

/**
 * @author: dengwn
 * @date: 2023-01-05
 **/
public class Solution231 {
    static final int BIG = 1 << 30;

    public boolean isPowerOfTwo(int n) {
        return n > 0 && BIG % n == 0;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 31; i++) {
            System.out.println((int)Math.pow(2,i) );
        }
    }
}
