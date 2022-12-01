package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2022-11-28
 */
public class NSolution813 {
    public double largestSumOfAverages(int[] nums, int k) {
        double max = 0.0;
        int[] indexes = new int[k + 1];
        indexes[0] = -1;
        indexes[k] = nums.length;
        for (int i = 1; i < k; i++) {
            indexes[i] = i;
        }

        // n当前移动的指针
        for (int n = k - 1; n > 0; n--) {
            while (indexes[n] < indexes[n + 1]) {
                double fraction = calc(nums, indexes);
                max = Math.max(max, fraction);
                if (indexes[n] + 1 == indexes[n + 1]) {
                    break;
                } else {
                    indexes[n]++;
                }
            }

        }

        return max;
    }

    public double calc(int[] nums, int[] indexes) {
        int indexLen = indexes.length;
        int numsLen = nums.length;
        double fraction = 0;
        for (int i = 1; i < indexLen; i++) {
            int left = indexes[i - 1];
            int right = indexes[i];
            int section = 0;
            int size = 0;
            for (int j = 0; j < numsLen; j++) {
                if (j >= left && j < right) {
                    section += nums[j];
                    size++;
                }
            }
            fraction += section * 1.0 / size;
        }
        return fraction;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6,7};
        int[] index = {-1, 2, 3, 4, 7};
        NSolution813 NSolution813 = new NSolution813();
    }
}
