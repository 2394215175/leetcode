package com.dengwn.leetcode.weeklyComp;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-03-26
 */
public class WeeklyComp338 {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        } else if (k <= numOnes + numZeros) {
            return numOnes;
        } else {
            return numOnes - (k - numOnes - numZeros);
        }
    }


    private int[] primeList = new int[168];

    private void init() {
        boolean[] isPrime = new boolean[1001];
        Arrays.fill(isPrime, true);
        int index = 0;

        for (int i = 2; i < isPrime.length; i++) {
            if (isPrime[i]) {
                for (int j = 2; i * j < isPrime.length; j++) {
                    isPrime[i * j] = false;
                }
                primeList[index++] = i;
            }
        }
    }

    public boolean primeSubOperation(int[] nums) {
        init();
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            for (int j = primeList.length - 1; j >= 0; j--) {
                if (primeList[j] < nums[i - 1] - dp[i - 1]) {
                    dp[i] = nums[i - 1] - primeList[j];
                    break;
                }
            }
            if (dp[i] == 0) {
                dp[i] = nums[i - 1];
            }
        }

        for (int i = 1; i < n + 1; i++) {
            if (dp[i] <= dp[i - 1]) {
                return false;
            }
        }
        return true;
    }


    public List<Long> minOperations(int[] nums, int[] queries) {
        int n = nums.length;
        Arrays.sort(nums);
        long[] prefix = new long[n + 1];
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = nums[i - 1] + prefix[i - 1];
        }


        List<Long> ans = new ArrayList<>();
        for (int query : queries) {
            int index = findInsert(nums, query);
            long left = (long) query * (index + 1) - prefix[index + 1];
            long right = prefix[n] - prefix[index + 1] - (long) query * (n - index - 1);
            ans.add(Math.abs(left) + Math.abs(right));
        }
        return ans;
    }

    public int findInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target && nums[mid + 1] > target) {
                return mid;
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    // 从0出发看能不能搜到结果
    public int collectTheCoins(int[] coins, int[][] edges) {
        int n = coins.length;
        int sum = 0;
        for (int coin : coins) {
            if (coin == 1) {
                sum++;
            }
        }

        Set<Integer>[][] lists = new Set[n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                lists[i][j] = new HashSet<>();
            }
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            lists[a][0].add(b);
            lists[b][0].add(a);
        }

        for (Set<Integer>[] list : lists) {
            Set<Integer> second = new HashSet<>();
            for (Integer first : list[0]) {
                second.addAll(lists[first][0]);
            }
            list[1] = second;
        }



        return 0;
    }



    public static void main(String[] args) {
        WeeklyComp338 weeklyComp338 = new WeeklyComp338();

//        int numOnes = 3;
//        int numZeros = 2;
//        int numNegOnes = 0;
//        int k = 4;
//        System.out.println(weeklyComp338.kItemsWithMaximumSum(numOnes,numZeros,numNegOnes,k));
//
//        int[] nums = {998,2};
//        System.out.println(weeklyComp338.primeSubOperation(nums));

//        int[] nums = {47,50,97,58,87,72,41,63,41,51,17,21,7,100,69,66,79,92,84,9,57,26,26,28,83,38};
//        int[] queries = {50,84,76,41,64,82,20,22,64,7,38,92,39,28,22,3,41,46,47,50,88,51,9,49,38,67,26,65,89,27,71,25,77,72,65,41,84,68,51,26,84,24,79,41,96,83,92,9,93,84,35,70,74,79,37,38,26,26,41,26};
//        System.out.println(weeklyComp338.minOperations(nums,queries));

        int[] coins = {0, 0, 0, 1, 1, 0, 0, 1};
        int[][] edges = {{0, 1}, {0, 2}, {1, 3}, {1, 4}, {2, 5}, {5, 6}, {5, 7}};
        System.out.println(weeklyComp338.collectTheCoins(coins, edges));
    }
}
