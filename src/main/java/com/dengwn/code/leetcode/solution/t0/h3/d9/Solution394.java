package com.dengwn.code.leetcode.solution.t0.h3.d9;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/12/24
 **/
public class Solution394 {
    public String decodeString(String s) {
        int n = s.length();
        LinkedList<String> queue = new LinkedList<>();
        for (int i = 0; i < n;) {
            char c = s.charAt(i);
            if (c == ']') {
                StringBuilder temp = new StringBuilder();
                while (!"[".equals(queue.peek())) {
                    temp.insert(0, queue.poll());
                }
                queue.poll();
                String time = queue.poll();
                StringBuffer sb = new StringBuffer();
                for (int j = 0; j < Integer.parseInt(time); j++) {
                    sb.append(temp);
                }
                queue.push(sb.toString());
                i++;
            } else if (c == '[') {
                queue.push("[");
                i++;
            } else if (c >= '0' && c <= '9') {
                StringBuilder nums = new StringBuilder();
                while (i < n && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
                    nums.append(s.charAt(i));
                    i++;
                }
                queue.push(nums.toString());
            } else {
                StringBuilder chars = new StringBuilder();
                while (i < n && s.charAt(i) >= 'a' && s.charAt(i) <= 'z') {
                    chars.append(s.charAt(i));
                    i++;
                }
                queue.push(chars.toString());
            }
        }
        StringBuilder ans = new StringBuilder();
        while (!queue.isEmpty()) {
            ans.insert(0, queue.poll());
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution394 solution = new Solution394();
        System.out.println(solution.decodeString("2[abc]3[cd]ef"));
    }
}
