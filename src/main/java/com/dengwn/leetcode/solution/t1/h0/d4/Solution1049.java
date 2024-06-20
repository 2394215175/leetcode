package com.dengwn.leetcode.solution.t1.h0.d4;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * @author dengwenning
 * @since 2024/6/20
 **/
public class Solution1049 {
    int[][] table;

    public int lastStoneWeightII(int[] stones) {
        int sum = 0;
        int n = stones.length;
        for (int stone : stones) {
            sum += stone;
        }
        int c = sum / 2;
        table = new int[n][c + 1];
        for (int i = 0; i < n; i++) {
            Arrays.fill(table[i], -1);
        }
        int half = dfs(n - 1, c, stones);
        return sum - 2 * (c - half);
    }


    public int dfs(int i, int c, int[] nums) {
        if (i < 0) {
            return c;
        }
        if (table[i][c] >= 0) {
            return table[i][c];
        }
        if (c < nums[i]) {
            return table[i][c] = dfs(i - 1, c, nums);
        }
        return table[i][c] = Math.min(dfs(i - 1, c, nums), dfs(i - 1, c - nums[i], nums));
    }

    public static void main(String[] args) {
        Solution1049 solution1049 = new Solution1049();
        int[] stones = {35, 33, 30, 25, 19, 11, 53, 40, 36, 10, 31, 23, 26, 13, 14, 18, 33, 22, 16, 22, 16, 28, 16, 72, 25, 23, 19};
        System.out.println(solution1049.lastStoneWeightII(stones));
    }
}
