package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-02-20
 **/
public class Solution2347 {
    public String bestHand(int[] ranks, char[] suits) {
        int[] suitSize = new int[4];
        int maxSuit = 0;
        for (char suit : suits) {
            if (suitSize[suit - 'a'] == 0) {
                maxSuit++;
            }
        }
        if (maxSuit == 1) {
            return "Flush";
        }

        int[] rankSize = new int[13];
        int maxRank = 0;
        for (int rank : ranks) {
            if (rankSize[rank - 1] == 0) {
                maxRank++;
            }
            rankSize[rank - 1]++;
        }
        if (maxRank == 5) {
            return "High Card";
        }

        for (int i : rankSize) {
            if (i >= 3) {
                return "Three of a Kind";
            }
        }
        return "Pair";
    }
}
