package com.dengwn.code.leetcode.solution.t0.h8.d8;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2022-11-14
 **/
public class Solution882 {
    public int reachableNodes(int[][] edges, int maxMoves, int n) {
        Map<Integer, List<int[]>> g = new HashMap<>();
        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            List<int[]> list1 = g.getOrDefault(u, new ArrayList<>());
            list1.add(new int[]{v, cnt + 1});
            g.put(u, list1);

            List<int[]> list2 = g.getOrDefault(v, new ArrayList<>());
            list2.add(new int[]{u, cnt + 1});
            g.put(v, list2);
        }

        int[] dist = dijkstra(g, 0,n); // 从 0 出发的最短路

        int ans = 0;
        for (int d : dist) {
            if (d <= maxMoves) {
                ++ans;
                // 这个点可以在 maxMoves 步内到达
            }
        }

        for (int[] e : edges) {
            int u = e[0], v = e[1], cnt = e[2];
            int a = Math.max(maxMoves - dist[u], 0);
            int b = Math.max(maxMoves - dist[v], 0);
            ans += Math.min(a + b, cnt); // 这条边上可以到达的节点数
        }
        return ans;
    }


    // Dijkstra 算法模板
    // 返回从 start 到每个点的最短路
    private int[] dijkstra(Map<Integer, List<int[]>> g, int start, int n) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[start] = 0;
        Queue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.offer(new int[]{start, 0});
        while (!pq.isEmpty()) {
            int[] p = pq.poll();
            int x = p[0], d = p[1];
            if (g.get(x) == null || d > dist[x]) {
                continue;
            }
            for (int[] e : g.get(x)) {
                int y = e[0];
                int newDist = d + e[1];
                if (newDist < dist[y]) {
                    dist[y] = newDist;
                    pq.offer(new int[]{y, newDist});
                }
            }
        }
        return dist;
    }

    public static void main(String[] args) {
        int[][] edges = {{1, 2, 4}, {1, 4, 5}, {1, 3, 1}, {2, 3, 4}, {3, 4, 5}};
        int maxMoves = 17;
        int n = 5;


        Solution882 solution882 = new Solution882();
        System.out.println(solution882.reachableNodes(edges, maxMoves, n));
    }
}
