package list;

import java.util.Scanner;

public class IsY {
    public static void main(String[] args) {
        IsY isY = new IsY();
        ListNode head = isY.createList();
        ListNode head2 = isY.createList();
        ListNode node = head.next.next;
        ListNode last = isY.findLastNode(head2);
        last.next = node;
        boolean flag = isY.isY2(head, head2);
        System.out.println(flag);
    }

    //如两个单链表相交，那么从相交结点开始到链表结束都是相同的结点，必然是Y字形，判断两个链表的最后一个结点是否相同即可
    public boolean isY2(ListNode f, ListNode s) {
        if (f == null || s == null) {
            return false;
        }

        ListNode node1 = f;
        ListNode node2 = s;
        while (node1.next != null) {
            node1 = node1.next;
        }

        while (node2.next != null) {
            node2 = node2.next;
        }

        if (node1 == node2) {
            return true;
        }

        return false;
    }

    //将两个链表的首尾相连，监测是否有环
    public boolean isY(ListNode f, ListNode s) {
        if (f == null || s == null) {
            return false;
        }

        while (s.next != null) {
            s = s.next;
        }

        s.next = f;

        return helper(s);
    }

    public boolean helper(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
    }

    public ListNode createList() {
        ListNode head = null;
        Scanner sc = new Scanner(System.in);
        int val = sc.nextInt();
        if (val == 100) {
            return head;
        } else {
            head = new ListNode(val);
            head.next = createList();
        }

        return head;
    }

    public void printList(ListNode head) {
        if (head == null) {
            return;
        }

        ListNode cur = head;
        while (cur.next != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println(cur.val);
    }

    public ListNode findLastNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        return cur;
    }
}
