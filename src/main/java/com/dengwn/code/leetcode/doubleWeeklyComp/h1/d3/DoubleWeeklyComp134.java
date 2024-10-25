package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d3;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/7/6
 **/
public class DoubleWeeklyComp134 {
    public int numberOfAlternatingGroups(int[] colors) {
        int count = 0;
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            if (colors[i] != colors[(i + 1) % n] && colors[i] != colors[(i - 1 + n) % n]) {
                count++;
            }
        }
        return count;
    }

    public long maximumPoints(int[] enemyEnergies, int currentEnergy) {
        Arrays.sort(enemyEnergies);
        int n = enemyEnergies.length;
        if (currentEnergy < enemyEnergies[0]) {
            return 0;
        }
        long k = currentEnergy;
        for (int i = 1; i < n; i++) {
            k += enemyEnergies[i];
        }
        return k / enemyEnergies[0];
    }

    public int numberOfAlternatingGroups(int[] colors, int k) {
        int count = 0;
        int n = colors.length;
        int[] dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);
        for (int i = 0; i < n; i++) {
            // 前一个值没算过
            if (dp[(i - 1 + n) % n] == Integer.MIN_VALUE) {
                // 计算当前值，看能和多少为组成交替
                int preIndex = i;
                for (int j = 0; j < k; j++) {
                    if (colors[(i - j + n) % n] != colors[(i - j - 1 + n) % n]) {
                        preIndex = i - j - 1;
                    } else {
                        break;
                    }
                }
                dp[i] = preIndex;
            } else {
                if (colors[i] == colors[(i - 1 + n) % n]) {
                    dp[i] = i;
                } else {
                    dp[i] = dp[(i - 1 + n) % n];
                }
            }
        }
        for (int i = 0; i < n; i++) {
            if ((i - dp[i]) >= k - 1) {
                count++;
            }
        }
        return count;
    }

    int k;
    int[] nums;
    int[][] memo;
    int m;

    public long countSubarrays(int[] nums, int k) {
        int n = nums.length;
        this.nums = nums;
        this.k = k;
        int max = 0;
        for (int num : nums) {
            max = Math.max(num, max);
        }
        int m = 1 << (Integer.toBinaryString(max).length() + 1);
        this.m = m;

        this.memo = new int[n][m];
        for (int[] i : memo) {
            Arrays.fill(i, -1);
        }

        return dfs(n - 1, m - 1, true);
    }

    public int dfs(int i, int j, boolean isAdd) {
        if (i < 0) {
            return j == k ? 1 : 0;
        }
        if (j < k) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        int ans = 0;
        if (j == m - 1 || isAdd) {
            ans += dfs(i - 1, j & nums[i], true);
        }
        ans += dfs(i - 1, j, false);
        // 选了是i
        memo[i][j] = ans;
        return ans;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp134 doubleWeeklyComp134 = new DoubleWeeklyComp134();
//        int[] enemyEnergies = {1, 2, 3};
//        int currentEnergy = 0;
//        System.out.println(doubleWeeklyComp134.maximumPoints(enemyEnergies, currentEnergy));

//        int[] colors = {0, 1, 0, 0, 1, 0, 1};
//        int k = 6;
//        System.out.println(doubleWeeklyComp134.numberOfAlternatingGroups(colors, k));

        int[] nums = {1,1,1};
        System.out.println(doubleWeeklyComp134.countSubarrays(nums, 1));

    }
}
