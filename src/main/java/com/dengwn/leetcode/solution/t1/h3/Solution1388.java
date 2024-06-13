package com.dengwn.leetcode.solution.t1.h3;

/**
 * @author: dengwn
 * @date: 2024-04-02
 **/
public class Solution1388 {
    public int maxSizeSlices(int[] slices) {
        int[] v1 = new int[slices.length - 1];
        int[] v2 = new int[slices.length - 1];
        System.arraycopy(slices, 1, v1, 0, slices.length - 1);
        System.arraycopy(slices, 0, v2, 0, slices.length - 1);
        int ans1 = calculate(v1);
        int ans2 = calculate(v2);
        return Math.max(ans1, ans2);
    }

    public int calculate(int[] slices) {
        int n = slices.length;
        int num = (n + 1) / 3;
        int[][] dp = new int[n][num + 1];
        dp[0][1] = slices[0];
        dp[1][1] = Math.max(slices[0], slices[1]);

        for (int i = 2; i < n; i++) {
            for (int j = 1; j <= i && j <= num; j++) {
                // 选or不选当前的
                dp[i][j] = Math.max(dp[i - 2][j - 1] + slices[i], dp[i - 1][j]);
            }
        }
        return dp[n - 1][num];
    }

    public static void main(String[] args) {
        Solution1388 solution1388 = new Solution1388();
        int[] slices = {1, 2, 3, 4, 5, 6};
        System.out.println(solution1388.maxSizeSlices(slices));
    }
}
