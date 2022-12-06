//给定一个排序的整数数组 nums ，其中元素的范围在 闭区间 [lower, upper] 当中，返回不包含在数组中的缺失区间。 
//
// 示例： 
//
// 输入: nums = [0, 1, 3, 50, 75], lower = 0 和 upper = 99,
//输出: ["2", "4->49", "51->74", "76->99"]
// 
//
// Related Topics 数组 👍 98 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int length = nums.length;
        List<String> res = new ArrayList<>();

        for (int i = 0; i <= length; i++) {
            int left = i - 1 < 0 ? lower : nums[i - 1] + 1;
            int right = i == length ? upper : nums[i] - 1;
            StringBuilder stringBuilder = new StringBuilder();
            if (left > right) {
                continue;
            } else if (left == right) {
                res.add(stringBuilder.append(left).toString());
            } else {
                res.add(stringBuilder.append(left).append("->").append(right).toString());
            }
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
