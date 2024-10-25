package com.dengwn.code.leetcode.solution.t1.h6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengwn
 * @date: 2023-03-23
 */
public class Solution1630 {
    public List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> ans = new ArrayList<>();
        int m = l.length;
        for (int i = 0; i < m; i++) {
            int left = l[i];
            int right = r[i];
            boolean b = isSubArrays(nums, left, right);
            ans.add(b);
        }
        return ans;
    }

    public boolean isSubArrays(int[] nums, int left, int right) {
        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy, left, right + 1);
        int diff = copy[left + 1] - copy[left];
        for (int i = left + 1; i <= right; i++) {
            if (diff != copy[i] - copy[i - 1]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution1630 solution1630 = new Solution1630();
        int[] nums = {4, 6, 5, 9, 3, 7};
        int[] l = {0, 0, 2};
        int[] r = {2, 3, 5};
        System.out.println(solution1630.checkArithmeticSubarrays(nums, l, r));
    }
}
