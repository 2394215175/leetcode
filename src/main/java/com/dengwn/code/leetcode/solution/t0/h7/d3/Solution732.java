package com.dengwn.code.leetcode.solution.t0.h7.d3;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author dengwenning
 * @since 2025/1/4
 **/
public class Solution732 {
}

class MyCalendarThree {

    TreeMap<Integer, Integer> map;

    public MyCalendarThree() {
        map = new TreeMap<>();
    }

    public int book(int startTime, int endTime) {
        map.merge(startTime, 1, Integer::sum);
        map.merge(endTime, -1, Integer::sum);
        int cnt = 0;
        int ans = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
            ans = Math.max(cnt, ans);
        }

        return ans;
    }
}
