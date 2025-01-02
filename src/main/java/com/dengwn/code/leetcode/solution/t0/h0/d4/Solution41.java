package com.dengwn.code.leetcode.solution.t0.h0.d4;

/**
 *
 * @author dengwenning
 * @since 2024/12/13
 **/
public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            while (nums[i] > 0 && nums[i] <= n && i != nums[i] - 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return n + 1;
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        Solution41 solution41 = new Solution41();
        int i = solution41.firstMissingPositive(nums);
        System.out.println(i);
    }

}
