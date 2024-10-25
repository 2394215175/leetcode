package com.dengwn.code.leetcode.solution.t0.h8.d7;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/10/10
 **/
public class Solution871 {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        int n = stations.length;
        Arrays.sort(stations, Comparator.comparingInt(a -> a[0]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o2 - o1);
        int ans = 0;
        for (int i = 0; i <= n; i++) {
            int pos = i == n ? target : stations[i][0];
            while (!pq.isEmpty() && startFuel < pos) {
                startFuel += pq.poll();
                ans++;
            }
            if (startFuel < pos) {
                return -1;
            }
            pq.add(i == n ? 0 : stations[i][1]);
        }
        return ans;
    }
}
