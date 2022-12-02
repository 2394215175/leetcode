package com.dengwn.leetcode.solution;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2022-12-02
 **/
public class Solution1769 {
    public int[] minOperations(String boxes) {
        int length = boxes.length();
        int[] res = new int[length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (boxes.charAt(i) == '1') {
                    res[j] += Math.abs(i - j);
                }
            }
        }

        return res;
    }

    public int[] minOperations2(String boxes) {
        int length = boxes.length();
        int[] res = new int[length];
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < length; i++) {
            if(boxes.charAt(i) == '1'){
                list.add(i);
            }
        }

        for (int i = 0; i < length; i++) {
            for (Integer integer : list) {
                res[i] += Math.abs(i - integer);
            }
        }

        return res;
    }

    public int[] minOperations1(String boxes) {
        int length = boxes.length();
        int[] res = new int[length];
        int left = boxes.charAt(0) - '0';
        int right = 0;
        for (int i = 1; i < length; i++) {
            if (boxes.charAt(i) == '1') {
                right++;
                res[0] += i;
            }
        }

        for (int i = 1; i < length; i++) {
            res[i] = res[i - 1] - right + left;
            if (boxes.charAt(i) == '1') {
                right--;
                left++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        Solution1769 solution1769 = new Solution1769();
        int[] ints = solution1769.minOperations("001011");
        int[] ints1 = solution1769.minOperations1("001011");
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i] + "_" + ints1[i]);
        }

    }
}
