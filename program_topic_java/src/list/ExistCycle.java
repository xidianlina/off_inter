package list;

import javax.security.auth.callback.TextInputCallback;
import java.util.Scanner;

public class ExistCycle {
    public static void main(String[] args) {
        ExistCycle existCycle = new ExistCycle();
        ListNode head = existCycle.createList();
        ListNode node = head.next.next.next;
        ListNode last = existCycle.findLastNode(head);
        last.next = node;
        boolean existFlag = existCycle.existCycle(head);
        System.out.println(existFlag);

        ListNode head2 = existCycle.createList();
        boolean flag = existCycle.existCycle(head2);
        System.out.println(flag);
    }

    public boolean existCycle(ListNode head) {
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
