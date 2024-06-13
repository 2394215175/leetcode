package com.dengwn.leetcode.solution.t0.h1;

/**
 * @author: dengwn
 * @date: 2022-12-27
 **/
public class Solution191 {
    public int hammingWeight(int n) {
        int ans = 0;
        if (n < 0) {
            n = n + Integer.MAX_VALUE + 1;
            ans++;
        }
        while (n > 0) {
            System.out.println(Integer.toBinaryString(n));
            if (n % 2 == 1) {
                ans++;
            }
            n /= 2;
        }
        return ans;
    }

    public int hammingWeight1(int n) {
        int ret = 0;
        while (n != 0) {
            n &= n - 1;
            ret++;
        }
        return ret;
    }

    public static void main(String[] args) {
        int x = 0b11111111111111111111111111111101;

        Solution191 solution191 = new Solution191();
        System.out.println(solution191.hammingWeight1(x));
    }
}
