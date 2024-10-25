package com.dengwn.code.leetcode.solution.t1.h6.d9;

import javafx.util.Pair;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution1695 {
    public int maximumUniqueSubarray(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans = 0;
        int left = 0;
        int temp = 0;
        for (int cur : nums) {
            map.merge(cur, 1, Integer::sum);
            temp += cur;
            while (map.get(cur) > 1) {
                map.merge(nums[left], -1, Integer::sum);
                temp -= nums[left];
                left++;
            }
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}
