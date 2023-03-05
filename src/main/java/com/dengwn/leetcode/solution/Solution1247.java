package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2023-02-25
 */
public class Solution1247 {
    public int minimumSwap(String s1, String s2) {
        int xy = 0;
        int yx = 0;
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            if (c1 != c2) {
                if (c1 == 'x') {
                    xy++;
                } else {
                    yx++;
                }
            }
        }
        if ((xy + yx) % 2 == 1) {
            return -1;
        }

        return xy / 2 + yx / 2 + xy % 2 + yx % 2;
    }

    public static void main(String[] args) {
        Solution1247 solution1247 = new Solution1247();
        String s1 = "xxyyxyxyxxx";
        String s2 = "xyyxyxxxyxy";
        System.out.println(solution1247.minimumSwap(s1, s2));
    }
}
