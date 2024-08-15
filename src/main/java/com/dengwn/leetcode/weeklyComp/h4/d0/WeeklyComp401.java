package com.dengwn.leetcode.weeklyComp.h4.d0;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/11
 **/
public class WeeklyComp401 {

    public int numberOfChild(int n, int k) {
        int ans = 0;
        int nx = 1;
        while (k > 0) {
            ans += nx;
            k--;
            if (ans == n - 1) {
                nx = -1;
            }
            if (ans == 0) {
                nx = 1;
            }
        }
        return ans;
    }

    int MOD = (int) 1e9 + 7;

    public int valueAfterKSeconds(int n, int k) {
        int[] ans = new int[n];
        Arrays.fill(ans, 1);
        for (int i = 0; i < k; i++) {
            for (int j = 1; j < n; j++) {
                ans[j] = ans[j - 1] + ans[j];
                ans[j] %= MOD;
            }
        }
        return ans[n - 1];
    }

    public int maxTotalReward(int[] rewardValues) {
        Arrays.sort(rewardValues);
        boolean[] dp = new boolean[2000 * 2000];
        dp[0] = true;
        int max = 0;
        for (int rewardValue : rewardValues) {
            for (int j = rewardValue - 1; j >= 0; j--) {
                if (dp[j]) {
                    dp[rewardValue + j] = true;
                    max = Math.max(max, rewardValue + j);
                }
            }
        }
        return max;
    }

    public int maxTotalReward1(int[] rewardValues) {
        Set<Integer> record = new HashSet<>();
        record.add(0);
        Arrays.sort(rewardValues);
        int max = 0;
        for (int rewardValue : rewardValues) {
            List<Integer> list = new ArrayList<>();
            for (Integer i : record) {
                if (rewardValue > i){
                    list.add(rewardValue + i);
                    max = Math.max(max, rewardValue + i);
                }
            }
            record.addAll(list);
        }
        return max;
    }


    public static void main(String[] args) {
        WeeklyComp401 weeklyComp401 = new WeeklyComp401();
    }
}
