package com.dengwn.leetcode.solution.t0.h7;

import javafx.util.Pair;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2024-03-26
 **/
public class Solution773 {

    int[][] neighbors = {{1, 3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};

    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        int n = board.length;
        int m = board[0].length;

        StringBuilder sb = new StringBuilder();
        int curIndex = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(board[i][j]);
                if (board[i][j] == 0) {
                    curIndex = i * m + j;
                }
            }
        }

        int step = 0;
        Queue<Pair<String, Integer>> queue = new LinkedList<>();
        Pair<String, Integer> start = new Pair<>(sb.toString(), curIndex);
        queue.add(start);
        Set<String> visited = new HashSet<>();
        visited.add(sb.toString());
        while (!queue.isEmpty()) {
            int k = queue.size();
            for (int i = k; i > 0; i--) {
                Pair<String, Integer> cur = queue.poll();
                String key = cur.getKey();
                if (target.equals(cur.getKey())) {
                    return step;
                }

                Integer oldIndex = cur.getValue();
                int[] neighbor = neighbors[oldIndex];
                for (int newIndex : neighbor) {
                    String next = change(key, oldIndex, newIndex);
                    if (!visited.contains(next)) {
                        queue.offer(new Pair<>(next, newIndex));
                        visited.add(next);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    public String change(String s, int oldIndex, int newIndex) {
        char[] array = s.toCharArray();
        char temp = array[oldIndex];
        array[oldIndex] = array[newIndex];
        array[newIndex] = temp;
        return new String(array);
    }

    public static void main(String[] args) {
        Solution773 solution773 = new Solution773();
        int[][] board = {{3, 2, 4}, {1, 5, 0}};
        System.out.println(solution773.slidingPuzzle(board));
    }
}
