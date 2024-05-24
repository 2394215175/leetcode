package com.dengwn.leetcode.solution;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/5/22
 **/
public class Solution1953 {
    public long numberOfWeeks(int[] milestones) {
        long sum = 0;
        long max = 0;
        for (int milestone : milestones) {
            sum += milestone;
            max = Math.max(max,milestone);
        }
        if (max > sum - max){
            return 2 * (sum - max) + 1;
        }
        return sum;
    }


}
