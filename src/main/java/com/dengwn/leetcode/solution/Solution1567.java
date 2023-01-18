package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-01-12
 **/
public class Solution1567 {
    public int getMaxLen(int[] nums) {
        int neg = 0;
        int pos = 0;
        int first = -1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                neg = 0;
                pos = 0;
                first = -1;
            } else if (nums[i] > 0) {
                neg++;
            } else {
                if (first == -1) {
                    first = i;
                }
                pos++;
            }
            ans = Math.max(ans, pos % 2 == 0 ? neg + pos : i - first);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1567 solution1567 = new Solution1567();
        int[] nums = {0, 1, -2, -3, -4};
        System.out.println(solution1567.getMaxLen(nums));
    }
}
