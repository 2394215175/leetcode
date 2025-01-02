package com.dengwn.code.leetcode.solution.t1.h8.d4;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeSet;

/**
 *
 * @author dengwenning
 * @since 2024/12/16
 **/
public class Solution1847 {
    public int[] closestRoom(int[][] rooms, int[][] queries) {
        Arrays.sort(rooms, Comparator.comparingInt(o -> o[1]));
        int k = queries.length;
        int[] ans = new int[k];
        Arrays.fill(ans, -1);
        int[][] queryIndex = new int[k][2];
        for (int i = 0; i < k; i++) {
            queryIndex[i][0] = i;
            queryIndex[i][1] = queries[i][1];
        }
        Arrays.sort(queryIndex, Comparator.comparingInt(o -> o[1]));
        TreeSet<Integer> roomIds = new TreeSet<>();
        int j = rooms.length - 1;
        for (int i = k - 1; i >= 0; i--) {
            int queryI = queryIndex[i][0];
            int minSize = queryIndex[i][1];
            while (j >= 0 && rooms[j][1] >= minSize) {
                roomIds.add(rooms[j][0]);
                j--;
            }
            int preferred = queries[queryI][0];
            int diff = Integer.MAX_VALUE;
            Integer floor = roomIds.floor(preferred);
            Integer ceiling = roomIds.ceiling(preferred);
            if (floor != null) {
                ans[queryI] = floor;
                diff = preferred - floor;
            }
            if (ceiling != null && ceiling - preferred < diff) {
                ans[queryI] = ceiling;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[][] rooms = {{23, 22}, {6, 20}, {15, 6}, {22, 19}, {2, 10}, {21, 4}, {10, 18}, {16, 1}, {12, 7}, {5, 22}};
        int[][] queries = {{12, 5}, {15, 15}, {21, 6}, {15, 1}, {23, 4}, {15, 11}, {1, 24}, {3, 19}, {25, 8}, {18, 6}};
        Solution1847 solution1847 = new Solution1847();
        System.out.println(Arrays.toString(solution1847.closestRoom(rooms, queries)));
    }
}
