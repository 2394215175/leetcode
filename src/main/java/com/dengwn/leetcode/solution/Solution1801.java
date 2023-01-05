package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-01-02
 */
public class Solution1801 {
    int MOD = 1000000007;

    public int getNumberOfBacklogOrders(int[][] orders) {
        Queue<int[]> buys = new PriorityQueue<>((o1, o2) -> o2[0] - o1[0]);
        Queue<int[]> sells = new PriorityQueue<>(Comparator.comparingInt(o -> o[0]));
        for (int[] order : orders) {
            int price = order[0];
            int amount = order[1];
            int orderType = order[2];

            if (orderType == 0) {
                while (!sells.isEmpty() && sells.peek()[0] <= price && amount > 0) {
                    int[] min = sells.poll();
                    int sellAmount = Math.min(min[1], amount);
                    amount -= sellAmount;
                    min[1] -= sellAmount;
                    if (min[1] > 0) {
                        sells.offer(min);
                    }
                }
                if (amount > 0) {
                    buys.add(new int[]{price, amount});
                }
            } else {
                while (!buys.isEmpty() && buys.peek()[0] >= price && amount > 0) {
                    int[] max = buys.poll();
                    int buyAmount = Math.min(max[1], amount);
                    amount -= buyAmount;
                    max[1] -= buyAmount;
                    if (max[1] > 0) {
                        buys.offer(max);
                    }
                }
                if (amount > 0) {
                    sells.add(new int[]{price, amount});
                }
            }
        }

        int ans = 0;
        for (Queue<int[]> pq : Arrays.asList(buys, sells)) {
            while (!pq.isEmpty()) {
                int[] order = pq.poll();
                ans = (ans + order[1]) % MOD;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

//        {{7, 1000000000, 1}, {15, 3, 0}, {5, 999999995, 0}, {5, 1, 1}}
        int[][] orders = {{10, 5, 0}, {15, 2, 1}, {25, 1, 1}, {30, 4, 0}};
        Solution1801 solution1801 = new Solution1801();
        System.out.println(solution1801.getNumberOfBacklogOrders(orders));
    }
}
