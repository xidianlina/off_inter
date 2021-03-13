package sword_offer;

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Stack<ListNode> stk1 = new Stack<ListNode>();
        Stack<ListNode> stk2 = new Stack<ListNode>();
        while (head1 != null) {
            stk1.push(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            stk2.push(head2);
            head2 = head2.next;
        }

        ListNode commonNode = null;
        while (!stk1.isEmpty() && !stk2.isEmpty() && stk1.peek() == stk2.peek()) {
            stk1.pop();
            commonNode = stk2.pop();
        }

        return commonNode;
    }

    public ListNode FindFirstCommonNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        HashMap<ListNode, ListNode> m = new HashMap<>();
        while (head1 != null) {
            m.put(head1, head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (m.containsKey(head2)) {
                return head2;
            }
            head2 = head2.next;
        }

        return null;
    }

    public ListNode FindFirstCommonNode3(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode cur = head1;
        int n = 0;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }

        cur = head2;
        while (cur != null) {
            --n;
            cur = cur.next;
        }

        ListNode shortList = null;
        ListNode longList = null;
        if (n < 0) {
            shortList = head1;
            longList = head2;
        } else {
            shortList = head2;
            longList = head1;
        }
        n = n < 0 ? -n : n;
        for (int i = 0; i < n; i++) {
            longList = longList.next;
        }

        while (shortList != null && longList != null && shortList.val != longList.val) {
            shortList = shortList.next;
            longList = longList.next;
        }

        return longList;
    }
}
