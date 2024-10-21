LeetCode
======
https://www.cnblogs.com/xidian2014                          
https://codetop.cc/home                                    
# 算法题目
### 1.两数之和
### 2.两数相加
### 3.无重复字符的最长子串
### 4.寻找两个正序数组的中位数
### 5.最长回文子串
### 6.Z字形变换
### 7.整数反转
### 8.字符串转换整数(atoi)
### 9.回文数
### 10.正则表达式匹配
### 11.盛最多水的容器
### 12.整数转罗马数字
### 13.罗马数字转整数
### 14.最长公共前缀                      
### 15.三数之和
### 16.最接近的三数之和
### 17.电话号码的字母组合
### 18.四数之和
### 19.删除链表的倒数第N个结点
### 20.有效的括号
### 21.合并两个有序链表
### 22.括号生成
### 23.合并K个升序链表
### 24.两两交换链表中的节点
### 25.K 个一组翻转链表
### 26.删除有序数组中的重复项
### 27.移除元素
### 28.实现 strStr() kmp算法
### 29.两数相除   
### 30.串联所有单词的子串
### 31.下一个排列
### 32.最长有效括号            
### 33.搜索旋转排序数组   
### 34.在排序数组中查找元素的第一个和最后一个位置        
### 35.搜索插入位置                   
### 38.外观数列(数数并说)        
### 39.组合总和                     
### 40.组合总和II
### 41.缺失的第一个正数
### 42.接雨水
### 43.字符串相乘
### 44.通配符匹配
### 45.跳跃游戏II
### 46.全排列      
### 47.全排列II
### 48.旋转图像
### 49.字母异位词分组
### 50.Pow(x, n)
### 53.最大子序和
### 54.螺旋矩阵
### 55.跳跃游戏
### 56.合并区间
### 57.插入区间
### 58.最后一个单词的长度
### 59.螺旋矩阵II
### 60.排列序列
### 61.旋转链表
### 62.不同路径
### 63.不同路径II
### 64.最小路径和
### 66.加一
### 67.二进制求和
### 69.x的平方根
### 70.爬楼梯
### 71.简化路径
### 72.编辑距离
### 73.矩阵置零
### 74.搜索二维矩阵
### 75.颜色分类
### 76.最小覆盖子串
### 77.组合
### 78.子集
### 79.单词搜索
### 80.删除有序数组中的重复项II
### 81.搜索旋转排序数组II
### 82.删除排序链表中的重复元素II
### 83.删除排序链表中的重复元素
### 84.柱状图中最大的矩形
### 88.合并两个有序数组
### 98.验证二叉搜索树
### 109.有序链表转换二叉搜索树
### 121.买卖股票的最佳时机
### 122.买卖股票的最佳时机II
### 123.买卖股票的最佳时机III
### 143.重排链表
### 146.LRU缓存机制
### 172.阶乘后的零
### 179.最大数
### 188.买卖股票的最佳时机IV
### 198.打家劫舍
### 206.反转链表
### 213.打家劫舍II
### 215.数组中的第K个最大元素
### 228.汇总区间
### 232.重排链表
### 300.最长递增子序列
### 309.最佳买卖股票时机含冷冻期
### 322.零钱兑换
### 328.奇偶链表
### 337.打家劫舍 III
### 349.两个数组的交集
### 543.二叉树的直径(二叉树中节点的最大距离)
### 581.最短无序连续子数组
### 674.最长连续递增序列
### 714.买卖股票的最佳时机含手续费
### 796.旋转字符串
### 1143.最长公共子序列
### 1502.判断能否形成等差数列

# 算法解答
### 1.两数之和
题目链接        
https://leetcode-cn.com/problems/two-sum/       
https://leetcode.com/problems/two-sum/      
```java
package leetcode;

import java.util.Map;
import java.util.HashMap;

/*
1. 两数之和
给定一个整数数组nums和一个整数目标值target，请你在该数组中找出和为目标值的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
你可以按任意顺序返回答案。
示例 1：
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
示例 2：
输入：nums = [3,2,4], target = 6
输出：[1,2]
示例 3：
输入：nums = [3,3], target = 6
输出：[0,1]
提示：
2 <= nums.length <= 103
-109 <= nums[i] <= 109
-109 <= target <= 109
只会存在一个有效答案
 */
public class lc001 {

    public int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int size = nums.length;
        if (size < 2 || nums == null) {
            return res;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i + 1; j < size; j++) {
                if (nums[i] + nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                }
            }
        }

        return res;
    }

    public int[] twoSum2(int[] nums, int target) {
        int[] res = new int[2];
        int size = nums.length;
        if (size < 2 || nums == null) {
            return res;
        }

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < size; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = map.get(target - nums[i]);
                res[1] = i;
                return res;
            }
            map.put(nums[i], i);
        }

        return res;
    }
}
```
### 2.两数相加
题目链接        
https://leetcode-cn.com/problems/add-two-numbers/       
https://leetcode.com/problems/add-two-numbers/      
```java
package leetcode;

/*
2. 两数相加
给你两个非空的链表，表示两个非负的整数。它们每位数字都是按照逆序的方式存储的，并且每个节点只能存储一位数字。
请你将两个数相加，并以相同形式返回一个表示和的链表。
你可以假设除了数字0之外，这两个数都不会以0开头。
示例 1：
输入：l1 = [2,4,3], l2 = [5,6,4]
输出：[7,0,8]
解释：342 + 465 = 807.
示例 2：
输入：l1 = [0], l2 = [0]
输出：[0]
示例 3：
输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
输出：[8,9,9,9,0,0,0,1]
提示：
每个链表中的节点数在范围 [1, 100] 内
0 <= Node.val <= 9
题目数据保证列表表示的数字不含前导零
 */
public class lc002 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode pre = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int val1 = l1 != null ? l1.val : 0;
            int val2 = l2 != null ? l2.val : 0;
            int val = val1 + val2 + carry;
            carry = val / 10;
            val %= 10;
            ListNode cur = new ListNode(val);
            if (head == null) {
                head = cur;
            }

            if (pre != null) {
                pre.next = cur;
            }
            pre = cur;

            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }

        if (carry != 0) {
            ListNode l = new ListNode(carry);
            pre.next = l;
        }

        return head;
    }
}
```
### 3.无重复字符的最长子串
题目链接        
https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/        
https://leetcode.com/problems/longest-substring-without-repeating-characters/       
```java
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
```
### 4.寻找两个正序数组的中位数
题目连接        
https://leetcode-cn.com/problems/median-of-two-sorted-arrays/       
https://leetcode.com/problems/median-of-two-sorted-arrays/      
```java
package leetcode;

/*
4.寻找两个正序数组的中位数
给定两个大小分别为m和n的正序（从小到大）数组nums1和nums2。请你找出并返回这两个正序数组的中位数 。
示例 1：
输入：nums1 = [1,3], nums2 = [2]
输出：2.00000
解释：合并数组 = [1,2,3] ，中位数 2
示例 2：
输入：nums1 = [1,2], nums2 = [3,4]
输出：2.50000
解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
示例 3：
输入：nums1 = [0,0], nums2 = [0,0]
输出：0.00000
示例 4：
输入：nums1 = [], nums2 = [1]
输出：1.00000
示例 5：
输入：nums1 = [2], nums2 = []
输出：2.00000
提示：
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
 */
public class lc004 {
    /*
    根据中位数的定义，当m+n是奇数时，中位数是两个有序数组中的第(m+n)/2个元素，当m+n是偶数时，中位数是两个有序数组中的第(m+n)/2个元素和第(m+n)/2+1个元素的平均值。
    因此，这道题可以转化成寻找两个有序数组中的第k小的数，其中k为(m+n)/2或(m+n)/2+1。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        int size = size1 + size2;
        if (size % 2 == 1) {
            return findKth(nums1, 0, size1, nums2, 0, size2, size / 2 + 1);
        } else {
            return (findKth(nums1, 0, size1, nums2, 0, size2, size / 2) + findKth(nums1, 0, size1, nums2, 0, size2, size / 2 + 1)) / 2;
        }
    }

    public double findKth(int[] nums1, int start1, int size1, int[] nums2, int start2, int size2, int k) {
        if (size1 - start1 > size2 - start2) {
            return findKth(nums2, start2, size2, nums1, start1, size1, k);
        }
        //如果一个数组为空，说明该数组中的所有元素都被排除，可以直接返回另一个数组中第k小的元素。
        if (size1 - start1 == 0) {
            return nums2[k - 1];
        }
        if (k == 1) {
            // k==1表示已经找到第k-1小的数，下一个数为两个数组start开始的最小值
            return Math.min(nums1[start1], nums2[start2]);
        }

        int p1 = start1 + Math.min(size1 - start1, k / 2); // p1和p2记录当前需要比较的那个位
        int p2 = start2 + k - p1 + start1;
        if (nums1[p1 - 1] < nums2[p2 - 1]) {
            return findKth(nums1, p1, size1, nums2, start2, size2, k - p1 + start1);
        } else if (nums1[p1 - 1] > nums2[p2 - 1]) {
            return findKth(nums1, start1, size1, nums2, p2, size2, k - p2 + start2);
        } else {
            return nums1[p1 - 1];
        }
    }
}
```
### 5.最长回文子串
题目链接        
https://leetcode-cn.com/problems/longest-palindromic-substring/     
https://leetcode.com/problems/longest-palindromic-substring/        
```java
package leetcode;

/*
5.最长回文子串
给你一个字符串 s，找到 s 中最长的回文子串。
示例 1：
输入：s = "babad"
输出："bab"
解释："aba" 同样是符合题意的答案。
示例 2：
输入：s = "cbbd"
输出："bb"
示例 3：
输入：s = "a"
输出："a"
示例 4：
输入：s = "ac"
输出："a"
提示：
1 <= s.length <= 1000
s仅由数字和英文字母（大写和/或小写）组成
 */
public class lc005 {
    public String longestPalindrome(String s) {
        int size = s.length();
        if (size == 1 || s.isEmpty()) {
            return s;
        }
        int len = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < size; ++i) {
            int len1 = helper(s, i, i);
            int len2 = helper(s, i, i + 1);
            len = Math.max(len1, len2);
            if (len > (end - start)) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int helper(String s, int start, int end) {
        while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
            --start;
            ++end;
        }
        return (end - start - 1);
    }
}
```
### 6.Z字形变换
题目链接        
https://leetcode-cn.com/problems/zigzag-conversion/     
https://leetcode.com/problems/zigzag-conversion/        
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
6.Z字形变换
将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
比如输入字符串为 "PAYPALISHIRING" 行数为 3 时，排列如下：
P   A   H   N
A P L S I I G
Y   I   R
之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："PAHNAPLSIIGYIR"。
请你实现这个将字符串进行指定行数变换的函数：
string convert(string s, int numRows);
示例 1：
输入：s = "PAYPALISHIRING", numRows = 3
输出："PAHNAPLSIIGYIR"
示例 2：
输入：s = "PAYPALISHIRING", numRows = 4
输出："PINALSIGYAHRPI"
解释：
P     I    N
A   L S  I G
Y A   H R
P     I
示例 3：
输入：s = "A", numRows = 1
输出："A"
提示：
1 <= s.length <= 1000
s 由英文字母（小写和大写）、',' 和 '.' 组成
1 <= numRows <= 1000
 */
public class lc006 {
    /*
    通过从左向右迭代字符串，我们可以轻松地确定字符位于 Z 字形图案中的哪一行。
    可以使用min(numRows,len(s))个列表来表示Z字形图案中的非空行。
    从左到右迭代字符串s，将每个字符添加到合适的行。可以使用当前行和当前方向这两个变量对合适的行进行跟踪。
    只有当向上移动到最上面的行或向下移动到最下面的行时，当前方向才会发生改变。
    复杂度分析:
    时间复杂度:O(n)，其中n=len(s)
    空间复杂度:O(n)
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }

        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }

        int curRow = 0;
        boolean goingDown = false;
        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }

        StringBuilder res = new StringBuilder();
        for (StringBuilder row : rows) {
            res.append(row);
        }

        return res.toString();
    }
}
```
### 7.整数反转
题目链接        
https://leetcode-cn.com/problems/reverse-integer/       
https://leetcode.com/problems/reverse-integer/
```java
package leetcode;

/*
7.整数反转
给你一个32位的有符号整数x ，返回将x中的数字部分反转后的结果。
如果反转后整数超过32位的有符号整数的范围[−2的31次方,2的31次方−1] ，就返回 0。
假设环境不允许存储64位整数（有符号或无符号）。
示例 1：
输入：x = 123
输出：321
示例 2：
输入：x = -123
输出：-321
示例 3：
输入：x = 120
输出：21
示例 4：
输入：x = 0
输出：0
提示：
-2的31次方 <= x <= 2的31次方 - 1
 */
public class lc007 {
    public int reverse(int x) {
        int res = 0;
        while (x != 0) {
            if (res > Integer.MAX_VALUE / 10 || res < Integer.MIN_VALUE / 10) {
                return 0;
            }
            res = res * 10 + x % 10;
            x /= 10;
        }

        return res;
    }
}
```
### 8.字符串转换整数 (atoi)
题目链接                
https://leetcode-cn.com/problems/string-to-integer-atoi/                
https://leetcode.com/problems/string-to-integer-atoi/
```java
package leetcode;

/*
请你来实现一个myAtoi(string s)函数，使其能将字符串转换成一个 32 位有符号整数（类似 C/C++ 中的 atoi 函数）。
函数myAtoi(string s) 的算法如下：

读入字符串并丢弃无用的前导空格
检查下一个字符（假设还未到字符末尾）为正还是负号，读取该字符（如果有）。 确定最终结果是负数还是正数。 如果两者都不存在，则假定结果为正。
读入下一个字符，直到到达下一个非数字字符或到达输入的结尾。字符串的其余部分将被忽略。
将前面步骤读入的这些数字转换为整数（即，"123" -> 123， "0032" -> 32）。如果没有读入数字，则整数为 0 。必要时更改符号（从步骤 2 开始）。
如果整数数超过32位有符号整数范围 [−2^31, 2^31− 1] ，需要截断这个整数，使其保持在这个范围内。具体来说，小于 −2^31 的整数应该被固定为 −2^31 ，大于 2^31− 1 的整数应该被固定为 2^31− 1 。
返回整数作为最终结果。

注意：
本题中的空白字符只包括空格字符 ' ' 。
除前导空格或数字后的其余字符串外，请勿忽略 任何其他字符。

示例1：
输入：s = "42"
输出：42
解释：加粗的字符串为已经读入的字符，插入符号是当前读取的字符。
第 1 步："42"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："42"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："42"（读入 "42"）
           ^
解析得到整数 42 。
由于 "42" 在范围 [-231, 231 - 1] 内，最终结果为 42 。

示例2：
输入：s = "   -42"
输出：-42
解释：
第 1 步："   -42"（读入前导空格，但忽视掉）
            ^
第 2 步："   -42"（读入 '-' 字符，所以结果应该是负数）
             ^
第 3 步："   -42"（读入 "42"）
               ^
解析得到整数 -42 。
由于 "-42" 在范围 [-231, 231 - 1] 内，最终结果为 -42 。

示例3：
输入：s = "4193 with words"
输出：4193
解释：
第 1 步："4193 with words"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："4193 with words"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："4193 with words"（读入 "4193"；由于下一个字符不是一个数字，所以读入停止）
             ^
解析得到整数 4193 。
由于 "4193" 在范围 [-231, 231 - 1] 内，最终结果为 4193 。

示例4：
输入：s = "words and 987"
输出：0
解释：
第 1 步："words and 987"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："words and 987"（当前没有读入字符，因为这里不存在 '-' 或者 '+'）
         ^
第 3 步："words and 987"（由于当前字符 'w' 不是一个数字，所以读入停止）
         ^
解析得到整数 0 ，因为没有读入任何数字。
由于 0 在范围 [-231, 231 - 1] 内，最终结果为 0 。

示例5：
输入：s = "-91283472332"
输出：-2147483648
解释：
第 1 步："-91283472332"（当前没有读入字符，因为没有前导空格）
         ^
第 2 步："-91283472332"（读入 '-' 字符，所以结果应该是负数）
          ^
第 3 步："-91283472332"（读入 "91283472332"）
                     ^
解析得到整数 -91283472332 。
由于 -91283472332 小于范围 [-231, 231 - 1] 的下界，最终结果被截断为 -2^31 = -2147483648 。

提示：
0 <= s.length <= 200
s 由英文字母（大写和小写）、数字（0-9）、' '、'+'、'-' 和 '.' 组成
 */
public class lc008 {
    public static void main(String[] args) {

    }

    public int myAtoi(String str) {
        int index = 0;
        Long total = new Long(0);
        int sign = 1;
        while (index < str.length() && str.charAt(index) == ' ') {
            index++;
        }

        if (index == str.length()) {
            return (int) (total * sign);
        }

        if (str.charAt(index) == '-' || str.charAt(index) == '+') {
            sign = str.charAt(index) == '-' ? -1 : 1;
            index++;
        }

        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            total = total * 10 + str.charAt(index) - '0';
            ++index;

            if (total > Integer.MAX_VALUE) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
        }

        return (int) (total * sign);
    }
}
```
### 9.回文数
题目链接            
https://leetcode-cn.com/problems/palindrome-number/
https://leetcode.com/problems/palindrome-number/
```java
package leetcode;

/*
给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。例如，121 是回文，而 123 不是。

示例 1：
输入：x = 121
输出：true

示例2：
输入：x = -121
输出：false
解释：从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。

示例 3：
输入：x = 10
输出：false
解释：从右向左读, 为 01 。因此它不是一个回文数。

示例 4：
输入：x = -101
输出：false

提示：
-2^31<= x <= 2^31- 1
 */
public class lc009 {
    public static void main(String[] args) {
        lc009 lc = new lc009();
        System.out.println(lc.isPalindrome(121));
        System.out.println(lc.isPalindrome(123));
        System.out.println("---------------");
        System.out.println(lc.isPalindrome2(121));
        System.out.println(lc.isPalindrome2(123));
    }

    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        String s = String.valueOf(x);
        int start = 0;
        int end = s.length() - 1;

        while (start <= end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            ++start;
            --end;
        }

        return true;
    }

    public boolean isPalindrome2(int x) {
        if (x < 0) {
            return false;
        }

        int reverse = 0;
        int origin = x;
        while (x > 0) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }

        return reverse == origin;
    }
}
```
### 10.正则表达式匹配
题目链接            
https://leetcode-cn.com/problems/regular-expression-matching/               
https://leetcode.com/problems/regular-expression-matching/   
> 解题思路:             
> 每次从字符串p中取出一个字符或者[字符 + 星号]的组合，并在s中进行匹配。对于p中一个字符而言，它只能在s中匹配一个字符，匹配的方法具有唯一性；                 
  而对于p中[字符+星号]的组合而言，它可以在s中匹配任意自然数个字符，并不具有唯一性。因此考虑使用动态规划，对匹配的方案进行枚举。                 
  用f[i][j]表示s的前i个字符与p中的前j个字符是否能够匹配。在进行状态转移时，考虑p的第j个字符的匹配情况:             
  (1).如果p的第j个字符是一个小写字母，那么必须在s中匹配一个相同的小写字母,即             
> ![lc010](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc010.png)                        
> 也就是说，如果s的第i个字符与p的第j个字符不相同，那么无法进行匹配；否则可以匹配两个字符串的最后一个字符，完整的匹配结果取决于两个字符串前面的部分。                   
> (2).在任意情况下，只要 p[j]p[j] 是 .，那么 p[j]p[j] 一定成功匹配 ss 中的任意一个小写字母。              
> (3).如果p的第j个字符是*，那么就表示可以对p的第j-1个字符匹配任意自然数次。在匹配0次的情况下,有                 
       f[i][j]=f[i][j−2]                
> 也就是"浪费""了一个[字符+星号]的组合，没有匹配任何 ss 中的字符。                             
> 在匹配1,2,3,⋯ 次的情况下，类似地有             
> f[i][j] = f[i - 1][j - 2], if s[i] = p[j - 1]                                              
> f[i][j] = f[i - 2][j - 2], if s[i - 1] = s[i] = p[j - 1]                                  
> f[i][j] = f[i - 3][j - 2], if s[i - 2] = s[i - 1] = s[i] = p[j - 1]                                 
> ......                
> 如果通过这种方法进行转移，那么就需要枚举这个组合到底匹配了s中的几个字符，会增导致时间复杂度增加，并且代码编写起来十分麻烦。                
> 换个角度考虑这个问题：[字母+星号]的组合在匹配的过程中，本质上只会有两种情况：              
  匹配s末尾的一个字符，将该字符扔掉，而该组合还可以继续进行匹配；                     
  不匹配字符，将该组合扔掉，不再进行匹配。                                                  
> 如果按照这个角度进行思考，可以写出很精巧的状态转移方程：                  
> ![lc010_2](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc010_2.png)                           
> 最终的状态转移方程如下：                                                     
> ![lc010_3](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc010_3.png)                                
> 其中matches(x, y)判断两个字符是否匹配的辅助函数。只有当y是.或者x和y本身相同时，这两个字符才会匹配。                                     
```java
package leetcode;

/*
给你一个字符串s和一个字符规律p，请你来实现一个支持 '.'和'*'的正则表达式匹配。
'.' 匹配任意单个字符
'*' 匹配零个或多个前面的那一个元素
所谓匹配，是要涵盖整个字符串s的，而不是部分字符串。

示例 1：
输入：s = "aa" p = "a"
输出：false
解释："a" 无法匹配 "aa" 整个字符串。

示例 2:
输入：s = "aa" p = "a*"
输出：true
解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。

示例3：
输入：s = "ab" p = ".*"
输出：true
解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。

示例 4：
输入：s = "aab" p = "c*a*b"
输出：true
解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。

示例 5：
输入：s = "mississippi" p = "mis*is*p*."
输出：false

提示：
0 <= s.length<= 20
0 <= p.length<= 30
s可能为空，且只包含从a-z的小写字母。
p可能为空，且只包含从a-z的小写字母，以及字符.和*。
保证每次出现字符* 时，前面都匹配到有效的字符
 */
public class lc010 {
    public static void main(String[] args) {
        lc010 lc = new lc010();
        String s = "ab";
        String p = ".*";
        System.out.println(lc.isMatch(s, p));
    }

    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (matches(s, p, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }

    public boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
```
### 11.盛最多水的容器
题目链接            
https://leetcode-cn.com/problems/container-with-most-water/                 
https://leetcode.com/problems/container-with-most-water/            
```java
package leetcode;

/*
盛最多水的容器:
给你n个非负整数a1，a2，...，an，每个数代表坐标中的一个点(i,ai)。在坐标内画n条垂直线，垂直线i的两个端点分别为(i,ai) 和 (i, 0)。
找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
说明：你不能倾斜容器。
示例 1：
输入：[1,8,6,2,5,4,8,3,7]
输出：49
解释：图中垂直线代表输入数组 [1,8,6,2,5,4,8,3,7]。在此情况下，容器能够容纳水（表示为蓝色部分）的最大值为49。

示例 2：
输入：height = [1,1]
输出：1

示例 3：
输入：height = [4,3,2,1,4]
输出：16

示例 4：
输入：height = [1,2,1]
输出：2

提示：
n = height.length
2 <= n <= 3 * 104
0 <= height[i] <= 3 * 104
 */
public class lc011 {
    public static void main(String[] args) {
        lc011 lc = new lc011();
        int[] arr = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println(lc.maxArea(arr));
    }

    /*
      时间复杂度:O(N),双指针总计最多遍历整个数组一次。
      空间复杂度:O(1),只需要额外的常数级别的空间。
     */
    public int maxArea(int[] height) {
        int size = height.length;
        if (size < 2) {
            return 0;
        }
        int maxArea = 0;
        int start = 0;
        int end = size - 1;
        while (start < end) {
            maxArea = Math.max(maxArea, Math.min(height[start], height[end]) * (end - start));
            if (height[start] < height[end]) {
                ++start;
            } else {
                --end;
            }
        }

        return maxArea;
    }
}
```
### 12.整数转罗马数字
题目链接            
https://leetcode-cn.com/problems/integer-to-roman/
https://leetcode.com/problems/integer-to-roman/
```java
package leetcode;

/*
罗马数字包含以下七种字符:I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如,罗马数字2写做II，即为两个并列的1。12写做XII，即为X+II。27写做XXVII, 即为XX+V+II。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如4不写做IIII，而是IV。
数字1在数字5的左边，所表示的数等于大数5减小数1得到的数值4。同样地，数字9表示为IX。这个特殊的规则只适用于以下六种情况：
I可以放在V(5)和X(10) 的左边，来表示4和9。
X可以放在L(50)和C(100)的左边，来表示40和90。
C可以放在D(500)和M(1000)的左边，来表示400和900。
给定一个整数，将其转为罗马数字。输入确保在1到3999的范围内。

示例1:
输入:3
输出: "III"

示例2:
输入:4
输出: "IV"

示例3:
输入:9
输出: "IX"

示例4:
输入:58
输出: "LVIII"
解释: L = 50, V = 5, III = 3.

示例5:
输入:1994
输出: "MCMXCIV"
解释: M = 1000, CM = 900, XC = 90, IV = 4.

提示：
1 <= num <= 3999
 */
public class lc012 {
    public static void main(String[] args) {
        lc012 lc = new lc012();
        System.out.println(lc.intToRoman(58));
    }

    int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < values.length && num >= 0; ++i) {
            while (values[i] <= num) {
                num -= values[i];
                sb.append(symbols[i]);
            }
        }

        return sb.toString();
    }
}
```
### 13.罗马数字转整数
题目链接                
https://leetcode-cn.com/problems/roman-to-integer/
https://leetcode.com/problems/roman-to-integer/
```java
package leetcode;

/*
罗马数字包含以下七种字符:I， V， X， L，C，D 和 M。
字符          数值
I             1
V             5
X             10
L             50
C             100
D             500
M             1000
例如,罗马数字2写做II，即为两个并列的1。12写做XII，即为X+II。27写做XXVII, 即为XX+V+II。
通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如4不写做IIII，而是IV。
数字1在数字5的左边，所表示的数等于大数5减小数1得到的数值4。同样地，数字9表示为IX。这个特殊的规则只适用于以下六种情况：
I可以放在V(5)和X(10) 的左边，来表示4和9。
X可以放在L(50)和C(100)的左边，来表示40和90。
C可以放在D(500)和M(1000)的左边，来表示400和900。
给定一个整数，将其转为罗马数字。输入确保在1到3999的范围内。

示例1:
输入:"III"
输出: 3

示例2:
输入:"IV"
输出: 4

示例3:
输入:"IX"
输出: 9

示例4:
输入:"LVIII"
输出: 58
解释: L = 50, V= 5, III = 3.

示例5:
输入:"MCMXCIV"
输出: 1994
解释: M = 1000, CM = 900, XC = 90, IV = 4.

提示：
1 <= s.length <= 15
s 仅含字符 ('I', 'V', 'X', 'L', 'C', 'D', 'M')
题目数据保证 s 是一个有效的罗马数字，且表示整数在范围 [1, 3999] 内
题目所给测试用例皆符合罗马数字书写规则，不会出现跨位等情况。
IL 和 IM 这样的例子并不符合题目要求，49 应该写作 XLIX，999 应该写作 CMXCIX 。
 */
public class lc013 {
    public static void main(String[] args) {

    }

    /*
       按照题目的描述，可以总结如下规则：
       罗马数字由 I,V,X,L,C,D,M 构成；
       当小值在大值的左边，则减小值，如 IV=5-1=4；
       当小值在大值的右边，则加小值，如 VI=5+1=6；
       由上可知，右值永远为正，因此最后一位必然为正。
       一言蔽之，把一个小值放在大值的左边，就是做减法，否则为加法。
       在代码实现上，可以往后看多一位，对比当前位与后一位的大小关系，从而确定当前位是加还是减法。当没有下一位时，做加法即可。
       也可保留当前位的值，当遍历到下一位的时，对比保留值与遍历位的大小关系，再确定保留值为加还是减。最后一位做加法即可。
     */
    public int romanToInt(String s) {
        int sum = 0;
        int preNum = getValue(s.charAt(0));
        for (int i = 1; i < s.length(); ++i) {
            int num = getValue(s.charAt(i));
            if (preNum < num) {
                sum -= preNum;
            } else {
                sum += preNum;
            }
            preNum = num;
        }
        sum += preNum;


        return sum;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }
}
```
### 14.最长公共前缀
题目链接                                    
https://leetcode-cn.com/problems/longest-common-prefix/                                 
https://leetcode.com/problems/longest-common-prefix/             
```java
package leetcode;

/*
编写一个函数来查找字符串数组中的最长公共前缀。
如果不存在公共前缀，返回空字符串""。

示例 1：
输入：strs = ["flower","flow","flight"]
输出："fl"

示例 2：
输入：strs = ["dog","racecar","car"]
输出：""
解释：输入不存在公共前缀。

提示：
0 <= strs.length <= 200
0 <= strs[i].length <= 200
strs[i] 仅由小写英文字母组成
 */
public class lc014 {
    public static void main(String[] args) {

    }

    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String res = new String();
        for (int j = 0; j < strs[0].length(); ++j) {
            char c = strs[0].charAt(j);
            for (int i = 1; i < strs.length; ++i) {
                if (j >= strs[i].length() || strs[i].charAt(j) != c) {
                    return res;
                }
            }
            res += Character.toString(c);
        }

        return res;
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        String prefix = strs[0];
        for (int i = 1; i < strs.length; ++i) {
            prefix = longestCommonPrefix(prefix, strs[i]);
            if (prefix.length() == 0) {
                break;
            }
        }

        return prefix;
    }

    public String longestCommonPrefix(String str1, String str2) {
        int length = Math.min(str1.length(), str2.length());
        int index = 0;
        while (index < length && str1.charAt(index) == str2.charAt(index)) {
            index++;
        }

        return str1.substring(0, index);
    }
}
```                         
### 15. 三数之和
题目链接                
https://leetcode-cn.com/problems/3sum/                  
https://leetcode.com/problems/3sum/              
```java
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个包含n个整数的数组nums，判断nums中是否存在三个元素a，b，c ，使得a + b + c = 0 ？请你找出所有和为0且不重复的三元组。
注意：答案中不可以包含重复的三元组。

示例 1：
输入：nums = [-1,0,1,2,-1,-4]
输出：[[-1,-1,2],[-1,0,1]]

示例 2：
输入：nums = []
输出：[]

示例 3：
输入：nums = [0]
输出：[]

提示：
0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */
public class lc015 {
    public static void main(String[] args) {
        lc015 lc = new lc015();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(lc.threeSum(arr));
    }

    public List<List<Integer>> threeSum(int[] nums) {
        int target = 0;
        List<List<Integer>> res = new ArrayList<>();
        int size = nums.length;
        if (size < 3 || nums == null) {
            return res;
        }

        Arrays.sort(nums);
        for (int i = 0; i < size - 2; ++i) {
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = i + 1;
            int right = size - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum < target) {
                    while (left < right && nums[++left] == nums[left - 1]) ;
                } else if (sum > target) {
                    while (left < right && nums[--right] == nums[right + 1]) ;
                } else {
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[left]);
                    tmp.add(nums[right]);
                    res.add(tmp);
                    while (left < right && nums[++left] == nums[left - 1]) ;
                    while (left < right && nums[--right] == nums[right + 1]) ;
                }
            }
        }

        return res;
    }
}
```
### 16.最接近的三数之和
题目链接        
https://leetcode-cn.com/problems/3sum-closest/          
https://leetcode.com/problems/3sum-closest/
```java
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;

/*
给定一个包括n个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。

示例：
输入：nums = [-1,2,1,-4], target = 1
输出：2
解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。

提示：
3 <= nums.length <= 10^3
-10^3<= nums[i]<= 10^3
-10^4<= target<= 10^4
 */
public class lc016 {
    public static void main(String[] args) {

    }

    public int threeSumClosest(int[] nums, int target) {
        int size = nums.length;
        if (size < 3 || nums == null) {
            return 0;
        }

        int closest = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(closest - target);
        Arrays.sort(nums);
        for (int i = 0; i < size - 2; ++i) {
            int j = i + 1;
            int k = size - 1;
            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];
                int newDiff = Math.abs(sum - target);
                if (diff > newDiff) {
                    diff = newDiff;
                    closest = sum;
                }
                if (sum > target) {
                    --k;
                } else {
                    ++j;
                }
            }
        }

        return closest;
    }
}
```
### 17.电话号码的字母组合
题目链接        
https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/             
https://leetcode.com/problems/letter-combinations-of-a-phone-number/       
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
给出数字到字母的映射如下（与电话按键相同）。注意1不对应任何字母。

示例 1：
输入：digits = "23"
输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

示例 2：
输入：digits = ""
输出：[]

示例 3：
输入：digits = "2"
输出：["a","b","c"]

提示：
0 <= digits.length <= 4
digits[i] 是范围 ['2', '9'] 的一个数字。
 */
public class lc017 {
    public static void main(String[] args) {

    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits == null || digits.isEmpty()) {
            return result;
        }
        result.add("");
        String[] btns = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        for (int i = 0; i < digits.length(); i++) {
            List<String> tmp = new ArrayList<>();
            String letter = btns[digits.charAt(i) - '0'];
            //遍历上一个列表，取出每一个元素，并和新的元素的每一个字符加起来保存
            for (int j = 0; j < result.size(); j++) {
                //遍历当前数字对应的所有字符
                for (int k = 0; k < letter.length(); k++) {
                    tmp.add(result.get(j) + letter.charAt(k));
                }
            }
            result = tmp;
        }
        return result;
    }
}
```
### 18.四数之和
题目链接            
https://leetcode-cn.com/problems/4sum/        
https://leetcode.com/problems/4sum/        
```java
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个包含n个整数的数组nums和一个目标值target，判断nums中是否存在四个元素a，b，c和d，使得a+b+c+d的值与target相等？找出所有满足条件且不重复的四元组。
注意：答案中不可以包含重复的四元组。

示例 1：
输入：nums = [1,0,-1,0,-2,2], target = 0
输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]

示例 2：
输入：nums = [], target = 0
输出：[]

提示：
0 <= nums.length <= 200
-109 <= nums[i] <= 109
-109 <= target <= 109
 */
public class lc018 {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length < 4 || nums == null) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 3; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = i + 1; j < nums.length - 2; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }

                int left = j + 1;
                int right = nums.length - 1;
                while (left < right) {
                    int tmp = nums[i] + nums[j] + nums[left] + nums[right];
                    if (tmp == target) {
                        List<Integer> l = new ArrayList<>();
                        l.add(nums[i]);
                        l.add(nums[j]);
                        l.add(nums[left]);
                        l.add(nums[right]);
                        result.add(l);
                        while (left < right && nums[++left] == nums[left - 1]) ;
                        while (left < right && nums[--right] == nums[right + 1]) ;
                    } else if (tmp < target) {
                        while (left < right && nums[++left] == nums[left - 1]) ;
                    } else {
                        while (left < right && nums[--right] == nums[right + 1]) ;
                    }
                }
            }
        }

        return result;
    }
}
```
### 19.删除链表的倒数第N个结点
题目链接        
https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list/          
https://leetcode.com/problems/remove-nth-node-from-end-of-list/        
```java
package leetcode;

/*
给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
进阶：你能尝试使用一趟扫描实现吗？

示例 1：
输入：head = [1,2,3,4,5], n = 2
输出：[1,2,3,5]

示例 2：
输入：head = [1], n = 1
输出：[]

示例 3：
输入：head = [1,2], n = 1
输出：[1]

提示：
链表中结点的数目为 sz
1 <= sz <= 30
0 <= Node.val <= 100
1 <= n <= sz
 */
public class lc019 {
    //时间复杂度为O(n), 空间复杂度O(1)。
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode first = head, second = head;
        for (int i = 0; i < n; ++i) {
            first = first.next;
        }

        if (first == null) {
            return head.next;
        }

        while (first.next != null) {
            first = first.next;
            second = second.next;
        }

        second.next = second.next.next;

        return head;
    }
}
```
### 20.有效的括号
题目链接      
https://leetcode-cn.com/problems/valid-parentheses/         
https://leetcode.com/problems/valid-parentheses/
```java
package leetcode;

import java.util.Stack;

/*
给定一个只包括'('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。

示例 1：
输入：s = "()"
输出：true

示例2：
输入：s = "()[]{}"
输出：true

示例3：
输入：s = "(]"
输出：false

示例4：
输入：s = "([)]"
输出：false

示例5：
输入：s = "{[]}"
输出：true

提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
public class lc020 {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        Character now;
        Character prev;
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            now = s.charAt(i);
            if (now == '(' || now == '[' || now == '{') {
                stack.push(now);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    prev = stack.pop();
                }

                if (now == ')' && prev != '(') {
                    return false;
                } else if (now == ']' && prev != '[') {
                    return false;
                } else if (now == '}' && prev != '{') {
                    return false;
                }
            }
        }

        return stack.isEmpty();
    }
}
```
### 21.合并两个有序链表
题目链接        
https://leetcode-cn.com/problems/merge-two-sorted-lists/        
https://leetcode.com/problems/merge-two-sorted-lists/       
```java
package leetcode;

/*
21.合并两个有序链表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：
输入：l1 = [], l2 = []
输出：[]
示例 3：
输入：l1 = [], l2 = [0]
输出：[0]
提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1和l2均按非递减顺序排列
 */
public class lc021 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;
        return head.next;
    }

    public ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = null;
        if (l1.val < l2.val) {
            head = l1;
            head.next = mergeTwoLists2(l1.next, l2);
        } else {
            head = l2;
            head.next = mergeTwoLists2(l1, l2.next);
        }

        return head;
    }
}
```
### 22.括号生成
题目链接                
https://leetcode-cn.com/problems/generate-parentheses/
https://leetcode.com/problems/generate-parentheses/
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
数字n代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。

示例 1：
输入：n = 3
输出：["((()))","(()())","(())()","()(())","()()()"]

示例 2：
输入：n = 1
输出：["()"]

提示：
1 <= n <= 8
 */
public class lc022 {
    /*
     深度优先遍历:
     当前左右括号都有大于0个可以使用的时候，才产生分支；
     产生左分支的时候，只看当前是否还有左括号可以使用；
     产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余的数量的时候，才可以产生分支；
     在左边和右边剩余的括号数都等于0的时候结算。
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();

        //特判
        if (n == 0) {
            return result;
        }

        // 执行深度优先遍历，搜索可能的结果
        generateParenthesisDFS(n, n, "", result);

        return result;
    }

    private void generateParenthesisDFS(int left, int right, String out, List<String> result) {
        if (left == 0 && right == 0) {
            result.add(out);
            return;
        }

        // 剪枝（左括号可以使用的个数严格大于右括号可以使用的个数才剪枝）
        if (left > right) {
            return;
        }

        if (left > 0) {
            generateParenthesisDFS(left - 1, right, out + "(", result);
        }

        if (right > 0) {
            generateParenthesisDFS(left, right - 1, out + ")", result);
        }
    }
}
```
### 23.合并K个升序链表
题目链接                
https://leetcode-cn.com/problems/merge-k-sorted-lists/
https://leetcode.com/problems/merge-k-sorted-lists/
```java
package leetcode;

/*
给你一个链表数组，每个链表都已经按升序排列。
请你将所有链表合并到一个升序链表中，返回合并后的链表。

示例 1：
输入：lists = [[1,4,5],[1,3,4],[2,6]]
输出：[1,1,2,3,4,4,5,6]
解释：链表数组如下：
[
  1->4->5,
  1->3->4,
  2->6
]
将它们合并到一个有序链表中得到。
1->1->2->3->4->4->5->6

示例 2：
输入：lists = []
输出：[]

示例 3：
输入：lists = [[]]
输出：[]

提示：
k == lists.length
0 <= k <= 10^4
0 <= lists[i].length <= 500
-10^4 <= lists[i][j] <= 10^4
lists[i] 按 升序 排列
lists[i].length 的总和不超过 10^4
 */
public class lc023 {
    //时间复杂度：O(n∗log(k))，n是所有链表中元素的总和，k是链表个数。
    public ListNode mergeKLists(ListNode[] lists) {
        int n = lists.length;
        if (n == 0) {
            return null;
        }

        while (n > 1) {
            int k = (n + 1) / 2;
            for (int i = 0; i < n / 2; ++i) {
                lists[i] = mergeTwoLists(lists[i], lists[i + k]);
            }
            n = k;
        }

        return lists[0];
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }

        ListNode head = new ListNode(-1);
        ListNode cur = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }

        cur.next = l1 == null ? l2 : l1;

        return head.next;
    }
}
```
### 24.两两交换链表中的节点
题目链接                
https://leetcode-cn.com/problems/swap-nodes-in-pairs/                   
https://leetcode-cn.com/problems/swap-nodes-in-pairs/           
```java
package leetcode;

/*
给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例 1：
输入：head = [1,2,3,4]
输出：[2,1,4,3]

示例 2：
输入：head = []
输出：[]

示例 3：
输入：head = [1]
输出：[1]

提示：
链表中节点的数目在范围 [0, 100] 内
0 <= Node.val <= 100
 */
public class lc024 {
    /*
      时间复杂度：O(n)O(n)，其中 nn 是链表的节点数量。需要对每个节点进行更新指针的操作。
      空间复杂度：O(n)O(n)，其中 nn 是链表的节点数量。空间复杂度主要取决于递归调用的栈空间
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode tmp = head.next;
        head.next = swapPairs(tmp.next);
        tmp.next = head;

        return tmp;
    }
}
```
### 25.K 个一组翻转链表
题目链接                
https://leetcode-cn.com/problems/reverse-nodes-in-k-group/              
https://leetcode.com/problems/reverse-nodes-in-k-group/             
```java
package leetcode;

/*
给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
k是一个正整数，它的值小于或等于链表的长度。
如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。

进阶：
你可以设计一个只使用常数额外空间的算法来解决此问题吗？
你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[2,1,4,3,5]

示例 2：
输入：head = [1,2,3,4,5], k = 3
输出：[3,2,1,4,5]

示例 3：
输入：head = [1,2,3,4,5], k = 1
输出：[1,2,3,4,5]

示例 4：
输入：head = [1], k = 1
输出：[1]

提示：
列表中节点的数量在范围 sz 内
1 <= sz <= 5000
0 <= Node.val <= 1000
1 <= k <= sz
 */
public class lc025 {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        ListNode cur = head;
        dummy.next = head;

        int i = 0;
        while (cur != null) {
            ++i;
            if (i % k == 0) {
                pre = reverseOneGroup(pre, cur.next);
                cur = pre.next;
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }

    private ListNode reverseOneGroup(ListNode pre, ListNode next) {
        ListNode last = pre.next;
        ListNode cur = last.next;
        while (cur != next) {
            last.next = cur.next;
            cur.next = pre.next;
            pre.next = cur;
            cur = last.next;
        }

        return last;
    }
}
```
### 26.删除有序数组中的重复项
题目链接                
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/               
https://leetcode.com/problems/remove-duplicates-from-sorted-array/          
```java
package leetcode;

/*
给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。

你可以想象内部操作如下:
// nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
int len = removeDuplicates(nums);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
     print(nums[i]);
}

示例 1：
输入：nums = [1,1,2]
输出：2, nums = [1,2]
解释：函数应该返回新的长度 2 ，并且原数组 nums 的前两个元素被修改为 1, 2 。不需要考虑数组中超出新长度后面的元素。

示例 2：
输入：nums = [0,0,1,1,1,2,2,3,3,4]
输出：5, nums = [0,1,2,3,4]
解释：函数应该返回新的长度 5 ， 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4 。不需要考虑数组中超出新长度后面的元素。

提示：
0 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 已按升序排列
 */
public class lc026 {
    public int removeDuplicates(int[] nums) {
        int size = nums.length;
        if (size == 0 || nums == null) {
            return 0;
        }

        int index = 1;
        for (int i = 1; i < size; ++i) {
            if (nums[i] != nums[i - 1]) {
                nums[index] = nums[i];
                ++index;
            }
        }

        return index;
    }
}
```
### 27.移除元素
题目链接                
https://leetcode-cn.com/problems/remove-element/                    
https://leetcode.com/problems/remove-element/               
```java
package leetcode;

/*
给你一个数组nums和一个值 val，你需要原地移除所有数值等于val的元素，并返回移除后数组的新长度。
不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。

说明:
为什么返回数值是整数，但输出的答案是数组呢?
请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
你可以想象内部操作如下:
// nums 是以“引用”方式传递的。也就是说，不对实参作任何拷贝
int len = removeElement(nums, val);

// 在函数里修改输入数组对于调用者是可见的。
// 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
for (int i = 0; i < len; i++) {
    print(nums[i]);
}

示例 1：
输入：nums = [3,2,2,3], val = 3
输出：2, nums = [2,2]
解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。

示例 2：
输入：nums = [0,1,2,2,3,0,4,2], val = 2
输出：5, nums = [0,1,4,0,3]
解释：函数应该返回新的长度 5, 并且 nums 中的前五个元素为 0, 1, 3, 0, 4。注意这五个元素可为任意顺序。你不需要考虑数组中超出新长度后面的元素。

提示：
0 <= nums.length <= 100
0 <= nums[i] <= 50
0 <= val <= 100
 */
public class lc027 {
    public int removeElement(int[] nums, int val) {
        int size = nums.length;
        if (size == 0 || nums == null) {
            return 0;
        }

        int n = 0;
        for (int i = 0; i < size; ++i) {
            if (nums[i] != val) {
                nums[n] = nums[i];
                ++n;
            }
        }

        return n;
    }
}
``` 
### 28.实现 strStr() kmp算法
题目链接      
https://leetcode-cn.com/problems/implement-strstr/      
https://leetcode.com/problems/implement-strstr/     
```java
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
```
> KMP算法：            
> KMP算法要解决的问题就是在字符串（也叫主串）中的模式（pattern）定位问题。就是平时常说的关键字搜索。模式串就是关键字（接下来称它为P），
> 如果它在一个主串（接下来称为T）中出现，就返回它的具体位置，否则返回-1（常用手段）。           
> KMP算法思想：“利用已经部分匹配这个有效信息，保持主串T的i指针不回溯，通过修改模式串P的j指针，让模式串尽量地移动到有效的位置。”           
> 整个KMP的重点就在于当模式串P某一个字符与主串T不匹配时，应该知道模式串P的j指针要移动到哪？              
> 当匹配失败时，模式串P的j要移动的下一个位置k。存在着这样的性质：最前面的k个字符和j之前的最后k个字符是一样的。即P[0 ~ k-1] == P[j-k ~ j-1]                            
> ![kmp](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/kmp.png)            
> 当 T[i] != P[j] 时                              
> 有 T[i-j ~ i-1] == P[0 ~ j-1]                                           
> 因为 P[0 ~ k-1] == P[j-k ~ j-1]                               
> 所以 T[i-k ~ i-1] == P[0 ~ k-1]                                         
> 接下来就是重点了，怎么求这个（这些）k呢？因为在P的每一个位置都可能发生不匹配，也就是说要计算每一个位置j对应的k，所以用一个数组next来保存，next[j] = k，表示当T[i] != P[j]时，j指针的下一个位置。                  
> 对于长度为m的字符串p，其前缀函数π(j)(0≤j<m) 表示p的子串p[0:i]的最长的相等的真前缀与真后缀的长度。特别地，如果不存在符合条件的前后缀，那么π(j)=0。其中真前缀与真后缀的定义为不等于自身的的前缀与后缀。              
> 下面讲解求解next[j]的推导思路：           
> next[j]的值（也就是k）表示，当P[j] != T[i]时，j指针的下一步移动位置。         
> 当j为0时，j已经在最左边了，不可能再移动了，这时候应该是i指针后移。所以在代码中才会有next[0]=-1;这个初始化。                      
> 当j为1时，j指针一定是后移到0位置的。因为它前面也就只有这一个位置了，所以在代码中才会有next[1]=0。               
> ![kmp2](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/kmp2.png)          
> 仔细对比这两个图发现一个规律：                   
> 当P[k] == P[j]时，有next[j+1] == next[j] + 1                  
> 证明：                   
> 因为在P[j]之前已经有P[0 ~ k-1] == p[j-k ~ j-1]。（next[j] == k）             
> 这时候现有P[k] == P[j]，可以得到P[0 ~ k-1] + P[k] == p[j-k ~ j-1] + P[j]。                   
> 即：P[0 ~ k] == P[j-k ~ j]，即next[j+1] == k + 1 == next[j] + 1。                              
> ![kmp3](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/kmp3.png)                  
> 当P[k] != P[j]时,k=next[k]                                      
> ![kmp4](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/kmp4.png)              
> 像上边的例子，已经不可能找到[ A，B，A，B ]这个最长的后缀串了，但还是可能找到[ A，B ]、[ B ]这样的前缀串的。所以这个过程像不像在定位[ A，B，A，C ]这个串，当C和主串不一样了（也就是k位置不一样了），那当然是把指针移动到next[k]啦。                                             
>                                     
> 参考 https://www.cnblogs.com/yjiyjige/p/3263858.html
### 29.两数相除
题目链接                
https://leetcode-cn.com/problems/divide-two-integers/               
https://leetcode.com/problems/divide-two-integers/              
```java
package leetcode;

/*
给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和mod运算符。
返回被除数dividend除以除数divisor得到的商。
整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2

示例1:
输入: dividend = 10, divisor = 3
输出: 3
解释: 10/3 = truncate(3.33333..) = truncate(3) = 3

示例2:
输入: dividend = 7, divisor = -3
输出: -2
解释: 7/-3 = truncate(-2.33333..) = -2

提示：
被除数和除数均为32位有符号整数。
除数不为0。
假设我们的环境只能存储 32 位有符号整数，其数值范围是 [−2^31, 2^31− 1]。本题中，如果除法结果溢出，则返回 2^31− 1。
 */
public class lc029 {
    /*
      位操作Bit Operation，思路是:如果被除数大于或等于除数，则进行如下循环，定义变量t等于除数，定义计数p，
      当t的两倍小于等于被除数时，进行如下循环，t扩大一倍，p扩大一倍，然后更新res和m。
      通过不断的二进制向左位移，判断除数(divisor)位移几次后，最接近被除数(dividend)。获取到最接近的值，用被除数减去最接近的值。
      并重复上述过程，同时记录每次位移至最接近的值所需要的2的幂次方。将所有位移致最接近的值所需要的2幂次方叠加起来，就是最终的结果了。
     */
    public int divide(int dividend, int divisor) {
        int res = 0;
        if (divisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long m = Math.abs((long) dividend);
        long n = Math.abs((long) divisor);
        while (m >= n) {
            long t = n, p = 1;
            while (m >= (t << 1)) {
                t <<= 1;
                p <<= 1;
            }
            res += p;
            m -= t;
        }
        if ((dividend > 0 && divisor > 0) || (dividend < 0 && divisor < 0)) {
            return res;
        } else {
            return -res;
        }
    }
}
```              
### 30.串联所有单词的子串
题目链接            
https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/                 
https://leetcode.com/problems/substring-with-concatenation-of-all-words/         
```java
package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
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
```   
### 31.下一个排列
题目链接            
https://leetcode-cn.com/problems/next-permutation/
https://leetcode.com/problems/next-permutation/
```java
package leetcode;

/*
实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
必须 原地 修改，只允许使用额外常数空间。

示例 1：
输入：nums = [1,2,3]
输出：[1,3,2]

示例 2：
输入：nums = [3,2,1]
输出：[1,2,3]

示例 3：
输入：nums = [1,1,5]
输出：[1,5,1]

示例 4：
输入：nums = [1]
输出：[1]

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 100
 */
public class lc031 {
    /*
        思路及解法:
        下一个排列总是比当前排列要大，除非该排列已经是最大的排列。希望找到一种方法，能够找到一个大于当前序列的新序列，且变大的幅度尽可能小。
        将一个左边的「较小数」与一个右边的「较大数」交换，以能够让当前排列变大，从而得到下一个排列。
        同时要让这个「较小数」尽量靠右，而「较大数」尽可能小。当交换完成后，「较大数」右边的数需要按照升序重新排列。
        这样可以在保证新排列大于原来排列的情况下，使变大的幅度尽可能小。
        
        时间复杂度：O(N)，其中N为给定序列的长度。至多只需要扫描两次序列，以及进行一次反转操作。
        空间复杂度：O(1),只需要常数的空间存放若干变量。
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //找到右边较大的数
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            --i;
        }

        //找到左边较小的数
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                --j;
            }

            //交换
            swap(nums, i, j);
        }

        //反转,使较大数右边的数需要按照升序重新排列
        reverse(nums, i + 1);
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private void reverse(int[] nums, int start) {
        int left = start;
        int right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            ++left;
            --right;
        }
    }
}
``` 
### 32.最长有效括号
题目链接            
https://leetcode-cn.com/problems/longest-valid-parentheses/             
https://leetcode.com/problems/longest-valid-parentheses/     
```java
package leetcode;

import java.util.Stack;

/*
给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。

示例 1：
输入：s = "(()"
输出：2
解释：最长有效括号子串是 "()"

示例 2：
输入：s = ")()())"
输出：4
解释：最长有效括号子串是 "()()"

示例 3：
输入：s = ""
输出：0

提示：
0 <= s.length <= 3 * 104
s[i] 为 '(' 或 ')'
 */
public class lc032 {
    /*
        时间复杂度:O(n)，nn是给定字符串的长度。只需要遍历字符串一次即可。
        空间复杂度:O(n)。栈的大小在最坏情况下会达到n，因此空间复杂度为O(n) 。
     */
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        Stack<Integer> stack = new Stack<Integer>();
        int start = 0;
        int result = 0;
        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (stack.isEmpty()) {
                    start = i + 1;
                } else {
                    stack.pop();
                    result = stack.isEmpty() ? Math.max(result, i - start + 1) : Math.max(result, i - stack.peek());
                }
            }
        }

        return result;
    }
}
```              
### 33.搜索旋转排序数组
题目链接            
https://leetcode-cn.com/problems/search-in-rotated-sorted-array/            
https://leetcode.com/problems/search-in-rotated-sorted-array/            
```java
package leetcode;

/*
整数数组 nums 按升序排列，数组中的值 互不相同 。
在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，
使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
例如，[0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
给你旋转后的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的下标，否则返回-1。

示例 1：
输入：nums = [4,5,6,7,0,1,2], target = 0
输出：4

示例 2：
输入：nums = [4,5,6,7,0,1,2], target = 3
输出：-1

示例 3：
输入：nums = [1], target = 0
输出：-1

提示：
1 <= nums.length <= 5000
-10^4 <= nums[i] <= 10^4
nums 中的每个值都 独一无二
题目数据保证 nums 在预先未知的某个下标上进行了旋转
-10^4 <= target <= 10^4
 */
public class lc033 {
    /*
        时间复杂度:O(logn)，其中n为num 数组的大小。整个算法时间复杂度即为二分查找的时间复杂度O(logn)。
        空间复杂度:O(1)。只需要常数级别的空间存放变量。
     */
    public int search(int[] nums, int target) {
        int size = nums.length;
        if (size == 0 || nums == null) {
            return -1;
        }

        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < nums[right]) {
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }
}
```              
### 34.在排序数组中查找元素的第一个和最后一个位置
题目链接                
https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/                   
https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/           
```java
package leetcode;

/*
给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
如果数组中不存在目标值 target，返回[-1, -1]。

进阶：
你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？

示例 1：
输入：nums = [5,7,7,8,8,10], target = 8
输出：[3,4]

示例2：
输入：nums = [5,7,7,8,8,10], target = 6
输出：[-1,-1]

示例 3：
输入：nums = [], target = 0
输出：[-1,-1]

提示：
0 <= nums.length <= 105
-10^9<= nums[i]<= 10^9
nums是一个非递减数组
-10^9<= target<= 10^9
 */
public class lc034 {
    /*
        时间复杂度:O(logn) ，其中n为数组的长度。二分查找的时间复杂度为O(logn)。
        空间复杂度:O(1) 。只需要常数空间存放若干变量。
     */
    public int[] searchRange(int[] nums, int target) {
        int size = nums.length;
        int[] result = {-1, -1};
        if (size == 0 || nums == null) {
            return result;
        }

        int left = 0;
        int right = size - 1;
        while (left <= right) {
            int mid = (left + right) >> 1;
            if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                int index = mid;
                while (index >= 0 && nums[index] == target) {
                    --index;
                }
                result[0] = index + 1;
                index = mid;
                while (index < size && nums[index] == target) {
                    ++index;
                }
                result[1] = index - 1;
                break;
            }
        }

        return result;
    }
}
```              
### 35.搜索插入位置
题目链接                
https://leetcode-cn.com/problems/search-insert-position/                
https://leetcode.com/problems/search-insert-position/            
```java
package leetcode;

/*
给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
你可以假设数组中无重复元素。

示例 1:
输入: [1,3,5,6], 5
输出: 2

示例2:
输入: [1,3,5,6], 2
输出: 1

示例 3:
输入: [1,3,5,6], 7
输出: 4

示例 4:
输入: [1,3,5,6], 0
输出: 0
 */
public class lc035 {
    /*
        问题可转化为「在一个有序数组中找第一个大于等于target的下标」
        直接套用二分法即可，即不断用二分法逼近查找第一个大于等于target的下标
        时间复杂度:O(logn)，其中n为数组的长度。二分查找所需的时间复杂度为O(logn)。
        空间复杂度:O(1)。只需要常数空间存放若干变量。
     */
    public int searchInsert(int[] nums, int target) {
        int size = nums.length;
        int left = 0;
        int right = size - 1;
        int result = size;
        while (left <= right) {
            int mid = (right - left >> 1) + left;
            if (target <= nums[mid]) {
                result = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return result;
    }
}
```                           
### 38.外观数列(数数并说)
题目链接                                    
https://leetcode-cn.com/problems/count-and-say/                 
https://leetcode.com/problems/count-and-say/            
```java
package leetcode;

/*
给定一个正整数n,输出外观数列的第n项。
「外观数列」是一个整数序列，从数字1开始，序列中的每一项都是对前一项的描述。
你可以将其视作是由递归公式定义的数字字符串序列：
countAndSay(1) = "1"
countAndSay(n) 是对 countAndSay(n-1) 的描述，然后转换成另一个数字字符串。
前五项如下：
1.     1
2.     11
3.     21
4.     1211
5.     111221
第一项是数字 1
描述前一项，这个数是 1 即 “ 一 个 1 ”，记作 "11"
描述前一项，这个数是 11 即 “ 二 个 1 ” ，记作 "21"
描述前一项，这个数是 21 即 “ 一 个 2 + 一 个 1 ” ，记作 "1211"
描述前一项，这个数是 1211 即 “ 一 个 1 + 一 个 2 + 二 个 1 ” ，记作 "111221"
要描述一个数字字符串，首先要将字符串分割为最小数量的组，每个组都由连续的最多相同字符组成。
然后对于每个组，先描述字符的数量，然后描述字符，形成一个描述组。要将描述转换为数字字符串，先将每组中的字符数量用数字替换，再将所有描述组连接起来。

示例 1：
输入：n = 1
输出："1"
解释：这是一个基本样例。

示例 2：
输入：n = 4
输出："1211"

解释：
countAndSay(1) = "1"
countAndSay(2) = 读 "1" = 一 个 1 = "11"
countAndSay(3) = 读 "11" = 二 个 1 = "21"
countAndSay(4) = 读 "21" = 一 个 2 + 一 个 1 = "12" + "11" = "1211"

提示：
1 <= n <= 30
 */
public class lc038 {
    public String countAndSay(int n) {
        if (n <= 0) {
            return null;
        }

        String s = "1";
        for (int i = 1; i < n; ++i) {
            StringBuilder tmp = new StringBuilder();
            int cnt = 1;
            for (int j = 1; j < s.length(); ++j) {
                if (s.charAt(j) == s.charAt(j - 1)) {
                    ++cnt;
                } else {
                    tmp.append(cnt);
                    tmp.append(s.charAt(j - 1));
                    cnt = 1;
                }
            }
            tmp.append(cnt);
            tmp.append(s.charAt(s.length() - 1));
            s = tmp.toString();
        }

        return s;
    }
}
```           
### 39.组合总和
题目链接            
https://leetcode-cn.com/problems/combination-sum/               
https://leetcode.com/problems/combination-sum/          
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的数字可以无限制重复被选取。

说明：
所有数字（包括target）都是正整数。
解集不能包含重复的组合。

示例1：
输入：candidates = [2,3,6,7], target = 7,
所求解集为：
[
  [7],
  [2,2,3]
]

示例2：
输入：candidates = [2,3,5], target = 8,
所求解集为：
[
 [2,2,2,2],
 [2,3,3],
 [3,5]
]

提示：
1 <= candidates.length <= 30
1 <= candidates[i] <= 200
candidate 中的每个元素都是独一无二的。
1 <= target <= 500
 */
public class lc039 {
    /*
      时间复杂度:O(S)，其中S为所有可行解的长度之和。时间复杂度取决于搜索树所有叶子节点的深度之和，即所有可行解的长度之和。
      空间复杂度:O(target)。除答案数组外，空间复杂度取决于递归的栈深度，在最差情况下需要递归O(target) 层。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        helper(candidates, target, 0, out, result);

        return result;
    }

    private void helper(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(out));
        }

        for (int i = start; i < candidates.length; ++i) {
            out.add(candidates[i]);
            helper(candidates, target - candidates[i], i, out, result);
            out.remove(out.size() - 1);
        }
    }
}
```                        
### 40.组合总和 II
题目链接            
https://leetcode-cn.com/problems/combination-sum-ii/                              
https://leetcode.com/problems/combination-sum-ii/               
```java
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
candidates中的每个数字在每个组合中只能使用一次。

说明：
所有数字（包括目标数）都是正整数。
解集不能包含重复的组合。

示例1:
输入: candidates =[10,1,2,7,6,1,5], target =8,
所求解集为:
[
  [1, 7],
  [1, 2, 5],
  [2, 6],
  [1, 1, 6]
]

示例2:
输入: candidates =[2,5,2,1,2], target =5,
所求解集为:
[
 [1,2,2],
 [5]
]
 */
public class lc040 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(candidates);
        helper(candidates, target, 0, out, result);

        return result;
    }

    private void helper(int[] candidates, int target, int start, List<Integer> out, List<List<Integer>> result) {
        if (target < 0) {
            return;
        }

        if (target == 0) {
            result.add(new ArrayList<>(out));
        }

        for (int i = start; i < candidates.length; ++i) {
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }
            out.add(candidates[i]);
            helper(candidates, target - candidates[i], i + 1, out, result);
            out.remove(out.size() - 1);
        }
    }
}
```     
### 41.缺失的第一个正数
题目链接      
https://leetcode-cn.com/problems/first-missing-positive/          
https://leetcode.com/problems/first-missing-positive/ 
```java
package leetcode;

/*
给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。

进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？

示例 1：
输入：nums = [1,2,0]
输出：3

示例 2：
输入：nums = [3,4,-1,1]
输出：2

示例 3：
输入：nums = [7,8,9,11,12]
输出：1
 */
public class lc041 {
    /*
        如果数组中包含x∈[1,N]，那么恢复后，数组的第x−1个元素为x。
        时间复杂度:O(N),其中N是数组的长度。
        空间复杂度:O(1)。
     */
    public int firstMissingPositive(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size; ++i) {
            while (nums[i] > 0 && nums[i] <= size && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for (int i = 0; i < size; ++i) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }

        return size + 1;
    }
}
```
### 42. 接雨水
题目链接                      
https://leetcode-cn.com/problems/trapping-rain-water/           
https://leetcode.com/problems/trapping-rain-water/           
```java
package leetcode;

/*
给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
 */
public class lc042 {
    /*
        方法一:先遍历一遍找到塔顶，然后分别从两边开始，往塔顶所在位置遍历，水位只会增高不会减小，
        且一直和最近遇到的最大高度持平，这样知道了实时水位，就可以边遍历边计算面积。
        时间复杂度:O(n)，其中n是数组height的长度。
        空间复杂度:O(1)。只需要使用常数的额外空间。
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int top = -1;
        int topIndex = 0;
        for (int i = 0; i < n; ++i) {
            if (height[i] > top) {
                top = height[i];
                topIndex = i;
            }
        }

        int area = 0;
        int root = height[0];
        for (int i = 0; i < topIndex; ++i) {
            if (root < height[i]) {
                root = height[i];
            } else {
                area += (root - height[i]);
            }
        }

        root = height[n - 1];
        for (int i = n - 1; i > topIndex; --i) {
            if (root < height[i]) {
                root = height[i];
            } else {
                area += (root - height[i]);
            }
        }

        return area;
    }

    /*
        方法二:left和right两个指针分别指向数组的首尾位置，从两边向中间扫描，在当前两指针确定的范围内，
        先比较两头找出较小值，如果较小值是left指向的值，则从左向右扫描，如果较小值是right指向的值，则从右向左扫描，
        若遇到的值比当较小值小，则将差值存入结果，如遇到的值大，则重新确定新的窗口范围，以此类推直至left和right指针重合。
        时间复杂度:O(n)，其中n是数组height的长度。两个指针的移动总次数不超过n。
        空间复杂度:O(1)。只需要使用常数的额外空间。
     */
    public int trap2(int[] height) {
        int n = height.length;
        if (n < 2) {
            return 0;
        }
        int area = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int min = height[left] < height[right] ? height[left] : height[right];
            if (height[left] == min) {
                ++left;
                while (left < right && height[left] < min) {
                    area += min - height[left];
                    ++left;
                }
            } else {
                --right;
                while (left < right && height[right] < min) {
                    area += min - height[right];
                    --right;
                }
            }
        }
        return area;
    }
}
```
### 43.字符串相乘
题目链接                
https://leetcode-cn.com/problems/multiply-strings/              
https://leetcode.com/problems/multiply-strings/          
```java
package leetcode;

/*
给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。

示例 1:
输入: num1 = "2", num2 = "3"
输出: "6"

示例 2:
输入: num1 = "123", num2 = "456"
输出: "56088"

说明：
num1和num2的长度小于110。
num1 和num2 只包含数字0-9。
num1 和num2均不以零开头，除非是数字 0 本身。
不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
 */
public class lc043 {
    /*
        如果num1和num2之一是0，则直接将0作为结果返回即可。如果num1和num2都不是0，则可以通过模拟「竖式乘法」的方法计算乘积。
        从右往左遍历乘数，将乘数的每一位与被乘数相乘得到对应的结果，再将每次得到的结果累加。这道题中，被乘数是num1，乘数是num2。
        需要注意的是num2除了最低位以外，其余的每一位的运算结果都需要补0。
        由于num1和num2的乘积的最大长度为m+n，因此创建长度为m+n的数组result用于存储乘积。对于任意0≤i<m 和0≤j<n，
        num1[i]×num2[j]的结果位于result[i+j+1]，如果result[i+j+1]≥10，则将进位部分加到result[i+j]。
        最后，将数组result转成字符串，如果最高位是0则舍弃最高位。
        
        时间复杂度:O(mn)，其中m和n分别是num1和num2的长度。需要计算num1的每一位和num2的每一位的乘积。
        空间复杂度:O(m+n)，其中m和n分别是num1和num2的长度。需要创建一个长度为m+n的数组存储乘积。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }

        int m = num1.length();
        int n = num2.length();
        int[] result = new int[m + n];
        for (int i = m - 1; i >= 0; --i) {
            int x = num1.charAt(i) - '0';
            for (int j = n - 1; j >= 0; --j) {
                int y = num2.charAt(j) - '0';
                result[i + j + 1] += x * y;
            }
        }

        for (int i = m + n - 1; i > 0; --i) {
            result[i - 1] += result[i] / 10;
            result[i] %= 10;
        }

        int index = result[0] == 0 ? 1 : 0;
        StringBuilder ans = new StringBuilder();
        while (index < m + n) {
            ans.append(result[index]);
            ++index;
        }

        return ans.toString();
    }
}
```
### 44.通配符匹配
题目链接                
https://leetcode-cn.com/problems/wildcard-matching/             
https://leetcode.com/problems/wildcard-matching/                
> 思路与算法:                
  在给定的模式p中，只会有三种类型的字符出现：                
  小写字母 a-za−z，可以匹配对应的一个小写字母；                    
  问号?，可以匹配任意一个小写字母；
  星号*，可以匹配任意字符串，可以为空，也就是匹配零或任意多个小写字母。
> ![lc044](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc044.png)                     
> ![lc044_2](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc044_2.png)                     
```java
package leetcode;

/*
给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
'?' 可以匹配任何单个字符。
'*' 可以匹配任意字符串（包括空字符串）。
两个字符串完全匹配才算匹配成功。

说明:
s可能为空，且只包含从a-z的小写字母。
p可能为空，且只包含从a-z的小写字母，以及字符?和*。

示例1:
输入:
s = "aa"
p = "a"
输出: false
解释: "a" 无法匹配 "aa" 整个字符串。

示例2:
输入:
s = "aa"
p = "*"
输出: true
解释:'*' 可以匹配任意字符串。

示例3:
输入:
s = "cb"
p = "?a"
输出: false
解释:'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。

示例4:
输入:
s = "adceb"
p = "*a*b"
输出: true
解释:第一个 '*' 可以匹配空字符串, 第二个 '*' 可以匹配字符串 "dce".

示例5:
输入:
s = "acdcb"
p = "a*c?b"
输出: false
 */
public class lc044 {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        boolean[][] dp = new boolean[m + 1][n + 1];
        dp[0][0] = true;
        for (int i = 1; i <= n; ++i) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[m][n];
    }
}
```
### 45.跳跃游戏 II
题目链接                
https://leetcode-cn.com/problems/jump-game-ii/              
https://leetcode.com/problems/jump-game-ii/          
```java
package leetcode;

/*
给定一个非负整数数组，你最初位于数组的第一个位置。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
你的目标是使用最少的跳跃次数到达数组的最后一个位置。
假设你总是可以到达数组的最后一个位置。

示例 1:
输入: [2,3,1,1,4]
输出: 2
解释: 跳到最后一个位置的最小跳跃数是 2。
     从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。

示例 2:
输入: [2,3,0,1,4]
输出: 2

提示:
1 <= nums.length <= 1000
0 <= nums[i] <= 105
 */
public class lc045 {
    /*
        方法一：反向查找出发位置
        目标是到达数组的最后一个位置，因此可以考虑最后一步跳跃前所在的位置，该位置通过跳跃能够到达最后一个位置。
        如果有多个位置通过跳跃都能够到达最后一个位置，那么应该如何进行选择呢？直观上来看，可以「贪心」地选择距离最后一个位置最远的那个位置，
        也就是对应下标最小的那个位置。因此，我们可以从左到右遍历数组，选择第一个满足要求的位置。
        找到最后一步跳跃前所在的位置之后，继续贪心地寻找倒数第二步跳跃前所在的位置，以此类推，直到找到数组的开始位置。

        时间复杂度：O(n^2)，其中n是数组长度。有两层嵌套循环，在最坏的情况下，例如数组中的所有元素都是1，position需要遍历数组中的每个位置，对于position的每个值都有一次循环。
        空间复杂度：O(1)。
     */
    public int jump(int[] nums) {
        int position = nums.length - 1;
        int steps = 0;
        while (position > 0) {
            for (int i = 0; i < position; ++i) {
                if (i + nums[i] >= position) {
                    position = i;
                    steps++;
                    break;
                }
            }
        }

        return steps;
    }

    /*
        方法二：正向查找可到达的最大位置
        维护当前能够到达的最大下标位置，记为边界。从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加1。
        在遍历数组时，不访问最后一个元素，这是因为在访问最后一个元素之前，边界一定大于等于最后一个位置，否则就无法跳到最后一个位置了。
        如果访问最后一个元素，在边界正好为最后一个位置的情况下，会增加一次「不必要的跳跃次数」，因此不必访问最后一个元素。
        时间复杂度：O(n)，其中n是数组长度。
        空间复杂度：O(1)。
     */
    public int jump2(int[] nums) {
        int n = nums.length;
        int step = 0;
        int curReach = 0;
        int maxReach = 0;
        for (int i = 0; i < n - 1; ++i) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (curReach == i) {
                ++step;
                curReach = maxReach;
            }
        }

        return step;
    }
}
```
### 46.全排列
题目链接            
https://leetcode-cn.com/problems/permutations/              
https://leetcode.com/problems/permutations/             
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个 没有重复 数字的序列，返回其所有可能的全排列。

示例:
输入: [1,2,3]
输出:
[
  [1,2,3],
  [1,3,2],
  [2,1,3],
  [2,3,1],
  [3,1,2],
  [3,2,1]
]
 */
public class lc046 {
    public List<List<Integer>> permute(int[] nums) {
        // 最终返回的结果集
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        if (size == 0 || nums == null) {
            return result;
        }
        helper(nums, 0, result);

        return result;
    }

    private void helper(int[] nums, int start, List<List<Integer>> result) {
        // 将当前数组加到结果集中
        if (start == nums.length) {
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < nums.length; ++i) {
                list.add(nums[i]);
            }
            result.add(list);
            return;
        }

        // 将当前位置的数跟后面的数交换，并搜索解
        for (int i = start; i < nums.length; ++i) {
            swap(nums, i, start);
            helper(nums, start + 1, result);
            swap(nums, i, start);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```              
### 47.全排列 II
题目链接                
https://leetcode-cn.com/problems/permutations-ii/               
https://leetcode.com/problems/permutations-ii/           
```java
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给定一个可包含重复数字的序 nums ，按任意顺序 返回所有不重复的全排列。

示例 1：
输入：nums = [1,1,2]
输出：
[[1,1,2],
 [1,2,1],
 [2,1,1]]

示例 2：
输入：nums = [1,2,3]
输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]

提示：
1 <= nums.length <= 8
-10 <= nums[i] <= 10
 */
public class lc047 {
    /*
        时间复杂度：O(n×n!)，其中n为序列的长度。
        空间复杂度：O(n)，其中n为序列的长度。
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int size = nums.length;
        if (size == 0 || nums == null) {
            return result;
        }

        boolean[] used = new boolean[size];
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, used, out, result);

        return result;
    }

    public void dfs(int[] nums, boolean[] used, List<Integer> out, List<List<Integer>> result) {
        if (out.size() == nums.length) {
            result.add(new ArrayList<>(out));
            return;
        }

        for (int i = 0; i < nums.length; ++i) {
            // 当前位置的数已经在List中了
            if (used[i]) {
                continue;
            }

            // 当前元素与其前一个元素值相同 且 前元素未被加到list中，跳过该元素
            if (i > 0 && nums[i] == nums[i - 1] && used[i - 1]) {
                continue;
            }

            // 深度优先搜索遍历
            used[i] = true;
            out.add(nums[i]);
            dfs(nums, used, out, result);
            out.remove(out.size() - 1);
            used[i] = false;
        }
    }
}
```
### 48.旋转图像
题目链接                
https://leetcode-cn.com/problems/rotate-image/          
https://leetcode.com/problems/rotate-image/          
```java
package leetcode;

/*
给定一个n×n的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转90度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]

示例 2：
输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

示例 3：
输入：matrix = [[1]]
输出：[[1]]

示例 4：
输入：matrix = [[1,2],[3,4]]
输出：[[3,1],[4,2]]
 */
public class lc048 {
    /*
        时间复杂度：O(N^2)，其中N是matrix的边长。对于每一次翻转操作都需要枚举矩阵中一半的元素。
        空间复杂度：O(1)。为原地翻转得到的原地旋转。
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //沿左上至右下对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //水平翻转每一行
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
```
### 49.字母异位词分组
题目链接            
https://leetcode-cn.com/problems/group-anagrams/            
https://leetcode.com/problems/group-anagrams/           
```java
package leetcode;

import java.util.*;

/*
给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。

示例:
输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
输出:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]

说明：
所有输入均为小写字母。
 */
public class lc049 {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        int size = strs.length;
        if (size < 1) {
            return result;
        }

        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] arrayOfString = str.toCharArray();
            Arrays.sort(arrayOfString);
            String tmp = new String(arrayOfString);
            if (map.containsKey(tmp)) {
                map.get(tmp).add(str);
            } else {
                List<String> item = new ArrayList<>();
                item.add(str);
                map.put(tmp, item);
            }
        }

        for (List<String> value : map.values()) {
            result.add(value);
        }

        return result;
    }
}
```
### 50.Pow(x, n)
题目链接    
https://leetcode-cn.com/problems/powx-n/        
https://leetcode.com/problems/powx-n/
```java
package leetcode;

/*
实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。

示例 1：
输入：x = 2.00000, n = 10
输出：1024.00000

示例 2：
输入：x = 2.10000, n = 3
输出：9.26100

示例 3：
输入：x = 2.00000, n = -2
输出：0.25000
解释：2-2 = 1/22 = 1/4 = 0.25

提示：

-100.0 <x< 100.0
-2^31<= n <=2^31-1
-10^4 <= xn <= 10^4
 */
public class lc050 {
    /*
        时间复杂度：O(logn)，即为递归的层数。
        空间复杂度：空间复杂度：O(1)。
     */
    public double myPow(double x, int n) {
        double res = 1.0;
        for (int i = n; i != 0; i /= 2) {
            if (i % 2 != 0) {
                res *= x;
            }
            x *= x;
        }

        return n < 0 ? 1 / res : res;
    }
}
```
### 53.最大子序和
题目链接      
https://leetcode-cn.com/problems/maximum-subarray/      
https://leetcode.com/problems/maximum-subarray/      
```java
package leetcode;

/*
给定一个整数数组nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。

示例 1：
输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
输出：6
解释：连续子数组[4,-1,2,1] 的和最大，为6 。

示例 2：
输入：nums = [1]
输出：1

示例 3：
输入：nums = [0]
输出：0

示例 4：
输入：nums = [-1]
输出：-1

示例 5：
输入：nums = [-100000]
输出：-100000
 */
public class lc053 {
    //方法一：暴力解
    public int maxSubArray(int[] nums) {
        int size = nums.length;
        if (size == 0 || nums == null) {
            return Integer.MIN_VALUE;
        }

        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < size; ++i) {
            int curSum = 0;
            for (int j = i; j < size; ++j) {
                curSum += nums[j];
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }

        return maxSum;
    }

    public int maxSubArray2(int[] nums) {
        int size = nums.length;
        if (size == 0 || nums == null) {
            return Integer.MIN_VALUE;
        }

        int maxSum = nums[0];
        int curSum = nums[0];
        for (int i = 1; i < size; ++i) {
            if (curSum < 0) {
                curSum = nums[i];
            } else {
                curSum += nums[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }
}
```
### 54.螺旋矩阵
题目链接            
https://leetcode-cn.com/problems/spiral-matrix/         
https://leetcode.com/problems/spiral-matrix/
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给你一个m行n列的矩阵matrix ，请按照顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class lc054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        if (matrix == null || row == 0 || col == 0) {
            return result;
        }

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        //螺旋曲线，运动轨迹总是一致的
        while (top <= bottom && left <= right) {
            //向右列递增遍历
            for (int j = left; j <= right; ++j) {
                result.add(matrix[top][j]);
            }

            //遍历后，去掉此行
            ++top;

            //向下行递增遍历
            for (int i = top; i <= bottom; ++i) {
                result.add(matrix[i][right]);
            }

            //遍历后，去掉此行
            --right;

            if (top <= bottom) {//重要判断，防止重复
                //向左列递减遍历
                for (int j = right; j >= left; --j) {
                    result.add(matrix[bottom][j]);
                }
            }

            //遍历后，去掉此行
            --bottom;

            if (left <= right) {//重要判断，防止重复
                //向上行递减遍历
                for (int i = bottom; i >= top; --i) {
                    result.add(matrix[i][left]);
                }
            }

            //遍历后，去掉此列
            ++left;
        }

        return result;
    }
}
```
### 55.跳跃游戏
题目链接                
https://leetcode-cn.com/problems/jump-game/         
https://leetcode.com/problems/jump-game/            
```java
package leetcode;

/*
给定一个非负整数数组nums ，你最初位于数组的第一个下标 。
数组中的每个元素代表你在该位置可以跳跃的最大长度。
判断你是否能够到达最后一个下标。

示例 1：
输入：nums = [2,3,1,1,4]
输出：true
解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。

示例 2：
输入：nums = [3,2,1,0,4]
输出：false
解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。

提示：
1 <= nums.length <= 3 * 104
0 <= nums[i] <= 105
 */
public class lc055 {
    /*
        时间复杂度：O(n)，其中n为数组的大小。只需要访问nums数组一遍，共n个位置。
        空间复杂度：O(1)，不需要额外的空间开销。
     */
    public boolean canJump(int[] nums) {
        int size = nums.length;

        //维护当前能跳到的最大位置
        int maxJump = 0;
        for (int i = 0; i < size; ++i) {
            // i>maxJump表示无法到达i的位置,失败
            // maxJump >= (n - 1),此时的距离已经足够到达终点，成功
            if (i > maxJump || maxJump >= (size - 1)) {
                break;
            }

            // nums[i]+i当前跳最远距离
            // maxJump为i之前跳最远距离
            maxJump = maxJump > (i + nums[i]) ? maxJump : (i + nums[i]);
        }

        return maxJump >= (size - 1);
    }

    public boolean canJump2(int[] nums) {
        int n = nums.length;

        // dp[i]表示当前跳跃的最大距离
        int[] dp = new int[n];
        dp[0] = nums[0];

        // i表示当前距离，也是下标
        for (int i = 1; i < n; ++i) {
            // i点可达
            if (i <= dp[i - 1]) {
                dp[i] = dp[i - 1] > (nums[i] + i) ? dp[i - 1] : (nums[i] + i);
            } else {
                dp[i] = dp[i - 1];
            }
        }

        return dp[n - 1] >= (n - 1);
    }
}
```
### 56.合并区间
题目链接                
https://leetcode-cn.com/problems/merge-intervals/               
https://leetcode.com/problems/merge-intervals/          
```java
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
以数组intervals表示若干个区间的集合，其中单个区间为intervals[i] = [starti, endi] 。
请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。

示例 1：
输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
输出：[[1,6],[8,10],[15,18]]
解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].

示例 2：
输入：intervals = [[1,4],[4,5]]
输出：[[1,5]]
解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
 */
public class lc056 {
    /*  按照区间的左端点升序排序，那么在排完序的列表中，可以合并的区间一定是连续的。
        算法:数组merged存储最终的答案,将列表中的区间按照左端点升序排序。然后将第一个区间加入merged数组中，并按顺序依次考虑之后的每个区间：
            如果当前区间的左端点在数组merged中最后一个区间的右端点之后，那么它们不会重合，可以直接将这个区间加入数组merged的末尾；
            否则，它们重合，需要用当前区间的右端点更新数组merged中最后一个区间的右端点，将其置为二者的较大值。
        时间复杂度：O(nlogn)，其中n为区间的数量。除去排序的开销，我们只需要一次线性扫描，所以主要的时间开销是排序的O(nlogn)。
        空间复杂度：O(logn)，其中n为区间的数量。这里计算的是存储答案之外，使用的额外空间。O(logn)即为排序所需要的空间复杂度。
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0) {
            return new int[0][2];
        }

        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] interval1, int[] interval2) {
                return interval1[0] - interval2[0];
            }
        });

        List<int[]> merged = new ArrayList<int[]>();
        for (int i = 0; i < intervals.length; ++i) {
            int left = intervals[i][0];
            int right = intervals[i][1];
            // 当前区间的左端点在数组merged中最后一个区间的右端点之后，那么它们不会重合，可以直接将这个区间加入数组merged的末尾
            if (merged.size() == 0 || merged.get(merged.size() - 1)[1] < left) {
                merged.add(new int[]{left, right});
            } else {
                // 重合，需要用当前区间的右端点更新数组merged中最后一个区间的右端点，将其置为二者的较大值。
                merged.get(merged.size() - 1)[1] = Math.max(merged.get(merged.size() - 1)[1], right);
            }
        }

        return merged.toArray(new int[merged.size()][]);
    }
}
```
### 57.插入区间
题目链接            
https://leetcode-cn.com/problems/insert-interval/               
https://leetcode.com/problems/insert-interval/          
> ![lc057](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc057.png)                       
> ![lc057_2](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc057_2.png)                       
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给你一个无重叠的 ，按照区间起始端点排序的区间列表。
在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。

示例 1：
输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
输出：[[1,5],[6,9]]

示例 2：
输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
输出：[[1,2],[3,10],[12,16]]
解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。

示例 3：
输入：intervals = [], newInterval = [5,7]
输出：[[5,7]]

示例 4：
输入：intervals = [[1,5]], newInterval = [2,3]
输出：[[1,5]]

示例 5：
输入：intervals = [[1,5]], newInterval = [2,7]
输出：[[1,7]]
 */
public class lc057 {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int left = newInterval[0];
        int right = newInterval[1];
        boolean placed = false;
        List<int[]> ansList = new ArrayList<int[]>();
        for (int[] interval : intervals) {
            // 无交集,在插入区间的左侧
            if (interval[1] < left) {
                ansList.add(interval);

                // 无交集,在插入区间的右侧
            } else if (interval[0] > right) {
                if (!placed) {
                    ansList.add(new int[]{left, right});
                    placed = true;
                }
                ansList.add(interval);
            } else {
                // 与插入区间有交集，计算它们的并集
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }
        }

        if (!placed) {
            ansList.add(new int[]{left, right});
        }

        return ansList.toArray(new int[ansList.size()][]);
    }
}
```
### 58.最后一个单词的长度
题目链接            
https://leetcode-cn.com/problems/length-of-last-word/           
https://leetcode.com/problems/length-of-last-word/       
```java
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
```
### 59.螺旋矩阵 II
题目链接
https://leetcode-cn.com/problems/spiral-matrix-ii/          
https://leetcode.com/problems/spiral-matrix-ii/          
```java
package leetcode;

/*
给你一个正整数n，生成一个包含1到n^2所有元素，且元素按顺时针顺序螺旋排列的n x n正方形矩阵matrix 。

示例 1：
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]

示例 2：
输入：n = 1
输出：[[1]]

提示：
1 <= n <= 20
 */
public class lc059 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (top <= bottom && left <= right) {
            if (num <= n * n) {
                for (int j = left; j <= right; ++j) {
                    result[top][j] = num;
                    ++num;
                }
            }

            ++top;

            if (num <= n * n) {
                for (int i = top; i <= bottom; ++i) {
                    result[i][right] = num;
                    ++num;
                }
            }

            --right;

            if (num <= n * n) {
                for (int j = right; j >= left; --j) {
                    result[bottom][j] = num;
                    ++num;
                }
            }

            --bottom;

            if (num <= n * n) {
                for (int i = bottom; i >= top; --i) {
                    result[i][left] = num;
                    ++num;
                }
            }

            ++left;
        }

        return result;
    }
}
```
### 60.排列序列
题目链接            
https://leetcode-cn.com/problems/permutation-sequence/          
https://leetcode.com/problems/permutation-sequence/          
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给出集合[1,2,3,...,n]，其所有元素共有n!种排列。
按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
"123"
"132"
"213"
"231"
"312"
"321"

给定n和k，返回第k个排列。

示例 1：
输入：n = 3, k = 3
输出："213"

示例 2：
输入：n = 4, k = 9
输出："2314"

示例 3：
输入：n = 3, k = 1
输出："123"

提示：
1 <= n <= 9
1 <= k <= n!
 */
public class lc060 {
    /*
        在数列1，2，3，... , n构建的全排列中，返回第k个排列。
        对于n个数可以有n!种排列；那么n-1个数就有(n-1)!种排列。
        那么对于n位数来说，如果除去最高位不看，后面的n-1位就有 (n-1)!种排列。
        所以，还是对于n位数来说，每一个不同的最高位数，后面可以拼接(n-1)!种排列。
        所以可以看成是按照每组(n-1)!个这样分组。
        利用k/(n-1)!可以取得最高位在数列中的index。这样第k个排列的最高位就能从数列中的index位取得，此时还要把这个数从数列中删除。
        然后，新的k就可以由k%(n-1)!获得。循环n次即可。同时，为了可以跟数组坐标对其，令k先--。
        时间复杂度：O(n^2)。
        空间复杂度：O(n)。
     */
    public String getPermutation(int n, int k) {
        //为了可以跟数组坐标对其，令k先--
        --k;

        List<Integer> numList = new ArrayList<>();
        for (int i = 1; i <= n; ++i) {
            numList.add(i);
        }

        //计算n!
        int fac = 1;
        for (int i = 2; i < n; ++i) {
            fac *= i;
        }

        StringBuilder res = new StringBuilder();
        int times = n - 1;
        while (times >= 0) {
            int indexInList = k / fac;
            res.append(numList.get(indexInList));
            numList.remove(indexInList);

            //新的k就可以由k%(n-1)!获得
            k = k % fac;

            if (times != 0) {
                fac = fac / times;
            }

            --times;
        }

        return res.toString();
    }
}
```
### 61.旋转链表
题目链接            
https://leetcode-cn.com/problems/rotate-list/               
https://leetcode.com/problems/rotate-list/               
```java
package leetcode;

/*
给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动 k 个位置。

示例 1：
输入：head = [1,2,3,4,5], k = 2
输出：[4,5,1,2,3]

示例 2：
输入：head = [0,1,2], k = 4
输出：[2,0,1]

提示：
链表中节点的数目在范围 [0, 500] 内
-100 <= Node.val <= 100
0 <= k <= 2 * 10^9
 */
public class lc061 {
    /*
        时间复杂度：O(n)，最坏情况下，需要遍历该链表两次。
        空间复杂度：O(1)，只需要常数的空间存储若干变量。
     */
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k <= 0) {
            return head;
        }

        int len = 0;
        ListNode cur = head;
        while (cur != null) {
            ++len;
            cur = cur.next;
        }

        k %= len;

        ListNode slow = head;
        ListNode fast = head;
        for (int i = 0; i < k; ++i) {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return head;
            }
        }

        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }

        fast.next = head;
        fast = slow.next;
        slow.next = null;

        return fast;
    }
}
```
### 62.不同路径
题目链接            
https://leetcode-cn.com/problems/unique-paths/          
https://leetcode.com/problems/unique-paths/          
```java
package leetcode;

/*
一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
问总共有多少条不同的路径？

示例 1：
输入：m = 3, n = 7
输出：28

示例 2：
输入：m = 3, n = 2
输出：3
解释：
从左上角开始，总共有 3 条路径可以到达右下角。
1. 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右
3. 向下 -> 向右 -> 向下

示例 3：
输入：m = 7, n = 3
输出：28

示例 4：
输入：m = 3, n = 3
输出：6

提示：
1 <= m, n <= 100
题目数据保证答案小于等于 2 * 109
 */
public class lc062 {
    /*
        时间复杂度：O(mn)
        空间复杂度：O(mn)
     */
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        }

        if (m == 1 || n == 1) {
            return 1;
        }

        int[][] dp = new int[m][n];

        //只有一行时，到终点每个格子只有一种走法
        for (int j = 0; j < n; ++j) {
            dp[0][j] = 1;
        }

        // 只有一列时，到终点每个格子只有一种走法
        for (int i = 0; i < m; ++i) {
            dp[i][0] = 1;
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }

        return dp[m - 1][n - 1];
    }
}
```
### 63.不同路径 II
题目链接            
https://leetcode-cn.com/problems/unique-paths-ii/           
https://leetcode.com/problems/unique-paths-ii/       
```java
package leetcode;

/*
一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为“Start” ）。
机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
网格中的障碍物和空位置分别用 1 和 0 来表示。

示例 1：
输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
输出：2
解释：
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右

示例 2：
输入：obstacleGrid = [[0,1],[0,0]]
输出：1

提示：
m ==obstacleGrid.length
n ==obstacleGrid[i].length
1 <= m, n <= 100
obstacleGrid[i][j] 为 0 或 1
 */
public class lc063 {
    /*
        时间复杂度：O(nm)，其中n为网格的行数，m为网格的列数。只需要遍历所有网格一次即可。
        空间复杂度：O(nm)。
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        if (m == 0 || n == 0) {
            return 0;
        }

        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];

        dp[0][0] = 1;

        //处理第一行
        for (int j = 1; j < n; ++j) {
            if (obstacleGrid[0][j] == 1) {
                dp[0][j] = 0;
            } else {
                dp[0][j] = dp[0][j - 1];
            }
        }

        //处理第一列
        for (int i = 1; i < m; ++i) {
            if (obstacleGrid[i][0] == 1) {
                dp[i][0] = 0;
            } else {
                dp[i][0] = dp[i - 1][0];
            }
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /*
        时间复杂度：O(nm)，其中n为网格的行数，m为网格的列数。只需要遍历所有网格一次即可。
        空间复杂度：O(m)。利用滚动数组优化，可以只用O(m)大小的空间来记录当前行的f值。
     */
    public int uniquePathsWithObstacles2(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        int[] f = new int[n];
        f[0] = obstacleGrid[0][0] == 0 ? 1 : 0;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (obstacleGrid[i][j] == 1) {
                    f[j] = 0;
                    continue;
                }

                if (j - 1 >= 0 && obstacleGrid[i][j - 1] == 0) {
                    f[j] += f[j - 1];
                }
            }
        }

        return f[n - 1];
    }
}
```
### 64.最小路径和
题目链接            
https://leetcode-cn.com/problems/minimum-path-sum/          
https://leetcode.com/problems/minimum-path-sum/         
```java
package leetcode;

/*
给定一个包含非负整数的mxn网格grid,请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
说明：每次只能向下或者向右移动一步。

示例 1：
输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
输出：7
解释：因为路径 1→3→1→1→1 的总和最小。

示例 2：
输入：grid = [[1,2,3],[4,5,6]]
输出：12

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 200
0 <= grid[i][j] <= 100
 */
public class lc064 {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int j = 1; j < n; ++j) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for (int i = 1; i < m; ++i) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }

        for (int i = 1; i < m; ++i) {
            for (int j = 1; j < n; ++j) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }
}
```
### 66.加一
题目链接            
https://leetcode-cn.com/problems/plus-one/          
https://leetcode.com/problems/plus-one/          
```java
package leetcode;

/*
给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
你可以假设除了整数 0 之外，这个整数不会以零开头。

示例 1：
输入：digits = [1,2,3]
输出：[1,2,4]
解释：输入数组表示数字 123。

示例 2：
输入：digits = [4,3,2,1]
输出：[4,3,2,2]
解释：输入数组表示数字 4321。

示例 3：
输入：digits = [0]
输出：[1]

提示：
1 <= digits.length <= 100
0 <= digits[i] <= 9
 */
public class lc066 {
    public int[] plusOne(int[] digits) {
        /*
            只加一的所以有可能的情况就只有两种：
            除9之外的数字加一；数字9加一。
            加一得十进一位个位数为0加法运算如不出现进位就运算结束了且进位只会是一。
            所以只需要判断有没有进位并模拟出它的进位方式，如十位数加1个位数置为0，如此循环直到判断没有再进位就退出循环返回结果。
            然后还有一些特殊情况就是当出现99、999之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。
         */
        for (int i = digits.length - 1; i >= 0; --i) {
            ++digits[i];
            digits[i] = digits[i] % 10;
            if (digits[i] != 0) {
                return digits;
            }
        }

        digits = new int[digits.length + 1];
        digits[0] = 1;

        return digits;
    }
}
```
### 67.二进制求和
题目链接        
https://leetcode-cn.com/problems/add-binary/            
https://leetcode.com/problems/add-binary/        
```java
package leetcode;

/*
给你两个二进制字符串，返回它们的和（用二进制表示）。
输入为非空字符串且只包含数字1和0。

示例1:
输入: a = "11", b = "1"
输出: "100"

示例2:
输入: a = "1010", b = "1011"
输出: "10101"

提示：
每个字符串仅由字符 '0' 或 '1' 组成。
1 <= a.length, b.length <= 10^4
字符串如果不是 "0" ，就都不含前导零。
 */
public class lc067 {
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int carry = 0;
        int i = a.length() - 1;
        int j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry == 1) {
            carry += i >= 0 ? a.charAt(i) - '0' : 0;
            carry += j >= 0 ? b.charAt(j) - '0' : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
            --i;
            --j;
        }

        return ans.reverse().toString();
    }
}
```
### 69.x 的平方根
题目链接            
https://leetcode-cn.com/problems/sqrtx/             
https://leetcode.com/problems/sqrtx/         
```java
package leetcode;

/*
实现int sqrt(int x)函数。
计算并返回x的平方根，其中 x 是非负整数。
由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。

示例 1:
输入: 4
输出: 2

示例 2:
输入: 8
输出: 2

说明: 8 的平方根是 2.82842...,
     由于返回类型是整数，小数部分将被舍去。
 */
public class lc069 {
    /*
        方法一：暴力解
        时间复杂度：O(logx)，即为二分查找需要的次数。
        空间复杂度：O(1)。
     */
    public int mySqrt(int x) {
        if (x < 0) {
            return x;
        }

        int begin = 1;
        int end = x;
        int mid = 0;
        while (begin <= end) {
            mid = (begin + end) >> 1;
            if (mid == x / mid) {
                return mid;
            } else if (mid < x / mid) {
                begin = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        // 结束条件end一定<begin，所以返回end
        return end;
    }

    /*
         牛顿迭代法
         时间复杂度：O(logx)，此方法是二次收敛的，相较于二分查找更快。
         空间复杂度：O(1)。
     */
    public int mySqrt2(int x) {
        if (x < 0) {
            return x;
        }

        long v = x;
        while (v * v > x) {
            v = (v + x / v) / 2;
        }

        return (int) v;
    }
}
```
### 70.爬楼梯
题目链接        
https://leetcode-cn.com/problems/climbing-stairs/           
https://leetcode.com/problems/climbing-stairs/           
```java
package leetcode;

/*
假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
注意：给定 n 是一个正整数。

示例 1：
输入： 2
输出： 2
解释： 有两种方法可以爬到楼顶。
1.  1 阶 + 1 阶
2.  2 阶

示例 2：
输入： 3
输出： 3
解释： 有三种方法可以爬到楼顶。
1.  1 阶 + 1 阶 + 1 阶
2.  1 阶 + 2 阶
3.  2 阶 + 1 阶
 */
public class lc070 {
    public int climbStairs(int n) {
        if (n == 0 || n == 1 || n == 2) {
            return n;
        }

        return climbStairs(n - 1) + climbStairs(n - 2);
    }

    public int climbStairs2(int n) {
        if (n < 2) {
            return n;
        }

        int temp = 0;
        int pre = 1;
        int result = 1;
        for (int i = 2; i <= n; ++i) {
            temp = result;
            result = result + pre;
            pre = temp;
        }

        return result;
    }

    public int climbStairs3(int n) {
        if (n == 0 || n == 1 || n == 3) {
            return n;
        }

        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < n; ++i) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n - 1];
    }
}
```
### 71.简化路径
题目链接            
https://leetcode-cn.com/problems/simplify-path/         
https://leetcode.com/problems/simplify-path/         
```java
package leetcode;

import java.util.*;

/*
给你一个字符串path ，表示指向某一文件或目录Unix风格绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点（..）表示将目录切换到上一级（指向父目录）；
两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他
格式的点（例如，'...'）均被视为文件/目录名称。

请注意，返回的 规范路径 必须遵循下述格式：
始终以斜杠 '/' 开头。
两个目录名之间必须只有一个斜杠 '/' 。
最后一个目录名（如果存在）不能 以 '/' 结尾。
此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
返回简化后得到的 规范路径 。

示例 1：
输入：path = "/home/"
输出："/home"
解释：注意，最后一个目录名后面没有斜杠。

示例 2：
输入：path = "/../"
输出："/"
解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。

示例 3：
输入：path = "/home//foo/"
输出："/home/foo"
解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。

示例 4：
输入：path = "/a/./b/../../c/"
输出："/c"

提示：
1 <= path.length <= 3000
path 由英文字母，数字，'.'，'/' 或 '_' 组成。
path 是一个有效的 Unix 风格绝对路径。
 */
public class lc071 {
    public String simplifyPath(String path) {
        //用栈来模拟
        LinkedList<String> stack = new LinkedList<>();

        //用/分割，多个/也视为/
        String[] strArr = path.split("/");
        for (String s : strArr) {
            //如果等于空或者等于.，那就没有影响
            if (s.equals("") || s.equals(".")) {
                continue;
            }

            //如果等于..，那就要返回上一级目录，因此栈中弹出当前目录
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            //栈中压入当前目录
            stack.push(s);
        }

        StringBuffer sb = new StringBuffer();
        Collections.reverse(stack);
        while (!stack.isEmpty()) {
            sb.append("/").append(stack.pop());
        }
        if (sb.length() == 0) {
            sb.append("/");
        }

        return sb.toString();
    }

    public String simplifyPath2(String path) {
        Stack<String> stack = new Stack<String>();

        String[] strs = path.split("/");
        for (String str : strs) {
            if (!stack.isEmpty() && str.equals("..")) {
                stack.pop();
            } else if (!str.equals("") && !str.equals(".") && !str.equals("..")) {
                stack.push(str);
            }
        }

        List<String> result = new ArrayList<>(stack);
        return "/" + String.join("/", result);
    }
}
```
### 72.编辑距离
题目链接            
https://leetcode-cn.com/problems/edit-distance/         
https://leetcode.com/problems/edit-distance/         
```java
package leetcode;

/*
给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
你可以对一个单词进行如下三种操作：
插入一个字符
删除一个字符
替换一个字符

示例1：
输入：word1 = "horse", word2 = "ros"
输出：3
解释：
horse -> rorse (将 'h' 替换为 'r')
rorse -> rose (删除 'r')
rose -> ros (删除 'e')

示例2：
输入：word1 = "intention", word2 = "execution"
输出：5
解释：
intention -> inention (删除 't')
inention -> enention (将 'i' 替换为 'e')
enention -> exention (将 'n' 替换为 'x')
exention -> exection (将 'n' 替换为 'c')
exection -> execution (插入 'u')

提示：
0 <= word1.length, word2.length <= 500
word1 和 word2 由小写英文字母组成
 */
public class lc072 {
    /*
        时间复杂度:O(mn)，其中m为word1的长度，n为word2的长度。
        空间复杂度:O(mn)，需要大小为O(mn)的数组来记录状态值。
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        //dp[i][j]表示从word1的前i个字符转换到word2的前j个字符所需要的步骤
        int[][] dp = new int[m + 1][n + 1];

        //先给这个二维数组dp的第一行第一列赋值，因为第一行和第一列对应的总有一个字符串是空串，于是转换步骤完全是另一个字符串的长度。
        for (int i = 0; i <= m; ++i) {
            dp[i][0] = i;
        }

        for (int j = 0; j <= n; ++j) {
            dp[0][j] = j;
        }

        //当word1[i] == word2[j]时，dp[i][j] = dp[i - 1][j - 1]，其他情况时，dp[i][j]是其左，左上，上的三个值中的最小值加1
        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j - 1], dp[i][j - 1]), dp[i - 1][j]) + 1;
                }
            }
        }

        return dp[m][n];
    }
}
```
### 73.矩阵置零
题目链接            
https://leetcode-cn.com/problems/set-matrix-zeroes/         
https://leetcode.com/problems/set-matrix-zeroes/             
```java
package leetcode;

/*
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用原地算法。

进阶：
一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？
 */
public class lc073 {
    /*
        先扫描第一行第一列，如果有0，则将各自的flag设置为true
        然后扫描除去第一行第一列的整个数组，如果有0，则将对应的第一行和第一列的数字赋0
        再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0
        最后根据第一行第一列的flag来更新第一行第一列
     */
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean rowZero=false;
        boolean colZero=false;
        for(int j=0;j<n;++j){
            if(matrix[0][j]==0){
                rowZero=true;
            }
        }
        for(int i=0;i<m;++i){
            if(matrix[i][0]==0){
                colZero=true;
            }
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowZero){
            for(int j=0;j<n;++j){
                matrix[0][j]=0;
            }
        }
        if(colZero){
            for(int i=0;i<m;++i){
                matrix[i][0]=0;
            }
        }
    }
}
```
### 74.搜索二维矩阵
题目链接            
https://leetcode-cn.com/problems/search-a-2d-matrix/            
https://leetcode.com/problems/search-a-2d-matrix/            
```java
package leetcode;

/*
编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
每行中的整数从左到右按升序排列。
每行的第一个整数大于前一行的最后一个整数。

示例 1：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
输出：true

示例 2：
输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
输出：false

提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 100
-10^4 <= matrix[i][j], target <= 10^4
 */
public class lc074 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;

        int i = 0;
        int j = col - 1;
        while (i < row && j >= 0) {
            if (matrix[i][j] < target) {
                ++i;
            } else if (matrix[i][j] > target) {
                --j;
            } else {
                return true;
            }
        }

        return false;
    }
}
```
### 75.颜色分类
题目链接                
https://leetcode-cn.com/problems/sort-colors/               
https://leetcode.com/problems/sort-colors/           
```java
package leetcode;

/*
给定一个包含红色、白色和蓝色，一共n个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
此题中，使用整数 0、1 和 2 分别表示红色、白色和蓝色。

示例 1：
输入：nums = [2,0,2,1,1,0]
输出：[0,0,1,1,2,2]

示例 2：
输入：nums = [2,0,1]
输出：[0,1,2]

示例 3：
输入：nums = [0]
输出：[0]

示例 4：
输入：nums = [1]
输出：[1]

提示：
n == nums.length
1 <= n <= 300
nums[i] 为 0、1 或 2
 */
public class lc075 {
    /*
        时间复杂度：O(n)，其中n是数组 nums 的长度。
        空间复杂度：O(1)。
     */
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int i = 0;
        while (i <= right) {
            if (nums[i] == 0) {
                swap(nums, i, left);
                ++left;
                ++i;
            } else if (nums[i] == 1) {
                ++i;
            } else {
                swap(nums, i, right);
                --right;
            }
        }
    }

    private void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
```
### 76.最小覆盖子串
题目链接            
https://leetcode-cn.com/problems/minimum-window-substring/              
https://leetcode.com/problems/minimum-window-substring/
```java
package leetcode;

import java.util.HashMap;

/*
给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
注意：如果 s 中存在这样的子串，保证它是唯一的答案。

示例 1：
输入：s = "ADOBECODEBANC", t = "ABC"
输出："BANC"

示例 2：
输入：s = "a", t = "a"
输出："a"

提示：
1 <= s.length, t.length <= 105
s 和 t 由英文字母组成
 */
public class lc076 {
    public String minWindow(String s, String t) {
        int n = s.length();
        HashMap<Character, Integer> tMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();

        // 记录 t 中所有字符出现的次数
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0;
        // 记录窗口中满足条件的字符个数
        int count = 0;

        // 记录最小覆盖字串的起始索引及长度
        int start = 0, minLength = Integer.MAX_VALUE;

        while (right < n) {
            char c = s.charAt(right);

            // 判断取出的字符是否在 t 中
            if (tMap.containsKey(c)) {
                windowMap.put(c, windowMap.getOrDefault(c, 0) + 1);
                // 判断取出的字符在窗口中的出现次数是否与 t 中该字符的出现次数相同
                if (windowMap.get(c).equals(tMap.get(c))) {
                    ++count;
                }
            }

            // 判断是否需要缩小窗口(已经找到符合条件的子串)
            while (count == tMap.size()) {
                if (right - left + 1 < minLength) {

                    start = left;
                    minLength = right - left + 1;
                }
                char c1 = s.charAt(left);
                left++;
                if (tMap.containsKey(c1)) {

                    if (windowMap.get(c1).equals(tMap.get(c1))) {

                        --count;
                    }
                    windowMap.put(c1, windowMap.getOrDefault(c1, 0) - 1);
                }
            }
            ++right;
        }

        return minLength == Integer.MAX_VALUE ? "" : s.substring(start, start + minLength);
    }
}
```
### 77.组合
题目链接            
https://leetcode-cn.com/problems/combinations/          
https://leetcode.com/problems/combinations/          
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。

示例:
输入:n = 4, k = 2
输出:
[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]
 */
public class lc077 {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        helper(n, k, 1, out, result);
        return result;
    }

    private void helper(int n, int k, int start, List<Integer> out, List<List<Integer>> result) {
        if (out.size() == k) {
            result.add(new ArrayList<>(out));
        }

        for (int i = start; i <= n; ++i) {
            out.add(i);
            helper(n, k, i + 1, out, result);
            out.remove(out.size() - 1);
        }
    }
}
```
### 78.子集
题目链接            
https://leetcode-cn.com/problems/subsets/           
https://leetcode.com/problems/subsets/           
```java
package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
给你一个整数数组nums ，数组中的元素互不相同。返回该数组所有可能的子集（幂集）。
解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。

示例 1：
输入：nums = [1,2,3]
输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]

示例 2：
输入：nums = [0]
输出：[[],[0]]

提示：
1 <= nums.length <= 10
-10 <= nums[i] <= 10
nums 中的所有元素 互不相同
 */
public class lc078 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> out = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, 0, out, result);
        return result;
    }

    private void helper(int[] nums, int start, List<Integer> out, List<List<Integer>> result) {
        result.add(new ArrayList<>(out));
        for (int i = start; i < nums.length; ++i) {
            out.add(nums[i]);
            helper(nums, i + 1, out, result);
            out.remove(out.size() - 1);
        }
    }
}
```
### 79.单词搜索
题目链接            
https://leetcode-cn.com/problems/word-search/           
https://leetcode.com/problems/word-search/
```java
package leetcode;

/*
给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word存在于网格中，返回true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true

示例 3：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false

提示：
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board 和 word 仅由大小写英文字母组成
 */
public class lc079 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (rowindex < 0 || colindex < 0 || rowindex >= board.length || colindex >= board[0].length) {
            return false;
        }

        if (visited[rowindex][colindex]) {
            return false;
        }

        if (board[rowindex][colindex] != word.charAt(index)) {
            return false;
        }

        visited[rowindex][colindex] = true;

        boolean res =
                dfs(board, word, index + 1, rowindex - 1, colindex, visited)
                        || dfs(board, word, index + 1, rowindex + 1, colindex, visited)
                        || dfs(board, word, index + 1, rowindex, colindex + 1, visited)
                        || dfs(board, word, index + 1, rowindex, colindex - 1, visited);

        visited[rowindex][colindex] = false;
        
        return res;
    }
}
```
### 80.删除有序数组中的重复项 II
题目链接            
https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii/            
https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/        
```java
package leetcode;

/*
给你一个有序数组nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。

示例 1：
输入：nums = [1,1,1,2,2,3]
输出：5, nums = [1,1,2,2,3]
解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。

示例 2：
输入：nums = [0,0,1,1,1,1,2,3,3]
输出：7, nums = [0,0,1,1,2,3,3]
解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。

提示：
1 <= nums.length <= 3 * 104
-104 <= nums[i] <= 104
nums 已按升序排列
 */
public class lc080 {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        if (n < 3) {
            return n;
        }

        int index = 2;
        for (int i = 2; i < n; ++i) {
            if (nums[i] != nums[index - 2]) {
                nums[index] = nums[i];
                ++index;
            }
        }

        return index;
    }
}
```
### 81.搜索旋转排序数组II
题目链接
https://leetcode.cn/problems/search-in-rotated-sorted-array-ii/
https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
```java
/**
 * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
 * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，
 * 使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。
 * 例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
 * 给你旋转后的数组nums和一个整数target，请你编写一个函数来判断给定的目标值是否存在于数组中。
 * 如果nums中存在这个目标值target ，则返回true ，否则返回false 。你必须尽可能减少整个操作步骤。
 *
 * 示例 1：
 * 输入：nums = [2,5,6,0,0,1,2], target = 0
 * 输出：true
 *
 * 示例 2：
 * 输入：nums = [2,5,6,0,0,1,2], target = 3
 * 输出：false
 *
 * 提示：
 * 1 <= nums.length <= 5000
 * -104 <= nums[i] <= 104
 * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
 * -104 <= target <= 104
 *
 * 进阶：
 * 此题与 搜索旋转排序数组 相似，但本题中的 nums  可能包含 重复 元素。这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
 */
public class lc081 {
    public boolean search(int[] nums, int target) {
        int n = nums.length;
        if (n == 0) {
            return false;
        }

        if (n == 1) {
            return nums[0] == target;
        }

        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }

            if (nums[l] == nums[mid] && nums[mid] == nums[r]) {
                ++l;
                --r;
            } else if (nums[l] <= nums[mid]) {
                if (nums[l] <= target && target < nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[mid] < target && target <= nums[r]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }
}
```
### 82.删除排序链表中的重复元素II
题目连接
https://leetcode.cn/problems/remove-duplicates-from-sorted-list-ii/
https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
```java
package leetcode;

/**
 *给定一个已排序的链表的头head,删除原始链表中所有重复数字的节点，
 * 只留下不同的数字 。返回已排序的链表。
 *
 * 示例 1：
 * 输入：head = [1,2,3,3,4,4,5]
 * 输出：[1,2,5]
 *
 * 示例 2：
 * 输入：head = [1,1,1,2,3]
 * 输出：[2,3]
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序 排列
 */
public class lc082 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = dummy;
        while (cur.next != null && cur.next.next != null) {
            if (cur.next.val == cur.next.next.val) {
                int val = cur.next.val;
                while (cur.next != null && cur.next.val == val) {
                    cur.next = cur.next.next;
                }
            } else {
                cur = cur.next;
            }
        }

        return dummy.next;
    }
}
```
### 83.删除排序链表中的重复元素
题目连接
https://leetcode.cn/problems/remove-duplicates-from-sorted-list/
https://leetcode.com/problems/remove-duplicates-from-sorted-list/
```java
package leetcode;

/**
 * 给定一个已排序的链表的头head,删除所有重复的元素，使每个元素只出现一次。返回已排序的链表。
 *
 * 示例 1：
 * 输入：head = [1,1,2]
 * 输出：[1,2]
 *
 * 示例 2：
 * 输入：head = [1,1,2,3,3]
 * 输出：[1,2,3]
 *
 *
 * 提示：
 * 链表中节点数目在范围 [0, 300] 内
 * -100 <= Node.val <= 100
 * 题目数据保证链表已经按升序排列
 */
public class lc083 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}
```
### 84.柱状图中最大的矩形
题目连接
https://leetcode.cn/problems/largest-rectangle-in-histogram/
https://leetcode.com/problems/largest-rectangle-in-histogram/
> ![lc84](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc84.png)
```java
package leetcode;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为10
 *
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * 提示：
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
import java.util.ArrayDeque;
import java.util.Deque;
public class lc084 {
    /*
    方法一：暴力枚举高
    使用一重循环枚举某一根柱子，将其固定为矩形的高度h。随后从这跟柱子开始向两侧延伸，直到遇到高度小于h的柱子，
    就确定了矩形的左右边界。如果左右边界之间的宽度为w，那么对应的面积为w×h
    这种暴力方法的时间复杂度均为 O(N*N)，会超出时间限制
    */
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int height = heights[i];
            int left = i;
            int right = i;
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < size && heights[right + 1] >= height) {
                ++right;
            }
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }

    /*
    方法二:单调栈
    时间复杂度：O(N)
    空间复杂度：O(N)
    */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
```
### 88.合并两个有序数组
题目连接
https://leetcode-cn.com/problems/merge-sorted-array/                    
https://leetcode.com/problems/merge-sorted-array/
```java
package leetcode;

/*
给你两个有序整数数组nums1和nums2，请你将nums2合并到nums1中，使nums1成为一个有序数组。
初始化nums1和nums2的元素数量分别为m和n。你可以假设nums1的空间大小等于m + n，这样它就有足够的空间保存来自nums2的元素。

示例 1：
输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
输出：[1,2,2,3,5,6]

示例 2：
输入：nums1 = [1], m = 1, nums2 = [], n = 0
输出：[1]

提示：
nums1.length == m + n
nums2.length == n
0 <= m, n <= 200
1 <= m + n <= 200
-109 <= nums1[i], nums2[i] <= 109
 */
public class lc088 {
    /*
        时间复杂度：O(m+n)。指针移动单调递减，最多移动 m+n 次，因此时间复杂度为 O(m+n)。
        空间复杂度：O(1)。直接对数组原地修改，不需要额外空间。
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        int k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
```
### 92.验证二叉搜索树
题目链接            
https://leetcode-cn.com/problems/reverse-linked-list-ii/                        
https://leetcode.com/problems/reverse-linked-list-ii/            
```java
package leetcode;

/*
92. 反转链表 II 反转子链表
给你单链表的头指针head和两个整数left和right，其中left <= right 。
请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
示例 1：
输入：head = [1,2,3,4,5], left = 2, right = 4
输出：[1,4,3,2,5]

示例 2：
输入：head = [5], left = 1, right = 1
输出：[5]

提示：
链表中节点数目为 n
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 */
public class lc092 {
    /*
        时间复杂度：O(N)，其中N是链表总节点数。最多只遍历了链表一次，就完成了反转。
        空间复杂度：O(1)。只使用到常数个变量。
     */
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;
        ListNode pre = dummyNode;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next;
        ListNode next;
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return dummyNode.next;
    }
}
```           
### 98.验证二叉搜索树
题目链接
https://leetcode-cn.com/problems/validate-binary-search-tree/                       
https://leetcode.com/problems/validate-binary-search-tree/                       
```java
package leetcode;

/*
给定一个二叉树，判断其是否是一个有效的二叉搜索树。
假设一个二叉搜索树具有如下特征：
节点的左子树只包含小于当前节点的数。
节点的右子树只包含大于当前节点的数。
所有左子树和右子树自身必须也是二叉搜索树。

示例1:
输入:
    2
   / \
  1   3
输出: true

示例2:
输入:
    5
   / \
  1   4
     / \
    3   6
输出: false
解释: 输入为: [5,1,4,null,null,3,6]。
     根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class lc098 {
    /*
    如果该二叉树的左子树不为空，则左子树上所有节点的值均小于它的根节点的值；
    若它的右子树不空，则右子树上所有节点的值均大于它的根节点的值；它的左右子树也为二叉搜索树。
    以root为根的子树，判断子树中所有节点的值是否都在 (l,r)的范围内（注意是开区间）。
    如果root节点的值val不在(l,r)的范围内说明不满足条件直接返回，否则要继续递归调用检查它的左右子树是否满足，如果都满足才说明这是一棵二叉搜索树。
    那么根据二叉搜索树的性质，在递归调用左子树时，需要把上界upper改为root.val，即调用helper(root.left, lower, root.val)，
    因为左子树里所有节点的值均小于它的根节点的值。同理递归调用右子树时，需要把下界lower改为root.val，即调用helper(root.right, root.val, upper)。
    函数递归调用的入口为helper(root, -inf, +inf)， inf表示一个无穷大的值。
    
    时间复杂度:O(n)，其中n为二叉树的节点个数。在递归调用时二叉树的每个节点最多被访问一次。
    空间复杂度:O(n)，其中n为二叉树的节点个数。递归函数在递归过程中需要为每一层递归函数分配栈空间，
    所以这里需要额外的空间且该空间取决于递归的深度，即二叉树的高度。最坏情况下二叉树为一条链，
    树的高度为n，递归最深达到n层，故最坏情况下空间复杂度为O(n)。
     */
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    private boolean isValidBST(TreeNode node, long lower, long upper) {
        if (node == null) {
            return true;
        }

        if (node.val <= lower || node.val >= upper) {
            return false;
        }

        return isValidBST(node.left, lower, node.val) && isValidBST(node.right, node.val, upper);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
```
### 109.有序链表转换二叉搜索树
题目链接
https://leetcode-cn.com/problems/convert-sorted-list-to-binary-search-tree/         
https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/             
```java
package leetcode;

/*
给定一个单链表，其中的元素按升序排序，将其转换为高度平衡的二叉搜索树。
本题中，一个高度平衡二叉树是指一个二叉树每个节点的左右两个子树的高度差的绝对值不超过 1。

示例:
给定的有序链表： [-10, -3, 0, 5, 9],
一个可能的答案是：[0, -3, 9, -10, null, 5], 它可以表示下面这个高度平衡二叉搜索树：

      0
     / \
   -3   9
   /   /
 -10  5
 */
public class lc109 {
    /*
        时间复杂度：O(nlogn)，其中n是链表的长度。
        设长度为n的链表构造二叉搜索树的时间为T(n)，递推式为T(n)=2⋅T(n/2)+O(n)，根据主定理，T(n)=O(nlogn)。
        空间复杂度：O(logn)，这里只计算除了返回答案之外的空间。平衡二叉树的高度为O(logn)，即为递归过程中栈的最大深度，也就是需要的空间。
     */
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head, null);
    }

    public TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right) {
            return null;
        }

        ListNode mid = getMedian(left, right);
        TreeNode root = new TreeNode(mid.val);
        root.left = buildTree(left, mid);
        root.right = buildTree(mid.next, right);
        return root;
    }

    public ListNode getMedian(ListNode left, ListNode right) {
        ListNode slow = left;
        ListNode fast = left;
        while (fast != right && fast.next != right) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }
}
```
### 121.买卖股票的最佳时机
题目连接
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
```java
package leetcode;

/*
给定一个数组 prices ，它的第i个元素prices[i] 表示一支给定股票第 i 天的价格。
你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。

示例 1：
输入：[7,1,5,3,6,4]
输出：5
解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。

示例 2：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这种情况下, 没有交易完成, 所以最大利润为 0。

提示：
1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class lc121 {
    /*
        时间复杂度：O(n^2)
        空间复杂度：O(1)。只使用了常数个变量。
        运行时超时
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        //从第一个元素遍历到倒数第二个元素
        for (int i = 0; i < prices.length - 1; ++i) {
            //从第二个元素遍历到最后一个元素,保证买入在卖出前
            for (int j = i + 1; j < prices.length; ++j) {
                int profile = prices[i] - prices[j];
                if (profile > max) {
                    max = profile;
                }
            }
        }

        return max;
    }

    /*
        时间复杂度：O(n)，只需要遍历一次。
        空间复杂度：O(1)，只使用了常数个变量。
     */

    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }

        return maxProfit;
    }
}
```
### 122.买卖股票的最佳时机II
题目连接
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-ii/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
```java
package leetcode;

import sun.nio.cs.ext.MacHebrew;

/*
给定一个数组 prices ，其中prices[i] 是一支给定股票第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入: prices = [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。

示例 2:
输入: prices = [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

示例 3:
输入: prices = [7,6,4,3,1]
输出: 0
解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。

提示：
1 <= prices.length <= 3 * 104
0 <= prices[i] <= 104
 */
public class lc122 {
    /*
        因为不能同时参与多笔交易，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
        dp[i][0]表示第i天交易完后手里没有股票的最大利润，dp[i][1]表示第i天交易完后手里持有一支股票的最大利润（i从0开始）。
        考虑dp[i][0]的转移方程，如果这一天交易完后手里没有股票，那么可能的转移状态为前一天已经没有股票，即dp[i−1][0]，
        或者前一天结束的时候手里持有一支股票，即dp[i−1][1]，这时候要将其卖出，并获得prices[i]的收益。因此为了收益最大化，转移方程：
        dp[i][0]=max{dp[i−1][0],dp[i−1][1]+prices[i]}

        再来考虑dp[i][1]的转移方程，如果这一天交易完后手里有股票，那么可能是前一天已经持有一支股票，即dp[i−1][1]，
        或者前一天结束时还没有股票，即dp[i−1][0]，这一天要将买入一支股票，并减少prices[i]的收益。转移方程：
        dp[i][1]=max{dp[i−1][1],dp[i−1][0]−prices[i]}

        对于初始状态，根据状态定义可以知道第0天交易结束的时候dp[0][0]=0，dp[0][1]=−prices[0]。
        因此，只要从前往后依次计算状态即可。由于全部交易结束后，持有股票的收益一定低于不持有股票的收益，
        因此这时候dp[n−1][0]的收益必然是大于dp[n−1][1]的，最后的答案即为dp[n−1][0]。

        时间复杂度：O(n)，其中n为数组的长度。一共有2n个状态，每次状态转移的时间复杂度为O(1)，因此时间复杂度为O(2n)=O(n)。
        空间复杂度：O(n)。需要开辟O(n)空间存储动态规划中的所有状态。如果使用空间优化，空间复杂度可以优化至O(1)。
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];

        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][0] - prices[i], dp[i - 1][1]);
        }

        return dp[n - 1][0];
    }

    /*
        贪心算法
        贪心算法只能用于计算最大利润，计算的过程并不是实际的交易过程。
        时间复杂度：O(n)，其中n为数组的长度。只需要遍历一次数组即可。
        空间复杂度：O(1)。只需要常数空间存放若干变量。
     */
    public int maxProfit2(int[] prices) {
        int ans = 0;
        int n = prices.length;

        for (int i = 1; i < n; ++i) {
            ans += Math.max(0, prices[i] - prices[i - 1]);
        }

        return ans;
    }
}
```
### 123.买卖股票的最佳时机III
题目连接
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iii/
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
```java
package leetcode;

/*
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成两笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:
输入：prices = [3,3,5,0,0,3,1,4]
输出：6
解释：在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。

示例 2：
输入：prices = [1,2,3,4,5]
输出：4
解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。

示例 3：
输入：prices = [7,6,4,3,1]
输出：0
解释：在这个情况下, 没有交易完成, 所以最大利润为 0。

示例 4：
输入：prices = [1]
输出：0

提示：
1 <=prices.length <= 10^5
0 <=prices[i] <= 10^5
 */
public class lc123 {
    /*
        由于最多可以完成两笔交易，因此在任意一天结束之后，会处于以下五个状态中的一种：
        1.未进行过任何操作；
        2.只进行过一次买操作；
        3.进行了一次买操作和一次卖操作，即完成了一笔交易；
        4.在完成了一笔交易的前提下，进行了第二次买操作；
        5.完成了全部两笔交易。
        由于第一个状态的利润显然为0，因此可以不用将其记录。
        对于剩下的四个状态，分别将它们的最大利润记为buy1、sell1、buy2、sell2

        对于buy1，在第i天可以不进行任何操作，保持不变，也可以在未进行任何操作的前提下以prices[i]的价格买入股票，那么buy1的状态转移方程即为：
        buy1 = max{buy1,−prices[i]}

        对于sell1，在第i天可以不进行任何操作，保持不变，也可以在只进行过一次买操作的前提下以prices[i]的价格卖出股票，那么sell1的状态转移方程即为：：
        sell1 = max{sell1,buy1+prices[i]}

        对于buy2，在第i天可以不进行任何操作，保持不变，也可以在完成了一笔交易(一次买操作和一次卖操作)操作的前提下以prices[i]的价格买入股票，那么buy2的状态转移方程即为：
        buy2 = max{buy2,sell1−prices[i]}

        对于sell2，在第i天可以不进行任何操作，保持不变，也可以在完成了一笔交易之后又买了一次的前提下以prices[i]的价格卖出股票，那么sell2的状态转移方程即为：
        sell2 = max{sell2,buy2+prices[i]}

        时间复杂度：O(n)，其中n是数组prices的长度。
        空间复杂度：O(1)。
     */

    public int maxProfit(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;
    }
}
```
### 143.重排链表
题目连接
https://leetcode-cn.com/problems/reorder-list/
https://leetcode.com/problems/reorder-list/
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个单链表L：L0→L1→…→Ln-1→Ln ，
将其重新排列后变为： L0→Ln→L1→Ln-1→L2→Ln-2→…
你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

示例1:
给定链表 1->2->3->4, 重新排列为 1->4->2->3.

示例 2:
给定链表 1->2->3->4->5, 重新排列为 1->5->2->4->3.
 */
public class lc143 {
    /*
        时间复杂度：O(N)，其中N是链表中的节点数。
        空间复杂度：O(N)，其中N是链表中的节点数。主要为线性表的开销。
     */
    public void reorderList(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<ListNode>();
        ListNode node = head;
        while (node != null) {
            list.add(node);
            node = node.next;
        }
        int i = 0, j = list.size() - 1;
        while (i < j) {
            list.get(i).next = list.get(j);
            i++;
            if (i == j) {
                break;
            }
            list.get(j).next = list.get(i);
            j--;
        }
        list.get(i).next = null;
    }

    /*
        时间复杂度：O(N)，其中 N 是链表中的节点数。
        空间复杂度：O(1)。
     */
    public void reorderList2(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode mid = middleNode(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        mid.next = null;
        list2 = reverseList(list2);
        mergeList(list1, list2);
    }

    public ListNode middleNode(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public void mergeList(ListNode list1, ListNode list2) {
        ListNode tmp1 = null;
        ListNode tmp2 = null;
        while (list1 != null && list2 != null) {
            tmp1 = list1.next;
            tmp2 = list2.next;

            list1.next = list2;
            list1 = tmp1;

            list2.next = list1;
            list2 = tmp2;
        }
    }
}
```

### 146.LRU缓存机制
题目链接        
https://leetcode-cn.com/problems/lru-cache/         
https://leetcode.com/problems/lru-cache/         
```java
package leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
运用你所掌握的数据结构，设计和实现一个LRU (最近最少使用) 缓存机制 。
实现 LRUCache 类：
LRUCache(int capacity) 以正整数作为容量capacity 初始化 LRU 缓存
int get(int key) 如果关键字 key 存在于缓存中，则返回关键字的值，否则返回 -1 。
void put(int key, int value)如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字-值」。
当缓存容量达到上限时，它应该在写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。

进阶：你是否可以在O(1) 时间复杂度内完成这两种操作？

示例：
输入
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]

输出
[null, null, null, 1, null, -1, null, -1, 3, 4]

解释
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // 缓存是 {1=1}
lRUCache.put(2, 2); // 缓存是 {1=1, 2=2}
lRUCache.get(1);    // 返回 1
lRUCache.put(3, 3); // 该操作会使得关键字 2 作废，缓存是 {1=1, 3=3}
lRUCache.get(2);    // 返回 -1 (未找到)
lRUCache.put(4, 4); // 该操作会使得关键字 1 作废，缓存是 {4=4, 3=3}
lRUCache.get(1);    // 返回 -1 (未找到)
lRUCache.get(3);    // 返回 3
lRUCache.get(4);    // 返回 4

提示：
1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
最多调用 3 * 104 次 get 和 put
 */
public class lc146 {
    private Queue<Integer> que;
    private Map<Integer, Integer> m;
    private int cap;

    public lc146(int capacity) {
        this.que = new LinkedList<>();
        this.m = new HashMap<Integer, Integer>();
        this.cap = capacity;
    }

    public int get(int key) {
        if (m.containsKey(key)) {
            que.remove(new Integer(key));
            que.add(key);
            return m.get(key);
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {
        if (m.containsKey(key)) {
            que.remove(new Integer(key));
        }

        if (que.size() == cap) {
            int val = que.poll();
            m.remove(val);
        }

        que.add(key);
        m.put(key, value);
    }
}
```
### 172.阶乘后的零
题目链接        
https://leetcode-cn.com/problems/factorial-trailing-zeroes/             
https://leetcode.com/problems/factorial-trailing-zeroes/         
```java
package leetcode;

/*
给定一个整数n，返回n!结果尾数中零的数量。

示例 1:
输入: 3
输出: 0
解释:3! = 6, 尾数中没有零。

示例2:
输入: 5
输出: 1
解释:5! = 120, 尾数中有1个零.
说明: 你算法的时间复杂度应为O(logn)。
 */
public class lc172 {
    /*
        N的阶乘可以分解为:2的X次方，3的Y次方，4的K次方，5次Z方，.....的乘积。
        由于10 = 2 * 5,所以M只能和X和Z有关，每一对2和5相乘就可以得到一个10，
        于是M = MIN(X,Z),不难看出X大于Z，因为被2整除的频率比被5整除的频率高的多。
        所以可以把公式简化为M=Z。
     */
    public int trailingZeroes(int n) {
        if (n < 0) {
            return 0;
        }
        int res = 0;
        for (int i = 5; i <= n; ++i) {
            int j = i;
            while (j % 5 == 0) {
                ++res;
                j = j / 5;
            }
        }
        return res;
    }

    /*
        时间复杂度:O(logn)。在这种方法中,将n除以5的每个幂。根据定义，5的log5n幂小于或等于n。
        由于乘法和除法在32位整数范围内，将这些计算视为O(1)。因此，正在执行log5nxO(1)=logn操作
        空间复杂度:O(1)，只是用了常数空间。
     */
    public int trailingZeroes2(int n) {
        int zeroCount = 0;
        while (n > 0) {
            n /= 5;
            zeroCount += n;
        }
        return zeroCount;
    }
}
```
### 179.最大数
题目链接                
https://leetcode-cn.com/problems/largest-number/            
https://leetcode.com/problems/largest-number/        
```java
package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"

示例 3：
输入：nums = [1]
输出："1"

示例 4：
输入：nums = [10]
输出："10"

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 109
 */
public class lc179 {
    /*
        时间复杂度：O(nlognlogm)，其中n是给定序列的长度，m是32位整数的最大值，每个数转化为字符串后的长度是O(logm) 的数量级。
        排序比较函数的时间复杂度为O(logm)，共需要进行O(nlogn) 次比较。同时需要对字符串序列进行拼接，时间复杂度为O(nlogm)，
        在渐进意义上小于O(nlognlogm)。
        空间复杂度：O(logn)，排序需要O(logn) 的栈空间。
     */
    public String largestNumber(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return "";
        }

        String[] strs = new String[size];
        for (int i = 0; i < size; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        return strs[0].equals("0") ? "0" : String.join("", strs);
    }
}
```
### 188.买卖股票的最佳时机IV
题目链接                    
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv/                    
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iv/                   
```java
package leetcode;

import java.util.Arrays;

/*
给定一个整数数组prices ，它的第i个元素prices[i] 是一支给定的股票在第 i 天的价格。
设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。
注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1：
输入：k = 2, prices = [2,4,1]
输出：2
解释：在第 1 天 (股票价格 = 2) 的时候买入，在第 2 天 (股票价格 = 4) 的时候卖出，这笔交易所能获得利润 = 4-2 = 2 。

示例 2：
输入：k = 2, prices = [3,2,6,5,0,3]
输出：7
解释：在第 2 天 (股票价格 = 2) 的时候买入，在第 3 天 (股票价格 = 6) 的时候卖出, 这笔交易所能获得利润 = 6-2 = 4 。
     随后，在第 5 天 (股票价格 = 0) 的时候买入，在第 6 天 (股票价格 = 3) 的时候卖出, 这笔交易所能获得利润 = 3-0 = 3 。

提示：
0 <= k <= 100
0 <= prices.length <= 1000
0 <= prices[i] <= 1000
 */
public class lc188 {
    /*
        时间复杂度：O(n*min(n,k))，其中n是数组prices的大小，即使用二重循环进行动态规划需要的时间。
        空间复杂度：O(min(n,k))。

        本题中k的最大值可以达到10^9 ，然而这是毫无意义的，因为n天最多只能进行n/2笔交易，其中[x]表示对x向下取整。
        因此可以将k对[n/2]取较小值之后再进行动态规划。
     */
    public int maxProfit(int k, int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        k = Math.min(k, n / 2);
        int[] buy = new int[k + 1];
        int[] sell = new int[k + 1];

        buy[0] = -prices[0];
        sell[0] = 0;
        for (int i = 1; i <= k; ++i) {
            buy[i] = sell[i] = Integer.MIN_VALUE / 2;
        }

        for (int i = 1; i < n; ++i) {
            buy[0] = Math.max(buy[0], sell[0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[j] = Math.max(buy[j], sell[j] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j - 1] + prices[i]);
            }
        }

        return Arrays.stream(sell).max().getAsInt();
    }
}
```
### 198.打家劫舍
题目链接            
https://leetcode-cn.com/problems/house-robber/              
https://leetcode.com/problems/house-robber/              
```java
package leetcode;

/*
198. 打家劫舍
你是一个专业的小偷，计划偷窃沿街的房屋。每间房内都藏有一定的现金，影响你偷窃的唯一制约因素就是相邻的房屋装有相互连通的防盗系统，
如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警。给定一个代表每个房屋存放金额的非负整数数组，计算你 不触动警报装置的情况下 ，
一夜之内能够偷窃到的最高金额。

示例 1：
输入：[1,2,3,1]
输出：4
解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 2：
输入：[2,7,9,3,1]
输出：12
解释：偷窃 1 号房屋 (金额 = 2), 偷窃 3 号房屋 (金额 = 9)，接着偷窃 5 号房屋 (金额 = 1)。
     偷窃到的最高金额 = 2 + 9 + 1 = 12 。

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 400
 */
public class lc198 {
    /*
        动态规划：
        如果只有一间房屋，则偷窃该房屋，可以偷窃到最高总金额。
        如果只有两间房屋，则由于两间房屋相邻，不能同时偷窃，只能偷窃其中的一间房屋，因此选择其中金额较高的房屋进行偷窃，可以偷窃到最高总金额。
        如果房屋数量大于两间，应该如何计算能够偷窃到的最高总金额呢？
        对于第k(k>2) 间房屋，有两个选项：
        偷窃第k间房屋，那么就不能偷窃第k-1间房屋，偷窃总金额为前k-2间房屋的最高总金额与第k间房屋的金额之和。
        不偷窃第k间房屋，偷窃总金额为前k−1间房屋的最高总金额。
        在两个选项中选择偷窃总金额较大的选项，该选项对应的偷窃总金额即为前k间房屋能偷窃到的最高总金额。

        用dp[i]表示前i间房屋能偷窃到的最高总金额，那么就有如下的状态转移方程：
        dp[i] = max(dp[i-2]+nums[i],dp[i-1])
        边界条件为：
        dp[0] = nums[0] 只有一间房屋，则偷窃该房屋
        dp[1] = max(nums[0], nums[1])  只有两间房屋，选择其中金额较高的房屋进行偷窃
        最终的答案即为dp[n−1]，其中n是数组的长度。

        时间复杂度：O(n)，其中n是数组长度。只需要对数组遍历一次。
        空间复杂度：O(1)。
     */
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int[] dp = new int[len];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }

        return dp[len - 1];
    }

    /*
        考虑到每间房屋的最高总金额只和该房屋的前两间房屋的最高总金额相关，
        因此可以使用滚动数组，在每个时刻只需要存储前两间房屋的最高总金额。

        时间复杂度：O(n)，其中n是数组长度。只需要对数组遍历一次。
        空间复杂度：O(1)。使用滚动数组，可以只存储前两间房屋的最高总金额，而不需要存储整个数组的结果，因此空间复杂度是O(1)。
     */
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int len = nums.length;
        if (len == 1) {
            return nums[0];
        }

        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }

        return second;
    }
}
```
 
### 200.反转链表
题目链接            
https://leetcode-cn.com/problems/binary-tree-right-side-view/           
https://leetcode.com/problems/binary-tree-right-side-view/
```java
package leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/*
199. 二叉树的右视图
给定一个二叉树的 根节点 root，想象自己站在它的右侧，按照从顶部到底部的顺序，返回从右侧所能看到的节点值。

示例 1:
输入:[1,2,3,null,5,null,4]
输出:[1,3,4]
示例 2:

输入:[1,null,3]
输出:[1,3]
示例 3:

输入:[]
输出:[]

提示:
二叉树的节点个数的范围是 [0,100]
-100<= Node.val <= 100
 */
public class lc199 {
    /*
        时间复杂度 : O(n)。 每个节点最多进队列一次，出队列一次，因此广度优先搜索的复杂度为线性。
        空间复杂度 : O(n)。
     */
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int node = 1;
        while (!que.isEmpty()) {
            root = que.poll();
            --node;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
            if (node == 0) {
                res.add(root.val);
                node = que.size();
            }
        }
        return res;
    }
}
```
### 200.反转链表
题目链接            
https://leetcode-cn.com/problems/number-of-islands/         
https://leetcode.com/problems/number-of-islands/         
```java
package leetcode;

/*
200. 岛屿数量
给你一个由'1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。
岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。
此外，你可以假设该网格的四条边均被水包围。

示例 1：
输入：grid = [
  ["1","1","1","1","0"],
  ["1","1","0","1","0"],
  ["1","1","0","0","0"],
  ["0","0","0","0","0"]
]
输出：1

示例 2：
输入：grid = [
  ["1","1","0","0","0"],
  ["1","1","0","0","0"],
  ["0","0","1","0","0"],
  ["0","0","0","1","1"]
]
输出：3

提示：
m == grid.length
n == grid[i].length
1 <= m, n <= 300
grid[i][j] 的值为 '0' 或 '1'
 */
public class lc200 {
    /*
        深度优先搜索：
            可以将二维网格看成一个无向图，竖直或水平相邻的1之间有边相连。
            为了求出岛屿的数量，可以扫描整个二维网格。如果一个位置为1，
            则以其为起始节点开始进行深度优先搜索。在深度优先搜索的过程中，
            每个搜索到的1都会被重新标记为0。最终岛屿的数量就是进行深度优先搜索的次数。

        时间复杂度：O(MN)，其中M和N分别为行数和列数。
        空间复杂度：O(min(M,N))，在最坏情况下，整个网格均为陆地，队列的大小可以达到min(M,N)。
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int row = grid.length;
        int col = grid[0].length;
        int count = 0;
        for (int r = 0; r < row; ++r) {
            for (int c = 0; c < col; ++c) {
                if (grid[r][c] == '1') {
                    ++count;
                    dfs(grid, r, c);
                }
            }
        }

        return count;
    }

    public void dfs(char[][] grid, int r, int c) {
        int row = grid.length;
        int col = grid[0].length;

        if (r < 0 || c < 0 || r >= row || c >= col || grid[r][c] == '0') {
            return;
        }

        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }
}
``` 



### 206.反转链表
题目链接        
https://leetcode-cn.com/problems/reverse-linked-list/       
https://leetcode.com/problems/reverse-linked-list/
```java
package leetcode;

/*
206. 反转链表
反转一个单链表。
示例:
输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？
 */
public class lc206 {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    public ListNode reverseList2(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode p = head;
        head = reverseList(p.next);
        p.next.next = p;
        p.next = null;

        return head;
    }
}
```
### 213.打家劫舍II
题目链接            
https://leetcode-cn.com/problems/house-robber-ii/           
https://leetcode.com/problems/house-robber-ii/           
```java
package leetcode;

/*
213. 打家劫舍 II
你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。这个地方所有的房屋都围成一圈 ，这意味着第一个房屋和最后一个房屋是紧挨着的。
同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
给定一个代表每个房屋存放金额的非负整数数，计算你 在不触动警报装置的情况下 ，今晚能够偷窃到的最高金额。

示例 1：

输入：nums = [2,3,2]
输出：3
解释：你不能先偷窃 1 号房屋（金额 = 2），然后偷窃 3 号房屋（金额 = 2）, 因为他们是相邻的。

示例 2：
输入：nums = [1,2,3,1]
输出：4
解释：你可以先偷窃 1 号房屋（金额 = 1），然后偷窃 3 号房屋（金额 = 3）。
     偷窃到的最高金额 = 1 + 3 = 4 。

示例 3：
输入：nums = [0]
输出：0

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 1000
 */
public class lc213 {
    /*
        时间复杂度：O(n)，其中n是数组长度。需要对数组遍历两次，计算可以偷窃到的最高总金额。
        空间复杂度：O(1)。
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        return Math.max(robRange(nums, 0, len - 2), robRange(nums, 1, len - 1));
    }

    public int robRange(int[] nums, int start, int end) {
        int first = nums[start];
        int second = Math.max(nums[start], nums[start + 1]);
        for (int i = start + 2; i <= end; i++) {
            int tmp = second;
            second = Math.max(first + nums[i], second);
            first = tmp;
        }

        return second;
    }
}
```
### 215.数组中的第K个最大元素
题目链接            
https://leetcode-cn.com/problems/kth-largest-element-in-an-array/           
https://leetcode.com/problems/kth-largest-element-in-an-array/           
```java
package leetcode;

import java.util.Random;

/*
215. 数组中的第K个最大元素
给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。
请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:
输入: [3,2,1,5,6,4] 和 k = 2
输出: 5

示例 2:
输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4

提示：
1 <= k <= nums.length <= 104
-104<= nums[i] <= 104
 */
public class lc215 {
    /*
        方法一：基于快速排序的选择方法
        时间复杂度：O(n)
        空间复杂度：O(logn)
     */
    Random random = new Random();

    public int findKthLargest(int[] nums, int k) {
        return quickSelect(nums, 0, nums.length - 1, nums.length - k);
    }

    public int quickSelect(int[] a, int l, int r, int index) {
        int q = randomPartition(a, l, r);
        if (q == index) {
            return a[q];
        } else {
            return q < index ? quickSelect(a, q + 1, r, index) : quickSelect(a, l, q - 1, index);
        }
    }

    public int randomPartition(int[] a, int l, int r) {
        int i = random.nextInt(r - l + 1) + l;
        swap(a, i, r);
        return partition(a, l, r);
    }

    public int partition(int[] a, int l, int r) {
        int x = a[r], i = l - 1;
        for (int j = l; j < r; ++j) {
            if (a[j] <= x) {
                swap(a, ++i, j);
            }
        }

        swap(a, i + 1, r);

        return i + 1;
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    /*
        方法二：基于堆排序的选择方法
        时间复杂度：O(nlogn)
        空间复杂度：O(logn)
     */
    public int findKthLargest2(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        int l = i * 2 + 1, r = i * 2 + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }
}
```
### 228.汇总区间
题目链接        
https://leetcode-cn.com/problems/summary-ranges/          
https://leetcode.com/problems/summary-ranges/        
```java
package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给定一个无重复元素的有序整数数组 nums 。
返回 恰好覆盖数组中所有数字 的 最小有序 区间范围列表。也就是说，nums 的每个元素都恰好被某个区间范围所覆盖，并且不存在属于某个范围但不属于 nums 的数字 x 。
列表中的每个区间范围 [a,b] 应该按如下格式输出：
"a->b" ，如果 a != b
"a" ，如果 a == b

示例 1：
输入：nums = [0,1,2,4,5,7]
输出：["0->2","4->5","7"]
解释：区间范围是：
[0,2] --> "0->2"
[4,5] --> "4->5"
[7,7] --> "7"

示例 2：
输入：nums = [0,2,3,4,6,8,9]
输出：["0","2->4","6","8->9"]
解释：区间范围是：
[0,0] --> "0"
[2,4] --> "2->4"
[6,6] --> "6"
[8,9] --> "8->9"

示例 3：
输入：nums = []
输出：[]

示例 4：
输入：nums = [-1]
输出：["-1"]

示例 5：
输入：nums = [0]
输出：["0"]

提示：
0 <= nums.length <= 20
-231 <= nums[i] <= 231 - 1
nums 中的所有值都 互不相同
nums 按升序排列
 */
public class lc228 {
    /*
        时间复杂度：O(n)，其中n为数组的长度。
        空间复杂度：O(1)。除了用于输出的空间外，额外使用的空间为常数。
     */
    public List<String> summaryRanges(int[] nums) {
        int n = nums.length;
        int i = 0;
        List<String> res = new ArrayList<>();
        while (i < n) {
            int j = 1;
            while (i + j < n && nums[i + j] - nums[i] == j) {
                ++j;
            }
            res.add(j == 1 ? String.valueOf(nums[i]) : String.valueOf(nums[i]) + "->" + String.valueOf(nums[i + j - 1]));

            i += j;
        }

        return res;
    }
}
```
### 232. 用栈实现队列
题目连接
https://leetcode-cn.com/problems/implement-queue-using-stacks/          
https://leetcode.com/problems/implement-queue-using-stacks/
```java
package leetcode;

import java.util.Stack;

/*
请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
实现 MyQueue 类：
void push(int x) 将元素 x 推到队列的末尾
int pop() 从队列的开头移除并返回元素
int peek() 返回队列开头的元素
boolean empty() 如果队列为空，返回 true ；否则，返回 false

说明：
你只能使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。

进阶：
你能否实现每个操作均摊时间复杂度为 O(1) 的队列？换句话说，执行 n 个操作的总时间复杂度为 O(n) ，即使其中一个操作可能花费较长时间。

示例：
输入：
["MyQueue", "push", "push", "peek", "pop", "empty"]
[[], [1], [2], [], [], []]
输出：
[null, null, null, 1, 1, false]

解释：
MyQueue myQueue = new MyQueue();
myQueue.push(1); // queue is: [1]
myQueue.push(2); // queue is: [1, 2] (leftmost is front of the queue)
myQueue.peek(); // return 1
myQueue.pop(); // return 1, queue is [2]
myQueue.empty(); // return false

提示：
1 <= x <= 9
最多调用 100 次 push、pop、peek 和 empty
假设所有操作都是有效的 （例如，一个空的队列不会调用 pop 或者 peek 操作）
 */
public class MyQueue {
    // 两个栈实现先入先出队列
    private Stack<Integer> stkPush;
    private Stack<Integer> stkPop;

    public MyQueue() {
        stkPush = new Stack<>();
        stkPop = new Stack<>();
    }

    public void push(int x) {
        stkPush.push(x);
    }

    public int pop() {
        if (stkPop.isEmpty()) {
            while (!stkPush.isEmpty()) {
                stkPop.push(stkPush.pop());
            }
        }

        return stkPop.pop();
    }

    public int peek() {
        if (stkPop.isEmpty()) {
            while (!stkPush.isEmpty()) {
                stkPop.push(stkPush.pop());
            }
        }

        return stkPop.peek();
    }

    public boolean empty() {
        return stkPush.isEmpty() && stkPop.isEmpty();
    }
}

class MyQueue2 {
    // 一个栈实现先入先出队列
    private Stack<Integer> stk;

    public MyQueue2() {
        stk = new Stack<>();
    }

    public void push(int x) {
        stk.add(0, x);
    }

    public int pop() {
        return stk.pop();
    }

    public int peek() {
        return stk.peek();
    }

    public boolean empty() {
        return stk.isEmpty();
    }
}
```

### 300.最长递增子序列
题目链接            
https://leetcode-cn.com/problems/longest-increasing-subsequence/           
https://leetcode.com/problems/longest-increasing-subsequence/               
```java
package leetcode;

/*
给你一个整数数组nums ，找到其中最长严格递增子序列的长度。
子序列是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。

示例 1：
输入：nums = [10,9,2,5,3,7,101,18]
输出：4
解释：最长递增子序列是 [2,3,7,101]，因此长度为 4 。

示例 2：
输入：nums = [0,1,0,3,2,3]
输出：4

示例 3：
输入：nums = [7,7,7,7,7,7,7]
输出：1

提示：
1 <= nums.length <= 2500
-104 <= nums[i] <= 104

进阶：
你可以设计时间复杂度为 O(n2) 的解决方案吗？
你能将算法的时间复杂度降低到O(nlog(n)) 吗?
 */
public class lc300 {
    /*
        方法一：动态规划
        dp[i]表示以nums[i]这个数结尾的最长递增子序列的长度。
        时间复杂度：O(n^2)，其中n为数组nums的长度。动态规划的状态数为n，计算状态dp[i] 时，需要O(n)的时间遍历dp[0…i−1]的所有状态，所以总时间复杂度为O(n^2)
        空间复杂度：O(n)，需要额外使用长度为n的dp数组。
     */
    public int lengthOfLIS(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return 0;
        }

        int[] dp = new int[size];
        dp[0] = 1;

        int maxLen = 1;
        for (int i = 1; i < size; ++i) {
            dp[i] = 1;
            for (int j = 0; j < i; ++j) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        return maxLen;
    }

    /*
           只能把点数小的牌压到点数比它大的牌上；如果当前牌点数较大没有可以放置的堆，则新建一个堆，把这张牌放进去；
           如果当前牌有多个堆可供选择，则选择最左边的那一堆放置。
           时间复杂度：O(nlogn)。
           空间复杂度：O(n)，需要额外使用长度为n的数组。
     */
    public int lengthOfLIS2(int[] nums) {
        int[] top = new int[nums.length];

        // 牌堆数初始化为0
        int piles = 0;
        for (int i = 0; i < nums.length; i++) {
            // 要处理的扑克牌
            int poker = nums[i];

            /**搜索左侧边界的二分查找 **/
            int left = 0, right = piles;
            while (left < right) {
                int mid = (left + right) / 2;
                if (top[mid] > poker) {
                    right = mid;
                } else if (top[mid] < poker) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // 没找到合适的牌堆，新建一堆
            if (left == piles) {
                piles++;
            }

            // 把这张牌放到牌堆顶
            top[left] = poker;
        }

        // 牌堆数就是LIS长度
        return piles;
    }
}
```
### 309.最佳买卖股票时机含冷冻期
题目链接                
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/             
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/            
```java
package leetcode;

/*
给定一个整数数组，其中第i个元素代表了第i天的股票价格 。
设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。

示例:
输入: [1,2,3,0,2]
输出: 3
解释: 对应的交易状态为: [买入, 卖出, 冷冻期, 买入, 卖出]
 */
public class lc309 {
    /*
        时间复杂度：O(n)，其中n为数组prices 的长度。
        空间复杂度：O(1)。
    */
    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }

        int n = prices.length;
        // f[i][0]: 手上持有股票的最大收益
        // f[i][1]: 手上不持有股票，并且处于冷冻期中的累计最大收益
        // f[i][2]: 手上不持有股票，并且不在冷冻期中的累计最大收益
        int[][] f = new int[n][3];
        f[0][0] = -prices[0];
        for (int i = 1; i < n; ++i) {
            f[i][0] = Math.max(f[i - 1][0], f[i - 1][2] - prices[i]);
            f[i][1] = f[i - 1][0] + prices[i];
            f[i][2] = Math.max(f[i - 1][1], f[i - 1][2]);
        }
        return Math.max(f[n - 1][1], f[n - 1][2]);
    }
}
```
### 322.零钱兑换
题目链接        
https://leetcode-cn.com/problems/coin-change/submissions/           
https://leetcode.com/problems/coin-change/submissions/           
```java
package leetcode;

import java.util.Arrays;

/*
给定不同面额的硬币coins和一个总金额amount。编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回-1。
你可以认为每种硬币的数量是无限的。

示例1：
输入：coins = [1, 2, 5], amount = 11
输出：3
解释：11 = 5 + 5 + 1

示例 2：
输入：coins = [2], amount = 3
输出：-1

示例 3：
输入：coins = [1], amount = 0
输出：0

示例 4：
输入：coins = [1], amount = 1
输出：1

示例 5：
输入：coins = [1], amount = 2
输出：2

提示：
1 <= coins.length <= 12
1 <= coins[i] <= 2^31 - 1
0 <= amount <= 10^4
 */
public class lc322 {
    /*
        维护一个一维动态数组dp，其中dp[i]表示钱数为i时的最小硬币数的找零
        更新dp[i]的方法就是遍历每个硬币，如果遍历到的硬币值小于等于i值时，用dp[i - coins[j]]+1来更新dp[i]，
        所以状态转移方程为:dp[i] = min(dp[i], dp[i - coins[j]] + 1)
     */
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i <= amount; ++i) {
            for (int j = 0; j < coins.length; ++j) {
                if (coins[j] <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];
    }
}
```

### 328.奇偶链表
题目链接    
https://leetcode-cn.com/problems/odd-even-linked-list/      
https://leetcode.com/problems/odd-even-linked-list/     
```java
package leetcode;

/*
 328. 奇偶链表
 给定一个单链表，把所有的奇数节点和偶数节点分别排在一起。请注意，这里的奇数节点和偶数节点指的是节点编号的奇偶性，而不是节点的值的奇偶性。
 请尝试使用原地算法完成。你的算法的空间复杂度应为 O(1)，时间复杂度应为 O(nodes)，nodes 为节点总数。
 示例 1:
 输入: 1->2->3->4->5->NULL
 输出: 1->3->5->2->4->NULL
 示例 2:
 输入: 2->1->3->5->6->4->7->NULL
 输出: 2->3->6->7->1->5->4->NULL
 说明:
 应当保持奇数节点和偶数节点的相对顺序。
 链表的第一个节点视为奇数节点，第二个节点视为偶数节点，以此类推。
 */
class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

public class lc328 {
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = head;
        ListNode cur = head.next;
        while (cur != null && cur.next != null) {
            ListNode tmp = pre.next;
            pre.next = cur.next;
            cur.next = cur.next.next;
            pre.next.next = tmp;
            pre = pre.next;
            cur = cur.next;
        }

        return head;
    }
}
```
### 337.打家劫舍 III
题目链接            
https://leetcode-cn.com/problems/house-robber-iii/          
https://leetcode.com/problems/house-robber-iii/      
```java
package leetcode;

/*
337. 打家劫舍 III
在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。
除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。
如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。
计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:
输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \
     3   1

输出: 7
解释:小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.

示例 2:
输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \
 1   3   1

输出: 9
解释:小偷一晚能够盗取的最高金额= 4 + 5 = 9.
 */
public class lc337 {
    /*
        一棵二叉树，树上的每个点都有对应的权值，每个点有两种状态（选中和不选中），
        问在不能同时选中有父子关系的点的情况下，能选中的点的最大权值和是多少。
        可以用f(o)表示选择o节点的情况下，o节点的子树上被选择的节点的最大权值和；
        g(o) 表示不选择o节点的情况下，o节点的子树上被选择的节点的最大权值和；
        l和r代表o的左右孩子。
        当o被选中时，o的左右孩子都不能被选中，故o被选中情况下子树上被选中点的最大权值和为
        l和r不被选中的最大权值和相加，即 f(o) = g(l) + g(r)。
        当o不被选中时，o的左右孩子可以被选中，也可以不被选中。对于o的某个具体的孩子x，
        它对o的贡献是x被选中和不被选中情况下权值和的较大值。
        故g(o) = max{f(l),g(l)}+max{f(r),g(r)}。
        
        时间复杂度：O(n)。
        空间复杂度：O(n)。
     */
    public int rob(TreeNode root) {
        int[] rootStatus = dfs(root);
        return Math.max(rootStatus[0], rootStatus[1]);
    }

    public int[] dfs(TreeNode node) {
        if (node == null) {
            return new int[]{0, 0};
        }
        int[] l = dfs(node.left);
        int[] r = dfs(node.right);
        int selected = node.val + l[1] + r[1];
        int notSelected = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return new int[]{selected, notSelected};
    }
}
```
### 349.两个数组的交集
题目链接                     
https://leetcode-cn.com/problems/intersection-of-two-arrays/                    
https://leetcode.com/problems/intersection-of-two-arrays/                                     
```java
package leetcode;

import java.util.*;

/*
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：
输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序
 */
public class lc349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<Integer>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            //放入时候去掉重复的
            nums.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums.contains(nums1[i])) {
                //放入交集
                result.add(nums1[i]);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            //集合变数组
            res[i++] = (int) iter.next();
        }
        return res;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            m.put(num, 1);
        }
        for (int num : nums2) {
            if (m.containsKey(num)) {
                //放入交集
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            //集合变数组
            res[i++] = (int) iter.next();
        }
        return res;
    }
}
```
### 415.字符串相加
题目链接            
https://leetcode-cn.com/problems/add-strings/                
https://leetcode.com/problems/add-strings/          
```java
package leetcode;

/*
415. 字符串相加
给定两个字符串形式的非负整数num1 和num2，计算它们的和。

提示：
num1 和num2的长度都小于 5100
num1 和num2 都只包含数字0-9
num1 和num2 都不包含任何前导零
你不能使用任何內建 BigInteger 库，也不能直接将输入的字符串转换为整数形式
 */
public class lc415 {
    /*
        时间复杂度：O(max(len1,len2))，其中len1=num 1.length，len2=num2.length。竖式加法的次数取决于较大数的位数。
        空间复杂度：O(1)
     */
    public String addStrings(String num1, String num2) {
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int carry = 0;
        StringBuffer ans = new StringBuffer();

        while (i >= 0 || j >= 0 || carry != 0) {
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int result = x + y + carry;
            ans.append(result % 10);
            carry = result / 10;
            i--;
            j--;
        }

        // 计算完以后的答案需要翻转过来
        ans.reverse();
        return ans.toString();
    }
}
```

### 543.二叉树的直径(二叉树中节点的最大距离)
题目链接            
https://leetcode-cn.com/problems/diameter-of-binary-tree/       
https://leetcode.com/problems/diameter-of-binary-tree/           
```java
package leetcode;

/*
给定一棵二叉树，你需要计算它的直径长度。一棵二叉树的直径长度是任意两个结点路径长度中的最大值。
这条路径可能穿过也可能不穿过根结点。

示例 :
给定二叉树

          1
         / \
        2   3
       / \
      4   5
返回3, 它的长度是路径 [4,2,1,3] 或者[5,2,1,3]。

注意：两结点之间的路径长度是以它们之间边的数目表示。
 */
public class lc543 {
    /*
        一条路径的长度为该路径经过的节点数减一，所以求直径（即求路径长度的最大值）等效于求路径经过节点数的最大值减一。
        而任意一条路径均可以被看作由某个节点为起点，从其左儿子和右儿子向下遍历的路径拼接得到。
        
        时间复杂度:O(N)，其中N为二叉树的节点数，即遍历一棵二叉树的时间复杂度，每个结点只被访问一次。
        空间复杂度:O(Height)，其中Height为二叉树的高度。由于递归函数在递归过程中需要为每一层递归函数分配栈空间，
        所以这里需要额外的空间且该空间取决于递归的深度，而递归的深度显然为二叉树的高度，并且每次递归调用的函数里又只用了常数个变量，
        所以所需空间复杂度为O(Height)。
     */

    int ans;

    public int diameterOfBinaryTree(TreeNode root) {
        ans = 1;
        getDepth(root);

        return ans - 1;
    }

    public int getDepth(TreeNode node) {
        if (node == null) {
            // 访问到空节点了，返回0
            return 0;
        }

        // 左儿子为根的子树的深度
        int left = getDepth(node.left);
        // 右儿子为根的子树的深度
        int right = getDepth(node.right);

        // 以该节点为起点的路径经过节点数的最大值为left+right+1
        ans = Math.max(ans, left + right + 1);

        // 返回该节点为根的子树的深度
        return Math.max(left, right) + 1;
    }
}
```
### 581.最短无序连续子数组
题目连接
https://leetcode-cn.com/problems/shortest-unsorted-continuous-subarray/                     
https://leetcode.com/problems/shortest-unsorted-continuous-subarray/                        
```java
package leetcode;

/*
给你一个整数数组 nums ，你需要找出一个 连续子数组 ，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
请你找出符合题意的 最短 子数组，并输出它的长度。

示例 1：
输入：nums = [2,6,4,8,10,9,15]
输出：5
解释：你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。

示例 2：
输入：nums = [1,2,3,4]
输出：0

示例 3：
输入：nums = [1]
输出：0

提示：
1 <= nums.length <= 104
-105 <= nums[i] <= 105

进阶：你可以设计一个时间复杂度为 O(n) 的解决方案吗？
 */
public class lc581 {
    /*
        无序子数组中最小元素的正确位置可以决定左边界，最大元素的正确位置可以决定右边界。
        首先需要找到原数组在哪个位置开始不是升序的。从头开始遍历数组，一旦遇到降序的元素，记录最小元素为min 。
        逆序扫描数组nums，当数组出现升序的时候，记录最大元素为max。
        再次遍历nums数组并通过与其他元素进行比较，来找到min和max在原数组中的正确位置。只需要从头开始找到第一个大于min的元素，
        从尾开始找到第一个小于max的元素，它们之间就是最短无序子数组。

        时间复杂度：O(n)。使用了4个O(n)的循环。
        空间复杂度：O(1)。使用了常数空间。
     */
    public int findUnsortedSubarray(int[] nums) {
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] < nums[i - 1]) {
                min = Math.min(min, nums[i]);
            }
        }
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] > nums[i + 1]) {
                max = Math.max(max, nums[i]);
            }
        }
        int left, right;
        for (left = 0; left < nums.length; left++) {
            if (min < nums[left]) {
                break;
            }
        }
        for (right = nums.length - 1; right >= 0; right--) {
            if (max > nums[right]) {
                break;
            }
        }
        return right - left < 0 ? 0 : right - left + 1;
    }
}
```

### 628.三个数的最大乘积
题目链接                
https://leetcode-cn.com/problems/maximum-product-of-three-numbers/          
https://leetcode.com/problems/maximum-product-of-three-numbers/          
```java
package leetcode;

import java.util.Arrays;

/*
628. 三个数的最大乘积
给你一个整型数组 nums ，在数组中找出由三个数组成的最大乘积，并输出这个乘积。

示例 1：
输入：nums = [1,2,3]
输出：6

示例 2：
输入：nums = [1,2,3,4]
输出：24

示例 3：
输入：nums = [-1,-2,-3]
输出：-6

提示：
3 <= nums.length <=104
-1000 <= nums[i] <= 1000
 */
public class lc628 {
    /*
        时间复杂度：O(N)，其中 N 为数组长度。仅需遍历数组一次。
        空间复杂度：O(1)。
     */
    public int maximumProduct(int[] nums) {
        // 最小的和第二小的
        int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        // 最大的、第二大的和第三大的
        int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;

        for (int x : nums) {
            if (x < min1) {
                min2 = min1;
                min1 = x;
            } else if (x < min2) {
                min2 = x;
            }

            if (x > max1) {
                max3 = max2;
                max2 = max1;
                max1 = x;
            } else if (x > max2) {
                max3 = max2;
                max2 = x;
            } else if (x > max3) {
                max3 = x;
            }
        }

        return Math.max(min1 * min2 * max1, max1 * max2 * max3);
    }

    /*
        首先将数组排序。
        如果数组中全是非负数，则排序后最大的三个数相乘即为最大乘积；如果全是非正数，则最大的三个数相乘同样也为最大乘积。
        如果数组中有正数有负数，则最大乘积既可能是三个最大正数的乘积，也可能是两个最小负数（即绝对值最大）与最大正数的乘积。
        综上，在给数组排序后，分别求出三个最大正数的乘积，以及两个最小负数与最大正数的乘积，二者之间的最大值即为所求答案。

        时间复杂度：O(NlogN)，其中 N 为数组长度。排序需要O(NlogN) 的时间。
        空间复杂度：O(logN)，主要为排序的空间开销。
     */
    public int maximumProduct2(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        return Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 3] * nums[n - 2] * nums[n - 1]);
    }
}
```
### 674.最长连续递增序列
题目链接        
https://leetcode-cn.com/problems/longest-continuous-increasing-subsequence/         
https://leetcode.com/problems/longest-continuous-increasing-subsequence/         
```java
package leetcode;

/*
给定一个未经排序的整数数组，找到最长且连续递增的子序列，并返回该序列的长度。
连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，
那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。

示例 1：
输入：nums = [1,3,5,4,7]
输出：3
解释：最长连续递增序列是 [1,3,5], 长度为3。
尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为 5 和 7 在原数组里被 4 隔开。

示例 2：
输入：nums = [2,2,2,2,2]
输出：1
解释：最长连续递增序列是 [2], 长度为1。

提示：
0 <= nums.length <= 104
-109 <= nums[i] <= 109
 */
public class lc674 {
    /*
        时间复杂度：O(n)，其中n是数组nums的长度。需要遍历数组一次。
        空间复杂度：O(1)。额外使用的空间为常数。
     */
    public int findLengthOfLCIS(int[] nums) {
        int ans = 0;
        int n = nums.length;
        int start = 0;
        for (int i = 0; i < n; ++i) {
            if (i > 0 && nums[i] <= nums[i - 1]) {
                start = i;
            }
            ans = Math.max(ans, i - start + 1);
        }

        return ans;
    }
}
```

### 714.买卖股票的最佳时机含手续费
题目链接                    
https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/              
https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/                     
```java
package leetcode;

/*
给定一个整数数组prices，其中第i个元素代表了第i天的股票价格 ；非负整数fee代表了交易股票的手续费用。
你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
返回获得利润的最大值。
注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:
输入: prices = [1, 3, 2, 8, 4, 9], fee = 2
输出: 8
解释: 能够达到的最大利润:
在此处买入prices[0] = 1
在此处卖出 prices[3] = 8
在此处买入 prices[4] = 4
在此处卖出 prices[5] = 9
总利润:((8 - 1) - 2) + ((9 - 4) - 2) = 8

注意:
0 < prices.length <= 50000.
0 < prices[i] < 50000.
0 <= fee < 50000.
 */
public class lc714 {
    /*
        不能同时参与多笔交易，因此每天交易结束后只可能存在手里有一支股票或者没有股票的状态。
        定义状态dp[i][0]表示第i天交易完后手里没有股票的最大利润，
        dp[i][1]表示第i天交易完后手里持有一支股票的最大利润（i从0开始）。

        时间复杂度：O(n)，其中n为数组的长度。一共有2n个状态，每次状态转移的时间复杂度为O(1)，因此时间复杂度为O(2n)=O(n)。
        空间复杂度：O(n)。
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for (int i = 1; i < n; ++i) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }
        return dp[n - 1][0];
    }
}
```
### 796.旋转字符串
题目链接                    
https://leetcode-cn.com/problems/rotate-string/                            
https://leetcode.com/problems/rotate-string/                    
```java
package leetcode;

import java.util.Arrays;

/*
给定两个字符串, A和B。
A的旋转操作就是将A最左边的字符移动到最右边。例如, 若A = 'abcde'，在移动一次之后结果就是'bcdea'。如果在若干次旋转操作之后，A能变成B，那么返回True。

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
```
### 1143.最长公共子序列
题目链接                    
https://leetcode-cn.com/problems/longest-common-subsequence/                            
https://leetcode.com/problems/longest-common-subsequence/                          
> ![lc1143](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/leetcode/picture/lc1143.png)            
```java
package leetcode;

import java.util.Map;

/*
给定两个字符串text1和text2，返回这两个字符串的最长公共子序列的长度。如果不存在 公共子序列 ，返回0。
一个字符串的子序列是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。

示例 1：
输入：text1 = "abcde", text2 = "ace"
输出：3
解释：最长公共子序列是 "ace" ，它的长度为 3 。

示例 2：
输入：text1 = "abc", text2 = "abc"
输出：3
解释：最长公共子序列是 "abc" ，它的长度为 3 。

示例 3：
输入：text1 = "abc", text2 = "def"
输出：0
解释：两个字符串没有公共子序列，返回 0 。

提示：
1 <= text1.length, text2.length <= 1000
text1 和text2 仅由小写英文字符组成。
 */
public class lc1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[m][n];
    }
}
```
### 1502.判断能否形成等差数列
题目链接                
https://leetcode-cn.com/problems/can-make-arithmetic-progression-from-sequence/                                         
https://leetcode.com/problems/can-make-arithmetic-progression-from-sequence/                                      
```java
package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
给你一个数字数组 arr 。
如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。

示例 1：
输入：arr = [3,5,1]
输出：true
解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。

示例 2：
输入：arr = [1,2,4]
输出：false
解释：无法通过重新排序得到等差数列。

提示：
2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
 */
public class lc1502 {
    /*
        时间复杂度：O(nlogn)。排序的时间代价为O(n*logn)，遍历序列的时间代价是O(n)，故渐进时间复杂度为 O(n*log n + n) = O(n*logn)。
        空间复杂度：O(logn)。快速排序中使用的栈空间期望是O(logn)。
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public boolean canMakeArithmeticProgression2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        //对数组进行第一次遍历,找出数组中min ,max
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            set.add(i);
        }

        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }

        //求得公差
        int diff = (max - min) / (arr.length - 1);

        for (int i = min + diff; i < max; i += diff) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
```