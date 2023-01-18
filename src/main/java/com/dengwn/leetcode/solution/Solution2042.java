package com.dengwn.leetcode.solution;


import org.springframework.util.NumberUtils;

/**
 * @author: dengwn
 * @date: 2023-01-03
 **/
public class Solution2042 {
    public boolean areNumbersAscending(String s) {
        String[] split = s.split(" ");
        int pre = -1;
        for (String str : split) {
            if (isNumber(str)) {
                int num = Integer.parseInt(str);
                if (num <= pre) {
                    return false;
                }
                pre = num;
            }
        }
        return true;
    }

    public boolean isNumber(String str) {
        for (int i = str.length(); --i > 0; ) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

}
