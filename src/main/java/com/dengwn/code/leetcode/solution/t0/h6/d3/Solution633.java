package com.dengwn.code.leetcode.solution.t0.h6.d3;

/**
 *
 * @author dengwenning
 * @since 2024/11/4
 **/
public class Solution633 {
    public boolean judgeSquareSum(int c) {
        int a = 0;
        while (a * a <= c / 2) {
            int b = (int) Math.sqrt(c - a * a);
            if (a * a + b * b == c) {
                return true;
            }
            a++;
        }
        return false;
    }

    public static void main(String[] args) {
        Solution633 solution633 = new Solution633();
        System.out.println(solution633.judgeSquareSum(2147483646));
    }
}
