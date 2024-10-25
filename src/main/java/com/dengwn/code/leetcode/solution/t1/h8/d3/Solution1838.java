package com.dengwn.code.leetcode.solution.t1.h8.d3;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution1838 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int ans = 1;
        int left = 0;
        long cnt = 0;
        for (int right = 1; right < n; right++) {
            cnt += (long) (nums[right] - nums[right - 1]) * (right - left);
            if (cnt > k) {
                cnt -= nums[right] - nums[left];
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1838 solution1838 = new Solution1838();
        System.out.println(solution1838.maxFrequency(new int[]{1, 1, 1, 1, 1, 1, 100000}, 1));
    }
}
