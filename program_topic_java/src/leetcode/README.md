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