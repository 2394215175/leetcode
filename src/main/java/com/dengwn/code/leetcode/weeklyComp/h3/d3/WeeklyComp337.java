package com.dengwn.code.leetcode.weeklyComp.h3.d3;

/**
 * @author dengwn
 * @date: 2023-03-19
 */
public class WeeklyComp337 {
    public int[] evenOddBit(int n) {
        int index = 0;
        int even = 0;
        int odd = 0;
        while (n > 0) {
            if (n % 2 == 1) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            n /= 2;
            index++;
        }
        return new int[]{even, odd};
    }

    int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
    int[] dy = {-1, -2, -2, -1, 1, 2, 2, 1};

    public boolean checkValidGrid(int[][] grid) {
        int n = grid.length;
        int end = n * n - 1;
        return dfs(grid, 0, end, 0, 0);
    }

    public boolean dfs(int[][] grid, int step, int end, int x, int y) {
        if (step == end) {
            return true;
        }
        boolean flag = false;
        for (int i = 0; i < 8; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            int nStep = step + 1;
            if (nx >= 0 && nx < grid.length && ny >= 0 && ny < grid[0].length && grid[nx][ny] == nStep) {
                flag = dfs(grid, nStep, end, nx, ny);
            }
        }
        return flag;
    }

    public int beautifulSubsets(int[] nums, int k) {
        int n = nums.length;
        int ans = 0;
        boolean[] isBeautiful = new boolean[1 << n];
        isBeautiful[0] = true;
        for (int i = 1; i < 1 << n; i++) {
            int temp = i;
            // index 为新加入的位
            int index = 0;
            while (temp > 0) {
                temp /= 2;
                index++;
            }
            int mask = ~(1 << (index - 1));
            int ln = i & mask;
            // 没加入index之前是可行的，加入后判断index和每一位的差是否为k
            if (isBeautiful[ln]) {
                int newVal = nums[index - 1];
                int t = i;
                int j = 0;
                boolean flag = true;
                while (t > 0) {
                    if (t % 2 == 1 && Math.abs(newVal - nums[j]) == k) {
                        flag = false;
                        break;
                    }
                    t /= 2;
                    j++;
                }
                if (flag) {
                    isBeautiful[i] = true;
                    ans++;
                }
            }
        }
        return ans;
    }

    public int findSmallestInteger(int[] nums, int value) {
        int n = nums.length;
        int[] mods = new int[value];
        for (int num : nums) {
            int i = num % value;
            if (i < 0) {
                i += value;
            }
            mods[i]++;
        }
        int ans = 0;
        for (; ans < n; ans++) {
            if (mods[ans % value] > 0) {
                mods[ans % value]--;
            } else {
                break;
            }
        }

        return ans;
    }


    public static void main(String[] args) {
        WeeklyComp337 weeklyComp337 = new WeeklyComp337();

//        System.out.println(Arrays.toString(weeklyComp337.evenOddBit(17)));
//
//        int[][] grid = {{0, 3, 6}, {5, 8, 1}, {2, 7, 4}};
//        System.out.println(weeklyComp337.checkValidGrid(grid));

//        int[] nums = {1};
//        int k = 1;
//        System.out.println(weeklyComp337.beautifulSubsets(nums, k));

        int[] nums = {1, -10, 7, 13, 6, 8};
        int value = 7;
        System.out.println(weeklyComp337.findSmallestInteger(nums, value));

    }
}
