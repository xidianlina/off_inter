package list;

import java.util.Scanner;

public class GetMedianNode {
    public static void main(String[] args) {
        GetMedianNode getMedianNode = new GetMedianNode();
        ListNode head = getMedianNode.createList();
        ListNode medianNode = getMedianNode.getMedianNode(head);
        System.out.println(medianNode.val);
    }

    public ListNode getMedianNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
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
