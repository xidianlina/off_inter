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





