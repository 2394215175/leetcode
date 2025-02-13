package com.dengwn.code.leetcode.solution.t3.h4.d4;

/**
 *
 * @author dengwenning
 * @since 2025/2/8
 **/
public class Solution3443 {
    public int maxDistance(String s, int k) {
        int[] cnt = new int['X'];
        int ans = 0;
        for (char c : s.toCharArray()) {
            cnt[c]++;
            int base = Math.abs(cnt['N'] - cnt['S']) + Math.abs(cnt['E'] - cnt['W']);
            int row = Math.min(cnt['N'], cnt['S']);
            int col = Math.min(cnt['E'], cnt['W']);
            ans = Math.max(ans, base + 2 * Math.min(row + col, k));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3443 solution3443 = new Solution3443();
        System.out.println(solution3443.maxDistance("EWWE", 0));
    }
}
