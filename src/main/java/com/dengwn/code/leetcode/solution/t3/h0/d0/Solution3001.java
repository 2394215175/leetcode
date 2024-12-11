package com.dengwn.code.leetcode.solution.t3.h0.d0;

/**
 *
 * @author dengwenning
 * @since 2024/12/5
 **/
public class Solution3001 {
    public int minMovesToCaptureTheQueen(int a, int b, int c, int d, int e, int f) {
        int[][] dirs = {{1, 1}, {-1, 1}, {-1, -1}, {1, -1}};
        for (int[] dir : dirs) {
            if (isValid(c, d, a, b, e, f, dir[0], dir[1])) {
                return 1;
            }
        }
        int[][] dirs2 = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        for (int[] dir : dirs2) {
            if (isValid(a, b, c, d, e, f, dir[0], dir[1])) {
                return 1;
            }
        }
        return 2;
    }

    public boolean isValid(int sx, int sy, int ex, int ey, int tx, int ty, int nx, int ny) {
        int size = 8;
        while (sx > 0 && sx <= size && sy > 0 && sy <= size) {
            if (sx == ex && sy == ey) {
                break;
            }
            sx += nx;
            sy += ny;
            if (sx == tx && sy == ty) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution3001 solution3001 = new Solution3001();
        System.out.println(solution3001.minMovesToCaptureTheQueen(5, 8, 8, 8, 1, 8));
    }
}
