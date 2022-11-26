//给你一个大小为 n x n 的整数矩阵 grid 。 
//
// 生成一个大小为 (n - 2) x (n - 2) 的整数矩阵 maxLocal ，并满足： 
//
// 
// maxLocal[i][j] 等于 grid 中以 i + 1 行和 j + 1 列为中心的 3 x 3 矩阵中的 最大值 。 
// 
//
// 换句话说，我们希望找出 grid 中每个 3 x 3 矩阵中的最大值。 
//
// 返回生成的矩阵。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
//输出：[[9,9],[8,6]]
//解释：原矩阵和生成的矩阵如上图所示。
//注意，生成的矩阵中，每个值都对应 grid 中一个相接的 3 x 3 矩阵的最大值。 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
//输出：[[2,2,2],[2,2,2],[2,2,2]]
//解释：注意，2 包含在 grid 中每个 3 x 3 的矩阵中。
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length == grid[i].length 
// 3 <= n <= 100 
// 1 <= grid[i][j] <= 100 
// 
//
// Related Topics 数组 矩阵 👍 9 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] largestLocal(int[][] grid) {
        int length = grid.length;
        int l = length - 2;
        int[][] ints = new int[l][l];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                int val = grid[i][j];
                int rowStart = i - 2 > 0 ? i - 2 : 0;
                int listStart = j - 2 > 0 ? j - 2 : 0;
                for (int n = rowStart; n <= i; n++) {
                    for (int m = listStart; m <= j; m++) {
                        if(val > grid[n][m]){
                            grid[n][m] = val;
                        }
                    }
                }
            }
        }

        for (int i = 0; i < l; i++) {
            for (int j = 0; j < l; j++) {
                ints[i][j] = grid[i][j];
            }
        }
        return ints;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
