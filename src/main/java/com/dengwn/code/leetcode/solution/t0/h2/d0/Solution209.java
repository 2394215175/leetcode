package com.dengwn.code.leetcode.solution.t0.h2.d0;

/**
 * @author: dengwn
 * @date: 2023-02-03
 **/
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int[] temp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            temp[i] = nums[i - 1] + temp[i - 1];
        }

        int ans = Integer.MAX_VALUE;
        int right = n;
        int left = n - 1;
        while (right > 0) {
            while (left >= 0) {
                if (temp[right] - temp[left] < target) {
                    left--;
                } else {
                    ans = Math.min(ans, right - left);
                    break;
                }
            }
            right--;
        }

        return ans == Integer.MAX_VALUE ? 0 : ans;
    }

    public static void main(String[] args) {
        Solution209 solution209 = new Solution209();
        int[] nums = {1,2,3,4,5};
        System.out.println(solution209.minSubArrayLen(15, nums));
    }
}
