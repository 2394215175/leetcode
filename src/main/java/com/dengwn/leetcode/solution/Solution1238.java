package com.dengwn.leetcode.solution;

import com.sun.org.apache.bcel.internal.classfile.Code;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author: dengwn
 * @date: 2023-02-23
 **/
public class Solution1238 {
    public List<Integer> circularPermutation(int n, int start) {
        List<Integer> ans = new LinkedList<>();
        int sum = (int) Math.pow(2, n);
        int[] grays = new int[sum];
        for (int i = 0; i < sum; i++) {
            grays[i] = getGrayCode(i);
        }

        int index = 0;
        boolean isStart = false;
        while (ans.size() < sum) {
            if (!isStart && grays[index] == start) {
                isStart = true;
            }
            if (isStart) {
                ans.add(grays[index % sum]);
            }
            index++;
        }
        return ans;
    }

    public int getGrayCode(int n) {
        return n ^ (n >> 1);
    }

    public List<Integer> circularPermutation1(int n, int start) {
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < 1 << n; ++i) {
            ans.add(getGrayCode(i) ^ start);
        }
        return ans;
    }


    public static void main(String[] args) {
        Solution1238 solution1238 = new Solution1238();
        System.out.println(solution1238.getGrayCode(2));
        System.out.println(solution1238.circularPermutation1(2, 3));
//        [3, 2, 6, 7, 5, 4, 0, 1]
//        [2, 0, 1, 3]
    }
}
