//一个正整数如果能被 a 或 b 整除，那么它是神奇的。 
//
// 给定三个整数 n , a , b ，返回第 n 个神奇的数字。因为答案可能很大，所以返回答案 对 10⁹ + 7 取模 后的值。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 
//输入：n = 1, a = 2, b = 3
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：n = 4, a = 2, b = 3
//输出：6
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10⁹ 
// 2 <= a, b <= 4 * 10⁴ 
// 
//
// 
//
// Related Topics 数学 二分查找 👍 130 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int nthMagicalNumber(int n, int a, int b) {
        int gcm = gcm(a, b);

        int na = a / gcm;
        int nb = b / gcm;
        int length = (na + nb - 1);
        int maxVal = a * b / gcm;

        long cycle = n / length;
        long mantissa = n % length;

        long repairA = (long) Math.ceil((nb * mantissa) / (na + nb + 0.0)) * na;
        long repairB = (long) Math.ceil((na * mantissa) / (na + nb + 0.0)) * nb;

        long repair = mantissa == 0 ? 0 : Math.min(repairA, repairB) * gcm;
        return (int) ((cycle * maxVal + repair) % 1000000007);
    }

    public int gcm(int a, int b) {
        // 指定a为大数，
        if (a % b == 0) {
            return b;
        }
        return gcm(b, a % b);
    }
}
//leetcode submit region end(Prohibit modification and deletion)
