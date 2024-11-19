package com.dengwn.code.leetcode.solution.t3.h0.d3;

import static java.awt.SystemColor.text;

/**
 *
 * @author dengwenning
 * @since 2024/11/14
 **/
public class Solution3036 {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        int ans = 0;
        int n = nums.length;
        int m = pattern.length;
        int[] matchTable = getMatchTable(pattern);
        int j = 0;
        for (int i = 1; i < n; i++) {
            int num = nums[i] - nums[i - 1];
            while (j > 0 && Integer.compare(num, 0) != pattern[j]) {
                j = matchTable[j - 1];
            }
            if (Integer.compare(num, 0) == pattern[j]) {
                j++;
            }
            if (j == m) {
                ans++;
                j = matchTable[j - 1];
            }
        }
        return ans;
    }


    public int[] getMatchTable(int[] pattern) {
        int m = pattern.length;
        int[] table = new int[m];
        int j = 0;
        for (int i = 1; i < m; i++) {
            while (j > 0 && pattern[i] != pattern[j]) {
                j = table[j - 1];
            }
            if (pattern[i] == pattern[j]) {
                j++;
            }
            table[i] = j;
        }
        return table;
    }

    public static void main(String[] args) {
        Solution3036 solution3036 = new Solution3036();
        int[] nums = {1, 2, 3, 4, 5, 6};
        int[] pattern = {1, 1};
        System.out.println(solution3036.countMatchingSubarrays(nums, pattern));
    }
}
