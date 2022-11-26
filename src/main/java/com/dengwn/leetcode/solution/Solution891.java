package com.dengwn.leetcode.solution;

import java.math.BigDecimal;
import java.util.Arrays;

/**
 * @author: dengwn
 * @date: 2022-11-18
 **/
public class Solution891 {
    public int sumSubseqWidths(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        long sum = 0;
        int[] remainders = new int[len];
        remainders[0] = 1;
        for (int i = 1; i < len; i++) {
            remainders[i] = remainders[i - 1] * 2 % 1000000007;
        }

        for (int i = 0; i < nums.length; i++) {
            //当在0这个下标
            // 需要加上0 即2的0次方-1*num[0]
            // 需要减去2的len-i-1此方-1*num[0]

            //当在1这个下标
            //需要加上 2的1次方-1*num[1]
            //需要减去2的len-i-1次方*nums[1]
            sum += (long) (remainders[i] - remainders[len - i - 1]) * nums[i];
            sum %= 1000000007;

        }
        return (int) sum;
    }

}
