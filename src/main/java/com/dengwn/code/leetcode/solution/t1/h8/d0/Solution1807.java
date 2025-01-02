package com.dengwn.code.leetcode.solution.t1.h8.d0;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: dengwn
 * @date: 2023-01-12
 **/
public class Solution1807 {
    public String evaluate(String s, List<List<String>> knowledge) {
        Map<String, String> dictionary = new HashMap<>();
        for (List<String> strings : knowledge) {
            dictionary.put(strings.get(0), strings.get(1));
        }

        int pre = -1;
        int cur = -1;
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') {
                pre = i;
            }
            if (pre == cur) {
                builder.append(c);
            }
            if (c == ')') {
                cur = i;
                builder.append(dictionary.getOrDefault(s.substring(pre + 1, cur), "?"));
                pre = i;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        Solution1807 solution1807 = new Solution1807();
        String s = "(name)is(age)yearsold";
        ArrayList<String> list1 = new ArrayList<>();
        list1.add("name");
        list1.add("bob");
        ArrayList<String> list2 = new ArrayList<>();
        list2.add("age");
        list2.add("two");
        ArrayList<List<String>> knowledge = new ArrayList<>();
        knowledge.add(list1);
        knowledge.add(list2);
        solution1807.evaluate(s, knowledge);
    }
}
