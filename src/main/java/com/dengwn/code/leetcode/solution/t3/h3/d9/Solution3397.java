package com.dengwn.code.leetcode.solution.t3.h3.d9;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution3397 {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int ans = 0;
        int preMax = Integer.MIN_VALUE;
        for (int num : nums) {
            if (num + k > preMax) {
                ans++;
                preMax = Math.max(preMax + 1, num - k);
            }
        }
        return ans;
    }
}
