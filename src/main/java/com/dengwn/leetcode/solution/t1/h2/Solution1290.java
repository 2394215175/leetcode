package com.dengwn.leetcode.solution.t1.h2;

import com.dengwn.leetcode.solution.t0.h8.d7.help876.ListNode;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution1290 {
    public int getDecimalValue(ListNode head) {
        int ans = 0;
        while (head != null) {
            ans <<= 1;
            ans += head.val;
            head = head.next;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Integer.parseInt("100100111000000", 2));
    }

}
