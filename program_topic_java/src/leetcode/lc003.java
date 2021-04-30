package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
3.无重复字符的最长子串
给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
示例1:
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
示例 4:
输入: s = ""
输出: 0
提示：
0 <= s.length <= 5 * 104
s由英文字母、数字、符号和空格组成
 */
public class lc003 {
    /*
    复杂度分析:
    时间复杂度:O(N)，其中N是字符串的长度。
    空间复杂度:O(∣Σ∣)，其中Σ表示字符集（即字符串中可以出现的字符）,∣Σ∣ 表示字符集的大小。在本题中没有明确说明字符集，
    因此可以默认为所有ASCII码在[0, 128)[0,128) 内的字符，即∣Σ∣=128。因此空间复杂度为O(∣Σ∣)。
    */
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        for (int i = 0; i < 256; i++) {
            hash[i] = -1;
        }

        int maxLen = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (hash[s.charAt(i)] > start) {
                start = hash[s.charAt(i)];
            }
            hash[s.charAt(i)] = i;
            maxLen = Math.max(maxLen, i - start);
        }

        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        int size = s.length();
        int maxLen = 0;
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        int start = 0;
        for (int end = 0; end < size; end++) {
            char cur = s.charAt(end);
            if (map.containsKey(cur)) {
                start = Math.max(map.get(cur), start);
            }
            maxLen = Math.max(maxLen, end - start + 1);
            map.put(cur, end + 1);
        }

        return maxLen;
    }
}
