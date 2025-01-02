package com.dengwn.code.leetcode.solution.t0.h0.d7;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dengwenning
 * @since 2024/12/26
 **/
public class Solution75 {
    public void sortColors(int[] nums) {
        int n = nums.length;
        int p0 = 0;
        int p1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                swap(nums, i, p1);
                p1++;
            }
            if (nums[i] == 0) {
                swap(nums, i, p0);
                if (p0 < p1) {
                    swap(nums, i, p1);
                }
                p0++;
                p1++;
            }
        }
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
        Solution75 solution75 = new Solution75();
        solution75.sortColors(new int[]{1, 0});
    }
}
