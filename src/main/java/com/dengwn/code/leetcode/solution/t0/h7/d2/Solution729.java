package com.dengwn.code.leetcode.solution.t0.h7.d2;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author dengwenning
 * @since 2025/1/3
 **/
public class Solution729 {

    public static void main(String[] args) {
        MyCalendar myCalendar = new MyCalendar();
        System.out.println(myCalendar.book(10, 20));
        System.out.println(myCalendar.book(15, 25));
        System.out.println(myCalendar.book(20, 30));
    }
}

class MyCalendar {

    TreeMap<Integer, Integer> map;

    public MyCalendar() {
        map = new TreeMap<>();
    }

    public boolean book(int startTime, int endTime) {
        map.merge(startTime, 1, Integer::sum);
        map.merge(endTime, -1, Integer::sum);
        int cnt = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            cnt += entry.getValue();
            if (cnt > 1) {
                map.merge(startTime, -1, Integer::sum);
                map.merge(endTime, 1, Integer::sum);
                return false;
            }
        }

        return true;
    }
}
