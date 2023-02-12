package com.dengwn.leetcode.solution;

import java.util.HashMap;

/**
 * @author dengwn
 * @date: 2023-02-12
 */
public class Solution1138 {
    public String alphabetBoardPath(String target) {
        HashMap<Character, int[]> map = new HashMap<>(26);
        for (int i = 0; i < 26; i++) {
            map.put((char) ('a' + i), new int[]{i / 5, i % 5});
        }

        StringBuilder res = new StringBuilder();
        int cx = 0, cy = 0;
        for (int i = 0; i < target.length(); i++) {
            int[] next = map.get(target.charAt(i));
            int nx = next[0];
            int ny = next[1];
            if (nx < cx) {
                for (int j = 0; j < cx - nx; j++) {
                    res.append('U');
                }
            }
            if (ny < cy) {
                for (int j = 0; j < cy - ny; j++) {
                    res.append('L');
                }
            }
            if (nx > cx) {
                for (int j = 0; j < nx - cx; j++) {
                    res.append('D');
                }
            }
            if (ny > cy) {
                for (int j = 0; j < ny - cy; j++) {
                    res.append('R');
                }
            }
            res.append('!');
            cx = nx;
            cy = ny;
        }
        return res.toString();
    }

    public String alphabetBoardPath1(String target) {
        int cx = 0, cy = 0;
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < target.length(); i++) {
            char c = target.charAt(i);
            int nx = (c - 'a') / 5;
            int ny = (c - 'a') % 5;
            if (nx < cx) {
                for (int j = 0; j < cx - nx; j++) {
                    res.append('U');
                }
            }
            if (ny < cy) {
                for (int j = 0; j < cy - ny; j++) {
                    res.append('L');
                }
            }
            if (nx > cx) {
                for (int j = 0; j < nx - cx; j++) {
                    res.append('D');
                }
            }
            if (ny > cy) {
                for (int j = 0; j < ny - cy; j++) {
                    res.append('R');
                }
            }
            res.append('!');
            cx = nx;
            cy = ny;
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution1138 solution1138 = new Solution1138();
        System.out.println(solution1138.alphabetBoardPath("zdz"));
        System.out.println(solution1138.alphabetBoardPath1("zdz"));
    }
}
