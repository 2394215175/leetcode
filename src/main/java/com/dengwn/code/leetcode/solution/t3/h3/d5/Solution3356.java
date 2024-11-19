package com.dengwn.code.leetcode.solution.t3.h3.d5;

/**
 *
 * @author dengwenning
 * @since 2024/11/18
 **/
public class Solution3356 {
    public int minZeroArray(int[] nums, int[][] queries) {
        if (!checkSum(queries, nums, queries.length)) {
            return -1;
        }
        int left = 0;
        int right = queries.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (checkSum(queries, nums, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    public boolean checkSum(int[][] queries, int[] nums, int k) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        for (int i = 0; i < k; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            int val = queries[i][2];
            cnt[l] += val;
            cnt[r + 1] -= val;
        }

        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += cnt[i];
            if (sum < nums[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 1};
        int[][] queries = {{1, 3, 2}, {0, 2, 1}};
        Solution3356 solution3356 = new Solution3356();
        System.out.println(solution3356.minZeroArray(nums, queries));
    }
}
