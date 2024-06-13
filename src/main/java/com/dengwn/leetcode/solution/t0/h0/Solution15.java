package com.dengwn.leetcode.solution.t0.h0;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-01-30
 **/
public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, Integer> map = new HashMap<>();
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        for (int i = 0; i < nums.length - 2; i++) {
            int a = nums[i];
            if (res.size() > 0 && res.get(res.size() - 1).get(0) == a) {
                continue;
            }
            for (int j = i + 1; j < nums.length - 1; j++) {
                int b = nums[j];
                if (res.size() > 0 && res.get(res.size() - 1).get(0) == a && res.get(res.size() - 1).get(1) == b) {
                    continue;
                }
                if (map.containsKey(-a - b) && map.get(-a - b) > j) {
                    res.add(Arrays.asList(a, b, -a - b));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution15 solution15 = new Solution15();
        int[] nums = {3, 0, -2, -1, 1, 2};
        System.out.println(solution15.threeSum(nums));
    }
}

