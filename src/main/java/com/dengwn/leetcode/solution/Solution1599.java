package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2023-03-05
 */
public class Solution1599 {
    public int minOperationsMaxProfit(int[] customers, int boardingCost, int runningCost) {
        int waiter = 0;
        int preTheory = 0;
        int theory = 0;
        int step = 0;
        int ans = 0;
        for (int customer : customers) {
            int cur = waiter + customer;
            if (cur > 4) {
                theory += 4 * boardingCost - runningCost;
                waiter = cur - 4;
            } else {
                theory += cur * boardingCost - runningCost;
                waiter = 0;
            }
            step++;
            if (theory > preTheory) {
                ans = step;
            }
            preTheory = theory;
        }

        while (waiter > 0) {
            if (waiter > 4) {
                theory += 4 * boardingCost - runningCost;
                waiter -= 4;
            } else {
                theory += waiter * boardingCost - runningCost;
                waiter = 0;
            }
            step++;
            if (theory > preTheory) {
                ans = step;
            }
            preTheory = theory;
        }

        return theory > 0 ? ans : -1;
    }

    public static void main(String[] args) {
        Solution1599 solution1599 = new Solution1599();
        int[] customers = {8, 3};
        int boardingCost = 5;
        int runningCost = 6;
        System.out.println(solution1599.minOperationsMaxProfit(customers, boardingCost, runningCost));
    }
}
