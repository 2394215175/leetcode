package com.dengwn.code.leetcode.solution.t0.h0.d7;

import java.util.Stack;

/**
 *
 * @author dengwenning
 * @since 2024/12/31
 **/
public class Solution71 {
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] pa = path.split("/");
        StringBuilder sb = new StringBuilder();
        for (String p : pa) {
            if (".".equals(p) || "".equals(p)) {
            } else if ("..".equals(p)) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(p);
            }
        }
        while (!stack.isEmpty()) {
            sb.insert(0, stack.pop());
            sb.insert(0, "/");
        }
        return "".contentEquals(sb) ? "/" : sb.toString();
    }

    public static void main(String[] args) {
        Solution71 solution71 = new Solution71();
        System.out.println(solution71.simplifyPath("/.../a/../b/c/../d/./"));
    }
}

