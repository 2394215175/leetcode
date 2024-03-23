package com.dengwn.leetcode.solution.help138;


import lombok.Data;

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