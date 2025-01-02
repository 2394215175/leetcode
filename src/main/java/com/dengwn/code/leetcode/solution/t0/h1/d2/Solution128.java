package com.dengwn.code.leetcode.solution.t0.h1.d2;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dengwenning
 * @since 2024/12/12
 **/
public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int ans = 0;
        for (int num : nums) {
            if (set.contains(num - 1)) {
                continue;
            }
            int cur = num;
            int curLen = 1;
            while (set.contains(cur + 1)) {
                cur++;
                curLen++;
            }
            ans = Math.max(ans, curLen);
        }
        return ans;
    }
}
