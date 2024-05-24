package com.dengwn.leetcode;

import java.util.TreeMap;

import java.util.*;

class Solution {

    int getState(boolean[] flag) {
        int base = 0;
        for (boolean b : flag) {
            base <<= 1;
            if (b) {
                base += 1;
            }
        }
        return base;
    }

    int dfs(int[][][] dp, int[] nums, int a, int b, boolean[] flag) {
        int state = getState(flag);
        if (nums.length % 2 == 1) {
            int cnt = 0;
            int num = 0;
            for (int i = 0; i < nums.length; i += 1) {
                if (!flag[i]) {
                    cnt += 1;
                    num = i;
                }
            }
            if (cnt == 1) {
                dp[state][a][b] = Math.abs(a - nums[num]) + Math.abs(num - nums[b]);
                return dp[state][a][b];
            }
        }
        if (state == (1 << nums.length) - 1) {
            dp[state][a][b] = Math.abs(a - nums[b]);
        }
        if (dp[state][a][b] != -1) {
            return dp[state][a][b];
        }
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i += 1) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            for (int j = 0; j < nums.length; j += 1) {
                if (flag[j]) {
                    continue;
                }
                flag[j] = true;
                int score = Math.abs(a - nums[i]) + Math.abs(j - nums[b]);
                min = Math.min(min, score + dfs(dp, nums, i, j, flag));
                flag[j] = false;
            }
            flag[i] = false;
        }
        dp[state][a][b] = min;
        return dp[state][a][b];
    }

    public int[] findPermutation(int[] nums) {
        int[][][] dp = new int[1 << nums.length][nums.length][nums.length];
        int[] ans = new int[nums.length];
        for (int[][] ints : dp) {
            for (int j = 0; j < dp[0].length; j += 1) {
                Arrays.fill(ints[j], -1);
            }
        }
        int min = Integer.MAX_VALUE;
        boolean[] flag = new boolean[nums.length];
        int a = 0;
        int b = 0;
        for (int i = 0; i < nums.length; i += 1) {
            if (flag[i]) {
                continue;
            }
            flag[i] = true;
            for (int j = nums.length - 1; j >= 0; j -= 1) {
                if (flag[j]) {
                    continue;
                }
                flag[j] = true;
                int score = Math.abs(j - nums[i]) + dfs(dp, nums, i, j, flag);
                if (score < min) {
                    a = i;
                    b = j;
                    min = score;
                }
                flag[j] = false;
            }
            flag[i] = false;
        }
        ans[0] = a;
        ans[nums.length - 1] = b;
        flag[a] = true;
        flag[b] = true;
        int rest = min - Math.abs(b - nums[a]);
        int l = 1;
        int r = nums.length - 2;
        while (l < r) {
            boolean quit = false;
            for (int i = 0; i < nums.length; i += 1) {
                if (flag[i]) {
                    continue;
                }
                flag[i] = true;
                for (int j = nums.length - 1; j >= 0; j -= 1) {
                    if (flag[j]) {
                        continue;
                    }
                    flag[j] = true;
                    int score = Math.abs(ans[l - 1] - nums[i]) + Math.abs(j - nums[ans[r + 1]]);
                    if (rest - score == dp[getState(flag)][i][j]) {
                        rest -= score;
                        ans[l] = i;
                        ans[r] = j;
                        quit = true;
                        break;
                    }
                    flag[j] = false;
                }
                if (quit) {
                    break;
                }
                flag[i] = false;
            }
            l += 1;
            r -= 1;
        }
        if (nums.length % 2 == 1) {
            Arrays.fill(flag, false);
            for (int i : ans) {
                flag[i] = true;
            }
            int num = 0;
            for (int i = 0; i < nums.length; i += 1) {
                if (!flag[i]) {
                    num = i;
                    break;
                }
            }
            ans[nums.length / 2] = num;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().findPermutation(new int[]{0,3,2,1})));
    }
}
