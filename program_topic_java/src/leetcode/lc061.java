package leetcode;

/*
61. 旋转链表
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
