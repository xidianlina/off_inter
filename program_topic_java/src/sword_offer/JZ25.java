package sword_offer;

import java.util.HashMap;

/**
 * 题目描述
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，另一个特殊指针random指向一个随机节点），
 * 请对此链表进行深拷贝，并返回拷贝后的头结点。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */

class RandomListNode {
    int label;
    RandomListNode next = null;
    RandomListNode random = null;

    RandomListNode(int label) {
        this.label = label;
    }
}

public class JZ25 {
    public RandomListNode Clone(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> m = new HashMap<>();
        if (head == null) {
            return null;
        }

        RandomListNode cur = head;
        while (cur != null) {
            m.put(cur, new RandomListNode(cur.label));
            cur = cur.next;
        }

        cur = head;
        while (cur != null) {
            m.get(cur).next = m.get(cur.next);
            m.get(cur).random = m.get(cur.random);
            cur = cur.next;
        }

        return m.get(head);
    }
}
