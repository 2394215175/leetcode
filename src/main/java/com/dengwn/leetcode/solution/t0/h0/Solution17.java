package com.dengwn.leetcode.solution.t0.h0;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2023-02-07
 **/
public class Solution17 {
    Map<Character, String> phoneMap = new HashMap<Character, String>() {{
        put('2', "abc");
        put('3', "def");
        put('4', "ghi");
        put('5', "jkl");
        put('6', "mno");
        put('7', "pqrs");
        put('8', "tuv");
        put('9', "wxyz");
    }};

    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        if (digits.length() == 0) {
            return ans;
        }
        backtrack(ans, digits, 0, new StringBuffer());
        return ans;
    }

    public void backtrack(List<String> combinations, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        for (int i = 0; i < letters.length(); i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }
}
