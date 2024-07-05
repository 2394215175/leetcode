package com.dengwn.leetcode.solution.t1.h1.d0;

import java.util.Stack;

/**
 * @author: dengwn
 * @date: 2022-12-02
 **/
public class Solution1106 {
    final String TRUE = "t";
    final String FALSE = "f";

    public boolean parseBoolExpr(String expression) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < expression.length(); i++) {
            String cur = expression.substring(i, i + 1);
            stack.add(cur);
            if (stack.peek().equals(")")) {
                String calcSb = "";
                while (!stack.peek().equals("(")) {
                    String pop = stack.pop();
                    calcSb = pop + calcSb;
                }
                calcSb = stack.pop() + calcSb;
                calcSb = stack.pop() + calcSb;
                String calc = calc(calcSb);
                stack.add(calc);
            }
        }

        return stack.pop().equals(TRUE);
    }

    public String calc(String s) {
        String[] split = s.split("\\(|\\)|,");
        int length = split.length;
        String res = "";
        if ("!".equals(split[0])) {
            res = TRUE.equals(split[1]) ? FALSE : TRUE;
        } else if ("&".equals(split[0])) {
            for (int i = 1; i < length; i++) {
                if (FALSE.equals(split[i])) {
                    res = FALSE;
                    break;
                }
            }
            if ("".equals(res)) {
                res = TRUE;
            }
        } else {
            for (int i = 1; i < length; i++) {
                if (TRUE.equals(split[i])) {
                    res = TRUE;
                    break;
                }
            }
            if ("".equals(res)) {
                res = FALSE;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1106 solution1106 = new Solution1106();
        System.out.println(solution1106.parseBoolExpr("|(&(t,f,t),!(t))"));
    }
}
