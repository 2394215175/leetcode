package com.dengwn.code.leetcode.solution.t1.h8.d2;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-01-18
 **/
public class Solution1825 {
    public static void main(String[] args) {
        MKAverage mkAverage = new MKAverage(6, 1);

        mkAverage.addElement(3);
        mkAverage.addElement(1);
        mkAverage.addElement(12);
        mkAverage.addElement(5);
        mkAverage.addElement(3);
        mkAverage.addElement(4);
        System.out.println(mkAverage.calculateMKAverage());
    }
}

class MKAverage {

    private int m, k;
    private long s;
    private int size1, size3;
    private Deque<Integer> q = new ArrayDeque<>();
    private TreeMap<Integer, Integer> lo = new TreeMap<>();
    private TreeMap<Integer, Integer> mid = new TreeMap<>();
    private TreeMap<Integer, Integer> hi = new TreeMap<>();


    public MKAverage(int m, int k) {
        this.m = m;
        this.k = k;
    }

    public void addElement(int num) {
        if (lo.isEmpty() || num <= lo.lastKey()) {
            lo.merge(num, 1, Integer::sum);
            ++size1;
        } else if (hi.isEmpty() || num >= hi.firstKey()) {
            hi.merge(num, 1, Integer::sum);
            ++size3;
        } else {
            mid.merge(num, 1, Integer::sum);
            s += num;
        }
        q.offer(num);
        if (q.size() > m) {
            int x = q.poll();
            if (lo.containsKey(x)) {
                lo.merge(x, -1, Integer::sum);
                if (lo.get(x) == 0) {
                    lo.remove(x);
                }
                --size1;
            } else if (hi.containsKey(x)) {
                hi.merge(x, -1, Integer::sum);
                if (hi.get(x) == 0) {
                    hi.remove(x);
                }
                --size3;
            } else {
                mid.merge(x, -1, Integer::sum);
                if (mid.get(x) == 0) {
                    mid.remove(x);
                }
                s -= x;
            }
        }
        for (; size1 > k; --size1) {
            int x = lo.lastKey();
            lo.merge(x, -1, Integer::sum);
            if (lo.get(x) == 0) {
                lo.remove(x);
            }
            mid.merge(x, 1, Integer::sum);
            s += x;
        }
        for (; size3 > k; --size3) {
            int x = hi.firstKey();
            hi.merge(x, -1, Integer::sum);
            if (hi.get(x) == 0) {
                hi.remove(x);
            }
            mid.merge(x, 1, Integer::sum);
            s += x;
        }
        for (; size1 < k && !mid.isEmpty(); ++size1) {
            int x = mid.firstKey();
            mid.merge(x, -1, Integer::sum);
            if (mid.get(x) == 0) {
                mid.remove(x);
            }
            s -= x;
            lo.merge(x, 1, Integer::sum);
        }
        for (; size3 < k && !mid.isEmpty(); ++size3) {
            int x = mid.lastKey();
            mid.merge(x, -1, Integer::sum);
            if (mid.get(x) == 0) {
                mid.remove(x);
            }
            s -= x;
            hi.merge(x, 1, Integer::sum);
        }
    }

    public int calculateMKAverage() {
        return q.size() < m ? -1 : (int) (s / (q.size() - k * 2));
    }
}
