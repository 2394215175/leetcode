package com.dengwn.leetcode.weeklyComp.h4.d1;

import java.util.Arrays;

/**
 * @author dengwenning
 * @since 2024/7/28
 **/
public class WeeklyComp408 {

    public boolean canAliceWin(int[] nums) {
        int two = 0;
        int one = 0;
        for (int num : nums) {
            if (num < 10) {
                one += num;
            } else {
                two += num;
            }
        }
        return one == two;
    }


    private int[] init(int n) {
        int[] primeList = new int[150000];
        boolean[] isPrime = new boolean[n + 1];
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
        return Arrays.copyOfRange(primeList, 0, index);
    }

    public int nonSpecialCount(int l, int r) {
        int[] init1 = init((int) Math.sqrt(l - 1));
        int[] init2 = init((int) Math.sqrt(r));

        return r - l + 1 - (init2.length - init1.length);
    }

    public int numberOfSubstrings(String s) {
        int n = s.length();
        int ans = 0;
        int pre1 = 0;
        int[] cnt0 = new int[n + 1];
        cnt0[0] = Integer.MIN_VALUE / 2;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') {
                ans++;
                if (pre1 < 4 && pre1 != 0) {
                    cnt0[i + 1] = Math.max(0, cnt0[i - pre1] + 4 - pre1);
                }
                ans += cnt0[i + 1];
                pre1 = 0;
            } else {
                cnt0[i + 1] = Math.max(0, cnt0[i - pre1] - 1);
                ans += cnt0[i + 1];
                pre1++;
            }
        }
        long sum = (long) n * (n - 1) / 2;
        return (int) (sum - ans);
    }

    static class UnionFind {
        int[] parent;
        int[][] circles;

        public UnionFind(int size, int[][] circles) {
            parent = new int[size];
            for (int i = 0; i < size; i++) {
                parent[i] = i;
            }
            this.circles = circles;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public void union(int x, int y) {
            int rootX = find(x);
            int rootY = find(y);
            if (rootX != rootY) {
                parent[rootX] = rootY;
            }
        }
    }

    public boolean canReachCorner(int X, int Y, int[][] circles) {
        // 计算多个圆形最上面的点和最下面的点
        int n = circles.length;
        UnionFind uf = new UnionFind(n, circles);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int x1 = circles[i][0], y1 = circles[i][1], r1 = circles[i][2];
                int x2 = circles[j][0], y2 = circles[j][1], r2 = circles[j][2];
                if ((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= r1 + r2) {
                    uf.union(i, j);
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WeeklyComp408 weeklycomp408 = new WeeklyComp408();

//        System.out.println(weeklycomp408.nonSpecialCount(5, 7));

        System.out.println(weeklycomp408.numberOfSubstrings("00011"));
//
//        int X = 3, Y = 3;
//        int[][] circles = {{2, 1, 1}, {1, 2, 1}};
//        System.out.println(weeklycomp408.canReachCorner(X, Y, circles));


    }
}
