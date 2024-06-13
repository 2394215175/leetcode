package com.dengwn.leetcode.solution.t1.h1;

/**
 * @author: dengwn
 * @date: 2023-02-27
 **/
public class Solution1144 {
    public int movesToMakeZigzag(int[] nums) {
        int n = nums.length;
        if (n == 1) {
            return 0;
        }
        int up = 0;
        int down = 0;
        for (int i = 0; i < n; i++) {
            int cur = nums[i];
            if (i % 2 == 0) {
                int pre = i > 0 ? nums[i - 1] : Integer.MAX_VALUE;
                int next = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
                int diff = cur - Math.min(pre, next);
                if (diff >= 0) {
                    up += diff + 1;
                }
            } else {
                int pre = nums[i - 1];
                int next = i < n - 1 ? nums[i + 1] : Integer.MAX_VALUE;
                int diff = cur - Math.min(pre, next);
                if (diff >= 0) {
                    down += diff + 1;
                }
            }
        }
        return Math.min(up, down);
    }

    public static void main(String[] args) {
        int[] nums = {9, 6, 1, 6, 2};
        Solution1144 solution1144 = new Solution1144();
        System.out.println(solution1144.movesToMakeZigzag(nums));
    }
}
