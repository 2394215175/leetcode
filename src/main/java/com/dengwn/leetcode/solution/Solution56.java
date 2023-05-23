package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengwn
 * @date: 2023-05-16
 **/
public class Solution56 {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        int[][] ans = new int[n][2];
        int index = 0;
        Arrays.sort(intervals, (o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];
        for (int[] interval : intervals) {
            if (interval[0] == start) {
                continue;
            }
            if (interval[0] <= end) {
                end = Math.max(end, interval[1]);
            } else {
                ans[index++] = new int[]{start, end};
                start = interval[0];
                end = interval[1];
            }
        }
        ans[index++] = new int[]{start, end};
        return Arrays.copyOf(ans, index);
    }
}
