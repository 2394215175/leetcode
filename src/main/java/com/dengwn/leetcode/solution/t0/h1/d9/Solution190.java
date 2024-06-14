package com.dengwn.leetcode.solution.t0.h1.d9;

/**
 * @author: dengwn
 * @date: 2023-01-05
 **/
public class Solution190 {
    public static int reverseBits(int n) {
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            ans <<= 1;
            ans += (n & 1);
            n >>= 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        reverseBits(Integer.parseInt("00000010100101000001111010011100", 2));
    }
}
