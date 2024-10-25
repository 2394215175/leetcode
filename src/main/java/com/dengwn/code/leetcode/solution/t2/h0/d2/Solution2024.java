package com.dengwn.code.leetcode.solution.t2.h0.d2;

/**
 *
 * @author dengwenning
 * @since 2024/9/2
 **/
public class Solution2024 {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        int n = answerKey.length();
        char[] s = answerKey.toCharArray();
        int left = 0;
        int right = 0;
        int[] counts = new int[2];
        int ans = 0;
        while (left < n && right < n) {
            counts[s[right] >> 1 & 1]++;
            while (counts[0] > k && counts[1] > k) {
                counts[s[left] >> 1 & 1]--;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution2024 solution2024 = new Solution2024();
        System.out.println(solution2024.maxConsecutiveAnswers("TFFT", 1));
    }
}
