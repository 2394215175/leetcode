package com.dengwn.leetcode.solution.t1.h1;

/**
 * @author: dengwn
 * @date: 2024-04-07
 **/
public class Solution1191 {
    int MOD = 1000000007;

    public int kConcatenationMaxSum(int[] arr, int k) {
        int n = arr.length;

        // 单个数组中最大前缀和以及最小前缀和
        long maxPreSum = 0;
        long minPreSum = 0;
        long sum = 0;
        for (int num : arr) {
            sum += num;
            maxPreSum = Math.max(maxPreSum, sum);
            minPreSum = Math.min(minPreSum, sum);
        }

        // 单个数组中最大后缀和以及最小后缀和
        long maxSufSum = 0;
        long minSufSum = 0;
        sum = 0;
        for (int i = n - 1; i >= 0; i--) {
            sum += arr[i];
            maxSufSum = Math.max(maxSufSum, sum);
            minSufSum = Math.min(minSufSum, sum);
        }

        long res = 0;
        // 单个数组中最大子数组
        res = Math.max(res, Math.max(sum - minPreSum, sum - minSufSum));

        // 两个以上数组拼接
        if (k >= 2) {
            res = Math.max(res, Math.max(sum, 0) * (k - 2) + maxPreSum + maxSufSum);
        }
        res %= MOD;

        return (int) res;
    }

    public static void main(String[] args) {
        Solution1191 solution1191 = new Solution1191();
        System.out.println(solution1191.kConcatenationMaxSum(new int[]{1, -1}, 1));
    }
}


