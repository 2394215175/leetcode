package com.dengwn.leetcode.solution.t2.h2.d0;

/**
 *
 * @author dengwenning
 * @since 2024/9/24
 **/
public class Solution2207 {
    public long maximumSubsequenceCount(String text, String pattern) {
        char[] array = pattern.toCharArray();
        int[] cnt = new int[pattern.length()];
        long res = 0;
        for (char c : text.toCharArray()) {
            if (c == array[1]) {
                res += cnt[0];
                cnt[1]++;
            }
            if (c == array[0]) {
                cnt[0]++;
            }
        }
        return res + Math.max(cnt[0], cnt[1]);
    }

    public static void main(String[] args) {
        Solution2207 solution2207 = new Solution2207();
        System.out.println(solution2207.maximumSubsequenceCount("fwymvreuftzgrcrxczjacqovduqaiig", "yy"));
    }
}
