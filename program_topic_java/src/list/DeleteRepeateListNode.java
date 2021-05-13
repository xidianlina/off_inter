package list;

import java.util.Scanner;

public class DeleteRepeateListNode {
    public static void main(String[] args) {
        DeleteRepeateListNode deleteRepeateListNode = new DeleteRepeateListNode();
        ListNode head = deleteRepeateListNode.createList();
        deleteRepeateListNode.printList(head);
        ListNode node = deleteRepeateListNode.deleteRepeateListNodeRecurtion(head);
        deleteRepeateListNode.printList(node);
        System.out.println("---------");
        ListNode head2 = deleteRepeateListNode.createList();
        deleteRepeateListNode.printList(head2);
        ListNode node2 = deleteRepeateListNode.deleteRepeateListNode(head2);
        deleteRepeateListNode.printList(node2);
    }

    public ListNode deleteRepeateListNodeRecurtion(ListNode head) {
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

            return deleteRepeateListNodeRecurtion(cur);
        } else {
            cur = head.next;
            head.next = deleteRepeateListNodeRecurtion(cur);
            return head;
        }
    }

    public ListNode deleteRepeateListNode(ListNode head) {
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
