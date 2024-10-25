package com.dengwn.code.leetcode.solution.t1.h8.d7;

/**
 *
 * @author dengwenning
 * @since 2024/10/17
 **/
public class Solution1870 {
    public int minSpeedOnTime(int[] dist, double hour) {
        int left = -1;
        int right = (int) (1e7 + 1);
        while (left < right) {
            int mid = (left + right) / 2;
            if (!check(dist, hour, mid)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return right == (int) (1e7 + 1) ? -1 : right;
    }

    public boolean check(int[] dist, double hour, int speed) {
        double spent = 0;
        for (int d : dist) {
            spent += d * 1.0 / speed;
            if (spent > hour) {
                return false;
            }
            spent = Math.ceil(spent);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] dist = {1, 3, 2};
        double hour = 1.9;
        Solution1870 solution1870 = new Solution1870();
        System.out.println(solution1870.minSpeedOnTime(dist, hour));

    }
}
