package com.dengwn.code.leetcode.solution.t0.h1.d6;

import com.dengwn.code.leetcode.solution.t0.h8.d7.help876.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author dengwenning
 * @since 2024/12/16
 **/
public class Solution160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodes1 = new HashSet<>();
        ListNode headA2 = headA;
        while (headA2 != null){
            nodes1.add(headA2);
            headA2 = headA2.next;
        }
        while (headB != null){
            if(nodes1.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }

    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode A = headA, B = headB;
        while (headA != headB){
            headA = headA == null ? B : headA.next;
            headB = headB == null ? A : headB.next;
        }
        return headA;
    }
}
