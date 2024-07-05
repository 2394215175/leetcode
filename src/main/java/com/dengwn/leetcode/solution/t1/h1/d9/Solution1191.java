package com.dengwn.leetcode.solution.t1.h1.d9;

/**
 * @author: dengwn
 * @date: 2024-04-07
 **/
public class Solution1191 {
    int MOD = 1000000007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        long sum = 0;
        // 计算两个数组中的最大值
        long min = 0;
        long max = Integer.MIN_VALUE;
        for (int j : arr) {
            sum += j;
            min = Math.min(min, sum);
            max = Math.max(max, sum - min);
        }
        if (k == 1) {
            return (int) max;
        }
        for (int j : arr) {
            sum += j;
            min = Math.min(min, sum);
            max = Math.max(max, sum - min);
        }
        if (sum <= 0) {
            return (int) max % MOD;
        } else {
            return (int) (max + (k - 2) * sum / 2 % MOD) % MOD;
        }
    }

    public static void main(String[] args) {
        Solution1191 solution1191 = new Solution1191();
        System.out.println(solution1191.kConcatenationMaxSum(new int[]{1, 2}, 3));
    }
}


