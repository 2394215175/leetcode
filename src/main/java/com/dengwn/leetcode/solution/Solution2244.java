package com.dengwn.leetcode.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dengwenning
 * @since 2024/5/14
 **/
public class Solution2244 {
    public int minimumRounds(int[] tasks) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int task : tasks) {
            map.merge(task, 1, Integer::sum);
        }
        int ans = 0;
        for (Integer value : map.values()) {
            if (value == 1) {
                return -1;
            }
            if (value <= 3) {
                ans++;
                continue;
            }
            ans += (value + 2) / 3;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution2244 solution2244 = new Solution2244();
        System.out.println(solution2244.minimumRounds(new int[]{2, 2, 3, 3, 2, 4, 4, 4, 4, 4}));
    }
}
