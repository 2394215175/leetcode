//给你一个整数数组 nums 和一个整数 k 。你需要找到 nums 中长度为 k 的 子序列 ，且这个子序列的 和最大 。 
//
// 请你返回 任意 一个长度为 k 的整数子序列。 
//
// 子序列 定义为从一个数组里删除一些元素后，不改变剩下元素的顺序得到的数组。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [2,1,3,3], k = 2
//输出：[3,3]
//解释：
//子序列有最大和：3 + 3 = 6 。 
//
// 示例 2： 
//
// 输入：nums = [-1,-2,3,4], k = 3
//输出：[-1,3,4]
//解释：
//子序列有最大和：-1 + 3 + 4 = 6 。
// 
//
// 示例 3： 
//
// 输入：nums = [3,4,3,3], k = 2
//输出：[3,4]
//解释：
//子序列有最大和：3 + 4 = 7 。
//另一个可行的子序列为 [4, 3] 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 1000 
// -10⁵ <= nums[i] <= 10⁵ 
// 1 <= k <= nums.length 
// 
//
// Related Topics 数组 哈希表 排序 堆（优先队列） 👍 27 👎 0


import javafx.util.Pair;

import java.util.Queue;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] maxSubsequence(int[] nums, int k) {
        int length = nums.length;
        int[] res = new int[k];
        Queue<Pair<Integer, Integer>> queue1 = new PriorityQueue<>(k, (a, b) -> b.getValue() - a.getValue());
        Queue<Pair<Integer, Integer>> queue2 = new PriorityQueue<>(k, Comparator.comparingInt(Pair::getKey));

        for (int i = 0; i < length; i++) {
            queue1.add(new Pair<>(i, nums[i]));
        }

        for (int i = 0; i < k; i++) {
            queue2.add(queue1.poll());
        }

        for (int i = 0; i < k; i++) {
            res[i] = queue2.poll().getValue();
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
