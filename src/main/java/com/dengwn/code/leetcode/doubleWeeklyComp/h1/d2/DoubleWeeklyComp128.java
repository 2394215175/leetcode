package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d2;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-04-13
 **/
public class DoubleWeeklyComp128 {

    public int scoreOfString(String s) {
        int n = s.length();
        char[] chars = s.toCharArray();
        int ans = 0;
        for (int i = 0; i < n - 1; i++) {
            ans += Math.abs(chars[i] - chars[i + 1]);
        }
        return ans;
    }

    public int minRectanglesToCoverPoints(int[][] points, int w) {
        int n = points.length;
        int[] x = new int[n];
        for (int i = 0; i < n; i++) {
            x[i] = points[i][0];
        }
        Arrays.sort(x);
        int ans = 1;
        int start = x[0];
        for (int i = 0; i < n; i++) {
            int next = start + w;
            if (x[i] > next) {
                ans++;
                start = x[i];
            }
        }
        return ans;
    }

    public int[] minimumTime(int n, int[][] edges, int[] disappear) {
        int INF = Integer.MAX_VALUE / 2;
        List<int[]>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int w = edge[2];
            graph[u].add(new int[]{v, w});
            graph[v].add(new int[]{u, w});
        }

        for (List<int[]> ints : graph) {
            ints.sort(Comparator.comparingInt(a -> a[1]));
        }

        int[] ans = new int[n];
        Arrays.fill(ans, INF);
        ans[0] = 0;
        TreeSet<Integer> queue = new TreeSet<>(Comparator.comparingInt(o -> ans[o]));
        queue.add(0);
        while (!queue.isEmpty()) {
            int u = queue.pollFirst();
            for (int[] edge : graph[u]) {
                int v = edge[0];
                int w = edge[1];
                if (ans[u] + w < ans[v] && ans[u] + w < disappear[v]) {
                    ans[v] = ans[u] + w;
                    queue.add(v);
                }
            }
        }

        for (int i = 1; i < n; i++) {
            ans[i] = ans[i] >= disappear[i] ? -1 : ans[i];
        }

        return ans;
    }

    public long numberOfSubarrays(int[] nums) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        queue.add(new int[]{Integer.MAX_VALUE, 1});
        long ans = nums.length;
        for (int num : nums) {
            while (num > queue.peek()[0]) {
                queue.poll();
            }
            if (num == queue.peek()[0]) {
                ans += queue.peek()[1];
                queue.peek()[1]++;
            } else {
                queue.add(new int[]{num, 1});
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp128 doubleWeeklyComp128 = new DoubleWeeklyComp128();

//        System.out.println(doubleWeeklyComp128.scoreOfString("zaz"));
// [[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]]
//        System.out.println(doubleWeeklyComp128.minRectanglesToCoverPoints(new int[][]{{2,3}, {1,2}}, 0));

//        System.out.println(Arrays.toString(doubleWeeklyComp128.minimumTime(8, new int[][]{{4, 4, 1}, {7, 4, 1}, {5, 0, 5}, {1, 7, 8}, {2, 5, 2}, {5, 5, 7}, {7, 0, 8}, {4, 0, 2}}, new int[]{3, 19, 1, 1, 17, 5, 1, 11})));

        System.out.println(doubleWeeklyComp128.numberOfSubarrays(new int[]{30, 15, 30}));
    }
}
