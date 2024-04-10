package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2024-04-02
 **/
public class Solution2597 {

    int ans = 0;
    int k = 0;
    int[] nums;
    int[] vis;

    public int beautifulSubsets(int[] nums, int k) {
        this.nums = nums;
        this.k = k;
        vis = new int[1001 + 2 * k];
        dfs(0);
        return ans;
    }

    public void dfs(int i) {
        if (i == nums.length) {
            ans++;
            return;
        }
        // 不选
        dfs(i + 1);
        // 选
        int x = nums[i] + k;
        if (vis[x + k] == 0 && vis[x - k] == 0) {
            vis[nums[i]]++;
            dfs(i + 1);
            vis[nums[i]]--;
        }
    }

    public static void main(String[] args) {
        //4,2,5,9,10,3
        Solution2597 solution2597 = new Solution2597();
        System.out.println(solution2597.beautifulSubsets(new int[]{10, 4, 5, 7, 2, 1}, 3));
    }
}
