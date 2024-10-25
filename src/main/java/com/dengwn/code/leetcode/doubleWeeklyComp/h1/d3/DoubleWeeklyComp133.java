package com.dengwn.code.leetcode.doubleWeeklyComp.h1.d3;

import java.util.*;

/**
 * @author dengwenning
 * @since 2024/6/22
 **/
public class DoubleWeeklyComp133 {

    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int num : nums) {
            if (num % 3 != 0) {
                ans++;
            }
        }
        return ans;
    }

    public int minOperations(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            if (nums[i] == 1) {
                continue;
            } else {
                ans++;
                nums[i + 1] = nums[i + 1] == 1 ? 0 : 1;
                nums[i + 2] = nums[i + 2] == 1 ? 0 : 1;
            }
        }
        return nums[n - 1] == 1 && nums[n - 2] == 1 ? ans : -1;
    }

    public int minOperations1(int[] nums) {
        int ans = 0;
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if ((nums[i] + ans) % 2 == 0) {
                ans++;
            }
        }
        return ans;
    }

    int n;
    HashMap<Integer, Integer> require;
    int MOD = (int) 1e9 + 7;

    public int numberOfPermutations(int n, int[][] requirements) {
        this.n = n;
        require = new HashMap<>();
        for (int[] requirement : requirements) {
            require.put(requirement[0], requirement[1]);
        }
        TreeSet<Integer> used = new TreeSet<>();
        long ans = dfs(0, 0, used);
        return (int) (ans % MOD);
    }

    // i第多少个位置
    // 已经使用的元素
    // 需要的逆序对数
    HashMap<String, Long> memo = new HashMap<>();

    public long dfs(int i, int cnt, TreeSet<Integer> used) {
        if (i == n) {
            return 1;
        }
        String key = i + "_" + cnt + used.toString();
        if (memo.containsKey(key)) {
            return memo.get(key);
        }
        long ans = 0;
        int left = 0;
        for (int j = 0; j < n; j++) {

            if (!used.contains(j)) {
                // 判断加入这个之后，逆序对数是否符合
                // 看前面有多少比这个数大的数
                int mx = 0;
                for (int u : used) {
                    if (u > j) {
                        mx++;
                    }
                }
                // 如果包含这个下标的限制
                // 需要判断逆序对
                if (require.containsKey(i)) {
                    if (require.get(i) == mx + cnt) {
                        used.add(j);
                        ans += dfs(i + 1, cnt + mx, used);
                        used.remove(j);
                    }
                } else {
                    used.add(j);
                    ans += dfs(i + 1, cnt + mx, used);
                    used.remove(j);
                }
            }
        }
        memo.put(key, ans);
        return ans;
    }

    public static void main(String[] args) {
        DoubleWeeklyComp133 doubleWeeklyComp133 = new DoubleWeeklyComp133();
        int n = 3;
        int[][] requirements = {{2, 0}};
        System.out.println(doubleWeeklyComp133.numberOfPermutations(n, requirements));


    }
}
