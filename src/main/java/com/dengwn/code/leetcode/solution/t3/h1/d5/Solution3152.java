package com.dengwn.code.leetcode.solution.t3.h1.d5;

/**
 * @author dengwenning
 * @since 2024/8/14
 **/
public class Solution3152 {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n = nums.length;
        int m = queries.length;
        int[] arr = new int[n];
        for (int i = 1; i < n; i++) {
            arr[i] = (nums[i - 1] + nums[i] + 1) % 2 + arr[i - 1];
        }

        boolean[] res = new boolean[m];
        for (int i = 0; i < m; i++) {
            int from = queries[i][0];
            int to = queries[i][1];
            res[i] = arr[to] == arr[from];
        }
        return res;
    }
}
