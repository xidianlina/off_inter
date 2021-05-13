package list;

import java.util.Scanner;

public class FindKNode {
    public static void main(String[] args) {
        FindKNode findKNode = new FindKNode();
        ListNode head = findKNode.createList();
        ListNode node = findKNode.findKNode(head, 10);
        System.out.println(node);
    }

    public ListNode findKNode(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        if (k == 0) {
            return head;
        }

        ListNode cur = head;
        while (k-- > 0) {
            cur = cur.next;
            if (cur == null) {
                System.out.println("no find");
                return null;
            }
        }

        return cur;
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
