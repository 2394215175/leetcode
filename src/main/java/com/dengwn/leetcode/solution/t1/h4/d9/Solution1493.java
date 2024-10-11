package com.dengwn.leetcode.solution.t1.h4.d9;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution1493 {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int left = 0;
        int ans = 0;
        int cnt0 = 0;
        for (int right = 0; right < n; right++) {
            if (nums[right] == 0) {
                cnt0++;
            }
            while (cnt0 > 1) {
                if (nums[left] == 0) {
                    cnt0--;
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans - 1;
    }

    public static void main(String[] args) {
        Solution1493 solution1493 = new Solution1493();
        System.out.println(solution1493.longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}));
    }
}
