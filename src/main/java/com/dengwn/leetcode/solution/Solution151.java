package com.dengwn.leetcode.solution;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-04-25
 **/
public class Solution151 {
    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }

}
