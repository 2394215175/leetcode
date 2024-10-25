package com.dengwn.code.leetcode.weeklyComp.h3.d4;

import java.util.HashSet;
import java.util.Set;

/**
 * @author dengwn
 * @date: 2023-06-04
 */
public class WeeklyComp348 {

    public int minimizedStringLength(String s) {
        int[] cnt = new int[26];
        int ans = 0;
        int n = s.length();
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cnt[i] > 0) {
                ans++;
            }
        }
        return ans;
    }

    public int semiOrderedPermutation(int[] nums) {
        int n = nums.length;
        if (nums[0] == 1 && nums[n - 1] == n) {
            return 0;
        }
        int index1 = 0;
        int indexN = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 1) {
                index1 = i;
            }
            if (nums[i] == n) {
                indexN = i;
            }
        }
        return index1 > indexN ? index1 + n - 2 - indexN : index1 + n - 1 - indexN;
    }

    public long matrixSumQueries(int n, int[][] queries) {
        Set<Integer> row = new HashSet<>();
        Set<Integer> col = new HashSet<>();
        int m = queries.length;
        long ans = 0;
        for (int i = m - 1; i >= 0; i--) {
            int type = queries[i][0];
            int index = queries[i][1];
            int val = queries[i][2];
            if (type == 1){
                if (!col.contains(index)){
                    ans += (long) val * (n - row.size());
                    col.add(index);
                }
            }else {
                if (!row.contains(index)){
                    ans += (long) val * (n - col.size());
                    row.add(index);
                }
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        WeeklyComp348 weeklyComp348 = new WeeklyComp348();

//        System.out.println(weeklyComp348.minimizedStringLength("aaabc"));

//        int[] nums = {2, 4, 1, 3};
//        System.out.println(weeklyComp348.semiOrderedPermutation(nums));

//        int n = 3;
//        int[][] queries = {{0, 0, 4}, {0, 1, 2}, {1, 0, 1}, {0, 2, 3}, {1, 2, 1}};
//        System.out.println(weeklyComp348.matrixSumQueries(n, queries));

    }
}
