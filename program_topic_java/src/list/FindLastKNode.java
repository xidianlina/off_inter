package list;

import java.util.Scanner;

public class FindLastKNode {
    public static void main(String[] args) {
        FindLastKNode findLastKNode = new FindLastKNode();
        ListNode head = findLastKNode.createList();
        findLastKNode.printList(head);
        ListNode node = findLastKNode.findLastKNode(head, 3);
        findLastKNode.printList(node);
    }

    public ListNode findLastKNode(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode first = head;
        ListNode last = head;
        for (int i = 0; i < k; ++i) {
            if (first.next != null) {
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
