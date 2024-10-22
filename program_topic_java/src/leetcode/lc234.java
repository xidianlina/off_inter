package leetcode;

/**
 * 给你一个单链表的头节点head,请你判断该链表是否为回文链表。如果是返回true；否则返回false 。
 * 示例 1：
 * 输入：head = [1,2,2,1]
 * 输出：true
 *
 * 示例 2：
 * 输入：head = [1,2]
 * 输出：false
 *
 * 提示：
 * 链表中节点数目在范围[1, 105] 内
 * 0 <= Node.val <= 9
 *
 * 进阶：你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
 */
import java.util.ArrayList;
import java.util.List;
public class lc234 {
    /**
     * 时间复杂度：O(n)，其中n指的是链表的元素个数。
     * 第一步：遍历链表并将值复制到数组中，O(n)。
     * 第二步：双指针判断是否为回文，执行了 O(n/2) 次的判断，即 O(n)。
     * 总的时间复杂度：O(2n)=O(n)。
     * 空间复杂度：O(n)，其中 n 指的是链表的元素个数，使用了一个数组列表存放链表的元素值。
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }

        List<Integer> list = new ArrayList<Integer>();

        // 将链表的值复制到数组中
        ListNode cur = head;
        while (cur != null) {
            list.add(cur.val);
            cur = cur.next;
        }

        // 使用双指针判断是否回文
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            if (!list.get(l).equals(list.get(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    /**
     * 时间复杂度：O(n)，其中n指的是链表的大小。
     * 空间复杂度：O(1)。只修改原本链表中节点的指向，而在堆栈上的堆栈帧不超过 O(1)。
     */
    public boolean isPalindrome2(ListNode head) {
        if (head == null){
            return true;
        }

        // 找到前半部分链表的尾节点并反转后半部分链表
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // 判断是否回文
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) {
                result = false;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        // 还原链表并返回结果
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
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

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
