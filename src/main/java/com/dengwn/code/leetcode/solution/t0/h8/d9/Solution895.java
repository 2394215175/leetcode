package com.dengwn.code.leetcode.solution.t0.h8.d9;

import java.util.*;

/**
 * @author dengwn
 * @date: 2022-11-30
 */
public class Solution895 {
    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(5);
        freqStack.push(0);
        freqStack.push(9);
        freqStack.push(3);
        freqStack.push(4);
        freqStack.push(2);
        System.out.println(freqStack.pop());
        freqStack.push(6);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(1);
        System.out.println(freqStack.pop());
        freqStack.push(4);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }

}

class FreqStack {

    private Map<Integer, LinkedList<Integer>> map;
    private Map<Integer, Integer> freq;
    int max = 0;

    public FreqStack() {
        map = new TreeMap<>((o1, o2) -> o2 - o1);
        freq = new HashMap<>();
    }

    public void push(int val) {
        Integer curMax = freq.get(val);
        int nMax = curMax != null ? curMax + 1 : 1;
        freq.merge(val, 1, Integer::sum);
        LinkedList<Integer> list = map.getOrDefault(nMax, new LinkedList<>());
        list.add(val);
        max = Math.max(max, nMax);
        map.put(nMax, list);
    }


    public int pop() {
        LinkedList<Integer> list = map.get(max);
        Integer ans = list.remove(list.size() - 1);
        if (list.isEmpty()) {
            max--;
        }
        freq.merge(ans, -1, Integer::sum);
        return ans;
    }
}