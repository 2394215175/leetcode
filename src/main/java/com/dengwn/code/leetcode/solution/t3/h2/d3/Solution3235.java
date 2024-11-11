package com.dengwn.code.leetcode.solution.t3.h2.d3;

/**
 *
 * @author dengwenning
 * @since 2024/11/8
 **/
public class Solution3235 {

    int X, Y;

    public boolean canReachCorner(int xCorner, int yCorner, int[][] circles) {
        boolean[] vis = new boolean[circles.length];
        int n = circles.length;
        X = xCorner;
        Y = yCorner;
        for (int i = 0; i < n; i++) {
            long ox = circles[i][0];
            long oy = circles[i][1];
            long r = circles[i][2];
            // 起点和终点在圆内的，直接结束
            if (isInCircle(ox, oy, r, 0, 0) || isInCircle(ox, oy, r, X, Y)) {
                return false;
            }
            if (!vis[i] && isLeftAndUp(ox, oy, r) && dfs(i, circles, vis)) {
                return false;
            }
        }
        return true;
    }

    public boolean isInCircle(long ox, long oy, long r, long x, long y) {
        return (x - ox) * (x - ox) + (y - oy) * (y - oy) <= r * r;
    }

    public boolean isInSquare(long ox1, long oy1, long ox2, long oy2, long r1, long r2) {
        return ox1 * r2 + ox2 * r1 < (r1 + r2) * X && oy1 * r2 + oy2 * r1 < (r1 + r2) * Y;
    }

    public boolean isIntersect(long ox1, long oy1, long ox2, long oy2, long r1, long r2) {
        return (ox1 - ox2) * (ox1 - ox2) + (oy1 - oy2) * (oy1 - oy2) <= (r1 + r2) * (r1 + r2);
    }

    public boolean dfs(int i, int[][] circles, boolean[] visited) {
        long ox1 = circles[i][0];
        long oy1 = circles[i][1];
        long r1 = circles[i][2];
        if (isRightAndDown(ox1, oy1, r1)) {
            return true;
        }
        visited[i] = true;
        for (int j = 0; j < circles.length; j++) {
            long ox2 = circles[j][0];
            long oy2 = circles[j][1];
            long r2 = circles[j][2];
            if (!visited[j] &&
                    isIntersect(ox1, oy1, ox2, oy2, r1, r2) &&
                    isInSquare(ox1, oy1, ox2, oy2, r1, r2) &&
                    dfs(j, circles, visited)) {
                return true;
            }
        }
        return false;
    }

    public boolean isLeftAndUp(long x, long y, long r) {
        return (x <= X && Math.abs(y - Y) <= r) ||
                (y <= Y && x <= r) ||
                (y > Y && isInCircle(x, y, r, 0, Y));
    }

    public boolean isRightAndDown(long x, long y, long r) {
        return (y <= Y && Math.abs(x - X) <= r) ||
                (x <= X && y <= r) ||
                (x > X && isInCircle(x, y, r, X, 0));
    }

    public static void main(String[] args) {
        Solution3235 solution3235 = new Solution3235();
        System.out.println(solution3235.canReachCorner(5, 8, new int[][]{{4, 7, 1}}));

    }

}
