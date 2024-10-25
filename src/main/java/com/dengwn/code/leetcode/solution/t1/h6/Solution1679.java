package com.dengwn.code.leetcode.solution.t1.h6;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author dengwn
 * @date: 2022-12-14
 */
public class Solution1679 {
    public boolean[] distanceLimitedPathsExist(int n, int[][] edgeList, int[][] queries) {
        Arrays.sort(edgeList, Comparator.comparingInt(a -> a[2]));

        Integer[] index = new Integer[queries.length];
        for (int i = 0; i < queries.length; i++) {
            index[i] = i;
        }
        Arrays.sort(index, Comparator.comparingInt(a -> queries[a][2]));

        int[] uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        boolean[] res = new boolean[queries.length];
        int k = 0;
        for (int i : index) {
            while (k < edgeList.length && edgeList[k][2] < queries[i][2]) {
                merge(uf, edgeList[k][0], edgeList[k][1]);
                k++;
            }
            res[i] = find(uf, queries[i][0]) == find(uf, queries[i][1]);
        }
        return res;
    }

    public int find(int[] uf, int x) {
        if (uf[x] == x) {
            return x;
        }
        return uf[x] = find(uf, uf[x]);
    }

    public void merge(int[] uf, int x, int y) {
        x = find(uf, x);
        y = find(uf, y);
        uf[y] = x;
    }

    public static void main(String[] args) {
        int n = 3;
        int[][] edgeList = {{0, 1, 2}, {1, 2, 4}, {1, 0, 16}, {2, 0, 8}};
        int[][] queries = {{0, 1, 2}, {0, 2, 5}};
        Solution1679 solution1679 = new Solution1679();
        System.out.println(solution1679.distanceLimitedPathsExist(n, edgeList, queries));
    }
}
