package com.dengwn.leetcode.weeklyComp.h4.d1;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/9/8
 **/
public class WeeklyComp414 {

    public String convertDateToBinary(String date) {
        String[] split = date.split("-");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(Integer.toBinaryString(Integer.parseInt(s)));
            sb.append("-");
        }
        return sb.substring(0, sb.length() - 1);
    }

    public int maxPossibleScore(int[] start, int d) {
        Arrays.sort(start);
        int n = start.length;
        int left = 0;
        int right = (start[n - 1] + d - start[0]) / (n - 1);
        while (left < right) {
            int mid = left + (right + 1 - left) / 2;
            if (!check(start, d, mid)) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
        return left;
    }

    public boolean check(int[] nums, int d, int ans) {
        int n = nums.length;
        int start = nums[0];
        for (int i = 1; i < n; i++) {
            if (nums[i] + d < start + ans) {
                return false;
            }
            start = Math.max(start + ans, nums[i]);
        }
        return true;
    }

    public long findMaximumScore(List<Integer> nums) {
        int n = nums.size();
        int preIndex = 0;
        long preMax = nums.get(0);
        long ans = 0;
        for (int i = 1; i < n; i++) {
            if (nums.get(i) > preMax || i == n - 1) {
                ans += (i - preIndex) * preMax;
                preMax = nums.get(i);
                preIndex = i;
            }
        }
        return ans;
    }

    int[][] dir = new int[][]{
            {1, 2}, {1, -2}, {2, 1}, {2, -1},
            {-1, 2}, {-1, -2}, {-2, 1}, {-2, -1}
    };

    int boardSize = 50;
    int[][][][] dis = new int[boardSize][boardSize][boardSize][boardSize];

    public int maxMoves(int kx, int ky, int[][] positions) {
        int n = positions.length;

        bfs(kx, ky);
        for (int[] position : positions) {
            bfs(position[0], position[1]);
        }

        // 初始化记忆化数组 memo[mask][kx][ky]
        int[][][] memo = new int[1 << n][boardSize][boardSize];
        for (int[][] twoD : memo) {
            for (int[] oneD : twoD) {
                Arrays.fill(oneD, -1);
            }
        }
        // 开始 DP，从 Alice 先手，初始 mask 是 (1 << n) - 1 表示所有兵都在棋盘上
        return dp(kx, ky, positions, (1 << n) - 1, true, memo);
    }

    // DP 解决游戏问题，Alice 先手，Bob 后手
    public int dp(int kx, int ky, int[][] positions, int mask, boolean isAlice, int[][][] memo) {
        // mask 表示剩余的兵，1 表示该兵还在棋盘上，0 表示已被吃掉
        if (mask == 0) {
            return 0;  // 没有兵时，步数为0
        }
        if (memo[mask][kx][ky] != -1) {
            return memo[mask][kx][ky];
        }

        int result = isAlice ? Integer.MIN_VALUE : Integer.MAX_VALUE;

        // 遍历所有剩余的兵，计算每个兵被吃掉的步数
        for (int i = 0; i < positions.length; i++) {
            if ((mask & (1 << i)) > 0) {
                // 检查兵 i 是否在剩余棋盘上
                // 吃掉兵 i 后的状态
                int nextMask = mask ^ (1 << i);
                int steps = dis[kx][ky][positions[i][0]][positions[i][1]];

                if (isAlice) {
                    // Alice 最大化总步数
                    result = Math.max(result, steps + dp(positions[i][0], positions[i][1], positions, nextMask, false, memo));
                } else {
                    // Bob 最小化总步数
                    result = Math.min(result, steps + dp(positions[i][0], positions[i][1], positions, nextMask, true, memo));
                }
            }
        }

        memo[mask][kx][ky] = result;
        return result;
    }

    // 计算马从 (kx, ky) 到各个点的步数
    public void bfs(int kx, int ky) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{kx, ky});
        for (int[] d : dis[kx][ky]) {
            Arrays.fill(d, Integer.MAX_VALUE);
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            steps++;
            for (int i = queue.size(); i > 0; i--) {
                int[] cur = queue.poll();
                int cx = cur[0];
                int cy = cur[1];
                // 遍历马的8个可能跳跃方向
                for (int[] move : dir) {
                    int nx = cx + move[0];
                    int ny = cy + move[1];
                    if (nx >= 0 && nx < boardSize && ny >= 0 && ny < boardSize && dis[kx][ky][nx][ny] > steps) {
                        dis[kx][ky][nx][ny] = steps;
                        queue.offer(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        WeeklyComp414 weeklyComp414 = new WeeklyComp414();

//        int ans = weeklyComp414.maxPossibleScore(new int[]{0, 9, 2, 9}, 2);
//        System.out.println(ans);

//        long ans = weeklyComp414.findMaximumScore(Arrays.asList(1, 3, 1, 5));
//        System.out.println(ans);

        int kx = 0;
        int ky = 2;
        int[][] positions = {{1, 1}, {2, 2}, {3, 3}};
        System.out.println(weeklyComp414.maxMoves(kx, ky, positions));


    }
}
