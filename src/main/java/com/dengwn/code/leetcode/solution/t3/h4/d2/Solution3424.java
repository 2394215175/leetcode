package com.dengwn.code.leetcode.solution.t3.h4.d2;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/1/22
 **/
public class Solution3424 {
    public long minCost(int[] arr, int[] brr, long k) {
        int n = arr.length;
        long ans1 = 0;
        for (int i = 0; i < n; i++) {
            ans1 += Math.abs(arr[i] - brr[i]);
        }
        Arrays.sort(arr);
        Arrays.sort(brr);
        long ans2 = k;
        for (int i = 0; i < n; i++) {
            ans2 += Math.abs(arr[i] - brr[i]);
        }
        return Math.min(ans1, ans2);
    }
}
