package com.dengwn.code.leetcode.solution.t0.h0.d7;

/**
 * @author: dengwn
 * @date: 2023-01-29
 **/
public class Solution74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int n = matrix.length;
        int m = matrix[0].length;
        int left = 0;
        int right = n * m - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (matrix[mid / m][mid % m] == target) {
                return true;
            } else if (matrix[mid / m][mid % m] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution74 solution74 = new Solution74();
        int[][] matrix = {{1,3,5,7},{10,11,16,20},{23,30,34,60}};
        System.out.println(solution74.searchMatrix(matrix,3));
    }
}
