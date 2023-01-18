package com.dengwn.leetcode.solution;

import java.util.LinkedList;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution232 {
}

class MyQueue {
    LinkedList<Integer> stack1;
    LinkedList<Integer> stack2;

    public MyQueue() {
        stack1 = new LinkedList<>();
        stack2 = new LinkedList<>();
    }

    public void push(int x) {
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
        stack1.push(x);
    }

    public int pop() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }

    public int peek() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        return stack2.peek();
    }

    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }
}
