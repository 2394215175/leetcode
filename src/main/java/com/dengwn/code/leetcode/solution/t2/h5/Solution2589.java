package com.dengwn.code.leetcode.solution.t2.h5;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/5/15
 **/
public class Solution2589 {
    public int findMinimumTime(int[][] tasks) {
        int ans = 0;
        Arrays.sort(tasks, Comparator.comparingInt(o -> o[1]));
        int mx = tasks[tasks.length - 1][1];
        boolean[] run = new boolean[mx + 1];
        for (int[] task : tasks) {
            int start = task[0];
            int end = task[1];
            int num = task[2];
            int cnt = 0;
            for (int i = start; i <= end; i++) {
                if (run[i]) {
                    cnt++;
                }
            }
            int add = Math.max(num - cnt, 0);
            ans += add;
            for (int i = end; i >= start && add > 0; i--) {
                if (run[i]) {
                    continue;
                }
                run[i] = true;
                add--;
            }

        }
        return ans;
    }


    public static void main(String[] args) {
        Solution2589 solution2589 = new Solution2589();
        System.out.println(solution2589.findMinimumTime(new int[][]{{8, 19, 1}, {3, 20, 1}, {1, 20, 2}, {6, 13, 3}}));
    }
}
