package sword_offer;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 示例1
 * 输入
 * {1,2,3,3,4,4,5}
 * 返回值
 * {1,2,5}
 */
public class JZ56 {
    public ListNode deleteDuplication(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head != null && head.next == null) {
            return head;
        }

        ListNode cur = null;
        if (head.val == head.next.val) {
            cur = head.next.next;
            while (cur != null && cur.val == head.val) {
                cur = cur.next;
            }
            return deleteDuplication(cur);
        } else {
            cur = head.next;
            head.next = deleteDuplication(cur);
            return head;
        }
    }

    public ListNode deleteDuplication2(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head != null && head.next == null) {
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode last = first;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                        p = p.next;
                }
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
    }
}
