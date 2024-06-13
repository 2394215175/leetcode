package com.dengwn.leetcode.solution.t0.h1.help138;


public class Node {
    public int val;
    public Node next;
    public Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }

    public Node(int val, Node node) {
        this.val = val;
        this.next = node;
        this.random = null;
    }
}