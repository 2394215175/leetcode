package com.dengwn.code.leetcode.solution.t2.h3.d9;

import java.util.Arrays;

/**
 * @author dengwn
 * @date: 2023-04-09
 */
public class Solution2399 {
    public boolean checkDistances(String s, int[] distance) {
        int[] diff = new int[26];
        char[] chars = s.toCharArray();
        Arrays.fill(diff, -1);
        for (int i = 0; i < chars.length; i++) {
            diff[chars[i] - 'a'] = i - diff[chars[i] - 'a'] - 1;
        }
        for (int i = 0; i < 26; i++) {
            if (diff[i] != -1 && diff[i] != distance[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2399 solution2399 = new Solution2399();
        String s = "abaccb";
        int[] distance = {1, 3, 0, 5, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
        System.out.println(solution2399.checkDistances(s, distance));
    }
}
