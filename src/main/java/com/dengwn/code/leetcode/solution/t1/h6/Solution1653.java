package com.dengwn.code.leetcode.solution.t1.h6;

/**
 * @author: dengwn
 * @date: 2023-03-06
 **/
public class Solution1653 {
    public int minimumDeletions(String s) {
        int size = 0;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            size += 'b' - c;
        }

        int ans = size;
        for (char c : chars) {
            size += (c - 'a') * 2 - 1;
            ans = Math.min(ans, size);
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1653 solution1653 = new Solution1653();
        System.out.println(solution1653.minimumDeletions("bbbbbbbaabbbbbaaabbbabbbbaabbbbbbaabbaaabaabbbaaaabaaababbbabbabbaaaabbbabbbbbaabbababbbaaaaaababaaababaabbabbbaaaabbbbbabbabaaaabbbaba"));
    }
}
