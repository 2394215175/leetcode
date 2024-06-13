package com.dengwn.leetcode.solution.t2.h4;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-04-25
 **/
public class Solution2418 {
    public String[] sortPeople(String[] names, int[] heights) {
        int n = names.length;
        int[][] temp = new int[n][2];
        for (int i = 0; i < n; i++) {
            temp[i][0] = i;
            temp[i][1] = heights[i];
        }
        Arrays.sort(temp, (o1, o2) -> o2[1] - o1[1]);
        String[] ans = new String[n];
        for (int i = 0; i < n; i++) {
            ans[i] = names[temp[i][0]];
        }
        return ans;
    }
}
