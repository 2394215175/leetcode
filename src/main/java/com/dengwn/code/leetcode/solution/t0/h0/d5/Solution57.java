package com.dengwn.code.leetcode.solution.t0.h0.d5;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/12/27
 **/
public class Solution57 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int n = intervals.length;
        int[][] ans = new int[n + 1][2];
        int index = 0;
        int j = 0;
        int preEnd = -1;
        while (j < n) {
            int[] cur = intervals[index];
            if (newInterval[1] < cur[0]) {
                // 在当前的左侧且不相交
                ans[index++] = newInterval;
            } else if (newInterval[0] > cur[1]) {
                // 在当前的右侧且不相交
                ans[index++] = cur;
            } else {

            }
        }

        int[][] result = new int[index][2];
        System.arraycopy(ans, 0, result, 0, index);
        return result;
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 5}};
        int[] newInterval = {2, 3};
        Solution57 solution57 = new Solution57();
        System.out.println(Arrays.deepToString(solution57.insert(intervals, newInterval)));
    }
}
