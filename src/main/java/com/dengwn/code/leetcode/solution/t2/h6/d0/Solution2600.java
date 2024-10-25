package com.dengwn.code.leetcode.solution.t2.h6.d0;

/**
 * @author: dengwn
 * @date: 2023-07-05
 **/
public class Solution2600 {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }
}
