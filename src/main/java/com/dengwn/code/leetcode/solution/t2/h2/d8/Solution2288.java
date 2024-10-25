package com.dengwn.code.leetcode.solution.t2.h2.d8;

/**
 * @author dengwenning
 * @since 2024/6/18
 **/
public class Solution2288 {
    public String discountPrices(String sentence, int discount) {
        double d = (100 - discount) / 100.0;
        String[] s = sentence.split(" ");
        for (int i = 0; i < s.length; i++) {
            if (!s[i].startsWith("$")) {
                continue;
            }
            try {
                s[i] = String.format("¥%.2f", Long.parseLong(s[i].substring(1)) * d);
            } catch (Exception ignored) {
            }
        }
        return String.join(" ", s);
    }


    public static void main(String[] args) {
        String sentence = "there are $-1 $2 and 5$ candies in the shop";
        int discount = 50;
        Solution2288 solution2288 = new Solution2288();
        System.out.println(solution2288.discountPrices(sentence, discount));
    }
}
