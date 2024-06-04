package com.dengwn.leetcode.solution;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/6/4
 **/
public class Solution3067 {
    public int[] countPairsOfConnectableServers(int[][] edges, int signalSpeed) {
        int n = edges.length + 1;
        List<int[]>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            lists[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            lists[edge[0]].add(new int[]{edge[1], edge[2]});
            lists[edge[1]].add(new int[]{edge[0], edge[2]});
        }

        int[] ans = new int[n];
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int[] pair : lists[i]) {
                int cnt = dfs(lists, pair[0], i, pair[1], signalSpeed);
                ans[i] += cnt * sum;
                sum += cnt;
            }
        }
        return ans;
    }

    public int dfs(List<int[]>[] lists, int x, int pre, int dis, int signalSpeed) {
        int cnt = dis % signalSpeed == 0 ? 1 : 0;
        for (int[] pair : lists[x]) {
            int next = pair[0];
            if (next != pre) {
                cnt += dfs(lists, next, x, dis + pair[1], signalSpeed);
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] edges = {{0, 1, 1}, {1, 2, 5}, {2, 3, 13}, {3, 4, 9}, {4, 5, 2}};
        int signalSpeed = 1;
        Solution3067 solution3067 = new Solution3067();
        System.out.println(Arrays.toString(solution3067.countPairsOfConnectableServers(edges, signalSpeed)));

    }
}
