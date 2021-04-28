package leetcode;

/*
实现strStr()函数。
给你两个字符串haystack和needle ，请你在haystack字符串中找出needle字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回-1 。

说明：
当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
对于本题而言，当needle是空字符串时我们应当返回0。这与C语言的strstr()以及Java的indexOf()定义相符。

示例 1：
输入：haystack = "hello", needle = "ll"
输出：2

示例 2：
输入：haystack = "aaaaa", needle = "bba"
输出：-1

示例 3：
输入：haystack = "", needle = ""
输出：0

提示：
0 <= haystack.length, needle.length <= 5 * 104
haystack 和 needle 仅由小写英文字符组成
 */
public class lc028 {
    //暴力解法
    public int strStr(String haystack, String needle) {
        int hsize = haystack.length();
        int nsize = needle.length();
        int i = 0;
        int j = 0;
        while (i < hsize && j < nsize) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                i = i - j + 1;
                j = 0;
            }
        }

        if (j == nsize) {
            return i - j;
        } else {
            return -1;
        }
    }

    /*
      kmp算法:
      利用已经部分匹配这个有效信息，保持i指针不回溯，通过修改j指针，让模式串尽量地移动到有效的位置。
      KMP算法的时间复杂度还是很稳定的。
      平均时间复杂度为 Θ(m+n)。
      最好时间复杂度为 O(m+(n−m))=O(n)。它发生在主串和模式串字符都不相同的情况下，例如，主串为abcdefghijk，模式串为+-*@。
      最差时间复杂度为 O(m+n)。它发生在主串和模式串都为相同的字符的情况下，例如，主串为aaaaaaaaaaaaaaaaaaaaa，模式串为aaaa。
     */
    public int strStrKmp(String haystack, String needle) {
        int i = 0;
        int j = -1;
        int nsize = needle.length();
        int[] next = new int[nsize + 1];
        next[0] = -1;
        while (i < nsize) {
            if (j == -1 || needle.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        int hsize = haystack.length();
        i = 0;
        j = 0;
        while (i < hsize && j < nsize) {
            if (j == -1 || haystack.charAt(i) == needle.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        if (j == nsize) {
            return i - j;
        }

        return -1;
    }
}
