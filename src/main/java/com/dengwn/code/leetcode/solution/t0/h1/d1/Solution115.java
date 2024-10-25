package com.dengwn.code.leetcode.solution.t0.h1.d1;

import java.util.Comparator;
import java.util.Stack;
import java.util.TreeMap;

/**
 * @author: dengwn
 * @date: 2023-04-25
 **/
public class Solution115 {

}

class MinStack {
    TreeMap<Integer, Integer> map;
    Stack<Integer> stack;

    public MinStack() {
        stack = new Stack<>();
        map = new TreeMap<>(Comparator.comparingInt(o -> o));
    }

    public void push(int val) {
        stack.push(val);
        map.merge(val, 1, Integer::sum);
    }

    public void pop() {
        Integer pop = stack.pop();
        Integer size = map.get(pop);
        if (size != null) {
            if (size == 1) {
                map.remove(pop);
            } else {
                map.put(pop, size - 1);
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return map.firstKey();
    }
}
