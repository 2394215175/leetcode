package com.dengwn.code.leetcode.solution.t1.h3.d6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 *
 * @author dengwenning
 * @since 2025/1/7
 **/
public class Solution1366 {
    public String rankTeams(String[] votes) {
        String vote1 = votes[0];
        int m = vote1.length();
        int[][] cnt = new int[26][m];
        for (String vote : votes) {
            char[] array = vote.toCharArray();
            for (int i = 0; i < array.length; i++) {
                cnt[array[i] - 'A'][i]++;
            }
        }
        return vote1.chars()
                .mapToObj(c -> (char) c)
                .sorted((a, b) -> {
                    int c = 0;
                    for (int i = 0; i < m; i++) {
                        if (cnt[b - 'A'][i] == cnt[a - 'A'][i]) {
                            continue;
                        }
                        c = cnt[b - 'A'][i] - cnt[a - 'A'][i];
                        break;
                    }
                    return c != 0 ? c : a - b;
                })
                .map(String::valueOf)
                .collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Solution1366 solution1366 = new Solution1366();
        System.out.println(solution1366.rankTeams(new String[]{"ABC", "ACB", "ABC", "ACB", "ACB"}));
    }
}
