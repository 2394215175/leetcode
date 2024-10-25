package com.dengwn.code.leetcode.solution.t0.h9.d9;

/**
 *
 * @author dengwenning
 * @since 2024/9/23
 **/
public class Solution997 {
    public int findJudge(int n, int[][] trust) {
        int[] cnt0 = new int[n + 1];
        int[] cnt1 = new int[n + 1];
        for (int[] t : trust) {
            cnt0[t[0]]++;
            cnt1[t[1]]++;
        }
        for (int i = 1; i < n + 1; i++) {
            if (cnt1[i] == n - 1 && cnt0[i] == 0) {
                return i;
            }
        }
        return -1;
    }
}
