//有时候人们会用重复写一些字母来表示额外的感受，比如 "hello" -> "heeellooo", "hi" -> "hiii"。我们将相邻字母都相同的一串
//字符定义为相同字母组，例如："h", "eee", "ll", "ooo"。 
//
// 对于一个给定的字符串 S ，如果另一个单词能够通过将一些字母组扩张从而使其和 S 相同，我们将这个单词定义为可扩张的（stretchy）。扩张操作定义如下
//：选择一个字母组（包含字母 c ），然后往其中添加相同的字母 c 使其长度达到 3 或以上。 
//
// 例如，以 "hello" 为例，我们可以对字母组 "o" 扩张得到 "hellooo"，但是无法以同样的方法得到 "helloo" 因为字母组 "oo" 
//长度小于 3。此外，我们可以进行另一种扩张 "ll" -> "lllll" 以获得 "helllllooo"。如果 s = "helllllooo"，那么查询词
// "hello" 是可扩张的，因为可以对它执行这两种扩张操作使得 query = "hello" -> "hellooo" -> "helllllooo" = 
//s。 
//
// 输入一组查询单词，输出其中可扩张的单词数量。 
//
// 
//
// 示例： 
//
// 
//输入： 
//s = "heeellooo"
//words = ["hello", "hi", "helo"]
//输出：1
//解释：
//我们能通过扩张 "hello" 的 "e" 和 "o" 来得到 "heeellooo"。
//我们不能通过扩张 "helo" 来得到 "heeellooo" 因为 "ll" 的长度小于 3 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length, words.length <= 100 
// 1 <= words[i].length <= 100 
// s 和所有在 words 中的单词都只由小写字母组成。 
// 
//
// Related Topics 数组 双指针 字符串 👍 94 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int expressiveWords(String s, String[] words) {
        int count = 0;
        for (String word : words) {
            if (isExpansion(word, s)) {
                count++;
            }
        }
        return count;
    }

    public boolean isExpansion(String word, String s) {
        int wLen = word.length();
        int sLen = s.length();
        if (wLen > sLen) {
            return false;
        }

        int i = 0;
        int j = 0;
        int countI = 0;
        int countJ = 0;
        while (i < sLen && j < wLen) {
            char c1 = s.charAt(i);
            char c2 = word.charAt(j);

            while (i < sLen) {
                if (c1 == s.charAt(i)) {
                    countI++;
                    i++;
                } else {
                    break;
                }
            }
            while (j < wLen) {
                if (c2 == word.charAt(j)) {
                    countJ++;
                    j++;
                } else {
                    break;
                }
            }
            if (c1 == c2) {
                if (countJ > countI) {
                    return false;
                }
                if (countI != countJ && countI == 2) {
                    return false;
                }
            } else {
                return false;
            }
            countI = 0;
            countJ = 0;
        }
        return i == sLen && j == wLen;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
