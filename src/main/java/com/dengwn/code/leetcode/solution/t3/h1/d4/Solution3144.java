package com.dengwn.code.leetcode.solution.t3.h1.d4;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/8/28
 **/
public class Solution3144 {

    char[] arr;
    Map<Integer, Integer> memo = new HashMap<>();
    public int minimumSubstringsInPartition(String s) {
        int n = s.length();
        arr = s.toCharArray();
        return dfs(n - 1);
    }

    public int dfs(int i) {
        if (i < 0) {
            return 0;
        }
        if (memo.containsKey(i)) {
            return memo.get(i);
        }
        int res = Integer.MAX_VALUE;
        Map<Character, Integer> map = new HashMap<>();
        int max = 0;
        for (int j = i; j >= 0; j--) {
            map.merge(arr[j], 1, Integer::sum);
            max = Math.max(max, map.get(arr[j]));
            if (max * map.size() == i - j + 1) {
                res = Math.min(res, dfs(j - 1) + 1);
            }
        }
        memo.put(i, res);
        return res;
    }

    public static void main(String[] args) {
        Solution3144 solution3144 = new Solution3144();
        System.out.println(solution3144.minimumSubstringsInPartition("xwjhpcyyyyrppppppppcccsqqqrrrssxxxfnnnhhjqnrsrnnnttt"));
    }
}
