package com.dengwn.leetcode.solution.t2.h5;

/**
 * @author dengwenning
 * @since 2024/4/30
 **/
public class Solution2594 {
    public long repairCars(int[] ranks, int cars) {
        long left = 0;
        long right = (long)ranks[0] * cars * cars;
        while (left < right) {
            long mid = (left + right) >> 1;
            if (!check(ranks, mid, cars)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] ranks, long num, int cars) {
        int ans = 0;
        for (int rank : ranks) {
            long temp = num / rank;
            ans += (int) Math.sqrt(temp);
            if (ans >= cars) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution2594 solution2594 = new Solution2594();
        int[] ranks = {5, 1, 8};
        System.out.println(solution2594.repairCars(ranks, 6));
    }
}
