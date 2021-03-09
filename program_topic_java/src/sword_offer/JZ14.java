package sword_offer;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 示例1
 * 输入
 * {1,2,3,4,5},1
 * 返回值
 * {5}
 */

public class JZ14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode first = head;
        ListNode last = head;
        for (int i = 0; i < k; i++) {
            if (first != null) {
                first = first.next;
            } else {
                return null;
            }
        }

        while (first != null) {
            first = first.next;
            last = last.next;
        }

        return last;
    }
}
