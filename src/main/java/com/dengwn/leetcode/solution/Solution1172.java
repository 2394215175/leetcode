package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-04-28
 **/
public class Solution1172 {
    public static void main(String[] args) {
    }
}

class DinnerPlates {
    private int capacity;
    private List<Deque<Integer>> stacks;
    private PriorityQueue<Integer> idx;

    public DinnerPlates(int capacity) {
        this.capacity = capacity;
        stacks = new ArrayList<>();
        idx = new PriorityQueue<>();
    }

    public void push(int val) {
        if (!idx.isEmpty() && idx.peek() > stacks.size()) {
            idx.clear();
        }
        if (idx.isEmpty()) {
            Deque<Integer> deque = new ArrayDeque<>();
            deque.push(val);
            stacks.add(deque);
            if (capacity > 1) {
                idx.add(stacks.size() - 1);
            }
        } else {
            Integer min = idx.peek();
            Deque<Integer> deque = stacks.get(min);
            deque.push(val);
            if (capacity == deque.size()) {
                idx.poll();
            }
        }
    }

    public int pop() {
        return popAtStack(stacks.size() - 1);
    }

    public int popAtStack(int index) {
        if (index < 0 || index >= stacks.size()) {
            return -1;
        }
        Deque<Integer> deque = stacks.get(index);
        if (deque.isEmpty()) {
            return -1;
        }
        Integer result = deque.pop();
        if (deque.isEmpty()){
            stacks.remove(index);
        }else {
            idx.add(index);
        }
        return result;
    }
}
