# 1.二维数组中的查找
```java
package sword_offer;

/**
 * 题目描述
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例
 * 输入
 * 7,[[1,2,8,9],[2,4,9,12],[4,7,10,13],[6,8,11,15]]
 * 返回值
 * true
 */

public class JZ01 {
    public static void main(String args[]) {
        int target = 7;
        int[][] array = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};

        JZ01 jz01 = new JZ01();

        boolean res = jz01.Find(target, array);
        System.out.println(res);
    }

    public boolean Find(int target, int[][] array) {
        int row = array.length;
        int col = array[0].length;
        int i = 0;
        int j = col - 1;

        while (i < row && j >= 0) {
            if (array[i][j] > target) {
                j--;
            } else if (array[i][j] < target) {
                i++;
            } else {
                return true;
            }
        }
        return false;
    }
}
```
# 2.替换空格
```java
package sword_offer;

/**
 * 题目描述
 * 请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * 示例
 * 输入
 * "We Are Happy"
 * 返回值
 * "We%20Are%20Happy"
 */
public class JZ02 {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        char[] charArr = s.toCharArray();
        String replaceStr = "%20";
        for (char c : charArr) {
            if (c == ' ') {
                sb.append(replaceStr);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String replaceSpace2(String s) {
        char[] charArr = s.toCharArray();
        int replaceLength = 0;
        for (char c : charArr) {
            if (c == ' ') {
                replaceLength++;
            }
        }

        char[] resultArr = new char[charArr.length + 2 * replaceLength];
        int oldLength = charArr.length - 1;
        int newLength = resultArr.length - 1;
        while (newLength >= 0) {
            if (charArr[oldLength] == ' ') {
                resultArr[newLength--] = '0';
                resultArr[newLength--] = '2';
                resultArr[newLength--] = '%';
            } else {
                resultArr[newLength--] = charArr[oldLength];
            }
            oldLength--;
        }
        return String.valueOf(resultArr);
    }
}
```
# 3.从尾到头打印链表
```java
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
```
# 4. 重建二叉树
```java
package sword_offer;

/**
 * 题目描述
 * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
 * 示例1
 * 输入
 * [1,2,3,4,5,6,7],[3,2,4,1,6,5,7]
 * 返回值
 * {1,2,5,3,4,6,7}
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        this.val = val;
    }
}

/**
 * 因为是树的结构，一般都是用递归来实现。
 * 用数学归纳法的思想就是，假设最后一步，就是root的左右子树都已经重建好了，
 * 那么我只要考虑将root的左右子树安上去即可。
 * 根据前序遍历的性质，第一个元素必然就是root，那么下面的工作就是如何确定root的左右子树的范围。
 * 根据中序遍历的性质，root元素前面都是root的左子树，后面都是root的右子树。
 * 那么只要找到中序遍历中root的位置，就可以确定好左右子树的范围。
 * 正如上面所说，只需要将确定的左右子树安到root上即可。递归要注意出口，
 * 假设最后只有一个元素了，那么就要返回。
 */
public class JZ04 {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null | pre.length == 0 || in.length == 0 || pre.length != in.length) {
            return null;
        }

        return reConstructBinaryTree(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    public TreeNode reConstructBinaryTree(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre || startIn > endIn) {
            return null;
        }

        TreeNode tree = new TreeNode(pre[startPre]);

        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == pre[startPre]) {
                tree.left = reConstructBinaryTree(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                tree.right = reConstructBinaryTree(pre, startPre + i - startIn + 1, endPre, in, i + 1, endIn);
            }
        }

        return tree;
    }
}
```
# 5.用两个栈实现队列
```java
package sword_offer;

import java.util.Stack;

/**
 * 题目描述
 * 用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型。
 */
public class JZ05 {
    Stack<Integer> stk1 = new Stack<>();
    Stack<Integer> stk2 = new Stack<>();

    public void push(int node) {
        stk1.push(node);
    }

    public int pop() {
        if (!stk1.isEmpty() && stk2.isEmpty()) {
            while (!stk1.isEmpty()) {
                stk2.push(stk1.pop());
            }
        }
        return stk2.pop();
    }
}
```
# 6.旋转数组的最小数字
```java
package sword_offer;

/**
 * 题目描述
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 * 示例1
 * 输入
 * [3,4,5,1,2]
 * 返回值
 * 1
 */
public class JZ06 {
    public int minNumberInRotateArray(int[] array) {
        int len = array.length;
        if (len == 0 || array == null) {
            return -1;
        }

        int low = 0;
        int high = len - 1;
        int mid = 0;
        while (array[low] >= array[high]) {
            if (high - low == 1) {
                mid = high;
                break;
            }

            mid = (low + high) >> 1;
            if (array[low] == array[high] && array[low] == array[mid]) {
                int res = array[low];
                for (int i = low + 1; i <= high; i++) {
                    if (array[i] < res) {
                        res = array[i];
                    }
                }
                return res;
            }

            if (array[mid] >= array[high]) {
                low = mid;
            } else if (array[mid] <= array[high]) {
                high = mid;
            }
        }
        return array[mid];
    }
}
```
# 7.斐波那契数列
```java
package sword_offer;

/**
 * 题目描述
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。39n≤39
 * 示例
 * 输入
 * 4
 * 返回值
 * 3
 */
public class JZ07 {
    public int Fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return Fibonacci(n - 1) + Fibonacci(n - 2);
    }

    public int Fibonacci2(int n) {
        if (n <= 1) {
            return n;
        }
        int temp = 0;
        int pre = 0;
        int res = 1;
        for (int i = 2; i <= n; i++) {
            temp = res;
            res = pre + res;
            pre = temp;
        }

        return res;
    }
}
```
# 8.跳台阶
```java
package sword_offer;

/**
 * 题目描述
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
 * 示例1
 * 输入
 * 1
 * 返回值
 * 1
 * 示例2
 * 输入
 * 4
 * 返回值
 * 5
 */
public class JZ08 {
    public static void main(String args[]) {
        JZ08 jz08 = new JZ08();
        int res = jz08.JumpFloor(4);
        System.out.println(res);
        int res2 = jz08.JumpFloor2(4);
        System.out.println(res2);
    }

    public int JumpFloor(int target) {
        if (target <= 2) {
            return target;
        }

        return JumpFloor(target - 1) + JumpFloor(target - 2);
    }

    public int JumpFloor2(int target) {
        if (target == 1) {
            return target;
        }
        int temp = 0, pre = 1, res = 1;
        for (int i = 2; i <= target; i++) {
            temp = res;
            res = res + pre;
            pre = temp;
        }

        return res;
    }
}
```
# 9.变态跳台阶
```java
package sword_offer;

/**
 * 题目描述:一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 示例1
 * 输入
 * 3
 * 返回值
 * 4
 */
public class JZ09 {
    public static void main(String[] args) {
        JZ09 jz09 = new JZ09();
        int res = jz09.JumpFloorII(3);
        System.out.println(res);
    }

    public int JumpFloorII(int n) {
        if (n <= 1) {
            return 1;
        }
        int res = 1;
        for (int i = 1; i < n; i++) {
            res += JumpFloorII(n - i);
        }
        return res;
    }
}
```
# 10.矩形覆盖
```java
package sword_offer;

/**
 * 题目描述:我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class JZ10 {
    public static void main(String[] args) {
        JZ10 jz10 = new JZ10();
        int res = jz10.RectCover(4);
        System.out.println(res);
    }

    public int RectCover(int n) {
        if (n <= 2) {
            return n;
        }
        return RectCover(n - 1) + RectCover(n - 2);
    }

    public int RectCover2(int n) {
        if (n <= 1) {
            return n;
        }

        int tmp = 0, pre = 1, res = 1;
        for (int i = 2; i <= n; ++i) {
            tmp = res;
            res = res + pre;
            pre = tmp;
        }

        return res;
    }
}
```
# 11.二进制中1的个数
```java
package sword_offer;

/**
 * 题目描述
 * 输入一个整数，输出该数32位二进制表示中1的个数。其中负数用补码表示。
 * 示例
 * 输入
 * 10
 * 返回值
 * 2
 */
public class JZ11 {
    public static void main(String[] args) {
        JZ11 jz11 = new JZ11();
        int res = jz11.NumberOf1(10);
        System.out.println(res);
        int res2 = jz11.NumberOf1_2(10);
        System.out.println(res2);
        int res3 = jz11.NumberOf1_3(10);
        System.out.println(res3);
    }

    /*
    利用&运算的特性,把一个整数减去1，再和原整数做与运算，
    会把该整数最右边一个1变成0.那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
     */
    public int NumberOf1(int n) {
        int res = 0;
        while (n != 0) {
            n &= (n - 1);
            res++;
        }
        return res;
    }

    /*
    正整数的二进制数最高位为 0 ，负整数和二进制数最高们为 1 ，
    则可利用左移、判断正负来实现 1 的个数的计算。
     */
    public int NumberOf1_2(int n) {
        int res = 0;
        while (n != 0) {
            if (n < 0) {
                res++;
            }
            //左移一位,左边的最高位为符号位，根据正负数来判断符号位的0,1，从而得到1的个数
            n = n << 1;
        }
        return res;
    }

    /*
    通过位移判断奇偶数并计数，标志位初始为1，将其和输入值相与，
    n & 1 的结果为 1 或 0 ，为 1 的时候 count+=1 ，为 0 的时候 count+=0
     */
    public int NumberOf1_3(int n) {
        int res = 0;
        int flag = 1;
        while (flag != 0) {
            if ((n & flag) != 0) {
                res++;
            }
            flag = flag << 1;
        }
        return res;
    }
}
```
# 12.数值的整数次方
```java
package sword_offer;

/**
 * 题目描述
 * 给定一个double类型的浮点数base和int类型的整数exponent。求base的exponent次方。
 * 保证base和exponent不同时为0
 * 示例1
 * 输入
 * 2,3
 * 返回值
 * 8.00000
 */
public class JZ12 {
    public double Power(double base, int exponent) {
        double res = 0;
        if (exponent == 0) {
            return 1;
        } else if (exponent > 0) {
            res = base;
            for (int i = 1; i < exponent; i++) {
                res *= base;
            }
            return res;
        } else {
            res = base;
            int flag = -exponent;
            for (int i = 1; i < flag; i++) {
                res *= base;
            }
            return 1 / res;
        }
    }

    public double Power2(double base, int exponent) {
        double res = 0;
        if (exponent == 0) {
            return 1;
        } else {
            int flag = exponent > 0 ? exponent : -exponent;
            res = base;
            for (int i = 1; i < flag; i++) {
                res *= base;
            }
            return exponent > 0 ? res : 1 / res;
        }
    }
}
```
# 13.调整数组顺序使奇数位于偶数前面
```java
package sword_offer;

/**
 * 题目描述
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 示例
 * 输入
 * [1,2,3,4]
 * 返回值
 * [1,3,2,4]
 */
public class JZ13 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        JZ13 jz13 = new JZ13();
        jz13.printArray(arr);
        jz13.reOrderArray(arr);
        jz13.printArray(arr);
        System.out.println("-----------------");
        int[] arr2 = {1, 2, 3, 4, 5};
        jz13.printArray(arr2);
        jz13.reOrderArray2(arr2);
        jz13.printArray(arr2);
    }

    public int[] reOrderArray(int[] array) {
        int len = array.length;
        if (len == 0) {
            return new int[]{};
        }
        for (int i = 0; i < len; i++) {
            for (int j = len - 1; j > i; j--) {
                if (array[j] % 2 == 1 && array[j - 1] % 2 == 0) {
                    array[j] = array[j] + array[j - 1];
                    array[j - 1] = array[j] - array[j - 1];
                    array[j] = array[j] - array[j - 1];
                }
            }
        }
        return array;
    }

    public int[] reOrderArray2(int[] array) {
        int len = array.length;
        if (len == 0) {
            return new int[]{};
        }
        int i = 0;
        int j = 0;
        while (i < len) {
            while (i < len && array[i] % 2 == 1) {
                i++;
            }
            j = i + 1;
            while (j < len && array[j] % 2 == 0) {
                j++;
            }
            if (j < len) {
                int tmp = array[j];
                for (int k = j - 1; k >= i; k--) {
                    array[k + 1] = array[k];
                }
                array[i] = tmp;
            } else {
                break;
            }
        }
        return array;
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0) {
            return;
        }

        for (int i = 0; i < size - 1; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
```
# 14.链表中倒数第k个结点
```java
package sword_offer;

/**
 * 题目描述
 * 输入一个链表，输出该链表中倒数第k个结点。
 * 示例1
 * 输入
 * {1,2,3,4,5},1
 * 返回值
 * {5}
 */

public class JZ14 {
    public ListNode FindKthToTail(ListNode head, int k) {
        if (head == null || k < 0) {
            return null;
        }

        ListNode first = head;
        ListNode last = head;
        for (int i = 0; i < k; i++) {
            if (first != null) {
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
}
```
# 15.反转链表
```java
package sword_offer;

/**
 * 题目描述
 * 输入一个链表，反转链表后，输出新链表的表头。
 * 示例1
 * 输入
 * {1,2,3}
 * 返回值
 * {3,2,1}
 */
public class JZ15 {
    public ListNode ReverseList(ListNode head) {
        if (head == null) {
            return null;
        }

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
}
```
# 16.合并两个排序的链表
```java
package sword_offer;

/**
 * 题目描述
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 * 示例1
 * 输入
 * {1,3,5},{2,4,6}
 * 返回值
 * {1,2,3,4,5,6}
 */
public class JZ16 {
    public ListNode Merge(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        ListNode first = new ListNode(-1);
        ListNode cur = first;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                cur.next = list1;
                list1 = list1.next;
            } else {
                cur.next = list2;
                list2 = list2.next;
            }
            cur = cur.next;
        }
        cur.next = list1 != null ? list1 : list2;
        return first.next;
    }
}
```
# 17.树的子结构
```java
package sword_offer;

/**
 * 题目描述
 * 输入两棵二叉树A，B，判断B是不是A的子结构。（ps：我们约定空树不是任意一个树的子结构）
 * 示例1
 * 输入
 * {8,8,#,9,#,2,#,5},{8,9,#,2}
 * 返回值
 * true
 */
public class JZ17 {
    public boolean HasSubtree(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return false;
        }

        return isSubtree(root1, root2) || isSubtree(root1.left, root2) || isSubtree(root1.right, root2);
    }

    private boolean isSubtree(TreeNode root1, TreeNode root2) {
        if (root2 == null) {
            return true;
        }

        if (root1 == null || root1.val != root2.val) {
            return false;
        }
        return isSubtree(root1.left, root2.left) && isSubtree(root1.right, root2.right);
    }
}
```
# 18.二叉树的镜像
```java
package sword_offer;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 题目描述
 * 操作给定的二叉树，将其变换为源二叉树的镜像。
 */
public class JZ18 {
    /*
    方法一 递归
    先前序遍历这棵树的每个结点，如果遍历到的结点有子结点，就交换它的两个子节点，当交换完所有的非叶子结点的左右子结点之后，就得到了树的镜像。
     */
    public TreeNode Mirror(TreeNode root) {
        //当前节点为空，直接返回
        if (root == null) {
            return root;
        }
        //当前节点没有叶子节点，直接返回
        if (root.left == null && root.right == null) {
            return root;
        }
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        //递归交换叶子节点
        if (root.left != null) {
            Mirror(root.left);
        }
        if (root.right != null) {
            Mirror(root.right);
        }
        return root;
    }

    /*
    方法二 非递归
    思路类似于之前的求二叉树高度，以广度优先的方式进行查找。首先查找出每一层的节点，接着对每一层节点的子节点进行镜像，也就是交换操作。全部完成后即镜像完毕。
     */
    public TreeNode Mirror2(TreeNode root) {
        if (root == null) {
            return root;
        }

        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int count = 1;
        while (que.size() != 0) {
            count--;
            TreeNode top = que.poll();
            if (top.left != null || top.right != null) {
                TreeNode temp = top.left;
                top.left = top.right;
                top.right = temp;
                if (top.left != null) {
                    que.offer(top.left);
                }
                if (top.right != null) {
                    que.offer(top.right);
                }
            }
            if (count == 0) {
                count = que.size();
            }
        }

        return root;
    }
}
```
# 19.顺时针打印矩阵
```java
package sword_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字，例如，如果输入如下4 X 4矩阵： 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 则依次打印出数字1,2,3,4,8,12,16,15,14,13,9,5,6,7,11,10.
 * 示例1
 * 输入
 * [[1,2],[3,4]]
 * 返回值
 * [1,2,4,3]
 */
public class JZ19 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        ArrayList<Integer> res = new ArrayList<>();

        if (matrix == null || row == 0 || col == 0) {
            return res;
        }

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;

        //螺旋曲线，运动轨迹总是一致的
        while (top <= bottom && left <= right) {
            //向右列递增遍历
            for (int j = left; j <= right; j++) {
                res.add(matrix[top][j]);
            }

            //遍历后，去掉此行
            top++;

            //向下行递增遍历
            for (int i = top; i <= bottom; i++) {
                res.add(matrix[i][right]);
            }

            //遍历后，去掉此行
            right--;

            if (top <= bottom) {//重要判断，防止重复
                //向左列递减遍历
                for (int j = right; j >= left; j--) {
                    res.add(matrix[bottom][j]);
                }
            }

            //遍历后，去掉此行
            bottom--;

            if (left <= right) {//重要判断，防止重复
                //向上行递减遍历
                for (int i = bottom; i >= top; i--) {
                    res.add(matrix[i][left]);
                }
            }

            //遍历后，去掉此列
            left++;
        }

        return res;
    }
}
```
# 20.包含min函数的栈
```java
package sword_offer;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class JZ20 {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> m = new Stack<Integer>();

    public void push(int node) {
        s.push(node);
        if (m.empty()) {
            m.push(node);
        } else if (m.peek() > node) {
            m.push(node);
        } else {
            m.push(m.peek());
        }
    }

    public void pop() {
        s.pop();
        m.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return m.peek();
    }
}
```
```java
package sword_offer;

import java.util.Stack;

/**
 * 题目描述
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class JZ20_2 {
    Stack<Integer> s = new Stack<Integer>();
    Stack<Integer> m = new Stack<Integer>();

    public void push(int node) {
        s.push(node);
        if (m.isEmpty()) {
            m.push(node);
        } else if (m.peek() > node) {
            m.push(node);
        }
    }

    public void pop() {
        if (s.peek() == m.peek()) {
            m.pop();
        }
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int min() {
        return m.peek();
    }
}
```
# 21.栈的压入、弹出序列
```java
package sword_offer;

import java.util.Stack;

/**
 * 题目描述
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否可能为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1,2,3,4,5是某栈的压入顺序，序列4,5,3,2,1是该压栈序列对应的一个弹出序列，但4,3,5,1,2就不可能是该压栈序列的弹出序列。（注意：这两个序列的长度是相等的）
 * 示例1
 * 输入
 * [1,2,3,4,5],[4,3,5,1,2]
 * 返回值
 * false
 */
public class JZ21 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        int pSize = pushA.length;
        int vSize = popA.length;
        if (pSize == 0 || vSize == 0 || pSize != vSize) {
            return false;
        }

        Stack<Integer> stk = new Stack<Integer>();
        int popIndex = 0;
        for (int i = 0; i < pSize; i++) {
            stk.push(pushA[i]);
            while (!stk.isEmpty() && stk.peek() == popA[popIndex]) {
                stk.pop();
                ++popIndex;
            }
        }

        return stk.isEmpty();
    }
}
```
# 22.从上往下打印二叉树
```java
package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 从上往下打印出二叉树的每个节点，同层节点从左至右打印。
 * 示例1
 * 输入
 * {5,4,#,3,#,2,#,1}
 * 返回值
 * [5,4,3,2,1]
 */
public class JZ22 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        LinkedList<TreeNode> que = new LinkedList<TreeNode>();
        ArrayList<Integer> res = new ArrayList<Integer>();

        if (root == null) {
            return res;
        }

        que.offer(root);
        while (!que.isEmpty()) {
            root = que.poll();
            res.add(root.val);
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
        }

        return res;
    }
}
```
# 23.二叉搜索树的后序遍历序列
```java
package sword_offer;

/**
 * 题目描述
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。如果是则返回true,否则返回false。
 * 假设输入的数组的任意两个数字都互不相同。（ps：我们约定空树不是二叉搜素树）
 * 示例1
 * 输入
 * [4,8,6,12,16,14,10]
 * 返回值
 * true
 */

/*
后序遍历定义:[左子树|右子树|根节点],即遍历顺序为“左、右、根” 。
二叉搜索树定义:左子树中所有节点的值小于根节点的值；右子树中所有节点的值大于根节点的值；其左、右子树也分别为二叉搜索树。
 */
public class JZ23 {
    public boolean VerifySquenceOfBST(int[] arr) {
        int size = arr.length;
        if (size == 0) {
            return false;
        }

        if (size == 1) {
            return true;
        }

        return helper(arr, 0, size - 1);
    }

    private boolean helper(int[] arr, int start, int end) {
        if (start >= end) {
            return true;
        }

        int i = end;
        while (i > start && arr[i - 1] > arr[end]) {
            --i;
        }

        for (int j = start; j < i; ++j) {
            if (arr[j] > arr[end]) {
                return false;
            }
        }

        return helper(arr, start, i - 1) && helper(arr, i, end - 1);
    }
}
```
# 24.二叉树中和为某一值的路径
```java
package sword_offer;

import java.io.File;
import java.util.ArrayList;

/**
 * 题目描述
 * 输入一颗二叉树的根节点和一个整数，按字典序打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。
 * 示例1
 * 输入
 * {10,5,12,4,7},22
 * 返回值
 * [[10,5,7],[10,12]]
 * 示例2
 * 输入
 * {10,5,12,4,7},15
 * 返回值
 * []
 */

/*
思路分析：首先思考节点值的和为输入的整数，每条路径都一定是从根节点到叶子节点，
在数据结构中从根节点到叶子节点的遍历称之为深度优先遍历DFS。因此整个过程可以采用先序遍历方式的DFS，
即根节点》左子树》右子树。随后考虑一次遍历完成后的处理，当一次遍历完成后，如果输入整数值恰好等于节点值之和，
则输出这条路径并且回退一个节点；如果不等于则直接回退一个节点，即回退到当前节点的父节点，如果该父节点有右孩子，
则继续遍历，否则继续回退。考虑回退到根节点，此时如果它有右孩子，则继续遍历，否则整个DFS结束。
 */
public class JZ24 {
    private ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    private ArrayList<Integer> path = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null) {
            return res;
        }

        path.add(root.val);
        if (root.val == target && root.left == null && root.right == null) {
            res.add(new ArrayList<>(path));
        }

        FindPath(root.left, target - root.val);
        FindPath(root.right, target - root.val);
        path.remove(path.size() - 1);

        return res;
    }
}
```
# 25.复杂链表的复制
```java
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
```
# 26.二叉搜索树与双向链表
```java
package sword_offer;

import java.util.Stack;

/**
 * 题目描述
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的双向链表。要求不能创建任何新的结点，只能调整树中结点指针的指向。
 */
public class JZ26 {
    /*
    解析：在二叉搜索树中，每个结点都有两个分别指向其左、右子树的指针，左子树结点的值总是小于父结点的值，
    右子树结点的值总是大于父结点的值。在双向链表中，每个结点也有两个指针，它们分别指向前一个结点和后一个结点。
    所以这两种数据结构的结点是一致，二叉搜索树和双向链表只是因为两个指针的指向不同而已，通过改变其指针的指向来实现是完全可能的。
    为了减少指针的变换次数，并让操作更加简单，在转换成排序双向链表时，原先指向左子结点的指针调整为链表中指向前一个结点的指针，
    原先指向右子结点的指针调整为链表中指向下一个结点的指针。由于要求链表是有序的，可以借助二叉树中序遍历，
    因为中序遍历算法的特点就是从小到大访问结点。当遍历访问到根结点时，假设根结点的左侧已经处理好，
    只需将根结点与上次访问的最近结点（左子树中最大值结点）的指针连接好即可。进而更新当前链表的最后一个结点指针。
    同时中序遍历过程正好是转换成链表的过程，可采用递归方法处理。
     */
    public TreeNode Convert(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        Stack<TreeNode> stk = new Stack<TreeNode>();
        TreeNode node = null;
        while (root != null || !stk.isEmpty()) {
            if (root != null) {
                stk.push(root);
                root = root.right;
            } else {
                root = stk.pop();
                if (node == null) {
                    node = root;
                } else {
                    node.left = root;
                    root.right = node;
                    node = root;
                }
                root = root.left;
            }
        }
        return node;
    }

    public TreeNode Convert2(TreeNode root) {
        if (root == null || root.left == null && root.right == null) {
            return root;
        }

        TreeNode left = Convert2(root.left);
        TreeNode node = left;
        while (node != null && node.right != null) {
            node = node.right;
        }

        if (node != null) {
            node.right = root;
            root.left = node;
        }

        TreeNode right = Convert2(root.right);
        if (right != null) {
            root.right = right;
            right.left = root;
        }

        return left != null ? left : root;
    }
}
```
# 27.字符串的排序
```java
package sword_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;

/**
 * 题目描述
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,则按字典序打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 * 输入描述:
 * 输入一个字符串,长度不超过9(可能有字符重复),字符只包括大小写字母。
 * 示例1
 * 输入
 * "ab"
 * 返回值
 * ["ab","ba"]
 */
public class JZ27 {
    /*
    以三个字符abc为例来分析一下求字符串排列的过程。首先固定第一个字符a，求后面两个字符bc的排列。
    当两个字符bc的排列求好之后，把第一个字符a和后面的b交换，得到bac，接着固定第一个字符b，
    求后面两个字符ac的排列。现在是把c放到第一位置的时候了。记住前面已经把原先的第一个字符a和后面的b做了交换，
    为了保证这次c仍然是和原先处在第一位置的a交换，在拿c和第一个字符交换之前，先要把b和a交换回来。
    在交换b和a之后，再拿c和处在第一位置的a进行交换，得到cba。再次固定第一个字符c，求后面两个字符b、a的排列。
     */
    public ArrayList<String> Permutation(String str) {
        ArrayList<String> res = new ArrayList<>();
        if (str.isEmpty() || str.length() == 0) {
            return res;
        }

        HashSet<String> set = new HashSet<>();
        helper(set, str.toCharArray(), 0);
        res.addAll(set);
        Collections.sort(res);
        return res;
    }

    private void helper(HashSet<String> set, char[] s, int k) {
        if (k == s.length) {
            set.add(new String(s));
            return;
        }

        for (int i = k; i < s.length; i++) {
            swap(s, i, k);
            helper(set, s, k + 1);
            swap(s, i, k);
        }
    }

    private void swap(char[] s, int i, int j) {
        char tmp = s[i];
        s[i] = s[j];
        s[j] = tmp;
    }
}
```
# 28.数组中出现次数超过一半的数字
```java
package sword_offer;

/**
 * 题目描述
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。例如输入一个长度为9的数组{1,2,3,2,2,2,5,4,2}。
 * 由于数字2在数组中出现了5次，超过数组长度的一半，因此输出2。如果不存在则输出0。
 * 示例1
 * 输入
 * [1,2,3,2,2,2,5,4,2]
 * 返回值
 * 2
 */

public class JZ28 {
    /*
    数组中有一个数字出现的次数超过数组长度的一半，也就是说它出现的次数比其他所有数字出现次数的和还要多。
    因此在遍历数组的时候保存两个值：一个是数组中的一个数字，一个是次数，当遍历到下一个数字时，如果下一
    个数字和之前保存的数字相同，则次数加1；如果下一个数字和之前保存的数字不同，则次数减1.如果次数为0，
    需要保存下一个数字，并把次数设为1。由于要找的数字出现的次数比其他所有数字出现的次数之和还要多，那么
    要找的数字肯定是最后一次次数设为1时对应的数字。
     */
    public int MoreThanHalfNum_Solution(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return 0;
        }

        int num = array[0];
        int cnt = 1;
        for (int i = 1; i < size; i++) {
            if (array[i] == num) {
                ++cnt;
            } else {
                --cnt;
                if (cnt == 0) {
                    num = array[i];
                    cnt = 1;
                }
            }
        }

        cnt = 0;
        for (int i = 0; i < size; i++) {
            if (num == array[i]) {
                ++cnt;
            }
        }

        if (2 * cnt > size) {
            return num;
        } else {
            return 0;
        }
    }

    public int MoreThanHalfNum_Solution2(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return 0;
        }

        int mid = size >> 1;
        int start = 0;
        int end = size - 1;
        int index = partition(array, start, end);
        while (index != mid) {
            if (index > mid) {
                end = index - 1;
                index = partition(array, start, end);
            } else if (index < mid) {
                start = index + 1;
                index = partition(array, start, end);
            }
        }

        int res = array[mid];
        int cnt = 0;
        for (int i = 0; i < size; i++) {
            if (array[i] == res) {
                ++cnt;
            }
        }

        if (2 * cnt > size) {
            return res;
        } else {
            return 0;
        }
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}
```
# 29.最小的K个数
```java
package sword_offer;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 给定一个数组，找出其中最小的K个数。例如数组元素是4,5,1,6,2,7,3,8这8个数字，则最小的4个数字是1,2,3,4。如果K>数组的长度，那么返回一个空的数组
 * 示例1
 * 输入
 * [4,5,1,6,2,7,3,8],4
 * 返回值
 * [1,2,3,4]
 */
public class JZ29 {
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        int size = input.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || input == null || size < k || k <= 0) {
            return res;
        }

        int start = 0;
        int end = size - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1) {
                end = index - 1;
                index = partition(input, start, end);
            } else if (index < k - 1) {
                start = index + 1;
                index = partition(input, start, end);
            }
        }

        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }

        return res;
    }

    private int partition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }

    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        int size = input.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (size == 0 || input == null || size < k || k <= 0) {
            return res;
        }

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2.compareTo(o1);
            }
        });

        for (int i = 0; i < size; i++) {
            if (maxHeap.size() != k) {
                maxHeap.offer(input[i]);
            } else {
                if (maxHeap.peek() > input[i]) {
                    maxHeap.poll();
                    maxHeap.offer(input[i]);
                }
            }
        }

        for (Integer num : maxHeap) {
            res.add(num);
        }

        return res;
    }
}
```
# 30.连续子数组的最大和
```java
package sword_offer;

/**
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值
 * 18
 * 说明
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class JZ30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return -1;
        }

        int maxSum = array[0];
        for (int i = 0; i < size; i++) {
            int curSum = 0;
            for (int j = i; j < size; j++) {
                curSum += array[j];
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }

        return maxSum;
    }

    public int FindGreatestSumOfSubArray2(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return -1;
        }

        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 1; i < size; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }
}
```
# 31.整数中1出现的次数（从1到n整数中1出现的次数）
```java
package sword_offer;

/**
 * 题目描述:输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。
 * 例如输入12，从1到12这些整数中包含1的数字有1，10，11，和12，1一共出现了5次。
 */
public class JZ31 {
    /*
    主要思路：设定整数点（如1、10、100等等）作为位置点i（对应n的各位、十位、百位等等），分别对每个数位上有多少包含1的点进行分析
    根据设定的整数位置，对n进行分割，分为两部分，高位n/i，低位n%i
    当i表示百位，且百位对应的数>=2,如n=31456,i=100，则a=314,b=56，此时百位为1的次数有a/10+1=32（最高两位0~31），
    每一次都包含100个连续的点，即共有(a/10+1)*100个点的百位为1
    当i表示百位，且百位对应的数为1，如n=31156,i=100，则a=311,b=56，此时百位对应的就是1，则共有a/10(最高两位0-30)次是包含100个连续点，
    当最高两位为31（即a=311），本次只对应局部点00~56，共b+1次，所有点加起来共有（a/10*100）+(b+1)，这些点百位对应为1
    当i表示百位，且百位对应的数为0,如n=31056,i=100，则a=310,b=56，此时百位为1的次数有a/10=31（最高两位0~30）
    综合以上三种情况，当百位对应0或>=2时，有(a+8)/10次包含所有100个点，还有当百位为1(a%10==1)，需要增加局部点b+1
    之所以补8，是因为当百位为0，则a/10==(a+8)/10，当百位>=2，补8会产生进位位，效果等同于(a/10+1)
     */
    public int NumberOf1Between1AndN_Solution(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;
            if (a % 10 == 0) {
                cnt += a / 10 * m;
            } else if (a % 10 == 1) {
                cnt += a / 10 * m + b + 1;
            } else {
                cnt += (a / 10 + 1) * m;
            }
        }

        return cnt;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        int cnt = 0;
        for (int m = 1; m <= n; m *= 10) {
            int a = n / m;
            int b = n % m;
            if (a % 10 == 1) {
                cnt += a / 10 * m + b + 1;
            } else {
                cnt += ((a + 8) / 10) * m;
            }
        }

        return cnt;
    }

    public int NumberOf1Between1AndN_Solution3(int n) {
        if (n == 0) {
            return 0;
        }
        if (n < 9) {
            return 1;
        }

        int cnt = 1;
        for (int i = 10; i <= n; i++) {
            int tmp = i;
            while (tmp != 0) {
                if (tmp % 10 == 1) {
                    cnt++;
                }
                tmp /= 10;
            }
        }

        return cnt;
    }

    public int NumberOf1Between1AndN_Solution4(int n) {
        int cnt = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            sb.append(String.valueOf(i));
        }

        String arr = sb.toString();
        for (int i = 0; i < arr.length(); i++) {
            if (arr.charAt(i) == '1') {
                cnt++;
            }
        }

        return cnt;
    }
}
```
# 32.把数组排成最小的数
```java
package sword_offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * 题目描述
 * 输入一个正整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 * 例如输入数组{3，32，321}，则打印出这三个数字能排成的最小数字为321323。
 * 示例1
 * 输入
 * [3,32,321]
 * 返回值
 * "321323"
 */
public class JZ32 {
    public String PrintMinNumber(int[] numbers) {
        ArrayList<Integer> list = new ArrayList<>();
        StringBuffer sb = new StringBuffer();
        for (int number : numbers) {
            list.add(number);
        }

        Collections.sort(list, new Comparator<Integer>() {
            @Override
            public int compare(Integer str1, Integer str2) {
                String s1 = str1 + "" + str2;
                String s2 = str2 + "" + str1;
                return s1.compareTo(s2);
            }
        });

        for (Integer n : list) {
            sb.append(n);
        }

        return sb.toString();
    }
}
```
# 33.丑数
```java
package sword_offer;

/**
 * 题目描述
 * 把只包含质因子2、3和5的数称作丑数（Ugly Number）。例如6、8都是丑数，但14不是，因为它包含质因子7。
 * 习惯上把1当做是第一个丑数。求按从小到大的顺序的第N个丑数。
 * 示例1
 * 输入
 * 7
 * 返回值
 * 8
 */
public class JZ33 {
    public int GetUglyNumber_Solution(int index) {
        if (index <= 1) {
            return index;
        }

        int[] res = new int[index];
        res[0] = 1;
        int t2 = 0, t3 = 0, t5 = 0;
        for (int i = 1; i < index; i++) {
            res[i] = Math.min(Math.min(res[t2] * 2, res[t3] * 3), res[t5] * 5);
            if (res[i] == res[t2] * 2) {
                t2++;
            }
            if (res[i] == res[t3] * 3) {
                t3++;
            }
            if (res[i] == res[t5] * 5) {
                t5++;
            }
        }

        return res[index - 1];
    }
}
```
# 34.第一个只出现一次的字符位置
```java
package sword_offer;

import java.util.HashMap;

/**
 * 题目描述
 * 在一个字符串(0<=字符串长度<=10000，全部由字母组成)中找到第一个只出现一次的字符,并返回它的位置, 如果没有则返回 -1（需要区分大小写）.（从0开始计数）
 * 示例1
 * 输入
 * "google"
 * 返回值
 * 4
 */
public class JZ34 {
    public int FirstNotRepeatingChar(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return -1;
        }

        char[] cs = str.toCharArray();
        int[] hash = new int[256];
        for (int i = 0; i < size; i++) {
            ++hash[cs[i]];
        }

        for (int i = 0; i < size; i++) {
            if (hash[cs[i]] == 1) {
                return i;
            }
        }

        return -1;
    }

    public int FirstNotRepeatingChar2(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return -1;
        }

        HashMap<Character, Integer> m = new HashMap<>();
        for (int i = 0; i < size; i++) {
            if (m.containsKey(str.charAt(i))) {
                m.put(str.charAt(i), m.get(str.charAt(i)) + 1);
            } else {
                m.put(str.charAt(i), 1);
            }
        }

        for (int i = 0; i < size; i++) {
            if (m.get(str.charAt(i)) == 1) {
                return i;
            }
        }

        return -1;
    }
}
```
# 35.数组中的逆序对
```java
package sword_offer;

/**
 * 题目描述
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组,求出这个数组中的逆序对的总数P。
 * 并将P对1000000007取模的结果输出。 即输出P%1000000007
 * 对于50%的数据,size≤10
 * 对于75%的数据,size≤10
 * 对于100%的数据,size≤2∗10
 * 输入描述:
 * 题目保证输入的数组中没有的相同的数字
 * 示例1
 * 输入
 * [1,2,3,4,5,6,7,0]
 * 返回值
 * 7
 */
public class JZ35 {
    static int pairNum;

    public int InversePairs(int[] array) {
        pairNum = 0;
        if (array != null) {
            mergeSort(array, 0, array.length - 1);
        }
        return pairNum;
    }

    private void mergeSort(int[] array, int start, int end) {
        int mid = (start + end) >> 1;
        if (start < end) {
            mergeSort(array, start, mid);
            mergeSort(array, mid + 1, end);
            mergeHelper(array, start, mid, end);
        }
    }

    private void mergeHelper(int[] array, int left, int mid, int right) {
        int[] tmp = new int[right - left + 1];
        int i = left;
        int j = mid + 1;
        int k = 0;
        while (i <= mid && j <= right) {
            if (array[i] < array[j]) {
                tmp[k++] = array[i++];
            } else {
                tmp[k++] = array[j++];
                pairNum += mid - i + 1;
                if (pairNum > 1000000007) {
                    pairNum %= 1000000007;
                }
            }
        }

        while (i <= mid) {
            tmp[k++] = array[i++];
        }

        while (j <= right) {
            tmp[k++] = array[j++];
        }

        for (int m = 0; m < tmp.length; m++) {
            array[m + left] = tmp[m];
        }
    }
}
```
# 36.两个链表的第一个公共结点
```java
package sword_offer;

import java.util.HashMap;
import java.util.Stack;

/**
 * 题目描述
 * 输入两个链表，找出它们的第一个公共结点。（注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 */
public class JZ36 {
    public ListNode FindFirstCommonNode(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        Stack<ListNode> stk1 = new Stack<ListNode>();
        Stack<ListNode> stk2 = new Stack<ListNode>();
        while (head1 != null) {
            stk1.push(head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            stk2.push(head2);
            head2 = head2.next;
        }

        ListNode commonNode = null;
        while (!stk1.isEmpty() && !stk2.isEmpty() && stk1.peek() == stk2.peek()) {
            stk1.pop();
            commonNode = stk2.pop();
        }

        return commonNode;
    }

    public ListNode FindFirstCommonNode2(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        HashMap<ListNode, ListNode> m = new HashMap<>();
        while (head1 != null) {
            m.put(head1, head1);
            head1 = head1.next;
        }

        while (head2 != null) {
            if (m.containsKey(head2)) {
                return head2;
            }
            head2 = head2.next;
        }

        return null;
    }

    public ListNode FindFirstCommonNode3(ListNode head1, ListNode head2) {
        if (head1 == null || head2 == null) {
            return null;
        }

        ListNode cur = head1;
        int n = 0;
        while (cur != null) {
            ++n;
            cur = cur.next;
        }

        cur = head2;
        while (cur != null) {
            --n;
            cur = cur.next;
        }

        ListNode shortList = null;
        ListNode longList = null;
        if (n < 0) {
            shortList = head1;
            longList = head2;
        } else {
            shortList = head2;
            longList = head1;
        }
        n = n < 0 ? -n : n;
        for (int i = 0; i < n; i++) {
            longList = longList.next;
        }

        while (shortList != null && longList != null && shortList.val != longList.val) {
            shortList = shortList.next;
            longList = longList.next;
        }

        return longList;
    }
}
```
# 37.数字在排序数组中出现的次数
```java
package sword_offer;

/**
 * 题目描述
 * 统计一个数字在升序数组中出现的次数。
 * 示例1
 * 输入
 * [1,2,3,3,3,3,4,5],3
 * 返回值
 * 4
 */
public class JZ37 {
    public int GetNumberOfK(int[] array, int k) {
        int size = array.length;
        if (size == 0 || array == null) {
            return 0;
        }

        int index = 0, low = 0, high = size - 1, mid = 0;
        while (low < high) {
            mid = (low + high) >> 1;
            if (array[mid] == k) {
                index = mid;
                break;
            } else if (array[mid] > k) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        int cnt = 0;
        for (int i = index; i < size; i++) {
            if (array[i] == k) {
                cnt++;
            }
        }

        for (int i = index - 1; i >= 0; i--) {
            if (array[i] == k) {
                cnt++;
            }
        }

        return cnt;
    }
}
```
# 38.二叉树的深度
```java
package sword_offer;

import java.util.LinkedList;

/**
 * 题目描述
 * 输入一棵二叉树，求该树的深度。从根结点到叶结点依次经过的结点（含根、叶结点）形成树的一条路径，最长路径的长度为树的深度。
 * 示例1
 * 输入
 * {1,2,3,4,5,#,6,#,#,7}
 * 返回值
 * 4
 */
public class JZ38 {
    public int TreeDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = TreeDepth(root.left);
        int right = TreeDepth(root.right);

        return left > right ? left + 1 : right + 1;
    }

    public int TreeDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }

        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int curNode = 1;
        int depth = 0;
        while (!que.isEmpty()) {
            root = que.poll();
            --curNode;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }

            if (curNode == 0) {
                curNode = que.size();
                ++depth;
            }
        }

        return depth;
    }
}
```
# 39.平衡二叉树
```java
package sword_offer;

/**
 * 题目描述
 * 输入一棵二叉树，判断该二叉树是否是平衡二叉树。
 * 在这里，我们只需要考虑其平衡性，不需要考虑其是不是排序二叉树
 * 平衡二叉树（Balanced Binary Tree），具有以下性质：它是一棵空树或它的左右两个子树的高度差的绝对值不超过1，并且左右两个子树都是一棵平衡二叉树。
 * 示例1
 * 输入
 * {1,2,3,4,5,6,7}
 * 返回值
 * true
 */
public class JZ39 {
    private boolean isBalanced = true;

    public boolean IsBalanced_Solution(TreeNode root) {
        if (root == null) {
            return true;
        }

        getDepth(root);
        return isBalanced;
    }

    private int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);
        if (Math.abs(left - right) > 1) {
            isBalanced = false;
        }

        return left > right ? left + 1 : right + 1;
    }
}
```
# 40.数组中只出现一次的数字
```java
package sword_offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * 示例1
 * 输入
 * [1,4,1,6]
 * 返回值
 * [4,6]
 * 说明
 * 返回的结果中较小的数排在前面
 */
public class JZ40 {
    public int[] FindNumsAppearOnce(int[] array) {
        int size = array.length;
        int[] res = new int[2];
        if (array == null || size < 2) {
            return res;
        }

        int sum = 0;
        for (int i = 0; i < size; i++) {
            sum ^= array[i];
        }

        int n = 1;
        if ((sum & n) == 0) {
            n <<= 1;
        }

        for (int i = 0; i < size; i++) {
            if ((array[i] & n) != 0) {
                res[0] ^= array[i];
            } else {
                res[1] ^= array[i];
            }
        }

        Arrays.sort(res);
        return res;
    }

    public int[] FindNumsAppearOnce2(int[] array) {
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < array.length; i++) {
            //检索是否存在这一个数字
            int flag = list.indexOf(array[i]);
            if (flag == -1) {
                //不存在则添加
                list.add(array[i]);
            } else {
                //存在则删除
                list.remove(flag);
            }
        }

        //最后剩下两个即是只出现一次的
        return new int[]{list.get(0), list.get(1)};
    }

    public int[] FindNumsAppearOnce3(int[] array) {
        HashMap<Integer, Integer> m = new HashMap<>();
        for (int n : array) {
            int times = m.getOrDefault(n, 0);
            times++;
            m.put(n, times);
        }

        int[] res = new int[2];
        int index = 0;
        for (Map.Entry<Integer, Integer> entry : m.entrySet()) {
            if (entry.getValue() == 1) {
                res[index] = entry.getKey();
                index++;
            }
        }

        return res;
    }
}
```
# 41.和为S的连续正数序列
```java
package sword_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。
 * 但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。
 * 没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,
 * 你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 * 返回值描述:
 * 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * 示例1
 * 输入
 * 9
 * 返回值
 * [[2,3,4],[4,5]]
 */
public class JZ41 {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> lists = new ArrayList<ArrayList<Integer>>();

        if (sum <= 1) {
            return lists;
        }

        int start = 1;
        int end = 2;
        while (start != (1 + sum) / 2) {
            int curSum = (start + end) * (end - start + 1) / 2;
            if (curSum == sum) {
                ArrayList<Integer> res = new ArrayList<>();
                for (int i = start; i <= end; i++) {
                    res.add(i);
                }
                lists.add(res);
                ++start;
                ++end;
            } else if (curSum > sum) {
                ++start;
            } else {
                ++end;
            }
        }

        return lists;
    }
}
```
# 42.和为S的两个数字
```java
package sword_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 示例1
 * 输入
 * [1,2,4,7,11,15],15
 * 返回值
 * [4,11]
 */
public class JZ42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int size = array.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || size < 2) {
            return res;
        }

        int i = 0;
        int j = size - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            } else if (array[i] + array[j] > sum) {
                --j;
            } else {
                ++i;
            }
        }

        return res;
    }

    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        int size = array.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || size < 2) {
            return res;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (array[i] + array[j] == sum) {
                    res.add(array[i]);
                    res.add(array[j]);
                    return res;
                }
            }
        }

        return res;
    }
}
```
# 43.左旋转字符串
```java
package sword_offer;

/**
 * 题目描述
 * 汇编语言中有一种移位指令叫做循环左移（ROL），现在有个简单的任务，就是用字符串模拟这个指令的运算结果。对于一个给定的字符序列S，请你把其循环左移K位后的序列输出。例如，字符序列S=”abcXYZdef”,要求输出循环左移3位后的结果，即“XYZdefabc”。是不是很简单？OK，搞定它！
 * 示例1
 * 输入
 * "abcXYZdef",3
 * 返回值
 * "XYZdefabc"
 */
public class JZ43 {
    public String LeftRotateString(String str, int n) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return "";
        }

        n %= size;
        str = str + str;
        return str.substring(n, n + size);
    }

    public String LeftRotateString2(String str, int n) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return "";
        }

        n %= size;
        String s = str.substring(0, n);
        String p = str.substring(n);

        return p + s;
    }

    public String LeftRotateString3(String str, int n) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return "";
        }

        char[] ch = str.toCharArray();
        reverse(ch, 0, n - 1);
        reverse(ch, n, size - 1);
        reverse(ch, 0, size - 1);

        return new String(ch);
    }

    private void reverse(char[] ch, int low, int high) {
        char tmp;
        while (low < high) {
            tmp = ch[low];
            ch[low] = ch[high];
            ch[high] = tmp;
            ++low;
            --high;
        }
    }
}
```
# 44.翻转单词序列
```java
package sword_offer;

/**
 * 题目描述
 * 牛客最近来了一个新员工Fish，每天早晨总是会拿着一本英文杂志，写些句子在本子上。同事Cat对Fish写的内容颇感兴趣，
 * 有一天他向Fish借来翻看，但却读不懂它的意思。例如，“student. a am I”。后来才意识到，这家伙原来把句子单词的顺序翻转了，
 * 正确的句子应该是“I am a student.”。Cat对一一的翻转这些单词顺序可不在行，你能帮助他么？
 * 示例1
 * 输入
 * "nowcoder. a am I"
 * 返回值
 * "I am a nowcoder."
 */
public class JZ44 {
    public String ReverseSentence(String str) {
        if (str.trim().equals("")) {
            return str;
        }

        String[] s = str.split(" ");
        StringBuffer sb = new StringBuffer();
        for (int i = s.length - 1; i >= 0; --i) {
            sb.append(s[i] + " ");
        }

        return sb.toString().trim();
    }

    public String ReverseSentence2(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return str;
        }

        String tmp = "", res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                res = " " + tmp + res;
                tmp = "";
            } else {
                tmp += str.charAt(i);
            }
        }

        if (tmp.length() > 1) {
            res = tmp + res;
        }

        return res;
    }
}
```
# 45.扑克牌顺子
```java
package sword_offer;

/**
 * 题目描述
 * LL今天心情特别好,因为他去买了一副扑克牌,发现里面居然有2个大王,2个小王(一副牌原本是54张^_^)...他随机从中抽出了5张牌,
 * 想测测自己的手气,看看能不能抽到顺子,如果抽到的话,他决定去买体育彩票,嘿嘿！！“红心A,黑桃3,小王,大王,方片5”,“Oh My God!”
 * 不是顺子.....LL不高兴了,他想了想,决定大\小 王可以看成任何数字,并且A看作1,J为11,Q为12,K为13。
 * 上面的5张牌就可以变成“1,2,3,4,5”(大小王分别看作2和4),“So Lucky!”。LL决定去买体育彩票啦。现在,要求你使用这幅牌模拟上面
 * 的过程,然后告诉我们LL的运气如何， 如果牌能组成顺子就输出true，否则就输出false。为了方便起见,你可以认为大小王是0。
 * 示例1
 * 输入
 * [0,3,2,6,4]
 * 返回值
 * true
 */
public class JZ45 {
    public boolean IsContinuous(int[] array) {
        int size = array.length;
        if (array == null || size != 5) {
            return false;
        }

        quickSort(array, 0, size - 1);

        int sub = 0;
        for (int i = 0; i < 4; ++i) {
            if (array[i] == 0) {
                continue;
            }
            if (array[i] == array[i + 1]) {
                return false;
            }

            sub += array[i + 1] - array[i];
        }

        return sub < 5;
    }

    private void quickSort(int[] array, int low, int high) {
        int pivot = 0;
        if (low < high) {
            pivot = quickPartition(array, low, high);
            quickSort(array, low, pivot - 1);
            quickSort(array, pivot + 1, high);
        }
    }

    private int quickPartition(int[] array, int low, int high) {
        int pivot = array[low];
        while (low < high) {
            while (low < high && array[high] >= pivot) {
                --high;
            }
            array[low] = array[high];
            while (low < high && array[low] <= pivot) {
                ++low;
            }
            array[high] = array[low];
        }
        array[low] = pivot;
        return low;
    }
}
```
# 46.孩子们的游戏(圆圈中最后剩下的数)	
```java
package sword_offer;

import java.util.LinkedList;

/**
 * 题目描述  孩子们的游戏(圆圈中最后剩下的数) 约瑟夫环
 * 每年六一儿童节,牛客都会准备一些小礼物去看望孤儿院的小朋友,今年亦是如此。
 * HF作为牛客的资深元老,自然也准备了一些小游戏。其中,有个游戏是这样的:
 * 首先,让小朋友们围成一个大圈。然后,他随机指定一个数m,让编号为0的小朋友开始报数。
 * 每次喊到m-1的那个小朋友要出列唱首歌,然后可以在礼品箱中任意的挑选礼物,并且不再回到圈中,
 * 从他的下一个小朋友开始,继续0...m-1报数....这样下去....直到剩下最后一个小朋友,可以不用表演,
 * 并且拿到牛客名贵的“名侦探柯南”典藏版(名额有限哦!!^_^)。请你试着想下,哪个小朋友会得到这份礼品呢？(注：小朋友的编号是从0到n-1)
 * 如果没有小朋友，请返回-1
 * 示例
 * 输入
 * 5,3
 * 返回值
 * 3
 */
public class JZ46 {
    /*
    f(n,m) 表示序号为 0,1,...,n-1 的圈要一直淘汰第 m 个人最终剩下来的序号，这里序号和对应的值是一致的。
    f(n-1,m) 表示序号为 0,1,...,n-2 的圈要一直淘汰第 m 个人最终剩下来的序号，这里序号和对应的值是一致的。
    当从 f(n,m) 中第一次淘汰第 m 个人（序号为 (m-1)%n ）时，该序列的长度就变成了 n-1，再淘汰一个第 m 个人时，
    情况就变成了 f'(n-1,m), 但是此时 f'(n-1,m) 是以 m%n 为序号开始的，而 f(n-1,m) 是以 0 为序号开始的。
    要想将 f(n-1,m) 对应的索引转换成 f(n,m) 对应的索引值，则 f(n,m) = (m%n +f(n-1,m) ) % n = (m+f(n-1,m)) % n
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n == 0) {
            return -1;
        }

        if (n == 1) {
            return 0;
        }

        return (m % n + LastRemaining_Solution(n - 1, m)) % n;
    }

    public int LastRemaining_Solution2(int n, int m) {
        LinkedList<Integer> list = new LinkedList<Integer>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.size() == 1 ? list.get(0) : -1;
    }
}
```
# 47.求1+2+3+...+n
```java
package sword_offer;

/**
 * 题目描述
 * 求1+2+3+...+n，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * 示例1
 * 输入
 * 5
 * 返回值
 * 15
 */
public class JZ47 {
    public int Sum_Solution(int n) {
        if (n == 0) {
            return 0;
        }

        return n + Sum_Solution(n - 1);
    }

    public int Sum_Solution2(int n) {
        int sum = n;
        boolean ans = (n > 0) && ((sum += Sum_Solution2(n - 1)) > 0);
        return sum;
    }
}
```
# 48.不用加减乘除做加法
```java
package sword_offer;

/**
 * 题目描述
 * 写一个函数，求两个整数之和，要求在函数体内不得使用+、-、*、/四则运算符号。
 * 示例1
 * 输入
 * 1,2
 * 返回值
 * 3
 */
public class JZ48 {
    /*
    用异或可以模拟不带进位的加法运算, 因为异或相同则0, 不同则1, 正好与不带进位的加法结果相同
    用与运算可以模拟出每一位的是否有进位
    用位运算来实现:
    1.进行异或运算，计算两个数各个位置上的相加，不考虑进位；
    2.进行位与运算，然后左移一位，计算进位值；
    3.把异或运算的结果赋给num1，把进位值赋给num2，依此循环，进位值为空的时候结束循环，num1就是两数之和。
     */
    public int Add(int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }

        return num1;
    }
}
```
# 49.把字符串转换成整数
```java
package sword_offer;

/**
 * 题目描述
 * 将一个字符串转换成一个整数，要求不能使用字符串转换整数的库函数。 数值为0或者字符串不是一个合法的数值则返回0
 * 输入描述:
 * 输入一个字符串,包括数字字母符号,可以为空
 * 返回值描述:
 * 如果是合法的数值表达则返回该数字，否则返回0
 * 示例1
 * 输入
 * "+2147483647"
 * 返回值
 * 2147483647
 * 示例2
 * 输入
 * "1a33"
 * 返回值
 * 0
 */
public class JZ49 {
    public int StrToInt(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return 0;
        }

        int sum = 0;
        int sign = 1;
        if (str.charAt(0) == '-') {
            sign = -1;
        } else if (str.charAt(0) == '+') {
            sign = 1;
        } else if (str.charAt(0) >= '1' && str.charAt(0) <= '9') {
            sum = str.charAt(0) - '0';
        } else {
            return 0;
        }

        for (int i = 1; i < size; i++) {
            if (str.charAt(i) < '1' || str.charAt(i) > '9') {
                return 0;
            }
            sum = sum * 10 + str.charAt(i) - '0';
        }

        return sum * sign;
    }
}
```
# 50.数组中重复的数字
```java
package sword_offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 题目描述
 * 在一个长度为n的数组里的所有数字都在0到n-1的范围内。 数组中某些数字是重复的，但不知道有几个数字是重复的。
 * 也不知道每个数字重复几次。请找出数组中第一个重复的数字。 例如，如果输入长度为7的数组[2,3,1,0,2,5,3]，
 * 那么对应的输出是第一个重复的数字2。没有重复的数字返回-1。
 * 示例1
 * 输入
 * [2,3,1,0,2,5,3]
 * 返回值
 * 2
 */
public class JZ50 {
    public int duplicate(int[] array) {
        int size = array.length;
        if (size < 1 || array == null) {
            return -1;
        }

        int[] hash = new int[size];
        for (int num : array) {
            ++hash[num];
            if (hash[num] > 1) {
                return num;
            }
        }

        return -1;
    }

    public int duplicate2(int[] array) {
        int size = array.length;
        if (size < 1 || array == null) {
            return -1;
        }

        Map<Integer, Integer> m = new HashMap<>();
        for (int num : array) {
            if (m.containsKey(num)) {
                return num;
            }
            m.put(num, 1);
        }

        return -1;
    }
}
```
# 51.构建乘积数组
```java
package sword_offer;

/**
 * 题目描述
 * 给定一个数组A[0,1,...,n-1],请构建一个数组B[0,1,...,n-1],其中B中的元素B[i]=A[0]*A[1]*...*A[i-1]*A[i+1]*...*A[n-1]。
 * 不能使用除法。（注意：规定B[0] = A[1] * A[2] * ... * A[n-1]，B[n-1] = A[0] * A[1] * ... * A[n-2];）
 * 对于A长度为1的情况，B无意义，故而无法构建，因此该情况不会存在。
 * 示例1
 * 输入
 * [1,2,3,4,5]
 * 返回值
 * [120,60,40,30,24]
 */
public class JZ51 {
    public int[] multiply(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return null;
        }

        int[] res = new int[size];
        res[0] = 1;
        for (int i = 1; i < size; i++) {
            res[i] = res[i - 1] * array[i - 1];
        }

        int tmp = 1;
        for (int i = size - 2; i >= 0; i--) {
            tmp *= array[i + 1];
            res[i] *= tmp;
        }

        return res;
    }
}
```
# 52.正则表达式匹配
> ![jz52](http://github.com/xidianlina/off_inter/raw/master//program_topic_java/src/sword_offer/picture/jz52.png)                           
```java
package sword_offer;

/*
题目描述
请实现一个函数用来匹配包括'.'和'*'的正则表达式。模式中的字符'.'表示任意一个字符，而'*'表示它前面的字符可以出现任意次（包含0次）。
在本题中，匹配是指字符串的所有字符匹配整个模式。例如，字符串"aaa"与模式"a.a"和"ab*ac*a"匹配，但是与"aa.a"和"ab*a"均不匹配

示例
输入
"aaa","a*a"
返回值
true
 */
public class JZ52 {
    public boolean match(String str, String pattern) {
        int m = str.length();
        int n = pattern.length();

        boolean[][] f = new boolean[m + 1][n + 1];
        f[0][0] = true;
        for (int i = 0; i <= m; ++i) {
            for (int j = 1; j <= n; ++j) {
                if (pattern.charAt(j - 1) == '*') {
                    f[i][j] = f[i][j - 2];
                    if (match(str, pattern, i, j - 1)) {
                        f[i][j] = f[i][j] || f[i - 1][j];
                    }
                } else {
                    if (match(str, pattern, i, j)) {
                        f[i][j] = f[i - 1][j - 1];
                    }
                }
            }
        }

        return f[m][n];
    }

    private boolean match(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
```
# 53.表示数值的字符串
```java
package sword_offer;

/**
 * 题目描述
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。例如，字符串"+100","5e2","-123","3.1416"和"-1E-16"都表示数值。
 * 但是"12e","1a3.14","1.2.3","+-5"和"12e+4.3"都不是。
 * 示例1
 * 输入
 * "123.45e+6"
 * 返回值
 * true
 * 示例2
 * 输入
 * "1.2.3"
 * 返回值
 * false
 */
public class JZ53 {
    public boolean isNumeric(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return true;
        }

        boolean hasE = false, sign = false, decimal = false;
        for (int i = 0; i < size; i++) {
            if (str.charAt(i) == 'e' || str.charAt(i) == 'E') {
                if (i == size - 1 || hasE) {
                    return false;
                }
                hasE = true;
            } else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (sign && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'E') {
                    return false;
                }
                if (!sign && i > 0 && str.charAt(i - 1) != 'e' && str.charAt(i - 1) != 'E') {
                    return false;
                }
                sign = true;
            } else if (str.charAt(i) == '.') {
                if (hasE) {
                    return false;
                }
                if (decimal) {
                    return false;
                }
                decimal = true;
            } else if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return false;
            }
        }

        return true;
    }
}
```
# 54.字符流中第一个不重复的字符
```java
package sword_offer;

import java.util.HashMap;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 返回值描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class JZ54 {
    HashMap<Character, Integer> map = new HashMap<Character, Integer>();
    StringBuffer s = new StringBuffer();

    public void Insert(char ch) {
        s.append(ch);
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    public char FirstAppearingOnce() {
        for (int i = 0; i < s.length(); i++) {
            if (map.get(s.charAt(i)) == 1) {
                return s.charAt(i);
            }
        }
        return '#';
    }
}
```

```java
package sword_offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 返回值描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class JZ54_2 {
    HashMap<Character, Integer> map = new LinkedHashMap<>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    public char FirstAppearingOnce() {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }
        return '#';
    }
}
```
```java
package sword_offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 题目描述
 * 请实现一个函数用来找出字符流中第一个只出现一次的字符。例如，当从字符流中只读出前两个字符"go"时，
 * 第一个只出现一次的字符是"g"。当从该字符流中读出前六个字符“google"时，第一个只出现一次的字符是"l"。
 * 返回值描述:
 * 如果当前字符流没有存在出现一次的字符，返回#字符。
 */
public class JZ54_3 {
    HashMap<Character, Integer> map = new LinkedHashMap<>();

    public void Insert(char ch) {
        if (map.containsKey(ch)) {
            map.put(ch, map.get(ch) + 1);
        } else {
            map.put(ch, 1);
        }
    }

    public char FirstAppearingOnce() {
        for (Character c : map.keySet()) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return '#';
    }
}
```
# 55.链表中环的入口结点	
```java
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
```
# 56.删除链表中重复的结点
```java
package sword_offer;

/**
 * 题目描述
 * 在一个排序的链表中，存在重复的结点，请删除该链表中重复的结点，重复的结点不保留，返回链表头指针。 例如，链表1->2->3->3->4->4->5 处理后为 1->2->5
 * 示例1
 * 输入
 * {1,2,3,3,4,4,5}
 * 返回值
 * {1,2,5}
 */
public class JZ56 {
    public ListNode deleteDuplication(ListNode head) {
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
            return deleteDuplication(cur);
        } else {
            cur = head.next;
            head.next = deleteDuplication(cur);
            return head;
        }
    }

    public ListNode deleteDuplication2(ListNode head) {
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
}
```
# 57.二叉树的下一个结点(后继结点)
```java
package sword_offer;

/**
 * 题目描述
 * 给定一个二叉树和其中的一个结点，请找出中序遍历顺序的下一个结点并且返回。
 * 注意，树中的结点不仅包含左右子结点，同时包含指向父结点的指针。
 */

class TreeLinkNode {
    int val;
    TreeLinkNode left = null;
    TreeLinkNode right = null;
    TreeLinkNode next = null;

    TreeLinkNode(int val) {
        this.val = val;
    }
}

public class JZ57 {
    /*
        如果结点中有指向父亲结点的指针（假如根结点的父结点为null），则：
        (1).如果当前结点有右孩子，则后继结点为这个右孩子的最左孩子；
        (2).如果当前结点没有右孩子；
        (2.1).当前结点为根结点，返回null；
        (2.2).当前结点只是个普通结点，也就是存在父结点；
        (2.2.1).当前结点是父亲结点的左孩子，则父亲结点就是后继结点；
        (2.2.2).当前结点是父亲结点的右孩子，沿着父亲结点往上走，直到n-1代祖先是n代祖先的左孩子，
                则后继为n代祖先或遍历到根结点也没找到符合的，则当前结点就是中序遍历的最后一个结点，返回null。
    */
    public TreeLinkNode GetNext(TreeLinkNode node) {
        if (node == null) {
            return null;
        }

        if (node.right != null) {
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }

            return node;
        }

        while (node.next != null) {
            TreeLinkNode root = node.next;
            if (root.left == node) {
                return root;
            }
            node = node.next;
        }

        return null;
    }
}
```
# 58.对称的二叉树
```java
package sword_offer;

/**
 * 题目描述
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。注意，如果一个二叉树同此二叉树的镜像是同样的，定义其为对称的。
 * 示例1
 * 输入
 * {8,6,6,5,7,7,5}
 * 返回值
 * true
 * 示例2
 * 输入
 * {8,6,9,5,7,7,5}
 * 返回值
 * false
 */
public class JZ58 {
    boolean isSymmetrical(TreeNode root) {
        if (root == null) {
            return true;
        }

        return helper(root.left, root.right);
    }

    boolean helper(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }

        if (left == null || right == null) {
            return false;
        }

        if (left.val != right.val) {
            return false;
        }

        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
```
# 59.按之字形顺序打印二叉树
```java
package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，
 * 第三行按照从左到右的顺序打印，其他行以此类推。
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 */
public class JZ59 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int curNode = 1;
        boolean leftToRight = true;
        while (!que.isEmpty()) {
            root = que.poll();
            --curNode;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
            list.add(root.val);

            if (curNode == 0) {
                curNode = que.size();
                if (leftToRight) {
                    res.add(list);
                } else {
                    res.add(reverseList(list));
                }
                leftToRight = !leftToRight;
                list = new ArrayList<>();
            }
        }

        return res;
    }

    private ArrayList<Integer> reverseList(ArrayList<Integer> list) {
        int size = list.size();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
```

```java
package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 请实现一个函数按照之字形打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右至左的顺序打印，第三行按照从左到右的顺序打印，其他行以此类推。
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[10,6],[5,7,9,11]]
 */
public class JZ59_2 {
    public ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.add(root);
        int curNode = 1;
        boolean leftToRight = true;
        while (!arr.isEmpty()) {
            root = arr.get(0);
            arr.remove(0);
            --curNode;
            if (root.left != null) {
                arr.add(root.left);
            }
            if (root.right != null) {
                arr.add(root.right);
            }
            list.add(root.val);

            if (curNode == 0) {
                curNode = arr.size();
                if (leftToRight) {
                    res.add(list);
                } else {
                    res.add(reverseList(list));
                }
                leftToRight = !leftToRight;
                list = new ArrayList<>();
            }
        }

        return res;
    }

    private ArrayList<Integer> reverseList(ArrayList<Integer> list) {
        int size = list.size();
        ArrayList<Integer> res = new ArrayList<>();
        for (int i = size - 1; i >= 0; i--) {
            res.add(list.get(i));
        }
        return res;
    }
}
```
# 60.把二叉树打印成多行
```java
package sword_offer;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * 题目描述
 * 从上到下按层打印二叉树，同一层结点从左至右输出。每一层输出一行。
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * [[8],[6,10],[5,7,9,11]]
 */
public class JZ60 {
    ArrayList<ArrayList<Integer>> Print(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        LinkedList<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int curNode = 1;
        while (!que.isEmpty()) {
            root = que.poll();
            --curNode;
            if (root.left != null) {
                que.offer(root.left);
            }
            if (root.right != null) {
                que.offer(root.right);
            }
            list.add(root.val);
            if (curNode == 0) {
                curNode = que.size();
                res.add(list);
                list = new ArrayList<>();
            }
        }

        return res;
    }

    ArrayList<ArrayList<Integer>> Print2(TreeNode root) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }

        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<TreeNode> arr = new ArrayList<>();
        arr.add(root);
        int curNode = 1;
        while (!arr.isEmpty()) {
            root = arr.get(0);
            arr.remove(0);
            --curNode;
            if (root.left != null) {
                arr.add(root.left);
            }
            if (root.right != null) {
                arr.add(root.right);
            }
            list.add(root.val);
            if (curNode == 0) {
                curNode = arr.size();
                res.add(list);
                list = new ArrayList<>();
            }
        }

        return res;
    }
}
```
# 61.序列化二叉树
```java
package sword_offer;

/**
 * 题目描述
 * 请实现两个函数，分别用来序列化和反序列化二叉树
 * 二叉树的序列化是指：把一棵二叉树按照某种遍历方式的结果以某种格式保存为字符串，从而使得内存中建立起来的二叉树可以持久保存。序列化可以基于先序、中序、后序、层序的二叉树遍历方式来进行修改，序列化的结果是一个字符串，序列化时通过 某种符号表示空节点（#），以 ！ 表示一个结点值的结束（value!）。
 * 二叉树的反序列化是指：根据某种遍历顺序得到的序列化字符串结果str，重构二叉树。
 * 例如，我们可以把一个只有根节点为1的二叉树序列化为"1,"，然后通过自己的函数来解析回这个二叉树
 * 示例1
 * 输入
 * {8,6,10,5,7,9,11}
 * 返回值
 * {8,6,10,5,7,9,11}
 */
public class JZ61 {
    String Serialize(TreeNode root) {
        StringBuffer sb = new StringBuffer();
        if (root == null) {
            sb.append("#,");
            return sb.toString();
        }

        sb.append(root.val + ",");
        sb.append(Serialize(root.left));
        sb.append(Serialize(root.right));

        return sb.toString();
    }

    public Integer index = -1;

    TreeNode Deserialize(String str) {
        ++index;
        if (str.length() <= 0) {
            return null;
        }

        String[] s = str.split(",");
        TreeNode node = null;
        if (!s[index].equals("#")) {
            node = new TreeNode(Integer.valueOf(s[index]));
            node.left = Deserialize(str);
            node.right = Deserialize(str);
        }

        return node;
    }
}
```
# 62.二叉搜索树的第k个结点
```java
package sword_offer;

import java.util.Stack;
import java.util.ArrayList;

/**
 * 题目描述
 * 给定一棵二叉搜索树，请找出其中的第k小的TreeNode结点。
 * 示例1
 * 输入
 * {5,3,7,2,4,6,8},3
 * 返回值
 * {4}
 * 说明
 * 按结点数值大小顺序第三小结点的值为4
 */
public class JZ62 {
    TreeNode KthNode(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        Stack<TreeNode> stk = new Stack<>();
        while (!stk.isEmpty() || root != null) {
            if (root != null) {
                stk.push(root);
                root = root.left;
            } else {
                root = stk.pop();
                if (k == 1) {
                    return root;
                }
                --k;
                root = root.right;
            }
        }

        return null;
    }

    TreeNode KthNode2(TreeNode root, int k) {
        if (root == null || k <= 0) {
            return null;
        }

        ArrayList<TreeNode> arr = new ArrayList<>();
        while (!arr.isEmpty() || root != null) {
            if (root != null) {
                arr.add(root);
                root = root.left;
            } else {
                root = arr.get(arr.size() - 1);
                arr.remove(arr.size() - 1);
                if (k == 1) {
                    return root;
                }
                --k;
                root = root.right;
            }
        }

        return null;
    }
}
```
# 63.数据流中的中位数
```java
package sword_offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 题目描述
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * 使用Insert()方法读取数据流，使用GetMedian()方法获取当前读取数据的中位数。
 */
public class JZ63 {
    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>(11, new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            //PriorityQueue默认是小顶堆，实现大顶堆，需要反转默认排序器
            return o2.compareTo(o1);
        }
    });

    public void Insert(Integer num) {
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(num);
            minHeap.add(maxHeap.poll());
            maxHeap.add(minHeap.poll());
        } else {
            minHeap.add(num);
            maxHeap.add(minHeap.poll());
            minHeap.add(maxHeap.poll());
        }
    }

    public Double GetMedian() {
        if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek() * 1.0;
        } else if (minHeap.size() < maxHeap.size()) {
            return maxHeap.peek() * 1.0;
        } else {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        }
    }
}
```
# 64.滑动窗口的最大值
```java
package sword_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 给定一个数组和滑动窗口的大小，找出所有滑动窗口里数值的最大值。例如，如果输入数组{2,3,4,2,6,2,5,1}及滑动窗口的大小3，
 * 那么一共存在6个滑动窗口，他们的最大值分别为{4,4,6,6,6,5}； 针对数组{2,3,4,2,6,2,5,1}的滑动窗口有以下6个：
 * {[2,3,4],2,6,2,5,1}， {2,[3,4,2],6,2,5,1}， {2,3,[4,2,6],2,5,1}， {2,3,4,[2,6,2],5,1}， {2,3,4,2,[6,2,5],1}， {2,3,4,2,6,[2,5,1]}。
 * 窗口大于数组长度的时候，返回空
 * 示例1
 * 输入
 * [2,3,4,2,6,2,5,1],3
 * 返回值
 * [4,4,6,6,6,5]
 */
public class JZ64 {
    public ArrayList<Integer> maxInWindows(int[] num, int size) {
        int len = num.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (len < size || size == 0 || num == null) {
            return res;
        }

        int m = 0;
        for (int i = 0; i < len - size + 1; i++) {
            m = num[i];
            for (int j = i; j < i + size; j++) {
                if (m < num[j]) {
                    m = num[j];
                }
            }
            res.add(m);
        }

        return res;
    }
}
```
# 67.剪绳子
```java
package sword_offer;

/**
 * 题目描述
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1，m<=n），每段绳子的长度记为k[1],...,k[m]。
 * 请问k[1]x...xk[m]可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * 输入描述:
 * 输入一个数n，意义见题面。（2 <= n <= 60）
 * 返回值描述:
 * 输出答案。
 * 示例1
 * 输入
 * 8
 * 返回值
 * 18
 */
public class JZ67 {
    /*
    解题思路
    首先判断k[0]到k[m]可能有哪些数字，实际上只可能是2或者3。
    当然也可能有4，但是4=2*2，所以简单些不考虑了。
    5<2*3,6<3*3,比6更大的数字就更不用考虑了，肯定要继续分。
    其次看2和3的数量，2的数量肯定小于3个，为什么呢？
    因为2*2*2<3*3，那么题目就简单了。
    直接用n除以3，根据得到的余数判断是一个2还是两个2还是没有2就行了。
    由于题目规定m>1，所以2只能是1*1，3只能是2*1，这两个特殊情况直接返回就行了。
     */
    public int cutRope(int target) {
        if (target < 3) {
            return target - 1;
        }

        int x = target % 3, y = target / 3;
        if (x == 0) {
            return pow_helper(3, y);
        } else if (x == 1) {
            return 2 * 2 * pow_helper(3, y - 1);
        } else {
            return 2 * pow_helper(3, y);
        }
    }

    private int pow_helper(int n, int m) {
        if (m == 0) {
            return 1;
        }
        int res = n;
        for (int i = 1; i < m; i++) {
            res *= n;
        }

        return res;
    }
}
```