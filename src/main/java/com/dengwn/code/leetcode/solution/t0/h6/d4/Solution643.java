package com.dengwn.code.leetcode.solution.t0.h6.d4;

/**
 *
 * @author dengwenning
 * @since 2025/1/4
 **/
public class Solution643 {
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += nums[i];
            if (i + 1 < k) {
                continue;
            }
            max = Math.max(max, sum);
            sum -= nums[i - k + 1];
        }
        return max * 1.0 / k;
    }

    public static void main(String[] args) {
        Solution643 solution643 = new Solution643();
        System.out.println(solution643.findMaxAverage(new int[]{-1}, 1));
    }
}
