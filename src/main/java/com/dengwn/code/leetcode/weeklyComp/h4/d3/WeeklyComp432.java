package com.dengwn.code.leetcode.weeklyComp.h4.d3;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2025/1/12
 **/
public class WeeklyComp432 {
    public List<Integer> zigzagTraversal(int[][] grid) {
        List<Integer> ans = new ArrayList<>();
        int n = grid.length;
        int m = grid[0].length;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < m; j++) {
                    if (cnt % 2 == 0) {
                        ans.add(grid[i][j]);
                    }
                    cnt++;
                }
            } else {
                for (int j = m - 1; j >= 0; j--) {
                    if (cnt % 2 == 0) {
                        ans.add(grid[i][j]);
                    }
                    cnt++;
                }
            }
        }
        return ans;
    }

    public int maximumAmount(int[][] coins) {
        int n = coins.length;
        int m = coins[0].length;
        int[][][] dp = new int[n][m][3];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                Arrays.fill(dp[i][j], Integer.MIN_VALUE / 2);
            }
        }
        dp[0][0][2] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0;
        }
        for (int i = 1; i < n; i++) {
            dp[i][0][2] = dp[i - 1][0][2] + coins[i][0];
            dp[i][0][1] = Math.max(dp[i - 1][0][2], dp[i - 1][0][1] + coins[i][0]);
            dp[i][0][0] = Math.max(dp[i - 1][0][1], dp[i - 1][0][0] + coins[i][0]);
        }
        for (int i = 1; i < m; i++) {
            dp[0][i][2] = dp[0][i - 1][2] + coins[0][i];
            dp[0][i][1] = Math.max(dp[0][i - 1][2], dp[0][i - 1][1] + coins[0][i]);
            dp[0][i][0] = Math.max(dp[0][i - 1][1], dp[0][i - 1][0] + coins[0][i]);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j][2] = Math.max(dp[i - 1][j][2], dp[i][j - 1][2]) + coins[i][j];
                int left1 = Math.max(dp[i][j - 1][2], dp[i][j - 1][1] + coins[i][j]);
                int up1 = Math.max(dp[i - 1][j][2], dp[i - 1][j][1] + coins[i][j]);
                dp[i][j][1] = Math.max(left1, up1);
                int left0 = Math.max(dp[i][j - 1][1], dp[i][j - 1][0] + coins[i][j]);
                int up0 = Math.max(dp[i - 1][j][1], dp[i - 1][j][0] + coins[i][j]);
                dp[i][j][0] = Math.max(left0, up0);
            }
        }
        return Math.max(Math.max(dp[n - 1][m - 1][2], dp[n - 1][m - 1][1]), dp[n - 1][m - 1][0]);
    }

    public int minMaxWeight(int n, int[][] edges, int threshold) {
        int max = Integer.MAX_VALUE / 2;
        List<int[]>[] list = new List[n];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int[] edge : edges) {
            list[edge[1]].add(new int[]{edge[0], edge[2]});
        }
        int[] ans = new int[n];
        Arrays.fill(ans, max);
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> ans[o1] - ans[o2]);
        queue.add(0);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                Integer cur = queue.poll();
                List<int[]> next = list[cur];
                for (int[] nx : next) {
                    int preAns = ans[cur] == max ? -1 : ans[cur];
                    if (ans[nx[0]] > preAns && ans[nx[0]] > nx[1]) {
                        ans[nx[0]] = Math.max(preAns, nx[1]);
                        queue.add(nx[0]);
                    }
                }
            }
        }
        int result = 0;
        for (int i = 1; i < n; i++) {
            result = Math.max(result, ans[i]);
        }
        return result == max ? -1 : result;
    }

    public long countNonDecreasingSubarrays(int[] nums, int k) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        int[] posR = new int[n];
        Arrays.fill(posR, n);
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            while (!st.isEmpty() && x >= nums[st.peek()]) {
                posR[st.pop()] = i;
            }
            // 循环结束后，栈顶就是左侧 > x 的最近元素了
            if (!st.isEmpty()) {
                g[st.peek()].add(i);
            }
            st.push(i);
        }

        long ans = 0;
        int cnt = 0;
        int l = 0; // 窗口左端点
        Deque<Integer> q = new ArrayDeque<>(); // 单调队列维护最大值
        for (int r = 0; r < n; r++) { // 窗口右端点
            int x = nums[r];
            // x 进入窗口
            while (!q.isEmpty() && nums[q.peekLast()] <= x) {
                q.pollLast(); // 维护 q 的单调性
            }
            q.addLast(r);

            // 由于队首到队尾单调递减，所以窗口最大值就是队首
            cnt += nums[q.peekFirst()] - x;

            // 操作次数太多，缩小窗口
            while (cnt > k) {
                int out = nums[l]; // 离开窗口的元素
                for (int i : g[l]) {
                    if (i > r) {
                        break;
                    }
                    cnt -= (out - nums[i]) * (Math.min(posR[i], r + 1) - i);
                }
                l++;

                // 队首已经离开窗口了
                if (!q.isEmpty() && q.peekFirst() < l) {
                    q.pollFirst();
                }
            }

            ans += r - l + 1;
        }

        return ans;
    }

    public static void main(String[] args) {
        WeeklyComp432 weeklyComp432 = new WeeklyComp432();

//        int[][] coins = {{-16, 8, -7, -19}, {6, 3, -10, 13}, {13, 15, 4, -3}, {-16, 4, 19, -12}};
//        System.out.println(weeklyComp432.maximumAmount(coins));

//        int[][] edges = {{1, 0, 59}, {3, 0, 43}, {3, 1, 41}, {1, 3, 6}, {3, 2, 58}, {2, 0, 76}};
//        System.out.println(weeklyComp432.minMaxWeight(5, edges, 1));

        int[] nums = {6, 3, 1, 2, 4, 4};
        System.out.println(weeklyComp432.countNonDecreasingSubarrays(nums, 7));

    }

}
