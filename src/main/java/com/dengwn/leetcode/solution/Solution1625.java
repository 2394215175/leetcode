package com.dengwn.leetcode.solution;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/**
 * @author dengwn
 * @date: 2023-03-19
 */
public class Solution1625 {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        Queue<char[]> queue = new LinkedList<>();
        queue.add(s.toCharArray());
        Set<String> visited = new HashSet<>();
        visited.add(s);
        String ans = s;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                char[] cur = queue.poll();
                // 比较当前值和结果哪个大
                String val = String.valueOf(cur);
                if (ans.compareTo(val) > 0) {
                    ans = val;
                }

                // 累加
                for (int j = 1; j < n; j += 2) {
                    cur[j] = (char) (((cur[j] - '0' + a) % 10) + '0');
                }

                String add = String.valueOf(cur);
                if (!visited.contains(add)) {
                    queue.add(cur);
                }
                visited.add(add);
                // 轮转
                String loop = val.substring(n - b) + val.substring(0, n - b);
                if (!visited.contains(loop)) {
                    queue.add(loop.toCharArray());
                }
                visited.add(loop);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "5525";
        int a = 9;
        int b = 2;
        Solution1625 solution1625 = new Solution1625();
        System.out.println(solution1625.findLexSmallestString(s, a, b));
    }
}
