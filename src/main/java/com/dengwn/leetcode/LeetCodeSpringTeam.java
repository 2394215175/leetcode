package com.dengwn.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author dengwn
 * @date: 2023-05-07
 */
public class LeetCodeSpringTeam {
    public int runeReserve(int[] runes) {
        int n = runes.length;
        Arrays.sort(runes);
        int[] dp = new int[n];
        int ans = 1;
        Arrays.fill(dp, 1);
        for (int i = 1; i < n; i++) {
            if (runes[i] - runes[i - 1] <= 1) {
                dp[i] = Math.max(dp[i], dp[i - 1] + 1);
                ans = Math.max(ans, dp[i]);
            }
        }
        return ans;
    }

    public int rampartDefensiveLine(int[][] rampart) {
        int ans = Integer.MAX_VALUE;
        int n = rampart.length;
        if (n == 3) {
            return rampart[2][0] - rampart[0][1] - (rampart[1][1] - rampart[1][0]);
        }

        for (int i = 0; i < n - 3; i++) {
            int first = rampart[i + 1][0] - rampart[i][1];
            int second = rampart[i + 2][0] - rampart[i + 1][1];
            int third = rampart[i + 3][0] - rampart[i + 2][1];
            if (first > second + third) {
                ans = Math.min(ans, second + third);
            } else {
                ans = Math.min(ans, (first + second + third) / 2);
            }
        }
        return ans;
    }

    public int extractMantra(String[] matrix, String mantra) {
        char[] targets = mantra.toCharArray();
        int n = matrix.length;
        int m = matrix[0].length();
        char[][] chars = new char[n][m];
        for (int i = 0; i < n; i++) {
            chars[i] = matrix[i].toCharArray();
        }
        int[] ints = djs(chars, 0, 0, targets[0]);
        if (ints == null) {
            return -1;
        }
        int ans = ints[2] + 1;
        for (int i = 1; i < targets.length; i++) {
            ints = djs(chars, ints[0], ints[1], targets[i]);
            if (ints == null) {
                return -1;
            }
            ans += ints[2] + 1;
        }
        return ans;
    }

    int[] dx = {-1, 1, 0, 0};
    int[] dy = {0, 0, -1, 1};

    public int[] djs(char[][] chars, int i, int j, char target) {
        int n = chars.length;
        int m = chars[0].length;
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{i, j});
        boolean[][] visited = new boolean[n][m];
        visited[i][j] = true;
        int step = 0;
        while (!queue.isEmpty()) {
            for (int k = queue.size(); k > 0; k--) {
                int[] cur = queue.poll();
                if (chars[cur[0]][cur[1]] == target) {
                    return new int[]{cur[0], cur[1], step};
                }
                for (int l = 0; l < 4; l++) {
                    int nx = cur[0] + dx[l];
                    int ny = cur[1] + dy[l];
                    if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny]) {
                        queue.add(new int[]{nx, ny});
                        visited[nx][ny] = true;
                    }
                }
            }
            step++;
        }
        return null;
    }


    public static void main(String[] args) {
        LeetCodeSpringTeam leetCodeSpringTeam = new LeetCodeSpringTeam();
//        int[][] rampart = {{0, 1}, {16, 20}, {21, 26}, {28, 33}, {36, 40}, {42, 44}, {45, 46}};
//        System.out.println(leetCodeSpringTeam.rampartDefensiveLine(rampart));

        String[] matrix = {"hydfpyqaoir", "ixpjveolliy", "hidhpqciygm", "icnefohovue", "qcwopbcbxbn", "dvahetjbfqg", "uiwjsukwofm", "spzjegbovxo", "aflruwmvkdp"};
        String mantra = "nrahvcpkmqgsyrcpmgfpmaxvydbp";
        System.out.println(leetCodeSpringTeam.extractMantra(matrix, mantra));
    }
}
