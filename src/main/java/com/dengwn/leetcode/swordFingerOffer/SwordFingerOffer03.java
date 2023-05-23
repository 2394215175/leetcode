package com.dengwn.leetcode.swordFingerOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @author: dengwn
 * @date: 2023-05-08
 **/
public class SwordFingerOffer03 {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    public int findRepeatNumber1(int[] nums) {
        int i = 0;
        while(i < nums.length) {
            if(nums[i] == i) {
                i++;
                continue;
            }
            if(nums[nums[i]] == nums[i]){
                return nums[i];
            }
            int tmp = nums[i];
            nums[i] = nums[tmp];
            nums[tmp] = tmp;
        }
        return -1;
    }

    public static void main(String[] args) {
        SwordFingerOffer03 swordFingerOffer03 = new SwordFingerOffer03();
        int[] nums = {2, 3, 1, 0, 2, 5, 3};
        System.out.println(swordFingerOffer03.findRepeatNumber1(nums));
    }
}
