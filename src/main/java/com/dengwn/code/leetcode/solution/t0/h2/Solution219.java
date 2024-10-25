package com.dengwn.code.leetcode.solution.t0.h2;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution219 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
}
