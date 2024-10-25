package com.dengwn.code.leetcode.solution.t2.h8.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/9/18
 **/
public class Solution2848 {
    public int numberOfPoints(List<List<Integer>> nums) {
        nums.sort(Comparator.comparingInt(o -> o.get(0)));
        int ans = 0;
        int pre = nums.get(0).get(0) - 1;
        for (List<Integer> num : nums) {
            if (pre >= num.get(1)) {
                continue;
            }
            ans += num.get(1) - num.get(0) + 1 - Math.max(pre - num.get(0) + 1, 0);
            pre = num.get(1);
        }
        return ans;
    }

    public static void main(String[] args) {
        List<List<Integer>> nums = Arrays.asList(
                Arrays.asList(4, 4),
                Arrays.asList(9, 10),
                Arrays.asList(9, 10),
                Arrays.asList(3, 8)
        );
        Solution2848 solution2848 = new Solution2848();
        System.out.println(solution2848.numberOfPoints(nums));
    }
}
