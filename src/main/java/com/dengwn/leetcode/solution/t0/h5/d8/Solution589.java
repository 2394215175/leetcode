package com.dengwn.leetcode.solution.t0.h5.d8;

import com.dengwn.leetcode.solution.t0.h5.d8.help589.Node;

import java.util.LinkedList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-01-06
 **/
public class Solution589 {
    public List<Integer> preorder(Node root) {
        LinkedList<Integer> res = new LinkedList<>();
        dfs(res,root);
        return res;
    }

    public void dfs(List<Integer> list, Node node) {
        if (node != null) {
            list.add(node.val);
            for (Node child : node.children) {
                dfs(list, child);
            }
        }
    }


}

