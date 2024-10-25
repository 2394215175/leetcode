package com.dengwn.code.leetcode.solution.t1.h1.d0;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2023-04-23
 **/
public class Solution1105 {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        Arrays.fill(dp, 2000000);
        dp[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            int maxHeight = 0, curWidth = 0;
            for (int j = i - 1; j >= 0; j--) {
                curWidth += books[j][0];
                if (curWidth > shelfWidth) {
                    break;
                }
                maxHeight = Math.max(maxHeight, books[j][1]);
                dp[i] = Math.min(dp[i], dp[j] + maxHeight);
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        Solution1105 solution1105 = new Solution1105();
        int[][] books = {{1, 1}, {2, 3}, {2, 3}, {1, 1}, {1, 1}, {1, 1}, {1, 2}};
        int shelfWidth = 4;
        System.out.println(solution1105.minHeightShelves(books, shelfWidth));
    }
}
