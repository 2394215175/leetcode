//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 264 👎 0


import java.util.Map;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int numMatchingSubseq(String s, String[] words) {
        // 针对字符串数组去重
        HashMap<String, Integer> map = new LinkedHashMap<>();
        for (String word : words) {
            map.merge(word, 1, Integer::sum);
        }

        // 对字符串s进行下标统计，方便后续搜索
        HashMap<Character, List<Integer>> sMap = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            List<Integer> list = sMap.getOrDefault(s.charAt(i), new ArrayList<>());
            list.add(i);
            sMap.put(s.charAt(i), list);
        }

        int count = 0;

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String word = entry.getKey();
            int index = -1;
            boolean isFind = true;
            for (int i = 0; i < word.length(); i++) {
                List<Integer> list = sMap.getOrDefault(word.charAt(i), new ArrayList<>());
                int left = 0;
                int right = list.size() - 1;
                while (left < right) {
                    int mid = left + right >> 1;
                    if (list.get(mid) > index) {
                        right = mid;
                    } else {
                        left = mid + 1;
                    }
                }

                if (right < 0 || list.get(right) <= index) {
                    isFind = false;
                    break;
                } else {
                    index = list.get(right);
                }
            }

            if (isFind) {
                count = count + entry.getValue();
            }
        }
        return count;
    }

}
//leetcode submit region end(Prohibit modification and deletion)
