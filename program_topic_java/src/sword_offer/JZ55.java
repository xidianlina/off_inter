package sword_offer;

import java.util.HashMap;

/**
 * 题目描述
 * 给一个链表，若其中包含环，请找出该链表的环的入口结点，否则，输出null。
 */
public class JZ55 {
    /*
    第一步，找环中相汇点。分别用p1，p2指向链表头部，p1每次走一步，p2每次走二步，直到p1==p2找到在环中的相汇点。
    第二步，找环的入口。接上步，当p1==p2时，p2所经过节点数为2x,p1所经过节点数为x,设环中有n个节点,p2比p1多走一圈有2x=n+x; n=x;
    可以看出p1实际走了一个环的步数，再让p2指向链表头部，p1位置不变，p1,p2每次走一步直到p1==p2; 此时p1指向环的入口。
     */
    public ListNode EntryNodeOfLoop(ListNode head) {
        if (head == null || head.next == null) {
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

    public ListNode EntryNodeOfLoop2(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        HashMap<ListNode, Boolean> m = new HashMap<>();
        ListNode node = head;
        while (node != null) {
            if (m.containsKey(node)) {
                return node;
            } else {
                m.put(node, true);
                node = node.next;
            }
        }

        return null;
    }
}
