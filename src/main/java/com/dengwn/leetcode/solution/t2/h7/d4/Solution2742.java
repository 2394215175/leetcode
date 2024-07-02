package com.dengwn.leetcode.solution.t2.h7.d4;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/6/28
 **/
public class Solution2742 {
    int[] cost;
    int[] time;
    int[][] memo;

    public int paintWalls(int[] cost, int[] time) {
        int n = cost.length;
        this.cost = cost;
        this.time = time;
        this.memo = new int[n][n * 2 + 1];
        for (int[] arr : memo) {
            Arrays.fill(arr, -1);
        }
        return dfs(n - 1, 0);
    }

    // i 为下标
    // j 为剩余可用的时间, j 可能是负数
    // 当前需要的价值
    public int dfs(int i, int j) {
        if (j > i) {
            return 0;
        }
        if (i < 0) {
            return Integer.MAX_VALUE / 2;
        }
        int k = memo.length + j;
        if (memo[i][k] != -1) {
            return memo[i][k];
        }

        int res1 = dfs(i - 1, j + time[i]) + cost[i];
        int res2 = dfs(i - 1, j - 1);
        return memo[i][k] = Math.min(res1, res2);
    }


    public static void main(String[] args) {
        Solution2742 solution2742 = new Solution2742();
        int[] cost = {2, 3, 4, 2};
        int[] time = {500, 500, 500, 500};
        System.out.println(solution2742.paintWalls(cost, time));
    }
}
