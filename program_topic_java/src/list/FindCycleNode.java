package list;

import java.util.Scanner;

public class FindCycleNode {
    public static void main(String[] args) {
        FindCycleNode findCycleNode = new FindCycleNode();
        ListNode head = findCycleNode.createList();
        ListNode last = findCycleNode.findLastNode(head);
        ListNode node = head.next.next.next;
        last.next = node;
        ListNode cycle = findCycleNode.findCycleNode(head);
        System.out.println(cycle.val);
    }

    public ListNode findCycleNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                fast = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
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

    public ListNode findLastNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur.next != null) {
            cur = cur.next;
        }

        return cur;
    }
}
