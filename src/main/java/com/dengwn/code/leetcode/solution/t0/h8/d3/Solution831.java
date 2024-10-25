package com.dengwn.code.leetcode.solution.t0.h8.d3;

/**
 * @author dengwn
 * @date: 2023-04-01
 */
public class Solution831 {
    String[] country = {"", "+*-", "+**-", "+***-"};

    public String maskPII(String s) {
        StringBuilder ans = new StringBuilder();
        int index = s.indexOf("@");
        if (index > 0) {
            ans.append(s.substring(0, 1).toLowerCase())
                    .append("*****")
                    .append(s.substring(index - 1).toLowerCase());
        } else {
            ans.append("***-***-");
            int nums = 0;
            for (int i = s.length() - 1; i >= 0; i--) {
                char c = s.charAt(i);
                if (c >= '0' && c <= '9') {
                    nums++;
                    if (ans.length() < 12) {
                        ans.insert(8, c);
                    }
                }
            }
            ans.insert(0, country[nums - 10]);
        }
        return ans.toString();
    }

    public static void main(String[] args) {
        Solution831 solution831 = new Solution831();
        System.out.println(solution831.maskPII("1(234)567-890"));
    }
}
