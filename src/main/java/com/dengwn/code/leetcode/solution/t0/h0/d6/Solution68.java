package com.dengwn.code.leetcode.solution.t0.h0.d6;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/12/26
 **/
public class Solution68 {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        List<Integer> ends = new ArrayList<>();
        int usedLen = 0;
        for (String word : words) {
            if (usedLen + word.length() > maxWidth) {
                // 移除最后一个空格
                sb.delete(usedLen - 1, usedLen);
                int blankSize = ends.size() - 1;
                if (blankSize == 0) {
                    for (int i = 0; i <= maxWidth - usedLen; i++) {
                        sb.append(" ");
                    }
                } else {
                    for (int i = blankSize - 1; i >= 0; i--) {
                        int blankLen = maxWidth - usedLen + 1;
                        for (int j = 0; j < blankLen / blankSize; j++) {
                            sb.insert(ends.get(i), " ");
                        }
                        if (i < blankLen % blankSize) {
                            sb.insert(ends.get(i), " ");
                        }
                    }
                }
                ans.add(sb.toString());
                sb.setLength(0);
                usedLen = 0;
                ends.clear();
            }
            sb.append(word + " ");
            usedLen += word.length() + 1;
            ends.add(usedLen);
        }
        sb.delete(usedLen - 1, usedLen);
        for (int i = sb.length(); i < maxWidth; i++) {
            sb.append(" ");
        }
        ans.add(sb.toString());
        return ans;
    }

    public static void main(String[] args) {
        Solution68 solution68 = new Solution68();
        String[] words = {"ask", "not", "what", "your", "country", "can", "do", "for", "you", "ask", "what", "you", "can", "do", "for", "your", "country"};
        int maxWidth = 16;
        System.out.println(solution68.fullJustify(words, maxWidth));
    }
}
