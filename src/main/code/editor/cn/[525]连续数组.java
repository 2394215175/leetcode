//给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: nums = [0,1]
//输出: 2
//说明: [0, 1] 是具有相同数量 0 和 1 的最长连续子数组。 
//
// 示例 2: 
//
// 
//输入: nums = [0,1,0]
//输出: 2
//说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 10⁵ 
// nums[i] 不是 0 就是 1 
// 
//
// Related Topics 数组 哈希表 前缀和 👍 598 👎 0


import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int findMaxLength(int[] nums) {
        int length = nums.length;
        int maxLength = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int counter = 0;
        for (int i = 0; i < length; i++) {
            counter = nums[i] == 0 ? counter - 1 : counter + 1;

            Integer preIndex = map.get(counter);
            if (preIndex != null) {
                maxLength = Math.max(maxLength, i - preIndex);
            } else {
                map.put(counter, i);
            }
        }

        return maxLength;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
