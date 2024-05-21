package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dengwenning
 * @since 2024/5/6
 **/
public class Solution1235 {

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] tables = new int[n][3];
        for (int i = 0; i < n; i++) {
            tables[i] = new int[]{startTime[i], endTime[i], profit[i]};
        }
        Arrays.sort(tables, Comparator.comparingInt(o -> o[1]));

        int[] dp = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            int j = binarySearch(tables, tables[i - 1][0]);
            dp[i] = Math.max(dp[i - 1], dp[j] + tables[i - 1][2]);
        }

        return dp[n];
    }

    public int binarySearch(int[][] tables, int upper) {
        // 寻找 endTime <= upper 的最大下标
        int left = 0;
        int right = tables.length;
        while (left < right) {
            int mid = (left + right) >> 1;
            if (tables[mid][1] > upper) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution1235 solution1235 = new Solution1235();
        int[] startTime = {1, 2, 3, 4, 6};
        int[] endTime = {3, 5, 10, 6, 9};
        int[] profit = {20, 20, 100, 70, 60};
        System.out.println(solution1235.jobScheduling(startTime, endTime, profit));

    }
}
