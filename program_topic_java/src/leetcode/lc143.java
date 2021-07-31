package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
143. 重排链表
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
