package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-03-02
 **/
public class Solution1817 {
    public int[] findingUsersActiveMinutes(int[][] logs, int k) {
        int[] ans = new int[k];
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] log : logs) {
            map.merge(log[0], new HashSet<Integer>() {{
                add(log[1]);
            }}, (oldValue, newValue) -> {
                oldValue.addAll(newValue);
                return oldValue;
            });
        }

//        for (int[] log : logs) {
//            int id = log[0], time = log[1];
//            map.putIfAbsent(id, new HashSet<Integer>());
//            map.get(id).add(time);
//        }

        for (Map.Entry<Integer, Set<Integer>> entry : map.entrySet()) {
            ans[entry.getValue().size() - 1]++;
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1817 solution1817 = new Solution1817();
        int[][] logs = {{0, 5}, {1, 2}, {0, 2}, {0, 5}, {1, 3}};
        int k = 5;
        System.out.println(Arrays.toString(solution1817.findingUsersActiveMinutes(logs, k)));
    }
}
