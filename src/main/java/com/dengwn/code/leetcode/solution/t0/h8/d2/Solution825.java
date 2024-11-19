package com.dengwn.code.leetcode.solution.t0.h8.d2;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2024/11/18
 **/
public class Solution825 {
    public int numFriendRequests(int[] ages) {
        int[] cnt = new int[121];
        for (int age : ages) {
            cnt[age]++;
        }

        int ans = 0;
        int l = 0;
        int cntWindow = 0;
        for (int i = 0; i < cnt.length; i++) {
            int cntY = cnt[i];
            int cntX = cnt[l];
            cntWindow += cntY;
            if (l * 2 <= i + 14) {
                cntWindow -= cntX;
                l++;
            }
            if (cntWindow > 0) {
                ans += cntY * cntWindow - cntY;
            }
        }
        return ans;
//
//        int[] cnt = new int[121];
//        for (int age : ages) {
//            cnt[age]++;
//        }
//        int ans = 0;
//        int l = 0;
//        int cntWindow = 0;
//        for (int i = 1; i < 121; i++) {
//            int cntY = cnt[i];
//            int cntX = cnt[l];
//            cntWindow += cntY;
//            if (cntY * 2 >= cntX + 14) {
//                cntWindow -= cntX;
//                l++;
//            }
//            ans += cntWindow * cntY - cntY;
//        }
//        return ans;
    }


    public static void main(String[] args) {
        int[] ages = {16, 16};
        Solution825 solution825 = new Solution825();
        System.out.println(solution825.numFriendRequests(ages));
    }

}
