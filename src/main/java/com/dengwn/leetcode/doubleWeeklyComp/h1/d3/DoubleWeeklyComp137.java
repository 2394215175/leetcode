package com.dengwn.leetcode.doubleWeeklyComp.h1.d3;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/8/17
 **/
public class DoubleWeeklyComp137 {

    public int[] resultsArray(int[] nums, int k) {
        int n = nums.length;
        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            res[i] = nums[i];
            for (int j = 1; j < k; j++) {
                if (nums[i + j] == res[i] + 1) {
                    res[i] = nums[i + j];
                } else {
                    res[i] = -1;
                    break;
                }
            }
        }
        return res;
    }

    public int[] resultsArray1(int[] nums, int k) {
        int n = nums.length;
        int[] temp = new int[n];
        for (int i = 1; i < n; i++) {
            if (nums[i] - nums[i - 1] == 1) {
                temp[i] = temp[i - 1] + 1;
            } else {
                temp[i] = temp[i - 1];
            }
        }

        int[] res = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            res[i] = temp[i + k - 1] - temp[i] == k - 1 ? nums[i + k - 1] : -1;
        }

        return res;
    }


    public long maximumValueSum(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] maxCol = new int[n][3];

        for (int i = 0; i < n; i++) {
            Arrays.fill(maxCol[i], Integer.MIN_VALUE);
            for (int j = 0; j < m; j++) {
                int num = board[i][j];
                if (num > maxCol[i][0]) {
                    maxCol[i][2] = maxCol[i][1];
                    maxCol[i][1] = maxCol[i][0];
                    maxCol[i][0] = num;
                } else if (num > maxCol[i][1]) {
                    maxCol[i][2] = maxCol[i][1];
                    maxCol[i][1] = num;
                } else if (num > maxCol[i][2]) {
                    maxCol[i][2] = num;
                }
            }
        }

        // 枚举选哪一行，以及那一行最大的三列里选哪一列
        long ans = 0;
        for (int i = 0; i < n; i++) {

        }
        return ans;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp137 doubleWeeklyComp137 = new DoubleWeeklyComp137();

//        int[] nums = {1, 2, 3, 4, 3, 2, 5};
//        int k = 3;
//        System.out.println(Arrays.toString(doubleWeeklyComp137.resultsArray1(nums, k)));

//        int[][] board = {{36, -30, -71},
//                {93, -51, -97},
//                {89, 59, 76}
//        };
//        System.out.println(doubleWeeklyComp137.maximumValueSum(board));

        System.out.println(sqrt(5));
        System.out.println(Math.sqrt(5));
    }

    public static double sqrt(int x) {
        double left = 1.0;
        double right = x;
        while (right - left > 0.000000000000001) {
            double mid = left + (right - left) / 2;
            if (mid * mid == x) {
                return mid;
            } else if (mid * mid < x) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return right;
    }
}
