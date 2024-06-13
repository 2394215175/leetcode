package com.dengwn.leetcode.weeklyComp.h3.d5;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-06-18
 */
public class WeeklyComp350 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank > 0) {
            if (mainTank >= 5) {
                mainTank -= 5;
                ans += 50;
                if (additionalTank > 0) {
                    additionalTank -= 1;
                    mainTank += 1;
                }
            } else {
                ans += mainTank * 10;
                mainTank = 0;
            }
        }
        return ans;
    }

    public int findValueOfPartition(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int ans = nums[n - 1] - nums[0];
        for (int i = 0; i < n - 1; i++) {
            ans = Math.min(ans, nums[i + 1] - nums[i]);
        }
        return ans;
    }

    int MOD = 1000000007;

    public int specialPerm(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int[] dp = new int[n];

        for (int i = 1; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if (j == 0) {
                    if (nums[i] % nums[0] == 0 || nums[0] % nums[i] == 0) {
                        dp[i] += dp[i - 1];
                    }
                    break;
                }

                if ((nums[i] % nums[j - 1] == 0 || nums[j - 1] % nums[0] == 0) && (nums[i] % nums[j] == 0 || nums[j] % nums[0] == 0)) {
                    dp[i] += dp[i - 1];
                }

            }
        }

        int totalSpecialPermutations = 0;
        for (int count : dp) {
            totalSpecialPermutations = (totalSpecialPermutations + count) % MOD;
        }

        return totalSpecialPermutations;
    }


    public int minCost(int[] cost, int[] time) {
        int n = cost.length;
        int ans = 0;
        int[][][] left = new int[n][2][2];
        left[0][0][0] = cost[0];
        left[0][0][1] = time[0];
        left[0][1][0] = 0;
        left[0][1][1] = 0;

        for (int i = 1; i < n; i++) {
            if (left[i - 1][0][1] > 0) {
                // 选免费的
                left[i][0][0] = left[i - 1][0][0];
                left[i][0][1] = left[i - 1][0][1] - 1;
                // 不选免费的
                left[i][0][0] = left[i - 1][0][0];
            }


        }

        return 0;
    }


    public static void main(String[] args) {
        WeeklyComp350 weeklyComp350 = new WeeklyComp350();

//        System.out.println(weeklyComp350.distanceTraveled(5, 10));

        int[] nums = {2, 3, 6};
        System.out.println(weeklyComp350.specialPerm(nums));

//        int[] cost = {1, 2, 3, 2};
//        int[] time = {1, 2, 3, 2};
//        System.out.println(weeklyComp350.minCost(cost, time));
    }
}
