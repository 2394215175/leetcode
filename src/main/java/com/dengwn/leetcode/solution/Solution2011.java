package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2022-12-23
 **/
public class Solution2011 {
    public int finalValueAfterOperations(String[] operations) {
        int ans = 0;
        for (String operation : operations) {
            ans += getOperations(operation);
        }
        return ans;
    }

    public int getOperations(String operations) {
        if ("++X".equals(operations) || "X++".equals(operations)) {
            return 1;
        } else {
            return -1;
        }
    }
}
