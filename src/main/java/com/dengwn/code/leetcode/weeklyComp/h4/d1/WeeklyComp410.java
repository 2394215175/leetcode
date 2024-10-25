package com.dengwn.code.leetcode.weeklyComp.h4.d1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/8/12
 **/
public class WeeklyComp410 {

    public int finalPositionOfSnake(int n, List<String> commands) {
        int s = 0;
        for (String command : commands) {
            switch (command) {
                case "up":
                    s -= n;
                    break;
                case "down":
                    s += n;
                    break;
                case "left":
                    s -= 1;
                    break;
                case "right":
                    s += 1;
                    break;
            }
        }
        return s;
    }

    int ans = 0;

    public int countGoodNodes(int[][] edges) {
        int n = edges.length;
        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        dfs(0, -1, graph);
        return ans;
    }

    public int dfs(int cur, int pre, List<Integer>[] graph) {
        int cnt = 1;
        boolean isOk = true;
        int childCnt = 0;
        for (Integer next : graph[cur]) {
            if (next == pre) {
                continue;
            }
            int dfs = dfs(next, cur, graph);
            if (childCnt == 0) {
                childCnt = dfs;
            } else if (childCnt != dfs) {
                isOk = false;
            }
            cnt += dfs;
        }
        if (isOk) {
            ans++;
        }
        return cnt;
    }


    public static void main(String[] args) {
        WeeklyComp410 wc = new WeeklyComp410();
        int[][] edges = {{0, 1}, {1, 2}, {2, 3}, {3, 4}, {0, 5}, {1, 6}, {2, 7}, {3, 8}};
        System.out.println(wc.countGoodNodes(edges));
    }

}
