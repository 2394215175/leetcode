package com.dengwn.code.leetcode.solution.t3.h4.d4;

import java.util.Arrays;

/**
 *
 * @author dengwenning
 * @since 2025/2/11
 **/
public class Solution3447 {
    public int[] assignElements(int[] groups, int[] elements) {
        int mx = 0;
        for (int group : groups) {
            mx = Math.max(mx, group);
        }
        int[] t = new int[mx + 1];
        Arrays.fill(t, -1);
        for (int i = 0; i < elements.length; i++) {
            int element = elements[i];
            if (element > mx || t[element] >= 0) {
                continue;
            }
            for (int m = element; m <= mx; m += element) {
                if (t[m] < 0) {
                    t[m] = i;
                }
            }
        }
        for (int i = 0; i < groups.length; i++) {
            groups[i] = t[groups[i]];
        }
        return groups;
    }

    public static void main(String[] args) {
        int[] groups = new int[]{8,4,3,2,4};
        int[] elements = new int[]{4,2};
        Solution3447 solution = new Solution3447();
        System.out.println(Arrays.toString(solution.assignElements(groups, elements)));
    }
}
