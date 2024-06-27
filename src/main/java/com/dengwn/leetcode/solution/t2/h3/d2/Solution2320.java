package com.dengwn.leetcode.solution.t2.h3.d2;

/**
 * @author: dengwn
 * @date: 2024-04-02
 **/
public class Solution2320 {
    int MOD = (int) 1e9 + 7;

    public int countHousePlacements(int n) {
        long first = 1;
        long second = 2;
        for (int i = 2; i <= n; i++) {
            long cur = (first + second) % MOD;
            first = second;
            second = cur;
        }
        return (int) (second * second % MOD);
    }
}
