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
