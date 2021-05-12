算法题目整理
======
# 1.洗牌算法
```java
package algorithm;

import java.util.Random;

/*
Fisher-Yates洗牌算法:
在每次迭代中，生成一个范围在当前下标到数组末尾元素下标之间的随机整数。
接下来，将当前元素和随机选出的下标所指的元素互相交换。
复杂度分析
时间复杂度:O(n)
Fisher-Yates洗牌算法时间复杂度是线性的，因为算法中生成随机序列，交换两个元素这两种操作都是常数时间复杂度的。
空间复杂度:O(n)
因为要实现重置功能，原始数组必须得保存一份，因此空间复杂度是O(n)。
 */
public class FisherYatesShuffle {
    private int[] array;
    private int[] original;

    //生成随机数
    Random rand = new Random();

    private int randRange(int min, int max) {
        return rand.nextInt(max - min) + min;
    }

    //交换数组里的两个元素
    private void swapAt(int i, int j) {
        int tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public FisherYatesShuffle(int[] nums) {
        array = nums;
        original = nums.clone();
    }

    //将数组重置为其原始配置并返回
    public int[] reset() {
        array = original;
        original = original.clone();
        return original;
    }

    //返回数组的随机洗牌
    public int[] shuffle() {
        for (int i = 0; i < array.length; i++) {
            swapAt(i, randRange(i, array.length));
        }

        return array;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        FisherYatesShuffle shuffle = new FisherYatesShuffle(arr);
        shuffle.printArray(arr);
        int[] res = shuffle.shuffle();
        shuffle.printArray(res);
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
```
# 2.完美洗牌算法
> 题目描述      
有个长度为2n的数组{a1, a2, a3, ..., an, b1, b2, b3, ..., bn} ，
希望排序后 {a1, b1, a2, b2, ...., an, bn} ，请考虑有无时间复杂度 O(n)，空间复杂度 O(1) 的解法。     
分析和解法     
解法一：蛮力变换      
题目要求怎么变换就怎么变换。为了便于分析，取n=4，那么题目要求把     
a1，a2，a3，a4， b1，b2，b3，b4      
变成        
a1，b1，a2，b2，a3，b3，a4，b4       
1.1、步步前移
仔细观察变换前后两个序列的特点，我们可做如下一系列操作：      
第①步、确定 b1 的位置，即让 b1 跟它前面的 a2，a3，a4 交换：        
a1，b1，a2，a3，a4， b2，b3，b4            
第②步、接着确定 b2 的位置，即让 b2 跟它前面的 a3，a4 交换：     
a1，b1，a2，b2，a3，a4， b3，b4      
第③步、b3 跟它前面的 a4 交换位置：     
a1，b1，a2，b2，a3，b3，a4，b4       
b4已在最后的位置，不需要再交换。如此，经过上述 3 个步骤后，得到我们最后想要的序列。      
源代码如下:
```java
package algorithm;

public class Shuffle {
    public static void main(String[] args) {
        Shuffle shuffle = new Shuffle();
        int[] arr = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        shuffle.printArray(arr);
        shuffle.shuffle(arr);
        shuffle.printArray(arr);
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }

    public void shuffle(int[] arr) {
        int l = arr.length;
        if (l < 3 || l % 2 == 1) {
            return;
        }

        int size = l / 2;
        int index = 0;
        int count = 0;
        for (int i = size; i < l - 1; i++) {
            //交换个数
            count = size - (i - size) - 1;
            //待交换的数的下标
            index = i;
            for (int j = 1; j <= count; j++) {
                int tmp = arr[index];
                arr[index] = arr[i - j];
                arr[i - j] = tmp;
                index = i - j;
            }
        }
    }
}
```
> 分析：但此方法的时间复杂度为O(N^2)，得继续寻找其它方法，看看有无办法能达到题目所预期的O(N)的时间复杂度。     
> 1.2、中间交换      
当然，除了如上面所述的让 b1，b2，b3，b4 步步前移跟它们各自前面的元素进行交换外，还可以每次让序列中最中间的元素进行交换达到目的。
还是用上面的例子，针对 a1，a2，a3，a4，b1，b2，b3，b4        
第①步：交换最中间的两个元素 a4，b1，序列变成：     
a1，a2，a3 ，b1，a4， b2，b3，b4      
第②步，让最中间的两对元素各自交换：     
a1，a2 ，b1，a3，b2，a4， b3，b4      
第③步，交换最中间的三对元素，序列变成：       
a1，b1，a2，b2，a3，b3，a4，b4        
同样，此法同解法 1.1、步步前移一样，时间复杂度依然为 O（N^2）。       
源代码如下：
```java
package algorithm;

public class Shuffle2 {
    public static void main(String[] args) {
        Shuffle2 shuffle = new Shuffle2();
        int[] arr = {0, 2, 4, 6, 8, 1, 3, 5, 7, 9};
        shuffle.printArray(arr);
        shuffle.shuffle(arr);
        shuffle.printArray(arr);
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size - 1; i++) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }

    public void shuffle(int[] arr) {
        int l = arr.length;
        if (l < 3 || l % 2 == 1) {
            return;
        }

        int n = l / 2;
        int left = n - 1;
        int right = n;
        //交换次数
        for (int i = 0; i < n - 1; i++) {
            for (int j = left; j < right; j += 2) {
                int tmp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = tmp;
            }
            --left;
            ++right;
        }
    }
}
```
> 参考 https://www.jianshu.com/p/9c841ad88ded                     
# 3.两个线程分别打印1-100，a线程打印偶数，b线程打印奇数
```java
package algorithm;

public class ThreadPrint {
    public static void main(String[] args) {
        for (int i = 1; i <= 100; ++i) {
            PrintOddThread odd = new PrintOddThread(i);
            PrintEvenThread even = new PrintEvenThread(i);
            Thread oddThread = new Thread(odd);
            Thread evenThread = new Thread(even);
            oddThread.start();
            evenThread.start();
        }
    }
}

class PrintOddThread implements Runnable {
    private int i;

    public PrintOddThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        if (i % 2 == 1) {
            System.out.println("odd thread " + i);
        }
    }
}

class PrintEvenThread implements Runnable {
    private int i;

    public PrintEvenThread(int i) {
        this.i = i;
    }

    @Override
    public void run() {
        if (i % 2 == 0) {
            System.out.println("even thread " + i);
        }
    }
}
```
# 4.一个链表，奇数位升序偶数位降序，让链表变成升序的
```java
package algorithm;


import java.util.List;

/*
题目描述：一个链表，奇数位升序偶数位降序，让链表变成升序的。比如：1 8 3 6 5 4 7 2 9，最后输出1 2 3 4 5 6 7 8 9。
分析：
这道题可以分成三步：
首先根据奇数位和偶数位拆分成两个链表。
然后对偶数链表进行反转。
最后将两个有序链表进行合并。
 */
public class OddIncreaseEvenDecrease {
    //按照奇偶位拆分成两个链表
    private ListNode[] splitList(ListNode head) {
        ListNode head1 = null;
        ListNode head2 = null;
        ListNode cur1 = null;
        ListNode cur2 = null;

        int count = 1;
        while (head != null) {
            if (count % 2 == 1) {
                if (cur1 != null) {
                    cur1.next = head;
                    cur1 = cur1.next;
                } else {
                    cur1 = head;
                    head1 = cur1;
                }
            } else {
                if (cur2 != null) {
                    cur2.next = head;
                    cur2 = cur2.next;
                } else {
                    cur2 = head;
                    head2 = cur2;
                }
            }
            head = head.next;
            ++count;
        }

        //跳出循环，要让最后两个末尾元素的下一个都指向null
        cur1.next = null;
        cur2.next = null;
        ListNode[] heads = new ListNode[]{head1, head2};
        return heads;
    }

    //反转链表
    private ListNode reverseList(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        ListNode next = null;
        while (cur != null) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    //合并两个有序链表
    private ListNode mergeLists(ListNode head1, ListNode head2) {
        if (head1 == null && head2 == null) {
            return null;
        }

        if (head1 == null) {
            return head2;
        }

        if (head2 == null) {
            return head1;
        }

        ListNode first = new ListNode(-1);
        ListNode cur = first;
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        cur.next = head1 != null ? head1 : head2;

        return first.next;
    }

    //初始化链表
    private ListNode initList() {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(6);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(4);
        ListNode node7 = new ListNode(7);
        ListNode node8 = new ListNode(2);
        ListNode node9 = new ListNode(9);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node7;
        node7.next = node8;
        node8.next = node9;
        return node1;
    }

    //打印链表
    private void printList(ListNode head) {
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

    public static void main(String[] args) {
        OddIncreaseEvenDecrease main = new OddIncreaseEvenDecrease();
        ListNode head = main.initList();
        main.printList(head);
        ListNode[] heads = main.splitList(head);
        main.printList(heads[0]);
        main.printList(heads[1]);
        ListNode reverseHead = main.reverseList(heads[1]);
        main.printList(reverseHead);
        ListNode mergeHead = main.mergeLists(heads[0], reverseHead);
        main.printList(mergeHead);
    }
}

class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {

    }

    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}
```
