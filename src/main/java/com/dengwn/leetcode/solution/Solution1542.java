package com.dengwn.leetcode.solution;

import java.util.HashMap;

/**
 * @author dengwenning
 * @since 2024/5/20
 **/
public class Solution1542 {
    public int longestAwesome(String s) {
        // key: 二进制压缩位
        // value： 下标
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int n = s.length();
        int pre = 0;
        int ans = 1;
        for (int i = 0; i < n; i++) {
            pre ^= 1 << (s.charAt(i) - '0');
            map.putIfAbsent(pre, i);
            for (int j = 0; j < 11; j++) {
                // 奇数
                int index = map.getOrDefault(pre ^ (1 << j), i);
                ans = Math.max(ans, i - index);
            }
            int index = map.getOrDefault(pre, i);
            ans = Math.max(ans, i - index);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution1542 solution1542 = new Solution1542();
        System.out.println(solution1542.longestAwesome("76263"));
    }
}
