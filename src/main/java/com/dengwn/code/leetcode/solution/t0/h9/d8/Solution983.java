package com.dengwn.code.leetcode.solution.t0.h9.d8;

/**
 *
 * @author dengwenning
 * @since 2024/10/18
 **/
public class Solution983 {
    public int mincostTickets(int[] days, int[] costs) {
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        boolean[] isPassed = new boolean[lastDay + 1];
        for (int day : days) {
            isPassed[day] = true;
        }
        for (int i = 1; i <= lastDay; i++) {
            if (!isPassed[i]) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = Math.min(dp[i - 1] + costs[0], Math.min(dp[Math.max(i - 7, 0)] + costs[1], dp[Math.max(i - 30, 0)] + costs[2]));
            }
        }
        return dp[lastDay];
    }

    public static void main(String[] args) {
        int[] days = {1, 4, 6, 7, 8, 20};
        int[] costs = {2, 7, 15};
        Solution983 solution983 = new Solution983();
        System.out.println(solution983.mincostTickets(days, costs));
    }
}
