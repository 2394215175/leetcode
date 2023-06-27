package com.dengwn.leetcode.weeklyComp;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-06-25
 **/
public class WeeklyComp351 {
    public int countBeautifulPairs(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int a = nums[i];
                int b = nums[j] % 10;
                while (a >= 10) {
                    a /= 10;
                }
                if (gcd(a, b) == 1) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    public int makeTheIntegerZero(int num1, int num2) {
        int n = 1;
        long num = num1 - num2;
        while (num > 0 && num1 < Math.pow(2, 60)) {
            int number = numberOf1(num);
            if (number <= n) {
                return n;
            }
            num -= num2;
            n++;
        }
        return -1;
    }

    public int numberOf1(long n) {
        int count = 0;
        while (n != 0) {
            if (n % 2 != 0) {
                ++count;
            }
            n = n / 2;
        }
        return count;
    }

    public static final int MOD = (int) 1e9 + 7;

    public int numberOfGoodSubarraySplits(int[] nums) {
        int n = nums.length;
        int pre = -1;
        long ans = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                if (pre == -1) {
                    ans = 1;
                } else {
                    ans *= (i - pre);
                    ans %= MOD;
                }
                pre = i;
            }
        }
        return (int) ans;
    }

    public static void main(String[] args) {
        WeeklyComp351 weeklyComp351 = new WeeklyComp351();

//        int[] nums = {11, 21, 12};
//        System.out.println(weeklyComp351.countBeautifulPairs(nums));

        int num1 = 112577768;
        int num2 = -501662198;
        System.out.println(weeklyComp351.makeTheIntegerZero(num1, num2));

//        int[] nums = {1, 0, 0, 0, 0, 0, 1, 0, 1};
//        System.out.println(weeklyComp351.numberOfGoodSubarraySplits(nums));

    }
}
