package com.dengwn.code.leetcode.solution.t1.h7.d0;

import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution1705 {
    public int eatenApples(int[] apples, int[] days) {
        int n = days.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[0] - o2[0]);
        int ans = 0;

        for (int i = 0; i < n || !pq.isEmpty(); i++) {
            if (i < n) {
                pq.add(new int[]{i + days[i], apples[i]});
            }
            while (!pq.isEmpty() && (pq.peek()[0] <= i || pq.peek()[1] == 0)) {
                pq.poll();
            }
            if (!pq.isEmpty() && pq.peek()[1] > 0) {
                ans++;
                pq.peek()[1]--;
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution1705 solution1705 = new Solution1705();
        int[] apples = {2, 1, 1, 4, 5};
        int[] days = {10, 10, 6, 4, 2};
        System.out.println(solution1705.eatenApples(apples, days));
    }
}
