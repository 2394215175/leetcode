package com.dengwn.code.leetcode.solution.t0.h7;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-01-17
 **/
public class Solution784 {
    public List<String> letterCasePermutation(String s) {
        int index = 0;
        Queue<String> queue = new LinkedList<>();
        ArrayList<String> res = new ArrayList<>();
        queue.add(s);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                while (cur != null && index < s.length()) {
                    char c = cur.charAt(index);
                    if (c >= 'A' && c <= 'z') {
                        queue.add(cur.replaceFirst(String.valueOf(c), String.valueOf(c)));
                    }
                    index++;
                }
            }
        }


        return res;
    }

    public static void main(String[] args) {
        System.out.println('z' - 0);
        System.out.println('A' - 0);
    }
}
