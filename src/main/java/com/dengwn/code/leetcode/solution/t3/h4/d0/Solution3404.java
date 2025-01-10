package com.dengwn.code.leetcode.solution.t3.h4.d0;

import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 *
 * @author dengwenning
 * @since 2025/1/3
 **/
public class Solution3404 {
    public long numberOfSubsequences(int[] nums) {
        int n = nums.length;
        HashMap<Double, Integer> map = new HashMap<>();
        for (int i = 4; i < n - 2; i++) {
            int c = nums[i];
            for (int j = i + 2; j < n; j++) {
                int d = nums[j];
                map.merge(c * 1.0 / d, 1, Integer::sum);
            }
        }

        long ans = 0;
        for (int i = 0; i < n - 6; i++) {
            int a = nums[i];
            for (int j = i + 2; j < n - 4; j++) {
                int b = nums[j];
                ans += 0;
            }
        }
        return ans;
    }
}
