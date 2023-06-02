package com.dengwn.leetcode.solution;

/**
 * @author: dengwn
 * @date: 2023-05-26
 **/
public class Solution1373 {
    private static int INF = 0x3F3F3F3F;

    int ans = 0;
    public int maxSumBST(TreeNode root) {
        dfs(root);
        return ans;
    }

    public SubTree dfs(TreeNode root) {
        if (root == null) {
            return new SubTree(true, -INF, INF, 0);
        }

        SubTree leftSubTree = dfs(root.left);
        SubTree rightSubTree = dfs(root.right);

        if (leftSubTree.isBST && rightSubTree.isBST && root.val > leftSubTree.maxVal && root.val < rightSubTree.minVal) {
            int sum = leftSubTree.sumVal + rightSubTree.sumVal + root.val;
            ans = Math.max(ans,sum);
            return new SubTree(true, Math.max(root.val, rightSubTree.maxVal), Math.min(root.val, leftSubTree.minVal), sum);
        }
        return new SubTree(false, INF, -INF, 0);
    }

    class SubTree {
        boolean isBST;
        int maxVal;
        int minVal;
        int sumVal;

        public SubTree() {
        }

        public SubTree(boolean isBST, int maxVal, int minVal, int sumVal) {
            this.isBST = isBST;
            this.maxVal = maxVal;
            this.minVal = minVal;
            this.sumVal = sumVal;
        }
    }
}
