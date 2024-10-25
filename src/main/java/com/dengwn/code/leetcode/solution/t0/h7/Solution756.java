package com.dengwn.code.leetcode.solution.t0.h7;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-03-27
 **/
public class Solution756 {
    HashMap<String, List<String>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        for (String str : allowed) {
            String key = str.substring(0, 2);
            List<String> list = map.getOrDefault(key, new ArrayList<>());
            list.add(str.substring(2, 3));
            map.put(key, list);
        }

        return dfs(bottom, "");
    }

    public boolean dfs(String pre, String cur) {
        // 最后一层
        if (pre.length() == 1) {
            return true;
        }

        // 到尾部了，进行下一层，开始时cur为空
        if (cur.length() + 1 == pre.length()) {
            return dfs(cur, "");
        }
        String key = pre.substring(cur.length(), cur.length() + 2);
        if (map.containsKey(key)) {
            for (String x : map.get(key)) {
                if (dfs(pre, cur + x)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String bottom = "AAAA";
        String[] allowed = {"AAB", "AAC", "BCD", "BBE", "DEF"};
        Solution756 solution756 = new Solution756();
        System.out.println(solution756.pyramidTransition(bottom, Arrays.asList(allowed)));
    }

}
