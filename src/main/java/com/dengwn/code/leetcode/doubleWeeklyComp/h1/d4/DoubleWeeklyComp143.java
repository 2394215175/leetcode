package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d4;

/**
 *
 * @author dengwenning
 * @since 2024/11/11
 **/
public class DoubleWeeklyComp143 {

    public int smallestNumber(int n, int t) {
        while (true) {
            if (getNumber(n) % t == 0) {
                return n;
            }
            n++;
        }
    }

    public int getNumber(int n) {
        int ans = 1;
        while (n > 0) {
            ans *= n % 10;
            n /= 10;
        }
        return ans;
    }

    public int maxFrequency(int[] nums, int k, int numOperations) {
        return 0;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp143 doubleWeeklyComp143 = new DoubleWeeklyComp143();

//        doubleWeeklyComp143.smallestNumber(15, 3);

        doubleWeeklyComp143.maxFrequency(new int[]{5, 11, 20, 20}, 5, 1);
    }
}
