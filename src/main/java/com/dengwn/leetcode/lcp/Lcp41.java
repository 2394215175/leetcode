package com.dengwn.leetcode.lcp;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2023-06-21
 **/
public class Lcp41 {
    int[][] d = {{-1, -1}, {-1, 0}, {-1, 1}, {0, 1}, {0, -1}, {1, -1}, {1, 0}, {1, 1}};

    public int flipChess(String[] chessboard) {
        int n = chessboard.length;
        int m = chessboard[0].length();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = chessboard[i].toCharArray();
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ans = Math.max(ans, bfs(chars, i, j));
            }
        }
        return ans;
    }

    public int bfs(char[][] board, int i, int j) {
        if (board[i][j] != '.') {
            return 0;
        }
        int n = board.length;
        int m = board[0].length;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        vis[i][j] = true;
        queue.add(new int[]{i, j});
        int ans = 0;
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int k = 0; k < 8; k++) {
                // 8个方向看是否有白棋且以黑棋结尾
                int x = cur[0];
                int y = cur[1];
                int dx = d[k][0];
                int dy = d[k][1];
                // 是否以黑棋结尾
                boolean canLoad = false;
                int size = 0;
                while (x + dx >= 0 && x + dx < n && y + dy >= 0 && y + dy < m) {
                    if (vis[x + dx][y + dy] || board[x + dx][y + dy] == '.') {
                        break;
                    }
                    if (board[x + dx][y + dy] == 'X') {
                        canLoad = true;
                        break;
                    }
                    if (board[x + dx][y + dy] == 'O') {
                        x = x + dx;
                        y = y + dy;
                        size++;
                    }
                }

                if (canLoad) {
                    for (int l = 0; l < size; l++) {
                        queue.offer(new int[]{x, y});
                        vis[x][y] = true;
                        x = x - dx;
                        y = y - dy;
                    }
                    ans += size;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String[] chessboard = {".O.....", ".O.....", "XOO.OOX", ".OO.OO.", ".XO.OX.", "..X.X.."};

        char[][] chars = new char[chessboard.length][chessboard[0].length()];

        for (int i = 0; i < chessboard.length; i++) {
            chars[i] = chessboard[i].toCharArray();
        }
        for (char[] aChar : chars) {
            for (int j = 0; j < chars[0].length; j++) {
                System.out.print(aChar[j]);
            }
            System.out.println();
        }

        Lcp41 lcp41 = new Lcp41();
        System.out.println(lcp41.bfs(chars, 2, 3));
//        lcp41.flipChess(chessboard);


    }
}
