package com.dengwn.leetcode.solution.t1.h3;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-05-24
 **/
public class Solution1377 {
    public double frogPosition(int n, int[][] edges, int t, int target) {
        List<Integer>[] lists = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            lists[i] = new ArrayList<>();
        }
        // 学灵神的加一个虚拟节点进去，减少后面的特判
        lists[1].add(0);
        // 建树
        for (int[] edge : edges) {
            lists[edge[0]].add(edge[1]);
            lists[edge[1]].add(edge[0]);
        }

        int step = 0;
        double[] ans = new double[n + 1];
        ans[1] = 1.0;
        // 这里泛型也可以用双列集合
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        boolean[] vis = new boolean[n + 1];
        vis[1] = true;
        while (step < t && !queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Integer cur = queue.poll();
                List<Integer> next = lists[cur];
                int size = next.size();
                for (Integer ni : next) {
                    if (!vis[ni]) {
                        ans[ni] = ans[cur] / (size - 1);
                        queue.add(ni);
                        vis[ni] = true;
                    }
                }
                // 大于1说明能往下走，当前节点的置为0
                if (size > 1) {
                    ans[cur] = 0.0;
                }
            }
            step++;
        }
        return ans[target];
    }

    public static void main(String[] args) {
        Solution1377 solution1377 = new Solution1377();
        int n = 7;
        int[][] edges = {{1, 2}, {1, 3}, {1, 7}, {2, 4}, {2, 6}, {3, 5}};
        int t = 20;
        int target = 6;
        System.out.println(solution1377.frogPosition(n, edges, t, target));
    }

}
