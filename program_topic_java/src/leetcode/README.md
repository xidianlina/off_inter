LeetCode
======

# 1.两数之和
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
# 2.两数相加
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
# 3.无重复字符的最长子串
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
# 4.寻找两个正序数组的中位数
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
# 5.最长回文子串
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
# 6.Z字形变换
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
# 7.整数反转
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
# 8.字符串转换整数 (atoi)
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
# 9.回文数
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
# 10.正则表达式匹配
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
# 11.盛最多水的容器
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
# 12.整数转罗马数字
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
# 13.罗马数字转整数
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
# 14.最长公共前缀
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
# 15. 三数之和
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
# 16.最接近的三数之和
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
# 17.电话号码的字母组合
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
# 18.四数之和
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
# 19.删除链表的倒数第N个结点
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
# 20.有效的括号
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
# 21.合并两个有序链表
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
# 22.括号生成
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
# 23.合并K个升序链表
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
# 24.两两交换链表中的节点
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
# 25.K 个一组翻转链表
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
# 26.
题目链接 
# 27.
题目链接 
# 28.
题目链接 
# 29.
题目链接 
# 30.
题目链接 
# 206.反转链表
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


# 328.奇偶链表
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