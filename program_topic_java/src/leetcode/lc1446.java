package leetcode;

/**
 * 给你一个字符串s,字符串的能量定义为:只包含一种字符的最长非空子字符串的长度。
 * 请你返回字符串 s 的 能量。
 *
 * 示例 1：
 * 输入：s = "leetcode"
 * 输出：2
 * 解释：子字符串 "ee" 长度为 2 ，只包含字符 'e' 。
 *
 * 示例 2：
 * 输入：s = "abbcccddddeeeeedcba"
 * 输出：5
 * 解释：子字符串 "eeeee" 长度为 5 ，只包含字符 'e' 。
 *
 * 提示：
 * 1 <= s.length <= 500
 * s 只包含小写英文字母。
 */
public class lc1446 {
    /*
    时间复杂度：O(n)，其中n是字符串s的长度。遍历一次s的时间复杂度为O(n)。
    空间复杂度：O(1)。只需要常数的空间保存若干变量。
     */
    public int maxPower(String s) {
        int size = s.length();
        if (size == 0 || s.isEmpty()) {
            return 0;
        }

        int curLen = 1;
        int maxLen = 1;
        char c = s.charAt(0);
        for (int i = 1; i < size; i++) {
            char t = s.charAt(i);
            if (c == t) {
                curLen++;
                if (curLen > maxLen) {
                    maxLen = curLen;
                }
            } else {
                curLen = 1;
                c = t;
            }
        }

        return maxLen;
    }
}
