package list;

import java.util.Scanner;

public class GetListLength {
    public static void main(String[] args) {
        GetListLength getListLength = new GetListLength();
        ListNode head = getListLength.createList();
        int length = getListLength.getListLength(head);
        System.out.println(length);
    }

    public int getListLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode cur = head;
        int length = 0;
        while (cur != null) {
            ++length;
            cur = cur.next;
        }

        return length;
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
