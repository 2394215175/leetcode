package com.dengwn.code.leetcode.solution.t0.h6.d0;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/8/5
 **/
public class Solution600 {

    int n;
    int[][] memo;

    public int findIntegers(int n) {
        this.n = n;
        int len = Integer.toBinaryString(n).length();
        memo = new int[len][2];
        for (int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dfs(len - 1, 0, true);
    }

    // i 表示当前到多少位
    // j 表示前一位填的什么
    // isLt表示是否小于n
    public int dfs(int i, int j, boolean isLt) {
        if (i < 0) {
            return 1;
        }
        if (!isLt && memo[i][j] >= 0) {
            return memo[i][j];
        }
        int up = isLt ? n >> i & 1 : 1;
        int res = dfs(i - 1, 0, isLt && up == 0);
        if (j == 0 && up == 1) {
            res += dfs(i - 1, 1, isLt);
        }
        if (!isLt) {
            memo[i][j] = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution600 solution600 = new Solution600();
        System.out.println(solution600.findIntegers(5));
    }
}
