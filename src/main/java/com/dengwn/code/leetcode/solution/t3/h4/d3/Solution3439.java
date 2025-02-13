package com.dengwn.code.leetcode.solution.t3.h4.d3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2025/2/8
 **/
public class Solution3439 {
    public int maxFreeTime(int eventTime, int k, int[] startTime, int[] endTime) {
        List<Integer> list = new ArrayList<>();
        int n = startTime.length;
        int prev = 0;
        for (int i = 0; i < n; i++) {
            list.add(startTime[i] - prev);
            prev = endTime[i];

        }
        list.add(eventTime - prev);
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < list.size(); i++) {
            temp += list.get(i);
            ans = Math.max(ans, temp);
            if (i >= k) {
                temp -= list.get(i - k);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution3439 solution3439 = new Solution3439();
        int eventTime = 21, k = 1;
        int[] startTime = {7, 10, 16}, endTime = {10, 14, 18};
        System.out.println(solution3439.maxFreeTime(eventTime, k, startTime, endTime));
    }
}
