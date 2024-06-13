package com.dengwn.leetcode.weeklyComp.h3.d3;

import java.util.*;

/**
 * @author dengwn
 * @date: 2023-03-05
 */
public class WeeklyComp335 {
    public int passThePillow(int n, int time) {
        int[] dic = new int[2 * n - 2];
        for (int i = 0; i < 2 * n - 2; i++) {
            if (i < n) {
                dic[i] = i + 1;
            } else {
                dic[i] = 2 * n - 1 - i;
            }
        }
        return dic[time % (2 * n - 2)];
    }

    public long kthLargestLevelSum(TreeNode root, int k) {
        int index = 0;
        long[] nums = new long[100001];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                nums[index] += node.val;
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            index++;
        }
        Arrays.sort(nums);
        return nums[100001 - k];
    }


    private int[] primeList = new int[78498];

    private void init() {
        boolean[] isPrime = new boolean[1000001];
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

    public int findValidSplit(int[] nums) {
        init();
        int n = nums.length;
        List<Integer>[] lists = new List[n];
        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int index = 0;
            List<Integer> list = new ArrayList<>();
            while (num != 0 && num >= primeList[index]) {
                if (num % primeList[index] == 0) {
                    list.add(primeList[index]);
                    num /= primeList[index];
                } else {
                    index++;
                }
            }
            lists[i] = list;
        }

        List<Integer> list1 = lists[0];
        List<Integer> list2 = new ArrayList<>();
        for (int j = 1; j < n; j++) {
            list2.addAll(lists[j]);
        }
        if (Collections.disjoint(list1, list2)) {
            return 0;
        }
        for (int i = 1; i < n - 2; i++) {
            list1.addAll(lists[i]);
            list2.removeAll(lists[i]);
            if (Collections.disjoint(list1, list2)) {
                return i;
            }
        }

        return -1;
    }


    public static void main(String[] args) {
        WeeklyComp335 weeklyComp335 = new WeeklyComp335();

//        int n = 3;
//        int time = 2;
//        System.out.println(weeklyComp335.passThePillow(n, time));
//
//        TreeNode root4 = new TreeNode(4);
//        TreeNode root6 = new TreeNode(6);
//        TreeNode root2 = new TreeNode(2, root4, root6);
//        TreeNode root1 = new TreeNode(1);
//        TreeNode root8 = new TreeNode(8, root2, root1);
//        TreeNode root3 = new TreeNode(3);
//        TreeNode root7 = new TreeNode(7);
//        TreeNode root9 = new TreeNode(9, root3, root7);
//        TreeNode root5 = new TreeNode(5, root8, root9);
//        int k = 2;
//        System.out.println(weeklyComp335.kthLargestLevelSum(root5, k));

        int[] nums = {4,7,15,8,3,5};
        System.out.println(weeklyComp335.findValidSplit(nums));


    }


}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
