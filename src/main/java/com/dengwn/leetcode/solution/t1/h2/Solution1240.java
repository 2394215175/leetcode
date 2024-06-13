package com.dengwn.leetcode.solution.t1.h2;

import java.util.TreeMap;

/**
 * @author: dengwn
 * @date: 2023-06-08
 **/
public class Solution1240 {
    int ans = 0;

    public int tilingRectangle(int n, int m) {
        ans = n * m;
        boolean[][] vis = new boolean[n][m];
        // 从(0,0)开始
        dfs(0, 0, vis, 0);
        return ans;
    }


    public void dfs(int x, int y, boolean[][] vis, int cnt) {
        // 如果结果大于ans，剪枝
        if (cnt > ans) {
            return;
        }
        int n = vis.length;
        int m = vis[0].length;

        if (x >= n) {
            ans = cnt;
            return;
        }
        /* 检测下一行 */
        if (y >= m) {
            dfs(x + 1, 0, vis, cnt);
            return;
        }
        /* 如当前已经被覆盖，则直接尝试下一个位置 */
        if (vis[x][y]) {
            dfs(x, y + 1, vis, cnt);
            return;
        }

        for (int i = Math.min(n - x, m - y); i > 0; i--) {
            // 如果能填
            if (isAvailable(vis, x, y, i)) {
                fillUp(vis, x, y, i, true);
                dfs(x, y + i, vis, cnt + 1);
                fillUp(vis, x, y, i, false);
            }
        }
    }

    public boolean isAvailable(boolean[][] rect, int x, int y, int k) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                if (rect[x + i][y + j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public void fillUp(boolean[][] rect, int x, int y, int k, boolean val) {
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < k; j++) {
                rect[x + i][y + j] = val;
            }
        }
    }

    public static void main(String[] args) {
        Solution1240 solution1240 = new Solution1240();
        System.out.println(solution1240.tilingRectangle(11, 13));

        TreeMap<String, Integer> treeMap = new TreeMap<>(String::compareTo);
        treeMap.put("111", 0);
        treeMap.put(null, 0);
        System.out.println(treeMap);

    }
}
