package list;

import java.util.Scanner;

public class DeleteList {
    public static void main(String[] args) {
        DeleteList deleteList = new DeleteList();
        ListNode head = deleteList.createList();
        deleteList.printList(head);
        ListNode node = head.next.next.next;
        deleteList.deleteNode(head, node);
        deleteList.printList(head);
    }

    public void deleteNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return;
        }

        if (head == node) {
            head.val = head.next.val;
            head.next = head.next.next;
        } else if (node.next != null) {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        } else {
            ListNode last = head;
            while (last != null) {
                if (last.next == node) {
                    last.next = null;
                }
                last = last.next;
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
