package com.dengwn.leetcode.solution.t0.h0.d0;

import java.util.HashMap;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-07-03
 **/
public class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
