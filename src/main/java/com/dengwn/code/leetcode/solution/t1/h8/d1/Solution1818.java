package com.dengwn.code.leetcode.solution.t1.h8.d1;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/4/30
 **/
public class Solution1818 {
    int MOD = (int) 1e9 + 7;

    public int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int ans = 0;
        int[] table = new int[n];
        for (int i = 0; i < n; i++) {
            ans += Math.abs(nums1[i] - nums2[i]);
            ans %= MOD;
            table[i] = nums1[i];
        }
        Arrays.sort(table);
        int diff = 0;
        for (int i = 0; i < n; i++) {
            int oldDiff = Math.abs(nums1[i] - nums2[i]);
            int index = searchLowBound(table, nums2[i]);
            int newDiff = Math.min(Math.abs(table[index] - nums2[i]), index == 0 ? Integer.MAX_VALUE : Math.abs(table[index - 1] - nums2[i]));
            diff = Math.max(diff, oldDiff - newDiff);
        }
        return ans - diff;
    }

    private int searchLowBound(int[] table, int target) {
        // 红蓝染色法找出 >= target 的最左边的元素 [l, r) 区间
        int l = 0;
        int r = table.length;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (table[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l == table.length ? l - 1 : l;
    }


    public static void main(String[] args) {
        Solution1818 solution1818 = new Solution1818();
        int[] nums1 = {5, 2, 7};
        int[] nums2 = {10, 7, 12};
        System.out.println(solution1818.minAbsoluteSumDiff(nums1, nums2));

        int[] nums = {1, 2, 3, 4, 5};
        System.out.println(solution1818.searchLowBound(nums, 1));
    }
}
