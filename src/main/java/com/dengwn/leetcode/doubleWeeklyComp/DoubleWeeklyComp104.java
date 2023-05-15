package com.dengwn.leetcode.doubleWeeklyComp;

import com.sun.org.apache.xpath.internal.operations.Mod;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-05-13
 */
public class DoubleWeeklyComp104 {
    public int countSeniors(String[] details) {
        int ans = 0;
        for (String detail : details) {
            String age = detail.substring(11, 13);
            if (Integer.parseInt(age) > 60) {
                ans++;
            }
        }
        return ans;
    }

    public int matrixSum(int[][] nums) {
        int ans = 0;
        int n = nums.length;
        int m = nums[0].length;
        for (int i = 0; i < n; i++) {
            Arrays.sort(nums[i]);
        }
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, nums[j][i]);
            }
            ans += max;
        }
        return ans;
    }

    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        int[][] dp = new int[n][47];
        int[] a = new int[47];
        for (int value : nums) {
            int num = value;
            int index = 0;
            while (num > 0) {
                a[index++] += num % 2;
                num /= 2;
            }
        }

        for (int i = 0; i < n; i++) {
            int[] ints = Arrays.copyOf(a, 47);
            int num = nums[i];
            int index = 0;
            while (num > 0) {
                ints[index + k] += num % 2;
                ints[index++] -= num % 2;
                num /= 2;
            }
            dp[i] = ints;
        }

        long ans = 0;
        for (int i = 0; i < n; i++) {
            long temp = 0;
            for (int j = 0; j < 47; j++) {
                temp += (dp[i][j] == 0 ? 0 : 1) * Math.pow(2, j);
            }
            ans = Math.max(temp, ans);
        }
        return ans;
    }

    static final int MOD = 1000000007;

    public int sumOfPower(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        long[] coefficient = new long[n];
        coefficient[0] = nums[0];
        for (int i = 1; i < n; i++) {
            coefficient[i] = (2 * coefficient[i - 1] - nums[i - 1] + nums[i]) % MOD;
        }
        long ans = 0;
        for (int i = 0; i < n; i++) {
            long l = coefficient[i] * nums[i];
            ans += (l % MOD) * nums[i];
            ans %= MOD;
        }
        return (int) ans;
    }

    //567530242
    public static void main(String[] args) {
        DoubleWeeklyComp104 doubleWeeklyComp104 = new DoubleWeeklyComp104();

//        String[] details = {"7868190130M7522", "5303914400F9211", "9273338290F4010"};
//        System.out.println(doubleWeeklyComp104.countSeniors(details));

//        int[][] nums = {
//                {1  , 8, 16, 15, 12, 9, 15, 11, 18, 6, 16, 4, 9, 4},
//                {3  , 19, 8, 17, 19, 4, 9, 3, 2, 10, 15, 17, 3, 11},
//                {13 , 10, 19, 20, 6, 17, 15, 14, 16, 8, 1, 17, 0, 2},
//                {12 , 20, 0, 19, 15, 10, 7, 10, 2, 6, 18, 7, 7, 4},
//                {17 , 14, 2, 2, 10, 16, 15, 3, 9, 17, 9, 3, 17, 10},
//                {17 , 6, 19, 17, 18, 9, 14, 2, 19, 12, 10, 18, 7, 9},
//                {5  , 6, 5, 1, 19, 8, 15, 2, 2, 4, 4, 1, 2, 17},
//                {12 , 16, 8, 16, 7, 6, 18, 13, 18, 8, 14, 15, 20, 11},
//                {2  , 10, 19, 3, 15, 18, 20, 10, 6, 7, 0, 8, 3, 7},
//                {11 , 5, 10, 13, 1, 3, 4, 7, 1, 18, 20, 17, 19, 2},
//                {0  , 3, 20, 6, 19, 18, 3, 12, 2, 11, 3, 1, 19, 0},
//                {6  , 5, 3, 15, 6, 1, 0, 17, 13, 19, 3, 8, 2, 7},
//                {2  , 20, 9, 11, 13, 5, 1, 16, 14, 1, 19, 3, 12, 6}};
//        System.out.println(doubleWeeklyComp104.matrixSum(nums));

        int[] nums = {12, 9};
        int k = 1;
        System.out.println(doubleWeeklyComp104.maximumOr(nums, k));

//        int[] nums = {658, 489, 777, 2418, 1893, 130, 2448, 178, 1128, 2149, 1059, 1495, 1166, 608, 2006, 713, 1906, 2108, 680, 1348, 860, 1620, 146, 2447, 1895, 1083, 1465, 2351, 1359, 1187, 906, 533, 1943, 1814, 1808, 2065, 1744, 254, 1988, 1889, 1206};
//        System.out.println(doubleWeeklyComp104.sumOfPower(nums));
    }


}
