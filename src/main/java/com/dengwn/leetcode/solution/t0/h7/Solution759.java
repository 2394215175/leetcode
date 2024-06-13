package com.dengwn.leetcode.solution.t0.h7;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-04-25
 **/
public class Solution759 {
    public List<Interval> employeeFreeTime(List<List<Interval>> schedule) {
        List<int[]> temp = new ArrayList<>();
        for (List<Interval> intervals : schedule) {
            for (Interval interval : intervals) {
                temp.add(new int[]{interval.start, interval.end});
            }
        }
        Collections.sort(temp,(o1, o2) -> o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0]);
        List<Interval> ans = new ArrayList<>();
        int preStart = temp.get(0)[0];
        int preEnd = temp.get(0)[1];
        for (int[] t : temp) {
            if (t[0] > preStart) {
                if (t[0] > preEnd) {
                    ans.add(new Interval(preEnd, t[0]));
                    preStart = t[0];
                    preEnd = t[1];
                }
                if (t[1] > preEnd) {
                    preEnd = t[1];
                }
            }
        }

        return ans;
    }

    public static void main(String[] args) {
        Solution759 solution759 = new Solution759();
        List<Interval> intervals1 = new ArrayList<>();
        intervals1.add(new Interval(1, 3));
        intervals1.add(new Interval(6, 7));
        List<Interval> intervals2 = new ArrayList<>();
        intervals2.add(new Interval(2, 4));
        List<Interval> intervals3 = new ArrayList<>();
        intervals3.add(new Interval(2, 5));
        intervals3.add(new Interval(9, 12));
        List<List<Interval>> schedule = new ArrayList<>();
        schedule.add(intervals1);
        schedule.add(intervals2);
        schedule.add(intervals3);

        System.out.println(solution759.employeeFreeTime(schedule));
    }
}

class Interval {
    public int start;
    public int end;

    public Interval() {
    }

    public Interval(int _start, int _end) {
        start = _start;
        end = _end;
    }
};
