package com.dengwn.leetcode.solution.t2.h2.d2;


import java.util.*;

/**
 * @author dengwenning
 * @since 2024/5/22
 **/
public class Solution2225 {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];
            freq.putIfAbsent(winner, 0);
            freq.merge(loser, 1, Integer::sum);
        }

        List<List<Integer>> ans = Arrays.asList(new ArrayList<>(), new ArrayList<>());
        for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (value < 2) {
                ans.get(value).add(key);
            }
        }

        Collections.sort(ans.get(0));
        Collections.sort(ans.get(1));
        return ans;
    }
}
