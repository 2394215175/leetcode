package com.dengwn.leetcode.solution.t1.h6;

/**
 * @author: dengwn
 * @date: 2022-12-01
 **/
public class Solution1678 {
    public String interpret(String command) {
        return command.replaceAll("\\(al\\)", "al").replaceAll("\\(\\)", "o");
    }

    public String interpret1(String command) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < command.length(); i++) {
            if (command.charAt(i) == 'G') {
                res.append("G");
            } else if (command.charAt(i) == '(') {
                if (command.charAt(i + 1) == ')') {
                    res.append("o");
                } else {
                    res.append("al");
                }
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        Solution1678 solution1678 = new Solution1678();
        String i = solution1678.interpret("G()(al)");
        System.out.println(i);
    }
}
