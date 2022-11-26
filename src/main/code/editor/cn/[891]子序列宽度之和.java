//一个序列的 宽度 定义为该序列中最大元素和最小元素的差值。 
//
// 给你一个整数数组 nums ，返回 nums 的所有非空 子序列 的 宽度之和 。由于答案可能非常大，请返回对 10⁹ + 7 取余 后的结果。 
//
// 子序列 定义为从一个数组里删除一些（或者不删除）元素，但不改变剩下元素的顺序得到的数组。例如，[3,6,2,7] 就是数组 [0,3,1,6,2,2,7]
// 的一个子序列。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,1,3]
//输出：6
//解释：子序列为 [1], [2], [3], [2,1], [2,3], [1,3], [2,1,3] 。
//相应的宽度是 0, 0, 0, 1, 1, 2, 2 。
//宽度之和是 6 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [2]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// 1 <= nums[i] <= 10⁵ 
// 
//
// Related Topics 数组 数学 排序 👍 113 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int sumSubseqWidths(int[] nums) {
        int len = nums.length;
        Arrays.sort(nums);

        long sum = 0;
        int[] remainders = new int[len];
        remainders[0] = 1;
        for (int i = 1; i < len; i++) {
            remainders[i] = remainders[i - 1] * 2 % 1000000007;
        }

        for (int i = 0; i < nums.length; i++) {
            //当在0这个下标
            // 需要加上0 即2的0次方-1*num[0]
            // 需要减去2的len-i-1此方-1*num[0]

            //当在1这个下标
            //需要加上 2的1次方-1*num[1]
            //需要减去2的len-i-1次方*nums[1]
            sum += (long) (remainders[i] - remainders[len - i - 1]) * nums[i];
            sum %= 1000000007;

        }
        return (int) sum;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
