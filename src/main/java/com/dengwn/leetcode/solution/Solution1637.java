package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author: dengwn
 * @date: 2023-03-30
 **/
public class Solution1637 {
    public int maxWidthOfVerticalArea(int[][] points) {
        Arrays.sort(points, Comparator.comparingInt(o -> o[0]));
        int ans = 0;
        for (int i = 1; i < points.length; i++) {
            ans = Math.max(points[i][0] - points[i - 1][0], ans);
        }
        return ans;
    }
}
