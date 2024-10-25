package com.dengwn.code.leetcode.solution.t3.h1.d7;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author dengwenning
 * @since 2024/9/6
 **/
public class Solution3176 {
    public int maximumLength(int[] nums, int k) {
        int n = nums.length;
        // 以num结尾的最大长度
        int ans = 0;
        int[][] f = new int[n][k + 1];
        // 第一个存相等时的最大值，第二个存不相等时的最大值，第三个前一个值
        int[][] max = new int[k + 1][3];
        for (int i = 0; i < n; i++) {
            for (int h = k; h >= 0; h--) {
                f[i][h] = 1;

                if (nums[i] == max[h][2]) {
                    f[i][h] = Math.max(f[i][h], max[h][0] + 1);
                    if (f[i][h] > max[h][0]) {
                        max[h][0] = f[i][h];
                    }
                } else {
                    if (h > 0) {
                        f[i][h] = Math.max(f[i][h], max[h - 1][1] + 1);
                    }
                    if (f[i][h] > max[h][0]) {
                        max[h][2] = nums[i];
                        max[h][1] = max[h][0];
                        max[h][0] = f[i][h];
                    } else if (f[i][h] > max[h][1]) {
                        max[h][1] = f[i][h];
                    }
                }
            }
            ans = Math.max(ans, f[i][k]);
        }
        return ans;
    }

    public int maximumLength1(int[] nums, int k) {
        Map<Integer, int[]> fs = new HashMap<>();
        int[][] records = new int[k + 1][3];
        for (int x : nums) {
            int[] f = fs.computeIfAbsent(x, i -> new int[k + 1]);
            for (int j = k; j >= 0; j--) {
                f[j]++;
                if (j > 0) {
                    int mx = records[j - 1][0], mx2 = records[j - 1][1], num = records[j - 1][2];
                    f[j] = Math.max(f[j], (x != num ? mx : mx2) + 1);
                }

                // records[j] 维护 fs[.][j] 的 mx, mx2, num
                int v = f[j];
                int[] p = records[j];
                if (v > p[0]) {
                    if (x != p[2]) {
                        p[2] = x;
                        p[1] = p[0];
                    }
                    p[0] = v;
                } else if (x != p[2] && v > p[1]) {
                    p[1] = v;
                }
            }
        }
        return records[k][0];
    }


    public static void main(String[] args) {
        Solution3176 solution = new Solution3176();
        System.out.println(solution.maximumLength1(new int[]{23, 18, 18}, 0));
    }
}
