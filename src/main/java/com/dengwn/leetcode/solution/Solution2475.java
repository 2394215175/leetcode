package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-06-13
 **/
public class Solution2475 {
    public int unequalTriplets(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2; i++) {
            for (int j = i + 1; j < n - 1; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (nums[i] != nums[j] && nums[i] != nums[k] && nums[j] != nums[k]) {
                        ans++;
                    }
                }
            }
        }
        return ans;
    }

    public int unequalTriplets1(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        int res = 0;
        int n = nums.length;
        int t = 0;
        for (Integer value : map.values()) {
            res += t * value * (n - t - value);
            t += value;
        }
        return res;
    }
}
