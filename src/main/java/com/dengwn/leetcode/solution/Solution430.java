package com.dengwn.leetcode.solution;

import com.dengwn.leetcode.solution.help430.Node;

/**
 * @author: dengwn
 * @date: 2022-11-23
 **/
public class Solution430 {
    public static void main(String[] args) {
//        Node node1 = new Node();
//        Node node2 = new Node();
//        Node node3 = new Node();
//        Node node4 = new Node();
//        Node node5 = new Node();
//        Node node6 = new Node();
//        Node node7 = new Node();
//        Node node8 = new Node();
//        Node node9 = new Node();
//        Node node10 = new Node();
//        Node node11 = new Node();
//        Node node12 = new Node();
//
//        node1.val = 1;
//        node1.next = node2;
//
//        node2.val = 2;
//        node2.prev = node1;
//        node2.next = node3;
//
//        node3.val = 3;
//        node3.prev = node2;
//        node3.next = node4;
//        node3.child = node7;
//
//        node4.val = 4;
//        node4.prev = node3;
//        node4.next = node5;
//
//        node5.val = 5;
//        node5.prev = node4;
//        node5.next = node6;
//
//        node6.val = 6;
//        node6.prev = node5;
//
//        node7.val = 7;
//        node7.next = node8;
//
//        node8.val = 8;
//        node8.prev = node7;
//        node8.next = node9;
//        node8.child = node11;
//
//        node9.val = 9;
//        node9.prev = node8;
//        node9.next = node10;
//
//        node10.val = 10;
//        node10.prev = node9;
//
//        node11.val = 11;
//        node11.next = node12;
//
//        node12.val = 12;
//        node12.prev = node11;

        Node node1 = new Node();
        Node node2 = new Node();
        Node node3 = new Node();
        Node node4 = new Node();
        Node node5 = new Node();
        Node node6 = new Node();
        Node node7 = new Node();
        Node node8 = new Node();
        Node node11 = new Node();
        Node node12 = new Node();


        node1.val = 1;
        node1.next = node2;
        node2.val = 2;
        node2.prev = node1;
        node2.next = node3;
        node3.val = 3;
        node3.prev = node2;
        node3.next = node4;
        node3.child = node7;
        node4.val = 4;
        node4.prev = node3;
        node4.next = node5;
        node5.val = 5;
        node5.prev = node4;
        node5.next = node6;
        node6.val = 6;
        node6.prev = node5;
        node7.val = 7;
        node7.next = node8;
        node8.val = 8;
        node8.prev = node7;
        node8.child = node11;
        node11.val = 11;
        node11.next = node12;
        node12.val = 12;
        node12.prev = node11;

        Node flatten = flatten(node1);
    }

    public static Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node node = dfs(head);
        while (node.prev != null) {
            node = node.prev;
        }
        return node;
    }

    public static Node dfs(Node node) {
        if (node.next == null && node.child == null) {
            return node;
        }

        while (true) {
            Node next = node.next;
            if (node.child != null) {
                Node child = dfs(node.child);
                // 有子节点，当前节点的下一个节点为子节点
                node.child.prev = node;
                node.next = node.child;

                while (child.next != null) {
                    child = child.next;
                }

                if (next != null) {
                    child.next = next;
                    next.prev = child;
                }

                node.child = null;
            }
            if(next == null){
                break;
            }
            node = next;
        }
        return node;
    }

}

