package com.dengwn.leetcode.solution;

/**
 * @author dengwenning
 * @since 2024/4/25
 **/
public class Solution2739 {
    public int distanceTraveled(int mainTank, int additionalTank) {
        int ans = 0;
        while (mainTank > 0) {
            if (mainTank > 5){
                mainTank -= 5;
                ans += 5 * 10;
                if (additionalTank >= 1){
                    additionalTank -= 1;
                    mainTank += 1;
                }
            }else {
                ans += mainTank * 10;
                mainTank = 0;
            }
        }
        return ans;
    }
}
