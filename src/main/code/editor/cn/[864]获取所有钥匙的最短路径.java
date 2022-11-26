//给定一个二维网格 grid ，其中： 
//
// 
// '.' 代表一个空房间 
// '#' 代表一堵 
// '@' 是起点 
// 小写字母代表钥匙 
// 大写字母代表锁 
// 
//
// 我们从起点开始出发，一次移动是指向四个基本方向之一行走一个单位空间。我们不能在网格外面行走，也无法穿过一堵墙。如果途经一个钥匙，我们就把它捡起来。除非我们
//手里有对应的钥匙，否则无法通过锁。 
//
// 假设 k 为 钥匙/锁 的个数，且满足 1 <= k <= 6，字母表中的前 k 个字母在网格中都有自己对应的一个小写和一个大写字母。换言之，每个锁有唯一
//对应的钥匙，每个钥匙也有唯一对应的锁。另外，代表钥匙和锁的字母互为大小写并按字母顺序排列。 
//
// 返回获取所有钥匙所需要的移动的最少次数。如果无法获取所有钥匙，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = ["@.a.#","###.#","b.A.B"]
//输出：8
//解释：目标是获得所有钥匙，而不是打开所有锁。
// 
//
// 示例 2： 
//
// 
//
// 
//输入：grid = ["@..aA","..B#.","....b"]
//输出：6
// 
//
// 示例 3: 
// 
// 
//输入: grid = ["@Aa"]
//输出: -1 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 30 
// grid[i][j] 只含有 '.', '#', '@', 'a'-'f' 以及 'A'-'F' 
// 钥匙的数目范围是 [1, 6] 
// 每个钥匙都对应一个 不同 的字母 
// 每个钥匙正好打开一个对应的锁 
// 
//
// Related Topics 位运算 广度优先搜索 数组 矩阵 👍 194 👎 0


import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int shortestPathAllKeys(String[] grid) {
        int row = grid.length;
        int col = grid[0].length();

        char[][] signal = new char[row][col];

        int keySize = 0;
        int begin = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                char c = grid[i].charAt(j);
                signal[i][j] = c;
                if (c == '@') {
                    begin = i * col + j;
                }
                if (c >= 'a' && c <= 'f') {
                    keySize++;
                }
            }
        }

        Set<Integer> visited = new HashSet<>();
        Queue<Integer[]> queue = new LinkedList<>();
        List<Integer> keys = new ArrayList<>();
        queue.add(new Integer[]{begin});
        visited.add(begin);

        int findKeys = 0;
        int target = 0;
        while (!queue.isEmpty()) {
            // 取出首个元素
            Integer[] current = queue.poll();
            List<Integer> next = new ArrayList<>();
            for (int i = 0; i < current.length; i++) {
                // 当前元素的横纵坐标
                int currentRow = current[i] / col;
                int currentCol = current[i] % col;


                // right
                int rightCol = currentCol + 1;
                if (rightCol < col) {
                    int right = current[i] + 1;
                    if (!visited.contains(right)) {
                        char rightVal = signal[currentRow][rightCol];
                        if (rightVal == '.') {
                            next.add(right);
                        }
                        if (rightVal >= 'a' && rightVal <= 'f') {
                            next.add(right);
                            keys.add(rightVal + 0);
                            findKeys++;
                        }
                        if (rightVal >= 'A' && rightVal <= 'F') {
                            if (keys.contains(rightVal + 32)) {
                                next.add(right);
                            }
                        }
                    }
                    visited.add(right);
                }


                // right
                int leftCol = currentCol - 1;
                if (leftCol >= 0) {
                    int left = current[i] - 1;
                    if (!visited.contains(left)) {
                        char leftVal = signal[currentRow][leftCol];
                        if (leftVal == '.') {
                            next.add(left);
                        }
                        if (leftVal >= 'a' && leftVal <= 'f') {
                            next.add(left);
                            keys.add(leftVal + 0);
                            findKeys++;
                        }
                        if (leftVal >= 'A' && leftVal <= 'F') {
                            if (keys.contains(leftVal + 32)) {
                                next.add(left);
                            }
                        }
                    }
                    visited.add(left);
                }

                // up
                int upRow = currentRow - 1;
                if (upRow >= 0) {
                    int up = current[i] - col;
                    if (!visited.contains(up)) {
                        char upVal = signal[upRow][currentCol];
                        if (upVal == '.') {
                            next.add(up);
                        }
                        if (upVal >= 'a' && upVal <= 'f') {
                            next.add(up);
                            keys.add(upVal + 0);
                            findKeys++;
                        }
                        if (upVal >= 'A' && upVal <= 'F') {
                            if (keys.contains(upVal + 32)) {
                                next.add(up);
                            }
                        }
                    }
                    visited.add(up);
                }

                // down
                int downRow = currentRow + 1;
                if (downRow < row) {
                    int down = current[i] + col;
                    if (!visited.contains(down)) {
                        char downVal = signal[downRow][currentCol];
                        if (downVal == '.') {
                            next.add(down);
                        }
                        if (downVal >= 'a' && downVal <= 'f') {
                            next.add(down);
                            keys.add(downVal + 0);
                            findKeys++;
                        }
                        if (downVal >= 'A' && downVal <= 'F') {
                            if (keys.contains(downVal + 32)) {
                                next.add(down);
                            }
                        }
                    }
                    visited.add(down);
                }
            }

            if(!next.isEmpty()){
                queue.add(next.toArray(new Integer[next.size()]));
            }

            target++;
            if (findKeys == keySize) {
                return target;
            }
        }
        return -1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
