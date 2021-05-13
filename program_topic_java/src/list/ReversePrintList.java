package list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class ReversePrintList {
    public static void main(String[] args) {
        ReversePrintList reversePrintList = new ReversePrintList();
        ListNode head = reversePrintList.createList();
        reversePrintList.printList(head);
        reversePrintList.reversePrintList(head);
        System.out.println();
        reversePrintList.reversePrintList2(head);
    }

    public void reversePrintList(ListNode head) {
        if (head == null) {
            return;
        }

        Stack<ListNode> stack = new Stack<>();
        ListNode cur = head;
        while (cur != null) {
            stack.push(cur);
            cur = cur.next;
        }

        while (!stack.isEmpty()) {
            ListNode node = stack.pop();
            System.out.print(node.val + "\t");
            node = node.next;
        }
    }

    public void reversePrintList2(ListNode head) {
        if (head == null) {
            return;
        }

        List<ListNode> list = new ArrayList<>();
        ListNode cur = head;
        while (cur != null) {
            list.add(cur);
            cur = cur.next;
        }

        for (int i = list.size() - 1; i >= 0; --i) {
            System.out.print(list.get(i).val + "\t");
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
