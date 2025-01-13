package com.dengwn.code.leetcode.solution.t2.h2.d7;

/**
 *
 * @author dengwenning
 * @since 2025/1/12
 **/
public class Solution2275 {
    public int largestCombination(int[] candidates) {
        int ans = 0;
        for (int i = 0; i < 24; i++) {
            int temp = 0;
            for (int candidate : candidates) {
                if ((candidate >> i & 1) > 0) {
                    temp++;
                }
            }
            ans = Math.max(ans, temp);

        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2275 solution = new Solution2275();
        System.out.println(solution.largestCombination(new int[]{16, 17, 71, 62, 12, 24, 14}));
    }
}
