package com.dengwn.code.leetcode.solution.t2.h9.d6;

/**
 * @author dengwenning
 * @since 2024/5/10
 **/
public class Solution2960 {
    public int countTestedDevices(int[] batteryPercentages) {
        int ans = 0;
        int diff = 0;
        for (int batteryPercentage : batteryPercentages) {
            if (batteryPercentage > diff){
                ans++;
                diff++;
            }
        }
        return ans;
    }
}
