package com.dengwn.leetcode.solution.t0.h7;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-06
 **/
public class Solution797 {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        dfs(graph, 0, graph.length - 1, list, ans);
        return ans;
    }

    public void dfs(int[][] graph, int index, int n, List<Integer> list, List<List<Integer>> ans) {
        if (index == n) {
            ans.add(new ArrayList<>(list));
            return;
        }

        int[] ints = graph[index];
        for (int i : ints) {
            list.add(i);
            dfs(graph, i, n, list, ans);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution797 solution797 = new Solution797();
        int[][] graph = {{4, 3, 1}, {3, 2, 4}, {3}, {4}, {}};
        System.out.println(solution797.allPathsSourceTarget(graph));
    }
}
