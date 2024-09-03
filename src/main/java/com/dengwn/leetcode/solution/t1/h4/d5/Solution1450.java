package com.dengwn.leetcode.solution.t1.h4.d5;

/**
 *
 * @author dengwenning
 * @since 2024/9/2
 **/
public class Solution1450 {

    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int n = startTime.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                ans++;
            }
        }
        return ans;
    }
}
