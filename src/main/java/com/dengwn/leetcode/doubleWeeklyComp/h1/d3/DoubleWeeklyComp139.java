package com.dengwn.leetcode.doubleWeeklyComp.h1.d3;

import java.util.*;

/**
 *
 * @author dengwenning
 * @since 2024/9/14
 **/
public class DoubleWeeklyComp139 {

    public List<Integer> stableMountains(int[] height, int threshold) {
        List<Integer> ans = new ArrayList<>();
        int n = height.length;
        for (int i = 1; i < n; i++) {
            if (height[i - 1] > threshold) {
                ans.add(i);
            }
        }
        return ans;
    }

    int[][] d = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public boolean findSafeWalk(List<List<Integer>> grid, int health) {
        int n = grid.size();
        int m = grid.get(0).size();

        int[][] visited = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(visited[i], -1);
        }
        visited[0][0] = health - grid.get(0).get(0);

        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0, 0, visited[0][0]});

        // 访问矩阵，记录到达每个格子时的最大健康值

        // 开始广度优先搜索
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[0], y = current[1], currentHealth = current[2];

            // 如果到达终点且健康值为正数，返回true
            if (x == n - 1 && y == m - 1 && currentHealth > 0) {
                return true;
            }

            // 尝试向四个方向移动
            for (int[] direction : d) {
                int nx = x + direction[0];
                int ny = y + direction[1];

                // 检查是否在矩形范围内
                if (nx >= 0 && nx < n && ny >= 0 && ny < m) {
                    // 计算进入这个格子后的健康值
                    int nextHealth = currentHealth - grid.get(nx).get(ny);
                    // 只有当健康值大于0且比之前访问时更高时，才进入这个格子
                    if (nextHealth > 0 && nextHealth > visited[nx][ny]) {
                        visited[nx][ny] = nextHealth;
                        queue.offer(new int[]{nx, ny, nextHealth});
                    }
                }
            }
        }

        // 如果无法到达终点，返回false
        return false;
    }

    public int maxValue(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        for (int i = 0; i < n - 2 * k + 1; i++) {
            int index = i + k;
            int[] nums1 = new int[n];
            int[] nums2 = new int[n];
            for (int j = 0; j < n; j++) {
                if (j < index) {
                    nums1[j] = nums[j];
                } else {
                    nums2[j] = nums[j];
                }
            }
            Arrays.sort(nums1);
            Arrays.sort(nums2);
            int max1 = getMaxOrValue(nums1, k) ^ getMinOrValue(nums2, k);
            int max2 = getMinOrValue(nums1, k) ^ getMaxOrValue(nums2, k);
            ans = Math.max(ans, Math.max(max1, max2));
        }
        return ans;
    }

    // 计算前 m 个数中，选 k 个数进行 OR 运算的最大值
    public int getMaxOrValue(int[] nums, int k) {
        int n = nums.length;
        int ans = nums[n - 1];
        k--;
        for (int i = n - 2; i >= 0; i--) {
            if ((ans | nums[i]) > 0) {
                ans |= nums[i];
                k--;
            }
        }
        return ans;
    }

    // 计算前 m 个数中，选 k 个数进行 OR 运算的最小值
    public int getMinOrValue(int[] nums, int k) {
        int ans = 0;
        int i = 0;
        while (k > 0) {
            if (nums[i] > 0) {
                ans |= nums[i];
                k--;
            }
            i++;
        }
        return ans;
    }


    public static void main(String[] args) {
        DoubleWeeklyComp139 weeklyComp139 = new DoubleWeeklyComp139();

//        List<List<Integer>> grid = Arrays.asList(
//                Arrays.asList(1, 1, 1, 1)
//        );
//        int health = 4;
//        System.out.println(weeklyComp139.findSafeWalk(grid, health));

        int[] nums = {4, 2, 5, 6, 7};
        System.out.println(weeklyComp139.maxValue(nums, 2));

    }
}
