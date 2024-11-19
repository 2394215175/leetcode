package com.dengwn.code.leetcode.solution.t3.h3.d5;

/**
 *
 * @author dengwenning
 * @since 2024/11/18
 **/
public class Solution3354 {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int[] cnt = new int[n + 1];
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            cnt[i] = cnt[i - 1] + nums[i - 1];
            sum += nums[i - 1];
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            if (nums[i - 1] != 0) {
                continue;
            }
            int left = cnt[i];
            int right = sum - left;
            if (left == right) {
                ans += 2;
            }
            if (Math.abs(left - right) == 1) {
                ans += 1;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 2, 0, 3};
        Solution3354 solution3354 = new Solution3354();
        System.out.println(solution3354.countValidSelections(nums));
    }
}
