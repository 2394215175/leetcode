package com.dengwn.code.leetcode.solution.t0.h5.d8.help589;

import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }

}
