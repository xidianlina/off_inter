链表题目
======
## 1.单链表的建立
```java
package list;

import java.util.Scanner;

public class CreateList {
    public static void main(String[] args) {
        CreateList createList = new CreateList();
        ListNode head = createList.createList();
        createList.printList(head);
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

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
```
## 2.求单链表的长度
```java
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
```
## 3.单链表的插入
```java
package list;

import java.util.Scanner;

public class InsertList {
    public static void main(String[] args) {
        InsertList insertList = new InsertList();
        ListNode head = insertList.createList();
        insertList.printList(head);
        insertList.insertNode(head,54,10);
        insertList.printList(head);
    }

    public void insertNode(ListNode head, int val, int pos) {
        if (head == null) {
            return;
        }

        ListNode node = new ListNode(val);
        ListNode cur = head;
        ListNode last = head;
        if (pos == 0) {
            node.val = head.val;
            head.val = val;
            node.next = head.next;
            head.next = node;
        } else {
            int index = 1;
            while (cur != null && index < pos) {
                ++index;
                cur = cur.next;
            }
            if (cur != null) {
                node.next = cur.next;
                cur.next = node;
            } else {
                while (last.next != null) {
                    last = last.next;
                }

                last.next = node;
            }
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
```
## 4.单链表的删除
```java
package list;

import java.util.Scanner;

public class DeleteList {
    public static void main(String[] args) {
        DeleteList deleteList = new DeleteList();
        ListNode head = deleteList.createList();
        deleteList.printList(head);
        ListNode node = head.next.next.next;
        deleteList.deleteNode(head, node);
        deleteList.printList(head);
    }

    public void deleteNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return;
        }

        if (head == node) {
            head.val = head.next.val;
            head.next = head.next.next;
        } else if (node.next != null) {
            ListNode next = node.next;
            node.val = next.val;
            node.next = next.next;
        } else {
            ListNode last = head;
            while (last != null) {
                if (last.next == node) {
                    last.next = null;
                }
                last = last.next;
            }
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
```
## 5.查找单链表的第k个结点
```java
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
```
## 6.查找单链表中倒数第k个元素
```java
package list;

import java.util.Scanner;

public class FindLastKNode {
    public static void main(String[] args) {
        FindLastKNode findLastKNode = new FindLastKNode();
        ListNode head = findLastKNode.createList();
        findLastKNode.printList(head);
        ListNode node = findLastKNode.findLastKNode(head, 3);
        findLastKNode.printList(node);
    }

    public ListNode findLastKNode(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode first = head;
        ListNode last = head;
        for (int i = 0; i < k; ++i) {
            if (first.next != null) {
                first = first.next;
            } else {
                return null;
            }
        }

        while (first != null) {
            first = first.next;
            last = last.next;
        }

        return last;
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
```
## 7.查找单链表的中间节点
```java
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
```
## 8.逆序输出单链表元素
```java
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
```
## 9.判断单链表是否存在环
```java
package list;

import javax.security.auth.callback.TextInputCallback;
import java.util.Scanner;

public class ExistCycle {
    public static void main(String[] args) {
        ExistCycle existCycle = new ExistCycle();
        ListNode head = existCycle.createList();
        ListNode node = head.next.next.next;
        ListNode last = existCycle.findLastNode(head);
        last.next = node;
        boolean existFlag = existCycle.existCycle(head);
        System.out.println(existFlag);

        ListNode head2 = existCycle.createList();
        boolean flag = existCycle.existCycle(head2);
        System.out.println(flag);
    }

    public boolean existCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
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
```
## 10.求单链表环的长度
```java
package list;

import java.util.Scanner;

public class CycleLength {
    public static void main(String[] args) {
        CycleLength cycleLength = new CycleLength();
        ListNode head = cycleLength.createList();
        ListNode last = cycleLength.findLastNode(head);
        ListNode node = head.next.next.next;
        last.next = node;
        int length = cycleLength.getCycleLength(head);
        System.out.println(length);
    }

    //第一次相遇后，让fast停着不走了，slow继续走，记录到下次相遇时循环了几次。
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
```
## 11.求环的入口结点
```java
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
```
## 12.求有环单链表的长度
```java
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
```
## 13.删除单链表的重复结点(保留一个重复接口)
```java
package list;

import java.util.Scanner;

public class DeleteRepeateList {
    public static void main(String[] args) {
        DeleteRepeateList deleteRepeateList = new DeleteRepeateList();
        ListNode head = deleteRepeateList.createList();
        deleteRepeateList.printList(head);
        deleteRepeateList.deleteRepeateNodeRecurtion(head);
        deleteRepeateList.printList(head);

        ListNode head2 = deleteRepeateList.createList();
        deleteRepeateList.printList(head2);
        deleteRepeateList.deleteRepeateNode(head2);
        deleteRepeateList.printList(head2);
    }

    public ListNode deleteRepeateNodeRecurtion(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head != null && head.next == null) {
            return head;
        }

        ListNode tmp = head;
        ListNode next = deleteRepeateNodeRecurtion(head.next);

        if (next != null) {
            if (tmp.val == next.val) {
                tmp.next = next.next;
            }
        }

        return head;
    }

    public ListNode deleteRepeateNode(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != null) {
            while (cur.next != null && cur.val == cur.next.val) {
                cur.next = cur.next.next;
            }

            cur = cur.next;
        }

        return head;
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
```
## 14.删除单链表的重复结点(不保留重复接口)
```java
package list;

import java.util.Scanner;

public class DeleteRepeateListNode {
    public static void main(String[] args) {
        DeleteRepeateListNode deleteRepeateListNode = new DeleteRepeateListNode();
        ListNode head = deleteRepeateListNode.createList();
        deleteRepeateListNode.printList(head);
        ListNode node = deleteRepeateListNode.deleteRepeateListNodeRecurtion(head);
        deleteRepeateListNode.printList(node);
        System.out.println("---------");
        ListNode head2 = deleteRepeateListNode.createList();
        deleteRepeateListNode.printList(head2);
        ListNode node2 = deleteRepeateListNode.deleteRepeateListNode(head2);
        deleteRepeateListNode.printList(node2);
    }

    public ListNode deleteRepeateListNodeRecurtion(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head != null && head.next == null) {
            return head;
        }

        ListNode cur = null;
        if (head.val == head.next.val) {
            cur = head.next.next;
            while (cur != null && cur.val == head.val) {
                cur = cur.next;
            }

            return deleteRepeateListNodeRecurtion(cur);
        } else {
            cur = head.next;
            head.next = deleteRepeateListNodeRecurtion(cur);
            return head;
        }
    }

    public ListNode deleteRepeateListNode(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head != null && head.next == null) {
            return head;
        }
        ListNode first = new ListNode(-1);
        first.next = head;
        ListNode last = first;
        ListNode p = head;
        while (p != null && p.next != null) {
            if (p.val == p.next.val) {
                int val = p.val;
                while (p != null && p.val == val) {
                    p = p.next;
                }
                last.next = p;
            } else {
                last = p;
                p = p.next;
            }
        }
        return first.next;
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
```
## 15.判断两个链表是否交叉
```java
package list;

import java.util.Scanner;

public class IsY {
    public static void main(String[] args) {
        IsY isY = new IsY();
        ListNode head = isY.createList();
        ListNode head2 = isY.createList();
        ListNode node = head.next.next;
        ListNode last = isY.findLastNode(head2);
        last.next = node;
        boolean flag = isY.isY2(head, head2);
        System.out.println(flag);
    }

    //如两个单链表相交，那么从相交结点开始到链表结束都是相同的结点，必然是Y字形，判断两个链表的最后一个结点是否相同即可
    public boolean isY2(ListNode f, ListNode s) {
        if (f == null || s == null) {
            return false;
        }

        ListNode node1 = f;
        ListNode node2 = s;
        while (node1.next != null) {
            node1 = node1.next;
        }

        while (node2.next != null) {
            node2 = node2.next;
        }

        if (node1 == node2) {
            return true;
        }

        return false;
    }

    //将两个链表的首尾相连，监测是否有环
    public boolean isY(ListNode f, ListNode s) {
        if (f == null || s == null) {
            return false;
        }

        while (s.next != null) {
            s = s.next;
        }

        s.next = f;

        return helper(s);
    }

    public boolean helper(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }

        return false;
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
```
## 16.交换单链表中任意两个结点
```java
package list;

import java.util.Scanner;

public class ExchangeTwoNode {
    public static void main(String[] args) {
        ExchangeTwoNode exchangeTwoNode = new ExchangeTwoNode();
        ListNode head = exchangeTwoNode.createList();
        exchangeTwoNode.printList(head);
        ListNode node1 = head.next.next.next.next;
        ListNode node2 = head.next.next.next;
        ListNode node = exchangeTwoNode.exchangeTwoNode(head, node1, node2);
        exchangeTwoNode.printList(node);
    }

    public ListNode exchangeTwoNode(ListNode head, ListNode node1, ListNode node2) {
        if (head == null || node1 == null || node2 == null) {
            return head;
        }

        if (node1.val == node2.val) {
            return head;
        }

        if (node1.next == node2) {
            ListNode preNode = findPreNode(head, node1);
            preNode.next = node2;
            node1.next = node2.next;
            node2.next = node1;
        } else if (node2.next == node1) {
            ListNode preNode = findPreNode(head, node2);
            preNode.next = node1;
            node2.next = node1.next;
            node1.next = node2;
        } else if (node1 != node2) {
            ListNode preNode1 = findPreNode(head, node1);
            ListNode preNode2 = findPreNode(head, node2);
            ListNode tmp = node1.next;
            node1.next = node2.next;
            node2.next = tmp;
            preNode1.next = node2;
            preNode2.next = node1;
        }

        return head;
    }

    public ListNode findPreNode(ListNode head, ListNode node) {
        if (head == null || node == null) {
            return null;
        }

        ListNode cur = head;
        while (cur != null) {
            if (cur.next == node) {
                return cur;
            }
            cur = cur.next;
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
}
```