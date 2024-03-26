package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-03-26
 **/
public class Solution2642 {
}

class Graph {

    List<int[]>[] graph;

    public Graph(int n, int[][] edges) {
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            addEdge(edge);
        }
    }

    public void addEdge(int[] edge) {
        graph[edge[0]].add(new int[]{edge[1], edge[2]});
    }

    public int shortestPath(int node1, int node2) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(node1);
        int[] dist = new int[graph.length];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[node1] = 0;
        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int[] next : graph[node]) {
                int nextNode = next[0];
                int nextDist = dist[node] + next[1];
                if (nextDist < dist[nextNode]) {
                    dist[nextNode] = nextDist;
                    queue.offer(nextNode);
                }
            }
        }
        return dist[node2] == Integer.MAX_VALUE ? -1 : dist[node2];
    }
}
