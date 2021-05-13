package list;

import java.util.Scanner;

public class DeleteRepeateList {
    public static void main(String[] args) {
        DeleteRepeateList deleteRepeateList = new DeleteRepeateList();
        ListNode head = deleteRepeateList.createList();
        deleteRepeateList.printList(head);
        deleteRepeateList.deleteRepeateNodeRecurtion(head);
        deleteRepeateList.printList(head);

        ListNode head2 = deleteRepeateList.createList();
        deleteRepeateList.printList(head2);
        deleteRepeateList.deleteRepeateNode(head2);
        deleteRepeateList.printList(head2);
    }

    public ListNode deleteRepeateNodeRecurtion(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head != null && head.next == null) {
            return head;
        }

        ListNode tmp = head;
        ListNode next = deleteRepeateNodeRecurtion(head.next);

        if (next != null) {
            if (tmp.val == next.val) {
                tmp.next = next.next;
            }
        }

        return head;
    }

    public ListNode deleteRepeateNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }

            cur = cur.next;
        }

        return head;
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
}
