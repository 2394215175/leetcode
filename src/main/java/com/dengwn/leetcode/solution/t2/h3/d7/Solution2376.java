package com.dengwn.leetcode.solution.t2.h3.d7;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/9/20
 **/
public class Solution2376 {

    public int countSpecialNumbers(int n) {
        char[] array = String.valueOf(n).toCharArray();
        int[][] memo = new int[array.length][1 << 10];
        for (int i = 0; i < array.length; i++) {
            Arrays.fill(memo[i], -1);
        }
        return dfs(0, 0, true, false, array, memo);
    }

    // mask 为选过的集合
    public int dfs(int i, int mask, boolean isLimit, boolean isNum, char[] arr, int[][] memo) {
        if (i == arr.length) {
            return isNum ? 1 : 0;
        }

        if (!isLimit && isNum && memo[i][mask] != -1) {
            return memo[i][mask];
        }

        int ans = 0;
        if (!isNum) {
            // 不选
            ans += dfs(i + 1, mask, false, false, arr, memo);
        }
        // 选
        int left = isNum ? 0 : 1;
        int right = isLimit ? arr[i] - '0' : 9;
        for (int j = left; j <= right; j++) {
            if ((mask >> j & 1) == 0) {
                // 可以选
                ans += dfs(i + 1, mask | (1 << j), isLimit && j == right, true, arr, memo);
            }
        }
        if (!isLimit && isNum) {
            memo[i][mask] = ans;
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution2376 solution2376 = new Solution2376();
        System.out.println(solution2376.countSpecialNumbers(135));
    }
}
