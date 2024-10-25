package com.dengwn.code.leetcode.solution.t1.h9;

/**
 * @author: dengwn
 * @date: 2024-03-28
 **/
public class Solution1997 {
    int MOD = 1_000_000_007;

    public int firstDayBeenInAllRooms(int[] nextVisit) {
        int n = nextVisit.length;
        int[] s = new int[n];
        for (int i = 0; i < n - 1; i++) {
            s[i + 1] = (2 * s[i] - s[nextVisit[i]] + 2) % MOD;
        }
        return s[n - 1];
    }
}
