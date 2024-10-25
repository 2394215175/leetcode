package com.dengwn.code.leetcode.solution.t1.h4;

/**
 * @author dengwenning
 * @since 2024/4/30
 **/
public class Solution1482 {

    public static void main(String[] args) {
        Solution1482 solution1482 = new Solution1482();
        int[] bloomDay = {1,10,3,10,2};
        System.out.println(solution1482.minDays(bloomDay, 3, 2));
    }


    public int minDays(int[] bloomDay, int m, int k) {
        if (bloomDay.length / k < m){
            return -1;
        }
        int left = 0;
        int right = 0;
        for (int i : bloomDay) {
            if (i > right) {
                right = i;
            }
        }

        while (left < right) {
            int mid = (left + right) >> 1;
            if (!check(bloomDay, mid, m, k)) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;

    }

    private boolean check(int[] bloomDay, int day, int m, int k) {
        int times = 0;
        int cnt = 0;
        for (int j : bloomDay) {
            if (j <= day) {
                times++;
                if (times == k) {
                    cnt++;
                    times = 0;
                }
            } else {
                times = 0;
            }
        }
        return cnt >= m;
    }


}
