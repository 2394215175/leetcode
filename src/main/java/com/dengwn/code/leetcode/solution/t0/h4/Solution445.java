package com.dengwn.code.leetcode.solution.t0.h4;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2023-07-03
 **/
public class Solution445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        while (l1 != null) {
            stack1.add(l1.val);

            l1 = l1.next;
        }

        while (l2 != null) {
            stack2.add(l2.val);
            l2 = l2.next;
        }

        int i1 = stack1.isEmpty() ? 0 : stack1.pop();
        int i2 = stack2.isEmpty() ? 0 : stack2.pop();

        ListNode ans = new ListNode((i1 + i2) % 10);
        boolean isAdd = (i1 + i2) >= 10;
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            int j1 = stack1.isEmpty() ? 0 : stack1.pop();
            int j2 = stack2.isEmpty() ? 0 : stack2.pop();
            int add = isAdd ? 1 : 0;
            ans = new ListNode((j1 + j2 + add) % 10, ans);
            isAdd = (j1 + j2 + add) >= 10;
        }

        if (isAdd) {
            ans = new ListNode(1, ans);
        }

        return ans;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(9, new ListNode(9));
        ListNode l2 = new ListNode(1);
        Solution445 solution445 = new Solution445();
        System.out.println(solution445.addTwoNumbers(l1, l2));
    }

}
