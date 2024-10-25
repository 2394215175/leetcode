package com.dengwn.code.leetcode.solution.t1.h3;

/**
 * @author: dengwn
 * @date: 2023-05-12
 **/
public class Solution1330 {
    public int maxValueAfterReverse(int[] nums) {
        int oldValue = 0;
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            oldValue += Math.abs(nums[i] - nums[i - 1]);
        }
        if (n <= 2) {
            return oldValue;
        }
        int max = 0;
        // 两个特判
        if (Math.abs(nums[2] - nums[0]) > Math.abs(nums[2] - nums[1])) {
            max = Math.abs(nums[2] - nums[0]) - Math.abs(nums[2] - nums[1]);
        }

        if (Math.abs(nums[n - 3] - nums[n - 1]) > Math.abs(nums[n - 3] - nums[n - 2])) {
            max = Math.max(max, Math.abs(nums[n - 3] - nums[n - 1]) - Math.abs(nums[n - 3] - nums[n - 2]));
        }
        for (int l = 1; l < n - 2; l++) {
            for (int r = l + 1; r < n - 1; r++) {
                int a = nums[l - 1];
                int b = nums[l];
                int c = nums[r];
                int d = nums[r + 1];
                int diff = Math.abs(b - a) + Math.abs(c - d);
                int nMax = Math.max((c + d - a - b), (b + a - c - d));
                max = Math.max(max, nMax - diff);
            }
        }
        return oldValue + max;
    }

    public static void main(String[] args) {
        Solution1330 solution1330 = new Solution1330();
        int[] nums = {2, 5, 1, 3, 4};
        System.out.println(solution1330.maxValueAfterReverse(nums));
    }
}
