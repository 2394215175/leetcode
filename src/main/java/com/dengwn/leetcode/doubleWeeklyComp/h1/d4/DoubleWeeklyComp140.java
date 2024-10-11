package com.dengwn.leetcode.doubleWeeklyComp.h1.d4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author dengwenning
 * @since 2024/9/28
 **/
public class DoubleWeeklyComp140 {

    public int minElement(int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int num : nums) {
            int temp = 0;
            while (num > 0) {
                temp += num % 10;
                num /= 10;
            }
            ans = Math.min(ans, temp);
        }
        return ans;
    }

    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);
        int n = maximumHeight.length;
        long ans = 0;
        int pre = Integer.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            pre = Math.min(pre - 1, maximumHeight[i]);
            ans += pre;
            if (pre <= 0) {
                return -1;
            }
        }
        return ans;
    }

    public int[] validSequence(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        char[] arr1 = word1.toCharArray();
        char[] arr2 = word2.toCharArray();
        List<Integer> result = new ArrayList<>();
        boolean changed = false;
        int j = 0;
        for (int i = 0; i < m; i++) {
            // 当前看i这个下标的匹配
            boolean matched = false;
            int temp = j;
            while (temp < n) {
                if (arr1[temp] == arr2[i]) {
                    // 直接匹配
                    result.add(temp);
                    matched = true;
                    break;
                }
                temp++;
            }

            // 如果没有直接匹配，尝试使用调整机会
            if (!matched) {
                if (changed) {
                    return new int[0];
                }
                changed = true;
                result.add(j);
                j++; // 更新 j
                continue;
            }
            j = temp + 1;
        }

        // 如果找到的下标数量等于 word2 的长度
        return result.size() == m ? result.stream().mapToInt(i -> i).toArray() : new int[]{};
    }

    public int minStartingIndex(String s, String pattern) {
        int n = s.length();
        int m = pattern.length();
        char[] arr1 = s.toCharArray();
        char[] arr2 = pattern.toCharArray();
        for (int i = 0; i <= n - m; i++) {
            int preDiff = -1;
            boolean isMatch = true;
            for (int j = 0; j < m; j++) {
                if (arr1[i + j] != arr2[j]) {
                    if (preDiff != -1) {
                        isMatch = false;
                        break;
                    }
                    preDiff = i + j;
                }

            }
            if (isMatch) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp140 doubleWeeklyComp = new DoubleWeeklyComp140();

        String word1 = "dcdccdddcdcdddccddccccddcd";
        String word2 = "ddc";
        System.out.println(doubleWeeklyComp.minStartingIndex(word1, word2));
    }
}
