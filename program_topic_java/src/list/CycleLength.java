package list;

import java.util.Scanner;

public class CycleLength {
    public static void main(String[] args) {
        CycleLength cycleLength = new CycleLength();
        ListNode head = cycleLength.createList();
        ListNode last = cycleLength.findLastNode(head);
        ListNode node = head.next.next.next;
        last.next = node;
        int length = cycleLength.getCycleLength(head);
        System.out.println(length);
    }

    //第一次相遇后，让fast停着不走了，slow继续走，记录到下次相遇时循环了几次。
    public int getCycleLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        int len = 1;
        ListNode cur = slow.next;
        while (cur != fast) {
            ++len;
            cur = cur.next;
        }

        return len;
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
