package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-05-04
 **/
public class Solution1376 {
    public int numOfMinutes(int n, int headID, int[] manager, int[] informTime) {
        if (n == 1) {
            return 0;
        }
        List<int[]>[] lists = new List[n];
        for (int i = 0; i < lists.length; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            if (manager[i] >= 0) {
                lists[manager[i]].add(new int[]{i, informTime[manager[i]]});
            }
        }
        return dfs(lists, headID, 0);
    }

    public int dfs(List<int[]>[] next, int cur, int curTime) {
        int max = 0;
        List<int[]> list = next[cur];
        if (list.isEmpty()) {
            return curTime;
        }
        for (int[] ints : list) {
            int i = dfs(next, ints[0], curTime + ints[1]);
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int n = 15;
        int headID = 0;
        int[] manager = {-1, 0, 0, 1, 1, 2, 2, 3, 3, 4, 4, 5, 5, 6, 6};
        int[] informTime = {1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0};
        Solution1376 solution1376 = new Solution1376();
        System.out.println(solution1376.numOfMinutes(n, headID, manager, informTime));
    }

}
