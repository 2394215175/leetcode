package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d2;

/**
 * @author: dengwn
 * @date: 2024-03-30
 **/
public class DoubleWeeklyComp127 {


    public int minimumSubarrayLength(int[] nums, int k) {
        int n = nums.length;
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            int sum = nums[i];
            for (int j = i; j < n; j++) {
                sum |= nums[j];
                if (sum >= k) {
                    ans = Math.min(ans, j - i + 1);
                }
            }
        }
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    public int minimumLevels(int[] possible) {
        int n = possible.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = dp[i - 1] + (possible[i - 1] == 0 ? -1 : 1);
        }
        for (int i = 1; i < n; i++) {
            if (dp[i] > dp[n] - dp[i]) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 给你一个 非负 整数数组 nums 和一个整数 k 。
     * 如果一个数组中所有元素的按位或运算 OR 的值 至少 为 k ，那么我们称这个数组是 特别的 。
     * 请你返回 nums 中 最短特别非空 子数组的长度，如果特别子数组不存在，那么返回 -1 。
     * 时间复杂度为O(n)
     *
     * @param nums
     * @param k
     * @return
     */
    public int minimumSubarrayLength1(int[] nums, int k) {
        int n = nums.length;
        int v = 0;
        for (int num : nums) {
            v |= num;
        }
        if (v < k) {
            return -1;
        }
        int[][] sums = new int[n + 1][31];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 31; j++) {
                sums[i + 1][j] = sums[i][j] + ((nums[i] >> j) & 1);
            }
        }
        int l = 1;
        int r = n;
        while (l < r) {
            int mid = (l + r) >> 1;
            boolean b = false;
            for (int i = mid; i <= n; i++) {
                int t = 0;
                for (int j = 0; j < 31; j++) {
                    if (sums[i][j] - sums[i - mid][j] > 0) {
                        t += 1 << j;
                    }
                }
                if (t >= k) {
                    b = true;
                    break;
                }
            }
            if (b) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp127 doubleWeeklyComp127 = new DoubleWeeklyComp127();

//        System.out.println(doubleWeeklyComp127.minimumSubarrayLength(new int[]{1, 2}, 0));

//        System.out.println(doubleWeeklyComp127.minimumLevels(new int[]{0, 0, 0}));

        System.out.println(doubleWeeklyComp127.minimumSubarrayLength1(new int[]{1, 36, 92, 32, 82, 33, 2}, 109));
    }
}
