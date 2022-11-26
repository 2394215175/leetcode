//给定一个非负整数，你至多可以交换一次数字中的任意两位。返回你能得到的最大值。 
//
// 示例 1 : 
//
// 
//输入: 2736
//输出: 7236
//解释: 交换数字2和数字7。
// 
//
// 示例 2 : 
//
// 
//输入: 9973
//输出: 9973
//解释: 不需要交换。
// 
//
// 注意: 
//
// 
// 给定数字的范围是 [0, 10⁸] 
// 
//
// Related Topics 贪心 数学 👍 375 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maximumSwap(int num) {
        int maxSize = 8;
        int[] pos = new int[maxSize];

        Arrays.fill(pos, -1);
        int[] newPos = new int[maxSize];
        Arrays.fill(newPos, -1);
        for (int i = 0; i < maxSize; i++) {
            if (num / 10 != 0 || num % 10 != 0) {
                pos[i] = num % 10;
                num = num / 10;
            }
        }

        int index = 0;
        for (int i = maxSize - 1; i >= 0; i--) {
            if (pos[i] != -1) {
                newPos[index++] = pos[i];
            }
        }

        for (int i = 0; i < maxSize; i++) {
            int maxPoint = i;
            for (int j = maxSize - 1; j >= i; j--) {
                if (newPos[j] > newPos[maxPoint]) {
                    maxPoint = j;
                }
            }
            if (maxPoint != i) {
                int temp = newPos[i];
                newPos[i] = newPos[maxPoint];
                newPos[maxPoint] = temp;
                break;
            }
        }

        int newNum = 0;
        for (int i = 0; i < maxSize; i++) {
            if (newPos[i] != -1) {
                newNum = newNum * 10 + newPos[i];
            }
        }

        return newNum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
