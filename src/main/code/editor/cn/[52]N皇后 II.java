//n 皇后问题 研究的是如何将 n 个皇后放置在 n × n 的棋盘上，并且使皇后彼此之间不能相互攻击。 
//
// 给你一个整数 n ，返回 n 皇后问题 不同的解决方案的数量。 
//
// 
//
// 
// 
// 示例 1： 
// 
// 
//输入：n = 4
//输出：2
//解释：如上图所示，4 皇后问题存在两个不同的解法。
// 
// 
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 9 
// 
//
// Related Topics 回溯 👍 404 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    /**
     * 摆放方案的个数
     */
    int count = 0;

    public int totalNQueens(int n) {
        dfs(0, n, new int[n]);
        return count;
    }

    public void dfs(int n, int max, int[] arr) {
        if (n == max) {
            count++;
            return;
        }
        // 对每个皇后，都依次去尝试摆放在每一列
        for (int i = 0; i < max; i++) {
            arr[n] = i;
            // 判断这个皇后摆放位置是否冲突
            if (isValid(n, arr)) {
                // 如果当前位置不冲突，继续递归，摆放下一个皇后
                dfs(n + 1, max, arr);
            }
            // 如果发生冲突，进入下一轮循环，尝试摆放在下一列
        }
    }

    public boolean isValid(int n, int[] arr) {
        for (int i = 0; i < n; i++) {
            // 判断是否在同一列，或一条对角线上
            if (arr[i] == arr[n] || Math.abs(n - i) == Math.abs(arr[i] - arr[n])) {
                return false;
            }
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
