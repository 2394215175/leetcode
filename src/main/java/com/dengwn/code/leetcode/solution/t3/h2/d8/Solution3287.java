package com.dengwn.code.leetcode.solution.t3.h2.d8;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/11/15
 **/
public class Solution3287 {
    public int maxValue(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2 * k + 1; i++) {
            int index = i + k;
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int j = 0; j < n; j++) {
                if (j < index) {
                    nums1[j] = nums[j];
                } else {
                    nums2[j] = nums[j];
                }
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int max1 = getMaxOrValue(nums1, k) ^ getMinOrValue(nums2, k);
            int max2 = getMinOrValue(nums1, k) ^ getMaxOrValue(nums2, k);
            ans = Math.max(ans, Math.max(max1, max2));
        }
        return ans;
    }

    // 计算前 m 个数中，选 k 个数进行 OR 运算的最大值
    public int getMaxOrValue(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[n - 1];
        k--;
        for (int i = n - 2; i >= 0; i--) {
            if ((ans | nums[i]) > 0) {
                ans |= nums[i];
                k--;
            }
        }
        return ans;
    }

    // 计算前 m 个数中，选 k 个数进行 OR 运算的最小值
    public int getMinOrValue(int[] nums, int k) {
        int ans = 0;
        int i = 0;
        while (k > 0) {
            if (nums[i] > 0) {
                ans |= nums[i];
                k--;
            }
            i++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3287 solution3287 = new Solution3287();
        int[] nums = {4, 2, 5, 6, 7};
        int k = 2;
        System.out.println(solution3287.maxValue(nums, k));
    }
}
