package com.dengwn.code.leetcode.solution.t0.h5.d4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-02-03
 **/
public class Solution547 {
    int[] parent;

    public int findCircleNum(int[][] isConnected) {
        int n = isConnected.length;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    union(i, j);
                }
            }
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(find(parent[i]));
        }
        return set.size();
    }

    public int find(int i) {
        if (parent[i] != i) {
            parent[i] = find(parent[i]);
        }
        return parent[i];
    }

    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            parent[rootY] = rootX;
        }
    }

    public static void main(String[] args) {
        int[][] isConnected = {{1, 1, 1, 0, 1, 1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 0, 1, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 1, 0, 0, 0, 1, 0},
                {1, 0, 0, 1, 1, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 0, 1, 0, 1, 0},
                {0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {0, 0, 0, 1, 0, 0, 1, 0, 1, 1},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1}};
        Solution547 solution547 = new Solution547();
        System.out.println(solution547.findCircleNum(isConnected));
    }


}
