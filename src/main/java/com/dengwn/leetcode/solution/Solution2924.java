package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2024-04-13
 **/
public class Solution2924 {
    public int findChampion(int n, int[][] edges) {
        boolean[] fail = new boolean[n];
        for (int[] edge : edges) {
            fail[edge[1]] = true;
        }

        int ans = -1;
        for (int i = 0; i < n; i++) {
            if (!fail[i]){
                if (ans != -1){
                    return -1;
                }
                ans = i;
            }
        }
        return ans;
    }
}
