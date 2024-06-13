package com.dengwn.leetcode.solution.t1.h1;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-06-15
 **/
public class Solution1177 {
    public List<Boolean> canMakePaliQueries(String s, int[][] queries) {
        int n = s.length();
        int[][] prefix = new int[n + 1][26];


        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i].clone();
            prefix[i + 1][s.charAt(i) - 'a']++;
        }
        List<Boolean> ans = new ArrayList<>();
        for (int[] query : queries) {
            int left = query[0];
            int right = query[1];
            int k = query[2];
            int cnt = 0;
            for (int i = 0; i < 26; i++) {
                cnt += (prefix[right + 1][i] - prefix[left][i]) % 2;
            }
            ans.add(cnt / 2 <= k);
        }

        return ans;
    }

    // 只需要考虑奇偶
    public List<Boolean> canMakePaliQueries1(String s, int[][] queries) {
        int n = s.length();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            int bit = 1 << (s.charAt(i) - 'a');
            sum[i + 1] = sum[i] ^ bit; // 该比特对应字母的奇偶性：奇数变偶数，偶数变奇数
        }

        List<Boolean> ans = new ArrayList<>(queries.length);
        for (int[] q : queries) {
            int left = q[0], right = q[1], k = q[2];
            int m = Integer.bitCount(sum[right + 1] ^ sum[left]);
            ans.add(m / 2 <= k);
        }
        return ans;
    }

    public static void main(String[] args) {
//        Solution1177 solution1177 = new Solution1177();
//        String s = "abcda";
//        int[][] queries = {{3, 3, 0}, {1, 2, 0}, {0, 3, 1}, {0, 3, 2}, {0, 4, 1}};
//        System.out.println(solution1177.canMakePaliQueries1(s, queries));

    }
}



