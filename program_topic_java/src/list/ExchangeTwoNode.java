package list;

import java.util.Scanner;

public class ExchangeTwoNode {
    public static void main(String[] args) {
        ExchangeTwoNode exchangeTwoNode = new ExchangeTwoNode();
        ListNode head = exchangeTwoNode.createList();
        exchangeTwoNode.printList(head);
        ListNode node1 = head.next.next.next.next;
        ListNode node2 = head.next.next.next;
        ListNode node = exchangeTwoNode.exchangeTwoNode(head, node1, node2);
        exchangeTwoNode.printList(node);
    }

    public ListNode exchangeTwoNode(ListNode head, ListNode node1, ListNode node2) {
        if (head == null || node1 == null || node2 == null) {
            return head;
        }

        if (node1.val == node2.val) {
            return head;
        }

        if (node1.next == node2) {
            ListNode preNode = findPreNode(head, node1);
            preNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
        } else if (node2.next == node1) {
            ListNode preNode = findPreNode(head, node2);
            preNode.next = node1;
            node2.next = node1.next;
            node1.next = node2;
        } else if (node1 != node2) {
            ListNode preNode1 = findPreNode(head, node1);
            ListNode preNode2 = findPreNode(head, node2);
            ListNode tmp = node1.next;
            node1.next = node2.next;
            node2.next = tmp;
            preNode1.next = node2;
            preNode2.next = node1;
        }

        return head;
    }

    public ListNode findPreNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != null) {
            if (cur.next == node) {
                return cur;
            }
            cur = cur.next;
        }

        return null;
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
