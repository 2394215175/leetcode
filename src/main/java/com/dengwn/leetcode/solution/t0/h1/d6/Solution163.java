package com.dengwn.leetcode.solution.t0.h1.d6;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution163 {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int length = nums.length;
        List<String> res = new ArrayList<>();

        for (int i = 1; i <= length; i++) {
            int left = i - 1 < 0 ? lower : nums[i - 1] + 1;
            int right = i == length ? upper : nums[i] - 1;
            StringBuilder stringBuilder = new StringBuilder();
            if (left > right) {
                continue;
            } else if (left == right) {
                res.add(stringBuilder.append(left).toString());
            } else {
                res.add(stringBuilder.append(left).append("->").append(right).toString());
            }
        }

        return res;
    }
}
