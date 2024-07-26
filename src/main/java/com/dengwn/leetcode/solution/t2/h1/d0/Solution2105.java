package com.dengwn.leetcode.solution.t2.h1.d0;

/**
 * @author dengwenning
 * @since 2024/5/9
 **/
public class Solution2105 {
    public int minimumRefill(int[] plants, int capacityA, int capacityB) {
        int n = plants.length;
        int left = 0;
        int right = n - 1;
        int tempA = capacityA;
        int tempB = capacityB;
        int ans = 0;
        while (left < right) {
            // 如果A不够就补满
            if (tempA < plants[left]) {
                tempA = capacityA;
                ans++;
            }
            tempA -= plants[left];
            left++;

            if (tempB < plants[right]) {
                tempB = capacityB;
                ans++;
            }
            tempB -= plants[right];
            right--;
        }
        if (left == right && tempA < plants[left] && tempB < plants[right]) {
            ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2105 solution2105 = new Solution2105();
        System.out.println(solution2105.minimumRefill(new int[]{1, 2, 4, 4, 5}, 6, 5));
    }
}
