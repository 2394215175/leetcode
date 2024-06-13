package com.dengwn.leetcode.weeklyComp.h3.d4;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-06-11
 */
public class WeeklyComp349 {

    public int findNonMinOrMax(int[] nums) {
        int n = nums.length;
        if (n <= 2) {
            return -1;
        }
        Arrays.sort(nums);
        return nums[1];
    }


    public String smallestString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean isPre = true;
        boolean isUsed = false;
        for (int i = 0; i < n; i++) {
            if (chars[i] == 'a' && isPre) {
                continue;
            } else if (chars[i] == 'a' && !isPre) {
                break;
            } else if (chars[i] != 'a') {
                isPre = false;
                isUsed = true;
                chars[i] = (char) (chars[i] - 1);
            }
        }
        if (!isUsed) {
            chars[n - 1] = chars[n - 1] == 'a' ? 'z' : (char) (chars[n - 1] - 1);
        }
        return new String(chars);
    }

    public long minCost(int[] nums, int x) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        int[] min = new int[n];

        int maxMove = 0;

        System.arraycopy(nums, 0, dp[0], 0, n);
        System.arraycopy(nums, 0, min, 0, n);

        // 最多移动n-1次
        for (int i = 1; i < n; i++) {
            // 可能更多带来的收益
            int diff = 0;
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][(j + 1) % n];
                if (dp[i][j] < min[j]) {
                    diff += Math.max(0, min[j] - dp[i][j]);
                    min[j] = dp[i][j];
                }
            }
            // 收益大于移动的付出才有效
            if (diff > x) {
                maxMove = i;
            }
        }

        long ans = (long) maxMove * x;
        for (int i = 0; i < n; i++) {
            int value = Integer.MAX_VALUE;
            for (int j = 0; j < maxMove + 1; j++) {
                value = Math.min(value, dp[j][i]);
            }
            ans += value;
        }
            
        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp349 weeklyComp349 = new WeeklyComp349();
//        System.out.println(weeklyComp349.smallestString("aa"));

        int[] nums = {15, 150, 56, 69, 214, 203};
        int x = 42;
        System.out.println(weeklyComp349.minCost(nums, x));
    }
}
