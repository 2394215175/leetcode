package com.dengwn.leetcode.solution;

import javafx.util.Pair;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * @author: dengwn
 * @date: 2022-11-15
 **/
public class Solution2099 {
    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[k];
        PriorityQueue<Pair<Integer, Integer>> queue1 = new PriorityQueue<>(k, Comparator.comparingInt(Pair::getValue));
        Queue<Pair<Integer, Integer>> queue2 = new PriorityQueue<>(k, Comparator.comparingInt(Pair::getKey));

        for (int i = 0; i < k; i++) {
            queue1.add(new Pair(i, nums[i]));
        }

        for (int i = k; i < length; i++) {
            if (queue1.peek().getValue() > nums[i]) {
                continue;
            }

            queue1.poll();
            queue1.add(new Pair(i, nums[i]));
        }



        for (int i = 0; i < k; i++) {
            queue2.add(queue1.poll());
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue2.poll().getValue();
        }

        return res;
    }
}
