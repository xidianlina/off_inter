package leetcode;

/*
给你一个字符串s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回0。
单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。

示例 1：
输入：s = "Hello World"
输出：5

示例 2：
输入：s = " "
输出：0
 */
public class lc058 {
    public int lengthOfLastWord(String s) {
        int size = s.length();
        if (size == 0 || s.isEmpty()) {
            return 0;
        }

        int count = 0;
        int end = size - 1;
        while (end >= 0 && s.charAt(end) == ' ') {
            --end;
        }

        while (end >= 0 && s.charAt(end) != ' ') {
            --end;
            ++count;
        }

        return count;
    }
}
