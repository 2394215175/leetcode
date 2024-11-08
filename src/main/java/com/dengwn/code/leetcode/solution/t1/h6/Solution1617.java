package com.dengwn.code.leetcode.solution.t1.h6;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-06-02
 **/
public class Solution1617 {
    private List<Integer>[] g;
    private int[][] dis;

    public int[] countSubgraphsForEachDiameter(int n, int[][] edges) {
        g = new ArrayList[n];
        Arrays.setAll(g, e -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0] - 1, y = e[1] - 1; // 编号改为从 0 开始
            g[x].add(y);
            g[y].add(x); // 建树
        }

        dis = new int[n][n];
        for (int i = 0; i < n; ++i){
            dfs(i, i, -1); // 计算 i 到其余点的距离
        }

        int[] ans = new int[n - 1];
        for (int i = 0; i < n; ++i){
            for (int j = i + 1; j < n; ++j){
                ans[dis[i][j] - 1] += dfs2(i, j, dis[i][j], i, -1);
            }
        }

        return ans;
    }

    private void dfs(int i, int x, int fa) {
        for (int y : g[x]){
            if (y != fa) {
                dis[i][y] = dis[i][x] + 1; // 自顶向下
                dfs(i, y, x);
            }
        }
    }

    private int dfs2(int i, int j, int d, int x, int fa) {
        // 能递归到这，说明 x 可以选
        int cnt = 1; // 选 x
        for (int y : g[x]){
            if (y != fa &&
                    (dis[i][y] < d || dis[i][y] == d && y > j) &&
                    (dis[j][y] < d || dis[j][y] == d && y > i)) {
                // 满足这些条件就可以选
                cnt *= dfs2(i, j, d, y, x); // 每棵子树互相独立，采用乘法原理
            }
        }

        if (dis[i][x] + dis[j][x] > d){
            // x 是可选点
            ++cnt; // 不选 x
        }
        return cnt;
    }

    public static void main(String[] args) {
        Solution1617 solution1617 = new Solution1617();
        int n = 4;
        int[][] edges = {{1, 2}, {2, 3}, {2, 4}};
        System.out.println(Arrays.toString(solution1617.countSubgraphsForEachDiameter(n, edges)));
    }
}
