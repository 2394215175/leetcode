package com.dengwn.code.leetcode.solution.t2.h7.d1;

/**
 *
 * @author dengwenning
 * @since 2024/12/11
 **/
public class Solution2717 {
    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        int index1 = 0;
        int indexN = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                index1 = i;
            }
            if (nums[i] == n) {
                indexN = i;
            }
        }
        return index1 > indexN ? index1 + n - 2 - indexN : index1 + n - 1 - indexN;
    }
}
