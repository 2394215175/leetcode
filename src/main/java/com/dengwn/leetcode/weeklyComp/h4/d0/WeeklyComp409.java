package com.dengwn.leetcode.weeklyComp.h4.d0;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/8/4
 **/
public class WeeklyComp409 {

    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        // 存储结果的列表
        int m = queries.length;
        int[] answer = new int[m];

        // 初始化邻接表
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // 初始状态下的道路 i -> i+1
        for (int i = 0; i < n - 1; i++) {
            adj.get(i).add(i + 1);
        }

        // 处理每个查询
        for (int i = 0; i < m; i++) {
            int[] query = queries[i];
            int u = query[0];
            int v = query[1];
            adj.get(u).add(v);  // 添加新道路 u -> v

            // 使用 BFS 计算从 0 到 n-1 的最短路径
            int shortestDistance = bfs(adj, n);
            answer[i] = shortestDistance;
        }
        return answer;
    }

    private int bfs(List<List<Integer>> adj, int n) {
        Queue<Integer> queue = new LinkedList<>();
        boolean[] visited = new boolean[n];
        int[] distance = new int[n];

        Arrays.fill(distance, Integer.MAX_VALUE);

        // 开始从城市 0
        queue.add(0);
        visited[0] = true;
        distance[0] = 0;

        while (!queue.isEmpty()) {
            int city = queue.poll();

            for (int neighbor : adj.get(city)) {
                if (!visited[neighbor]) {
                    if (distance[city] + 1 < distance[neighbor]) {
                        distance[neighbor] = distance[city] + 1;
                        queue.add(neighbor);
                        visited[neighbor] = true;
                    }
                }
            }
        }

        // 返回从 0 到 n-1 的最短路径长度
        return distance[n - 1];
    }


    public int[] shortestPathLength(int n, int[][] queries) {
        int[] nxt = new int[n - 1];
        for (int i = 0; i < n - 1; i++) {
            nxt[i] = i + 1;
        }

        int[] ans = new int[queries.length];
        int cnt = n - 1;
        for (int qi = 0; qi < queries.length; qi++) {
            int l = queries[qi][0];
            int r = queries[qi][1];
            if (nxt[l] > 0 && nxt[l] < r) {
                for (int i = nxt[l]; i < r; ) {
                    cnt--;
                    int tmp = nxt[i];
                    nxt[i] = 0;
                    i = tmp;
                }
                nxt[l] = r;
            }
            ans[qi] = cnt;
        }
        return ans;
    }


    public static void main(String[] args) {
        WeeklyComp409 weeklyComp409 = new WeeklyComp409();

        int n = 5;
        int[][] queries = {{2, 4}, {0, 2}, {0, 4}};

        int[] result = weeklyComp409.shortestPathLength(n, queries);
        System.out.println(Arrays.toString(result));  // 输出: [3, 3, 2]


//        int[][] grid = {{0,1,2},{3,4,5},{6,7,8}};
//
//        neighborSum neighborSum = new neighborSum(grid);
//        System.out.println(neighborSum.adjacentSum(1));
//        System.out.println(neighborSum.adjacentSum(4));
//        System.out.println(neighborSum.diagonalSum(4));
//        System.out.println(neighborSum.diagonalSum(8));
    }
}

class neighborSum {

    int[][] g;
    int n;

    public neighborSum(int[][] grid) {
        this.g = grid;
        this.n = grid.length;
    }

    int[][] adjacent = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int adjacentSum(int value) {
        int[] ints = find(value);
        return calc(ints[0], ints[1], adjacent);
    }

    int[][] diagonal = {{-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public int diagonalSum(int value) {
        int[] ints = find(value);
        return calc(ints[0], ints[1], diagonal);
    }

    public int[] find(int value) {
        int x = -1;
        int y = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (value == g[i][j]) {
                    x = i;
                    y = j;
                }
            }
        }
        return new int[]{x, y};
    }

    public int calc(int x, int y, int[][] dis) {
        int ans = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dis[i][0];
            int ny = y + dis[i][1];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n) {
                ans += g[nx][ny];
            }
        }
        return ans;
    }
}
