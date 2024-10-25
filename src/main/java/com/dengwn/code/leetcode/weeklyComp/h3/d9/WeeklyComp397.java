package com.dengwn.code.leetcode.weeklyComp.h3.d9;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dengwenning
 * @since 2024/6/4
 **/
public class WeeklyComp397 {

    public int findPermutationDifference(String s, String t) {
        int[] a = new int[26];
        int[] b = new int[26];
        for (int i = 0; i < s.length(); i++) {
            a[s.charAt(i) - 'a'] = i;
            b[t.charAt(i) - 'a'] = i;
        }
        int ans = 0;
        for (int i = 0; i < 26; i++) {
            ans += Math.abs(a[i] - b[i]);
        }
        return ans;
    }

    public int maximumEnergy(int[] energy, int k) {
        int[] res = new int[k];
        long n = energy.length;
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int index = (int) ((k - i - 1 + n * k) % k);
            res[index] += energy[(int) n - i - 1];
            ans = Math.max(ans, res[index]);
        }
        return ans;
    }

    public int maxScore(List<List<Integer>> grid) {
        int n = grid.size();
        int m = grid.get(0).size();
        int[][] f = new int[n][m];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int left = i - 1 >= 0 ? f[i - 1][j] : Integer.MAX_VALUE;
                int up = j - 1 >= 0 ? f[i][j - 1] : Integer.MAX_VALUE;
                int min = Math.min(left, up);
                ans = Math.max(ans, grid.get(i).get(j) - min);
                f[i][j] = Math.min(grid.get(i).get(j), min);
            }
        }
        return ans;
    }

    public int[] findPermutation(int[] nums) {
        // todo
        return null;
    }

    public static void main(String[] args) {
        WeeklyComp397 weeklyComp397 = new WeeklyComp397();

        System.out.println(weeklyComp397.findPermutationDifference("abc", "bac"));

        int[][] grid = {{9, 5, 7, 3}, {8, 9, 6, 1}, {6, 7, 14, 3}, {2, 5, 3, 1}};
        List<List<Integer>> lists = new ArrayList<>();
        for (int[] ints : grid) {
            List<Integer> list = new ArrayList<>();
            for (int i : ints) {
                list.add(i);
            }
            lists.add(list);
        }
        System.out.println(weeklyComp397.maxScore(lists));


    }
}
