package list;

import java.util.Scanner;

public class InsertList {
    public static void main(String[] args) {
        InsertList insertList = new InsertList();
        ListNode head = insertList.createList();
        insertList.printList(head);
        insertList.insertNode(head,54,10);
        insertList.printList(head);
    }

    public void insertNode(ListNode head, int val, int pos) {
        if (head == null) {
            return;
        }

        ListNode node = new ListNode(val);
        ListNode cur = head;
        ListNode last = head;
        if (pos == 0) {
            node.val = head.val;
            head.val = val;
            node.next = head.next;
            head.next = node;
        } else {
            int index = 1;
            while (cur != null && index < pos) {
                ++index;
                cur = cur.next;
            }
            if (cur != null) {
                node.next = cur.next;
                cur.next = node;
            } else {
                while (last.next != null) {
                    last = last.next;
                }

                last.next = node;
            }
        }
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
