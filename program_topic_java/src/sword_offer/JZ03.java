package sword_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

/**
 * 题目描述
 * 输入一个链表，按链表从尾到头的顺序返回一个ArrayList。
 * 示例1
 * 输入
 * {67,0,24,58}
 * 返回值
 * [58,24,0,67]
 */
class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}

public class JZ03 {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }

        Stack<Integer> stk = new Stack<>();
        while (listNode != null) {
            stk.push(listNode.val);
            listNode = listNode.next;
        }

        while (!stk.isEmpty()) {
            res.add(stk.pop());
        }

        return res;
    }

    public ArrayList<Integer> printListFromTailToHead2(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<>();
        if (listNode == null) {
            return res;
        }

        ListNode p = listNode;
        int n = 0;
        while (p != null) {
            n++;
            p = p.next;
        }

        p = listNode;
        Integer[] arr = new Integer[n];
        for (int i = n - 1; i >= 0; i--) {
            arr[i] = p.val;
            p = p.next;
        }

        Collections.addAll(res, arr);
        return res;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(0);
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        JZ03 jz = new JZ03();
        ArrayList<Integer> list = jz.printListFromTailToHead(head);
        for (Integer item : list) {
            System.out.print(item + "\t");
        }
    }
}
