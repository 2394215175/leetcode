package com.dengwn.leetcode.solution.t1.h1;

/**
 * @author dengwenning
 * @since 2024/6/3
 **/
public class Solution1103 {
    public int[] distributeCandies(int candies, int num_people) {
        int[] ans = new int[num_people];
        int i = 0;
        int j = 0;
        while (candies > 0) {
            j++;
            int add = Math.min(candies, j);
            ans[i % num_people] += add;
            i++;
            candies -= add;
        }
        return ans;
    }
}
