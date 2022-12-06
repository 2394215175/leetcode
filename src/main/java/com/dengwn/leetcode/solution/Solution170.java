package com.dengwn.leetcode.solution;

import java.util.*;

/**
 * @author: dengwn
 * @date: 2022-12-06
 **/
public class Solution170 {
    public static void main(String[] args) {
        TwoSum twoSum = new TwoSum();
        twoSum.add(1);
        
        System.out.println(twoSum.find(-2147483648));
    }
}

class TwoSum {
    int[] arr;
    int index = 0;

    public TwoSum() {
        arr = new int[10000];
    }

    public void add(int number) {
        arr[index] = number;
        index++;
    }

    public boolean find(int value) {
        Arrays.sort(arr, 0, index);
        for (int i = 0; i < index; i++) {
            int ans = value - arr[i];
            int search = Arrays.binarySearch(arr, 0, index, ans);
            if (search >= 0 && search != i) {
                return true;
            }
        }
        return false;
    }

}
