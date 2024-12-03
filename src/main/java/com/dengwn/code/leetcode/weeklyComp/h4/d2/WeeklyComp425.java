package com.dengwn.code.leetcode.weeklyComp.h4.d2;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/11/24
 **/
public class WeeklyComp425 {

    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;
        int size = nums.size();
        int[] sum = new int[size + 1];
        for (int i = 0; i < size; i++) {
            sum[i + 1] = sum[i] + nums.get(i);
        }
        for (int i = l; i <= r; i++) {
            // 长度为i
            for (int j = i; j <= size; j++) {
                if (sum[j] - sum[j - i] > 0) {
                    ans = Math.min(ans, sum[j] - sum[j - i]);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public boolean isPossibleToRearrange(String s, String t, int k) {
        int n = s.length();
        int d = n / k;
        String[] s1 = new String[k];
        String[] s2 = new String[k];
        for (int i = 0; i < k; i++) {
            s1[i] = s.substring(i * d, (i + 1) * d);
            s2[i] = t.substring(i * d, (i + 1) * d);
        }
        Arrays.sort(s1);
        Arrays.sort(s2);
        for (int i = 0; i < d; i++) {
            if (!s1[i].equals(s2[i])) {
                return false;
            }
        }
        return true;
    }

    int t1, t2;
    int[][] t;
    int[][][] memo;
    int[] nums;

    public int minArraySum(int[] nums, int k, int op1, int op2) {
        int n = nums.length;
        int[][] dp = new int[n][5];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE / 2);
        }
        for (int i = 0; i < n; i++) {
            dp[i][0] = nums[i];
            // 0 操作1，1操作2，2 先操作1后操作2，3 先操作2后操作1
            dp[i][1] = (nums[i] + 1) / 2;
            if (nums[i] >= k) {
                dp[i][2] = nums[i] - k;
                dp[i][4] = (nums[i] - k + 1) / 2;
            }
            if ((nums[i] + 1) / 2 >= k) {
                dp[i][3] = (nums[i] + 1) / 2 - k;
            }
        }
        t = dp;
        t1 = op1;
        t2 = op2;
        memo = new int[n][t1 + 1][t2 + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < t1 + 1; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(0, 0, 0);
    }

    public int dfs(int i, int time1, int time2) {
        if (i >= t.length) {
            return 0;
        }
        if (memo[i][time1][time2] != -1) {
            return memo[i][time1][time2];
        }
        // 啥都不操作
        int nx = dfs(i + 1, time1, time2) + nums[i];
        // 如果可以用操作1
        if (time1 < t1) {
            int tmp = dfs(i + 1, time1 + 1, time2) + t[i][1];
            nx = Math.min(nx, tmp);
        }
        // 如果可以用操作2
        if (time2 < t2) {
            int tmp = dfs(i + 1, time1, time2 + 1) + t[i][2];
            nx = Math.min(nx, tmp);
        }
        // 如果可以同时用操作1和2
        if (time1 < t1 && time2 < t2) {
            int tmp1 = dfs(i + 1, time1 + 1, time2 + 1) + t[i][3];
            int tmp2 = dfs(i + 1, time1 + 1, time2 + 1) + t[i][4];
            int tmp = Math.min(tmp1, tmp2);
            nx = Math.min(nx, tmp);
        }
        memo[i][time1][time2] = nx;
        return nx;
    }

    public long maximizeSumOfWeights(int[][] edges, int k) {
        return 0;
    }

    public static void main(String[] args) {
        WeeklyComp425 weeklyComp425 = new WeeklyComp425();

//        List<Integer> nums = Arrays.asList(3, -2, 1, 4);
//        int l = 2, r = 3;
//        System.out.println(weeklyComp425.minimumSumSubarray(nums, l, r));

//        String s = "aabbcc";
//        String t = "bbaacc";
//        int k = 3;
//        System.out.println(weeklyComp425.isPossibleToRearrange(s, t, k));

        int[] nums = {3};
        int k = 6, op1 = 0, op2 = 1;
        System.out.println(weeklyComp425.minArraySum(nums, k, op1, op2));
    }
}
