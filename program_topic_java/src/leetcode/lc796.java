package leetcode;

import java.util.Arrays;

/*
796. 旋转字符串
给定两个字符串, A和B。
A的旋转操作就是将A最左边的字符移动到最右边。例如, 若A = 'abcde'，在移动一次之后结果就是'bcdea'。
如果在若干次旋转操作之后，A能变成B，那么返回True。

示例 1:
输入: A = 'abcde', B = 'cdeab'
输出: true

示例 2:
输入: A = 'abcde', B = 'abced'
输出: false
注意：
A和B长度不超过100。
 */
public class lc796 {
    /*
        方法一：穷举法
        时间复杂度：O(N^2)，其中N是字符串 A 的长度。
        空间复杂度：O(1)。
     */
    public boolean rotateString(String A, String B) {
        if (A.equals("") && B.equals("")) {
            return true;
        }

        int len = A.length();
        for (int i = 0; i < len; ++i) {
            String begin = A.substring(0, 1);
            String end = A.substring(1, len);
            A = end + begin;
            if (A.equals(B)) {
                return true;
            }
        }

        return false;
    }

    /*
        方法二：判断子串
        时间复杂度：O(N^2)，其中N是字符串 A 的长度。
        空间复杂度：O(1)。
     */
    public boolean rotateString2(String A, String B) {
        return A.length() == B.length() && (A + A).contains(B);
    }

    /*
        方法三：KMP算法
        时间复杂度：O(N)，其中N是字符串A的长度。
        空间复杂度：O(N)。
     */
    public boolean rotateString3(String A, String B) {
        if (A.length() != B.length()) {
            return false;
        }
        int i = 0;
        int j = -1;
        int BSize = B.length();
        int[] next = new int[BSize + 1];
        next[0] = -1;
        while (i < BSize) {
            if (j == -1 || B.charAt(i) == B.charAt(j)) {
                ++i;
                ++j;
                next[i] = j;
            } else {
                j = next[j];
            }
        }

        A = A + A;
        int ASize = A.length();
        i = 0;
        j = 0;
        while (i < ASize && j < BSize) {
            if (j == -1 || A.charAt(i) == B.charAt(j)) {
                ++i;
                ++j;
            } else {
                j = next[j];
            }
        }

        if (j == BSize) {
            return true;
        }

        return false;
    }
}
