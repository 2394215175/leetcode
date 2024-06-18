package com.dengwn.leetcode.solution.t2.h4.d3;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-05-05
 **/
public class Solution2432 {
    public int hardestWorker(int n, int[][] logs) {
        int m = logs.length;
        int[][] temp = new int[m][2];
        temp[0][0] = logs[0][0];
        temp[0][1] = logs[0][1];
        for (int i = 1; i < m; i++) {
            temp[i][0] = logs[i][0];
            temp[i][1] = logs[i][1] - logs[i - 1][1];
        }

        Arrays.sort(temp, (o1, o2) -> o1[1] == o2[1] ? o1[0] - o2[0] : o2[1] - o1[1]);

        return temp[0][0];
    }

    public static void main(String[] args) {
        Solution2432 solution2432 = new Solution2432();
        int n = 10;
        int[][] logs = {{0, 3}, {2, 5}, {0, 9}, {1, 15}};
        System.out.println(solution2432.hardestWorker(n, logs));
    }
}
