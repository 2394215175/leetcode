package com.dengwn.code.leetcode.solution.t2.h2.d7;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/1/6
 **/
public class Solution2274 {
    public int maxConsecutive(int bottom, int top, int[] special) {
        int ans = 0;
        int pre = bottom;
        Arrays.sort(special);
        for (int i : special) {
            ans = Math.max(ans, i - pre + 1);
            pre = i + 1;
        }
        ans = Math.max(ans, top - pre + 1);
        char c = 'c';
        Character.toUpperCase(c);
        return ans;
    }

}
