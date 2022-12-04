package com.dengwn.leetcode.solution;

/**
 * @author dengwn
 * @date: 2022-12-04
 */
public class Solution1774 {
    public int closestCost(int[] baseCosts, int[] toppingCosts, int target) {
        int len = target + 1;
        int res = Integer.MAX_VALUE;
        boolean[] dp = new boolean[len];

        for (int i = 0; i < baseCosts.length; i++) {
            // 加0
            if (baseCosts[i] < target) {
                dp[baseCosts[i]] = true;
            } else {
                res = Math.min(baseCosts[i], res);
            }
        }

        for (int toppingCost : toppingCosts) {
            // 每种基料可以加两种辅料
            for (int count = 0; count < 2; count++) {
                // 从要凑配的目标开始反向遍历
                for (int i = target; i > 0; i--) {
                    // 进行动态规划，如果当前位置 dp 数组设置为 true, 即允许进行下一步操作的话
                    // 如果比 target 大
                    if (dp[i] && i + toppingCost > target) {
                        res = Math.min(res, i + toppingCost);
                    }
                    // 因为任意一个合法方案加上一份配料一定也是合法方案，所以 dp 数组的状态转义方程是 dp[i] = dp[i] | dp[i - t]
                    // dp[i - t] 就是去掉当前这份配料以后，有可能存在的上一份合法方案, 根据此更新 dp 数组的值
                    if (i - toppingCost > 0) {
                        dp[i] = dp[i] | dp[i - toppingCost];
                    }
                }
            }
        }

        //目前获得与target的差距
        for (int i = 0; i <= res - target && i <= target; i++) {
            if (dp[target - i]) {
                return target - i;
            }
        }
        return res;
    }


    public static void main(String[] args) {
        int[] baseCosts = {3, 10};
        int[] toppingCosts = {2, 5};
        Solution1774 solution1774 = new Solution1774();
        System.out.println(solution1774.closestCost(baseCosts, toppingCosts, 9));
    }
}
