package com.dengwn.code.leetcode.solution.t3.h4.d2;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2025/1/22
 **/
public class Solution3425 {

    int maxLen = -1;
    int minNodes = 0;
    List<int[]>[] graph;
    int[] nums;

    public int[] longestSpecialPath(int[][] edges, int[] nums) {
        int n = nums.length;
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(new int[]{edge[1], edge[2]});
        }
        this.graph = graph;
        this.nums = nums;
        List<Integer> dis = new ArrayList<>();
        dis.add(0);
        Map<Integer, Integer> lastDepth = new HashMap<>();
        dfs(0, 0, dis, lastDepth);
        return new int[]{maxLen, minNodes};
    }

    public void dfs(int i, int topDepth, List<Integer> dis, Map<Integer, Integer> lastDepth) {
        int color = nums[i];
        int oldDepth = lastDepth.getOrDefault(color, 0);
        topDepth = Math.max(topDepth, oldDepth);

        int disX = dis.get(dis.size() - 1);
        int len = disX - dis.get(topDepth);
        int nodes = dis.size() - topDepth;
        if (len > maxLen || len == maxLen && nodes < minNodes) {
            maxLen = len;
            minNodes = nodes;
        }
        lastDepth.put(color, dis.size());
        for (int[] nx : graph[i]) {
            int y = nx[0];
            dis.add(disX + nx[1]);
            dfs(y, topDepth, dis, lastDepth);
            // 恢复现场
            dis.remove(dis.size() - 1);
        }
        lastDepth.put(color, oldDepth);
    }

    public static void main(String[] args) {
        Solution3425 solution3425 = new Solution3425();
        int[][] edges = {{1,0,8}};
        int[] nums = {2,2};
        System.out.println(Arrays.toString(solution3425.longestSpecialPath(edges, nums)));
    }
}
