package list;

import java.util.Scanner;

public class GetHaveCycleListLength {
    public static void main(String[] args) {
        GetHaveCycleListLength main = new GetHaveCycleListLength();
        ListNode head = main.createList();
        ListNode last = main.findLastNode(head);
        ListNode node = head.next.next.next;
        last.next = node;
        int len = main.gethaveCycleListLength(head);
        System.out.println(len);
    }

    public int gethaveCycleListLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        //获取入口结点
        ListNode cycleNode = findCycleNode(head);

        //计算环的长度
        int cycleLen = getCycleLength(head);

        //获取链表头到环入口结点的长度
        int headCycleLenght = getHeadCycleLength(head, cycleNode);

        return cycleLen + headCycleLenght;
    }

    //获取链表头到环入口结点的长度
    public int getHeadCycleLength(ListNode head, ListNode cycleNode) {
        if (head == null || cycleNode == null) {
            return 0;
        }

        ListNode cur = head;
        int len = 0;
        while (cur.next != cycleNode) {
            ++len;
            cur = cur.next;
        }

        return len;
    }

    //计算环的长度：第一次相遇后，让fast停着不走了，slow继续走，记录到下次相遇时循环了几次。
    public int getCycleLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                break;
            }
        }

        int len = 1;
        ListNode cur = slow.next;
        while (cur != fast) {
            ++len;
            cur = cur.next;
        }

        return len;
    }

    //获取入口结点
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
