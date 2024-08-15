package com.dengwn.leetcode.weeklyComp.h4.d0;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/16
 **/
public class WeeklyComp402 {

    public int countCompleteDayPairs(int[] hours) {
        int[] count = new int[24];
        for (int hour : hours) {
            count[hour % 24]++;
        }
        int pairs = 0;
        pairs += count[0] * (count[0] - 1) / 2;
        pairs += count[12] * (count[12] - 1) / 2;
        for (int i = 1; i < 12; i++) {
            pairs += count[i] * (count[24 - i]);
        }
        return pairs;
    }

    public long countCompleteDayPairs1(int[] hours) {
        long[] count = new long[24];
        for (int hour : hours) {
            count[hour % 24]++;
        }
        long pairs = 0;
        pairs += count[0] * (count[0] - 1) / 2;
        pairs += count[12] * (count[12] - 1) / 2;
        for (int i = 1; i < 12; i++) {
            pairs += count[i] * (count[24 - i]);
        }
        return pairs;
    }

    public long maximumTotalDamage(int[] power) {
        TreeMap<Integer, Long> treeMap = new TreeMap<>();
        for (int j : power) {
            treeMap.merge(j, 1L, Long::sum);
        }
        int size = treeMap.size();

        long[][] dp = new long[size + 2][2];
        dp[0][1] = -3;
        dp[1][1] = -2;
        Map.Entry<Integer, Long> firstEntry = treeMap.pollFirstEntry();
        dp[2][0] = firstEntry.getKey() * firstEntry.getValue();
        dp[2][1] = firstEntry.getKey();
        long ans = dp[2][0];
        for (int i = 3; i < size + 2; i++) {
            Map.Entry<Integer, Long> entry = treeMap.pollFirstEntry();
            int num = entry.getKey();
            long add = num * entry.getValue();
            for (int j = 1; j <= 3; j++) {
                if (num - dp[i - j][1] > 2) {
                    if (dp[i - j][0] + add > dp[i][0]) {
                        dp[i][0] = dp[i - j][0] + add;
                        dp[i][1] = num;
                    }
                } else {
                    if (dp[i - j][0] > dp[i][0]) {
                        dp[i][0] = dp[i - j][0];
                        dp[i][1] = dp[i - j][1];
                    }
                }
            }
            ans = Math.max(ans, dp[i][0]);
        }
        return ans;
    }

    public List<Integer> countOfPeaks(int[] nums, int[][] queries) {
        List<Integer> res = new ArrayList<>();
        return res;
    }

    public static void main(String[] args) {
        WeeklyComp402 weeklyComp402 = new WeeklyComp402();

//        int[] hours = {1, 23, 12, 12};
//        System.out.println(weeklyComp402.countCompleteDayPairs(hours));

        int[] power = {5, 9, 2, 10, 2, 7, 10, 9, 3, 8};
        System.out.println(weeklyComp402.maximumTotalDamage(power));

    }
}
