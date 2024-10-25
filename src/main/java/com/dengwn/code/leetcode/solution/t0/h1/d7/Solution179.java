package com.dengwn.code.leetcode.solution.t0.h1.d7;

import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-11-25
 **/
public class Solution179 {
    public String largestNumber(int[] nums) {
        StringBuilder res = new StringBuilder();
//        for (int i = 0; i < nums.length - 1; i++) {
//            for (int j = 0; j < nums.length - 1; j++) {
//                if (!compare(nums[j], nums[j + 1])) {
//                    int temp = nums[j + 1];
//                    nums[j + 1] = nums[j];
//                    nums[j] = temp;
//                }
//            }
//        }

        Integer[] integers = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, (a, b) -> {
            // a在b前
            String ab = a + "" + b;
            // b在a前
            String ba = b + "" + a;
            return ab.compareTo(ba);
        });

        for (int i = 0; i < integers.length; i++) {
            if("0".equals(res.toString()) && integers[i] == 0){
                continue;
            }
            res.append(integers[i]);
        }

        return res.toString();
    }

    public boolean compare(int a, int b) {
        // a在b前
        String ab = a + "" + b;
        // b在a前
        String ba = b + "" + a;
        return ab.compareTo(ba) >= 0;
    }
}
