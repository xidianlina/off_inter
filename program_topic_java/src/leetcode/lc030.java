package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
30. 串联所有单词的子串
给定一个字符串s和一些长度相同的单词words。找出s中恰好可以由words中所有单词串联形成的子串的起始位置。
注意子串要与words中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。

示例 1：
输入：
  s = "barfoothefoobarman",
  words = ["foo","bar"]
输出：[0,9]
解释：
从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
输出的顺序不重要, [9,0] 也是有效答案。

示例 2：
输入：
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
输出：[]
 */
public class lc030 {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s.isEmpty() || s == null || words.length == 0 || words == null) {
            return result;
        }

        //存储words的所有单词
        Map<String, Integer> allWords = new HashMap<String, Integer>();
        for (String str : words) {
            if (allWords.containsKey(str)) {
                allWords.put(str, allWords.get(str) + 1);
            } else {
                allWords.put(str, 1);
            }
        }

        int wordNum = words.length;
        int wordLen = words[0].length();
        //遍历所有子串
        for (int i = 0; i <= s.length() - wordNum * wordLen; ++i) {
            //存当前扫描的字符串含有的单词
            Map<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0;
            //判断该子串是否符合
            while (num < wordNum) {
                String word = s.substring(i + num * wordLen, i + num * wordLen + wordLen);
                if (!allWords.containsKey(word)) {
                    break;
                }

                int value = hasWords.getOrDefault(word, 0);
                hasWords.put(word, value + 1);

                //判断当前单词的value和allWords中该单词的value
                if (hasWords.get(word) > allWords.get(word)) {
                    break;
                }

                ++num;
            }

            if (num == wordNum) {
                result.add(i);
            }
        }

        return result;
    }
}
