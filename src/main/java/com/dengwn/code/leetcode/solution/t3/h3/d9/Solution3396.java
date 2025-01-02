package com.dengwn.code.leetcode.solution.t3.h3.d9;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution3396 {
    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int lastIndex = -1;
        for (int i = n - 1; i >= 0; i--) {
            if (!set.add(nums[i])) {
                lastIndex = i;
                break;
            }
        }
        return (lastIndex + 3) / 3;
    }
}
