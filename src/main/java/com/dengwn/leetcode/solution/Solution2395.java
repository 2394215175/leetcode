package com.dengwn.leetcode.solution;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dengwn
 * @date: 2023-03-26
 */
public class Solution2395 {
    public boolean findSubarrays(int[] nums) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (!set.add(sum)) {
                return true;
            }
        }
        return false;
    }
}
