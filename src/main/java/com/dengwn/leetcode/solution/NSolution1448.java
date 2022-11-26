package com.dengwn.leetcode.solution;


/**
 * @author: dengwn
 * @date: 2022-11-15
 **/
public class NSolution1448 {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val, 1);
    }

    public static void main(String[] args) {
        Integer[] nums = {9, null, 3, 6};
        NSolution1448 solution1448 = new NSolution1448();
        TreeNode tree = solution1448.createTree(nums, 0);
        int i = solution1448.goodNodes(tree);
        System.out.println(i);
    }

    public TreeNode createTree(Integer[] array, int index) {
        TreeNode treeNode = null;
        if (index < array.length) {
            Integer value = array[index];
            if (value == null) {
                return null;
            }
            /*主要操作！！！*/
        /*采用递归方式，每次执行此方法，就会生成一个根节点和两个子节点a和b，
		同时子节点a再往下，创建属于a的子节点c和d，b也是同理。
		index为当前的下标。
		*/
            treeNode = new TreeNode(value);
            treeNode.left = createTree(array, 2 * index + 1);
            treeNode.right = createTree(array, 2 * index + 2);
            return treeNode;
        }
        return treeNode;
    }


    public int dfs(TreeNode root, int maxVal, int size) {
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;
        for (int i = 0; i < 2; i++) {
            if (i == 0 && leftNode != null) {
                int leftVal = leftNode.val;
                if (leftVal >= maxVal) {
                    size++;
                }
                size = dfs(leftNode, leftVal, size);
            } else if (i == 1 && rightNode != null) {
                int rightVal = rightNode.val;
                if (rightVal >= maxVal) {
                    size++;
                }
                size = dfs(rightNode, rightVal, size);
            }

        }

        return size;
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
