package com.dengwn.leetcode.solution.t2.h9;

/**
 * @author dengwenning
 * @since 2024/6/2
 **/
public class Solution2928 {
    public int distributeCandies(int n, int limit) {
        int ans = 0;
        for (int i = 0; i <= limit; i++) {
            for (int j = 0; j <= limit; j++) {
                int k = n - i - j;
                if (k <= limit && k >= 0) {
                    ans++;
                }
            }
        }
        return ans;
    }
}
