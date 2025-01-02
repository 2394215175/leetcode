package com.dengwn.code.leetcode.solution.t0.h2.d9;

import java.util.PriorityQueue;

/**
 *
 * @author dengwenning
 * @since 2024/12/25
 **/
public class Solution295 {
    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
//        medianFinder.addNum(-1);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-2);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-3);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-4);
//        System.out.println(medianFinder.findMedian());
//        medianFinder.addNum(-5);
//        System.out.println(medianFinder.findMedian());

        medianFinder.addNum(1);
        medianFinder.addNum(2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(3);
        System.out.println(medianFinder.findMedian());
    }
}

class MedianFinder {

    PriorityQueue<Integer> min;
    PriorityQueue<Integer> max;

    public MedianFinder() {
        min = new PriorityQueue<>(((o1, o2) -> o2 - o1));
        max = new PriorityQueue<>();
    }

    public void addNum(int num) {
        max.add(num);
        min.add(max.poll());
        if (min.size() == max.size() + 2) {
            max.add(min.poll());
        }
    }

    public double findMedian() {
        return max.size() == min.size() ? (max.peek() + min.peek()) / 2.0 : min.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
