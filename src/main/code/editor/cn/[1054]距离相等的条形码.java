//在一个仓库里，有一排条形码，其中第 i 个条形码为 barcodes[i]。 
//
// 请你重新排列这些条形码，使其中任意两个相邻的条形码不能相等。 你可以返回任何满足该要求的答案，此题保证存在答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：barcodes = [1,1,1,2,2,2]
//输出：[2,1,2,1,2,1]
// 
//
// 示例 2： 
//
// 
//输入：barcodes = [1,1,1,1,2,2,3,3]
//输出：[1,3,1,3,2,1,2,1] 
//
// 
//
// 提示： 
//
// 
// 1 <= barcodes.length <= 10000 
// 1 <= barcodes[i] <= 10000 
// 
//
// Related Topics 贪心 数组 哈希表 计数 排序 堆（优先队列） 👍 92 👎 0


import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] rearrangeBarcodes(int[] barcodes) {
        Map<Integer, Integer> map = toMap(barcodes);

        int i = 0;
        while (i < barcodes.length) {
            for (Map.Entry<Integer, Integer> it : map.entrySet()) {
                for (int j = 0; j < it.getValue(); j++) {
                    barcodes[i] = it.getKey();
                    i++;
                }
            }
        }

        int[] result = new int[barcodes.length];

        int index = 1;
        for (int j = 0; j < barcodes.length; j++) {
            if (j < barcodes.length / 2 + barcodes.length % 2) {
                result[j * 2] = barcodes[j];
            } else {
                result[index] = barcodes[j];
                index = index +2;
            }
        }

        return result;
    }
    
    public static Map<Integer, Integer> toMap(int[] barcodes) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int key : barcodes) {
            map.merge(key, 1, Integer::sum);
        }
        Map<Integer, Integer> result = new LinkedHashMap<>();
        map.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> result.put(x.getKey(), x.getValue()));

        return result;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
