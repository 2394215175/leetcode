package com.dengwn.leetcode.solution.t1.h0;

import com.dengwn.leetcode.solution.t0.h8.help876.ListNode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2023-04-10
 **/
public class Solution1019 {
    public int[] nextLargerNodes(ListNode head) {
        int index = 0;
        HashMap<ListNode, Integer> map = new HashMap<>();
        ListNode node = head;
        while (head != null) {
            map.put(head, index++);
            head = head.next;
        }
        Stack<ListNode> stack = new Stack<>();
        int[] ans = new int[map.size()];
        index = 0;
        while (node != null) {
            if (stack.empty() || stack.peek().val > node.val) {
                stack.push(node);
            } else {
                while (!stack.empty() && stack.peek().val < node.val) {
                    ans[map.get(stack.pop())] = node.val;
                }
                stack.push(node);
            }
            node = node.next;
            index++;
        }
        return ans;
    }


    public static void main(String[] args) {
        ListNode list5 = new ListNode(9);
        ListNode list4 = new ListNode(6, list5);
        ListNode list3 = new ListNode(7, list4);
        ListNode list2 = new ListNode(6, list3);
        ListNode list1 = new ListNode(7, list2);
        ListNode list0 = new ListNode(9, list1);
        Solution1019 solution1019 = new Solution1019();
        System.out.println(Arrays.toString(solution1019.nextLargerNodes(list0)));
    }

}
