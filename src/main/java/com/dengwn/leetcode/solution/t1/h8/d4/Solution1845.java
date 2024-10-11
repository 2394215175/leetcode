package com.dengwn.leetcode.solution.t1.h8.d4;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/9/30
 **/
public class Solution1845 {
}

class SeatManager {

    PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o));
    int cnt = 1;
    public SeatManager(int n) {
    }

    public int reserve() {
        if (!pq.isEmpty()){
            return pq.poll();
        }
        return cnt++;
    }

    public void unreserve(int seatNumber) {
        pq.add(seatNumber);
    }
}

