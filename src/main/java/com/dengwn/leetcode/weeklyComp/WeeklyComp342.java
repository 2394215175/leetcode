package com.dengwn.leetcode.weeklyComp;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @author: dengwn
 * @date: 2023-04-23
 **/
public class WeeklyComp342 {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

    public int sumOfMultiples(int n) {
        int ans = 0;
        for (int i = 3; i <= n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                ans += i;
            }
        }
        return ans;
    }

    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int n = nums.length;
        int[] ans = new int[n - k + 1];
        int[] cnt = new int[101];
        for (int i = 0; i < k; i++) {
            cnt[nums[i] + 50]++;
        }
        for (int i = 0; i < ans.length; i++) {
            int temp = x;
            for (int j = 0; j < 100; j++) {
                temp -= cnt[j];
                if (temp <= 0) {
                    ans[i] = j < 50 ? j - 50 : 0;
                    break;
                }
            }
            if (i == ans.length - 1){
                break;
            }
            cnt[nums[i] + 50]--;
            cnt[nums[i + k] + 50]++;
        }

        return ans;
    }

    public int minOperations(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int min = Integer.MAX_VALUE;

        int size = 0;
        for (int num : nums) {
            if (num == 1) {
                size++;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) {
                    dp[i][j] = nums[i];
                } else {
                    dp[i][j] = gcd(dp[i][j - 1], nums[j]);
                }
                if (dp[i][j] == 1) {
                    min = Math.min(min, j - i);
                }
            }
        }
        if (size == 0) {
            size = 1;
        }

        return min == Integer.MAX_VALUE ? -1 : min + n - size;
    }

    public int gcd(int a, int b) {
        if (a < b) {
            return gcd(b, a);
        }
        return b == 0 ? a : gcd(b, a % b);
    }

    public static void main(String[] args) {
        WeeklyComp342 weeklyComp342 = new WeeklyComp342();

//        int[] nums = {2, 6, 3, 4};
//        System.out.println(weeklyComp342.minOperations(nums));
        int[] nums = {-21,-24,50};
        int k = 2;
        int x = 2;
        System.out.println(Arrays.toString(weeklyComp342.getSubarrayBeauty(nums, k, x)));
    }
}
