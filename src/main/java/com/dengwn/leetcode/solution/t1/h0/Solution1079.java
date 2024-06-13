package com.dengwn.leetcode.solution.t1.h0;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-05-19
 **/
public class Solution1079 {
    public int numTilePossibilities(String tiles) {
        int n = tiles.length();
        char[] chars = tiles.toCharArray();
        int ans = 0;
        boolean[] isUsed = new boolean[n];
        for (int i = 1; i <= n; i++) {
            Set<String> set = new HashSet<>();
            dfs(set, chars, i, isUsed, new StringBuilder());
            ans += set.size();
        }
        return ans;
    }

    public void dfs(Set<String> set, char[] tiles, int len, boolean[] isUsed, StringBuilder sb) {
        String s = sb.toString();
        if (set.contains(s)) {
            return;
        }
        if (s.length() == len) {
            set.add(s);
            return;
        }
        for (int i = 0; i < tiles.length; i++) {
            if (isUsed[i]) {
                continue;
            }
            sb.append(tiles[i]);
            isUsed[i] = true;
            dfs(set, tiles, len, isUsed, sb);
            sb.deleteCharAt(sb.length() - 1);
            isUsed[i] = false;
        }
    }

    public static void main(String[] args) {

        Solution1079 solution1079 = new Solution1079();
        System.out.println(solution1079.numTilePossibilities("AAB"));
    }
}
