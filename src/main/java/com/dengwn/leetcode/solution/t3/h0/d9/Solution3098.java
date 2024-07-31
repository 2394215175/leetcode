package com.dengwn.leetcode.solution.t3.h0.d9;

import javafx.util.Pair;

import java.util.Arrays;
import java.util.HashMap;

/**
 * @author dengwenning
 * @since 2024/7/24
 **/
public class Solution3098 {
    int MOD = (int) 1e9 + 7;

    int n;
    int[] nums;
    HashMap<Long, Integer> map;

    public int sumOfPowers(int[] nums, int k) {
        this.n = nums.length;
        this.nums = nums;
        map = new HashMap<>();
        Arrays.sort(nums);

        return dfs(0, n, k, Integer.MAX_VALUE);
    }

    public int dfs(int i, int j, int k, int min) {
        if (i >= n) {
            return k == 0 ? min : 0;
        }
        if (n - i < k) {
            return 0;
        }
        long key = ((long) min) << 18 | (i << 12) | (j << 6) | k;
        if (map.containsKey(key)) {
            return map.get(key);
        }
        int ans = dfs(i + 1, j, k, min);
        if (j == n) {
            ans += dfs(i + 1, i, k - 1, min);
        } else {
            int diff = nums[i] - nums[j];
            if (diff < min) {
                ans += dfs(i + 1, i, k - 1, diff);
            } else {
                ans += dfs(i + 1, i, k - 1, min);
            }
        }
        ans %= MOD;
        map.put(key, ans);
        return ans;
    }
}
