package com.dengwn.leetcode.solution.t1.h1.d2;

import javafx.util.Pair;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-02
 **/
public class Solution1129 {
    public int[] shortestAlternatingPaths(int n, int[][] redEdges, int[][] blueEdges) {
        int[] ans = new int[n];
        Arrays.fill(ans, -1);
        ans[0] = 0;
        int step = 0;
        List<Integer>[][] edge = new List[2][n];
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < n; j++) {
                edge[i][j] = new ArrayList<>();
            }
        }

        for (int[] redEdge : redEdges) {
            edge[0][redEdge[0]].add(redEdge[1]);
        }
        for (int[] blueEdge : blueEdges) {
            edge[1][blueEdge[0]].add(blueEdge[1]);
        }

        Queue<Pair<Integer, Integer>> queue = new LinkedList<>();
        queue.add(new Pair<>(0, 0));
        queue.add(new Pair<>(0, 1));
        boolean[][] visited = new boolean[n][2];

        while (!queue.isEmpty()) {
            step++;
            for (int k = queue.size(); k > 0; --k) {
                Pair<Integer, Integer> cur = queue.poll();
                Integer preIndex = cur.getKey();
                Integer color = cur.getValue();

                int newColor = color ^ 1;
                List<Integer> nextIndexes = edge[newColor][preIndex];
                for (Integer nextIndex : nextIndexes) {
                    if (!visited[nextIndex][newColor]) {
                        if (ans[nextIndex] == -1) {
                            ans[nextIndex] = step;
                        }
                        queue.offer(new Pair<>(nextIndex, newColor));
                    }
                }
                visited[preIndex][color] = true;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        int n = 6;
        int[][] redEdges = {{2, 3}, {0, 5}, {3, 1}, {5, 0}, {3, 0}, {0, 0}};
        int[][] blueEdges = {{1, 2}, {3, 2}, {1, 0}, {2, 2}, {5, 2}};

        Solution1129 solution1129 = new Solution1129();
        System.out.println(Arrays.toString(solution1129.shortestAlternatingPaths(n, redEdges, blueEdges)));
    }

}
