package com.dengwn.leetcode.solution;

import java.util.HashMap;

/**
 * @author dengwn
 * @date: 2023-04-22
 */
public class Solution873 {
    public int lenLongestFibSubseq(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        int ans = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(arr[i], i);
        }
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0 && arr[i] < 2 * arr[j]; j--) {
                int t = arr[i] - arr[j];
                if (map.containsKey(t)) {
                    dp[i][j] = Math.max(3, dp[j][map.get(t)] + 1);
                    ans = Math.max(ans, dp[i][j]);
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution873 solution873 = new Solution873();
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        System.out.println(solution873.lenLongestFibSubseq(arr));
    }
}
