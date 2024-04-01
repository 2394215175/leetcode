package com.dengwn.leetcode.weeklyComp;

/**
 * @author: dengwn
 * @date: 2024-03-31
 **/
public class WeeklyComp391 {

    public int sumOfTheDigitsOfHarshadNumber(int x) {
        int temp = x;
        int sum = 0;
        while (x > 0) {
            sum += x % 10;
            x /= 10;
        }
        return temp % sum == 0 ? sum : -1;
    }

    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int sum = 0;
        int empty = 0;
        while (numBottles > 0) {
            sum += numBottles;
            empty += numBottles;
            numBottles = 0;
            while (empty >= numExchange) {
                empty -= numExchange;
                numExchange++;
                numBottles++;
            }
        }
        return sum;
    }

    public long countAlternatingSubarrays(int[] nums) {
        int n = nums.length;
        long ans = 0;
        int pre = 0;
        int preNum = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] != preNum) {
                ans += i - pre;
            } else {
                pre = i;
            }
            ans += 1;
            preNum = nums[i];
        }
        return ans;
    }

    public int minimumDistance(int[][] points) {
        int[][] minAndMax = getMinAndMax(points, -1);
        int ans = Integer.MAX_VALUE;
        for (int[] temp : minAndMax) {
            int[][] diff = getMinAndMax(points, temp[1]);
            int minMax = Math.max(diff[0][0] - diff[1][0], diff[2][0] - diff[3][0]);
            ans = Math.min(ans, minMax);
        }
        return ans;
    }

    public int[][] getMinAndMax(int[][] points, int index) {
        int n = points.length;
        int[][] ans = new int[4][2];
        ans[0][0] = Integer.MIN_VALUE;
        ans[1][0] = Integer.MAX_VALUE;
        ans[2][0] = Integer.MIN_VALUE;
        ans[3][0] = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            if (i == index) {
                continue;
            }
            int xy = points[i][0] + points[i][1];
            if (xy > ans[0][0]) {
                ans[0][0] = xy;
                ans[0][1] = i;
            }
            if (xy < ans[1][0]) {
                ans[1][0] = xy;
                ans[1][1] = i;
            }
            int yx = points[i][1] - points[i][0];
            if (yx > ans[2][0]) {
                ans[2][0] = yx;
                ans[2][1] = i;
            }
            if (yx < ans[3][0]) {
                ans[3][0] = yx;
                ans[3][1] = i;
            }
        }
        return ans;
    }


    public static void main(String[] args) {
        WeeklyComp391 weeklyComp391 = new WeeklyComp391();

//        System.out.println(weeklyComp391.sumOfTheDigitsOfHarshadNumber(23));

//        System.out.println(weeklyComp391.maxBottlesDrunk(13, 6));

//        System.out.println(weeklyComp391.countAlternatingSubarrays(new int[]{1, 0, 1, 1, 1}));

        System.out.println(weeklyComp391.minimumDistance(new int[][]{{3, 10}, {5, 15}, {10, 2}, {4, 4}}));
    }
}
