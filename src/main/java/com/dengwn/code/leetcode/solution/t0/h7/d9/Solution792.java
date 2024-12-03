package com.dengwn.code.leetcode.solution.t0.h7.d9;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2022-11-17
 **/
public class Solution792 {
    public int numMatchingSubseq(String s, String[] words) {
        // 针对字符串数组去重
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        // 对字符串s进行下标统计，方便后续搜索
        HashMap<Character, List<Integer>> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = sMap.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            sMap.put(s.charAt(i), list);
        }

        int count = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int index = -1;
            boolean isFind = true;
            for (int i = 0; i < word.length(); i++) {
                List<Integer> list = sMap.getOrDefault(word.charAt(i), new ArrayList<>());
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = left + right >> 1;
                    if (list.get(mid) > index) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                if (right < 0 || list.get(right) <= index) {
                    isFind = false;
                    break;
                } else {
                    index = list.get(right);
                }
            }

            if (isFind) {
                count = count + entry.getValue();
            }
        }
        return count;

    }


}
