package com.dengwn.code.leetcode.solution.t0.h8.d2;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dengwenning
 * @since 2024/5/22
 **/
public class Solution826 {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] talbe = new int[n][2];
        for (int i = 0; i < n; i++) {
            talbe[i] = new int[]{difficulty[i], profit[i]};
        }
        Arrays.sort(talbe, Comparator.comparingInt(o -> o[0]));
        int max = 0;
        for (int i = 0; i < n; i++) {
            if (talbe[i][1] < max) {
                talbe[i][1] = max;
            } else {
                max = talbe[i][1];
            }
        }

        int ans = 0;
        for (int i : worker) {
            int j = binarySearch(i, talbe);
            if (j == -1) {
                continue;
            }
            ans += talbe[j][1];
        }
        return ans;
    }

    public int binarySearch(int target, int[][] table) {
        int left = -1;
        int right = table.length - 1;
        while (left < right) {
            int mid = (left + right + 1) >> 1;
            if (table[mid][0] > target) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Solution826 solution826 = new Solution826();
        int[] difficulty = {68, 35, 52, 47, 86};
        int[] profit = {67, 17, 1, 81, 3};
        int[] worker = {92, 10, 85, 84, 82};

        System.out.println(solution826.maxProfitAssignment(difficulty, profit, worker));
    }
}
