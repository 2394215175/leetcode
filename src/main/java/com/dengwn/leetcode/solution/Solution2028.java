package com.dengwn.leetcode.solution;

/**
 * @author dengwenning
 * @since 2024/5/27
 **/
public class Solution2028 {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int m = rolls.length;
        int sum = 0;
        for (int roll : rolls) {
            sum += roll;
        }
        int missing = (n + m) * mean - sum;
        if (n * 6 < missing || n > missing) {
            return new int[0];
        }
        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            ans[i] = missing / n;
            if (missing % n > 0) {
                ans[i]++;
                missing--;
            }
        }

        return ans;
    }
}
