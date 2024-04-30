package com.dengwn.leetcode.solution;

/**
 * @author dengwenning
 * @since 2024/4/30
 **/
public class Solution2798 {
    public int numberOfEmployeesWhoMetTarget(int[] hours, int target) {
        int ans = 0;
        for (int hour : hours) {
            if (hour >= target){
                ans++;
            }
        }
        return ans;
    }
}
