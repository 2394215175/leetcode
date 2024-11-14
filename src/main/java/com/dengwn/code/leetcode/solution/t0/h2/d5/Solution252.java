package com.dengwn.code.leetcode.solution.t0.h2.d5;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengwn
 * @date: 2022-12-09
 **/
public class Solution252 {
    public boolean canAttendMeetings(int[][] intervals) {
        for (int i = 1; i < intervals.length; i++) {
            for (int j = 0; j < i; j++) {
                if (intervals[i][0] <= intervals[j][1] && intervals[i][1] >= intervals[j][0]) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean canAttendMeetings1(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        for (int i = 0; i < intervals.length; i++) {
            if (intervals[i][1] > intervals[i + 1][0]) {
                return false;
            }
        }
        return true;
    }
}
