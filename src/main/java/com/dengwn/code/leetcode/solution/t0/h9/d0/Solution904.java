package com.dengwn.code.leetcode.solution.t0.h9.d0;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution904 {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> map = new HashMap<>();
        int len = fruits.length;
        int ans = 0;
        int left = 0;
        for (int right = 0; right < len; right++) {
            map.merge(fruits[right], 1, Integer::sum);
            if (map.size() > 2) {
                int l = fruits[left];
                map.merge(l, -1, Integer::sum);
                if (map.get(l) == 0) {
                    map.remove(l);
                }
                left++;
            }
            ans = Math.max(ans, right - left + 1);
        }
        return ans;
    }
}
