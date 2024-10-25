package com.dengwn.code.leetcode.solution.t0.h8.d1;

import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author dengwenning
 * @since 2024/9/19
 **/
public class Solution815 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        int n = routes.length;
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int r : routes[i]) {
                graph.computeIfAbsent(r, k -> new ArrayList<>()).add(i);
            }
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.add(source);
        int steps = 0;
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                int cur = queue.poll();
                if (cur == target) {
                    return steps;
                }
                List<Integer> nextBus = graph.get(cur);
                if (!graph.containsKey(cur)) {
                    continue;
                }
                for (Integer bus : nextBus) {
                    if (routes[bus] == null) {
                        continue;
                    }
                    for (int nx : routes[bus]) {
                        queue.add(nx);
                    }
                    routes[bus] = null;
                }
            }
            steps++;
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution815 solution815 = new Solution815();
        int[][] routes = {{1, 2, 7}, {3, 6, 7}};

        System.out.println(solution815.numBusesToDestination(routes, 8, 6));
    }
}
