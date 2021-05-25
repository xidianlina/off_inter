package list;

import java.util.HashMap;
import java.util.Scanner;

public class GetNodeCount {
    public static void main(String[] args) {
        GetNodeCount cn = new GetNodeCount();
        ListNode head = cn.createList();
        cn.printList(head);
        ListNode last = head;
        while (last.next != null) {
            last = last.next;
        }
        ListNode cur = head;
        ListNode node = cur.next.next.next;
        last.next = node;
        int count = cn.nodeCount(head);
        System.out.println(count);
        System.out.println("----------------------");
        ListNode head2 = cn.createList();
        cn.printList(head2);
        ListNode last2 = head;
        while (last2.next != null) {
            last2 = last2.next;
        }
        ListNode cur2 = head2;
        ListNode node2 = cur2.next.next.next;
        last2.next = node;
        int count2 = cn.countNode(head2);
        System.out.println(count2);
    }

    //删除计数过的结点
    public int nodeCount(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode cur = head;
        int cnt = 0;
        while (cur.next != null) {
            cur = cur.next;
            head.next = null;
            head = cur;
            ++cnt;
        }

        return cnt;
    }

    //map记录计数过的结点
    private int countNode(ListNode head) {
        if (head == null) {
            return 0;
        }
        ListNode cur = head;
        int cnt = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (cur != null) {
            if (!map.containsKey(cur.val)) {
                ++cnt;
                map.put(cur.val, cur.val);
            }
            cur = cur.next;
        }
        return cnt;
    }

    private ListNode createList() {
        int val;
        ListNode head = null;
        System.out.println("enter value of list (100 to quit):");
        Scanner sc = new Scanner(System.in);
        val = sc.nextInt();
        if (val == 100) {
            return head;
        } else {
            head = new ListNode(val);
            head.next = createList();
        }
        return head;
    }

    private void printList(ListNode head) {
        if (head == null) {
            return;
        }
        ListNode cur = head;
        while (cur != null) {
            System.out.print(cur.val + "\t");
            cur = cur.next;
        }
        System.out.println();
    }
}
