package com.dengwn.code.leetcode.solution.t2.h3.d6;

/**
 * @author: dengwn
 * @date: 2023-03-31
 **/
public class Solution2367 {
    public int arithmeticTriplets(int[] nums, int diff) {
        boolean[] vis = new boolean[500];
        for (int num : nums) {
            vis[num] = true;
        }
        int ans = 0;
        for (int num : nums) {
            if (vis[num + diff] && vis[num + diff + diff]) {
                ans++;
            }
        }
        return ans;
    }
}
