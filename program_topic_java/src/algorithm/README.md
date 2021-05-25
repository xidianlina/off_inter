算法题目整理
======
# 算法题目
### 1.洗牌算法
### 2.完美洗牌算法                   
### 3.两个线程分别打印1-100，a线程打印偶数，b线程打印奇数
### 4.一个链表，奇数位升序偶数位降序，让链表变成升序的
### 5.IP转换成整数及整数转换成IP
### 6.IP转换成长整数及长整数转换成IP
### 7.给一个字符串表示IP地址，检测是否合法
### 8.杨辉三角
### 9.字符串翻转
### 10.判断两个日期之间相隔的天数
### 11.给定A, B两个整数，不使用除法和取模运算，求A/B的商和余数
### 12.压缩驼峰字符串
### 13,除去s1中与s2中相同的字符
### 14.给定n个数，要求比较1.5n次同时找出最大值和最小值
### 15.按照map的value进行排序，并按value有序输出
### 16.找出数组里出现次数超过总数1/3的数(可能存在一个也可能存在两个)
### 17.判断一个字符串是否是回文字符串
### 18.不使用循环，判断一个数是否是2的N次方
### 19.求1!+2!+3!+4!+...+n!的结果
### 20.在字符串中求最长数字子序列的长度
### 21.打印最长递增子序列
### 22.打印最长连续递增子序列
### 22.没有优先级的"+","-","x"
### 23.在不使用循环的条件下，如何计算出一个数其2的n次方的最大数字（这个比较绕，例如17-->16，31-- >16）
### 24.未排序数组中累加和为给定值的最长子数组的长度
### 25.N的阶乘二进制表示的最低位1的位置
### 26.输入一个正整数N，输出大于N且最接近这个数的素数
### 27.字符串转换float
### 28.字符串数组的字符串是否都能首尾相接
### 29.递归求和
### 30.递归算法判断一个数组是否是递增数组
### 31.二分查找的递归与非递归实现
### 32.正整数序列Q中的每个元素都至少能被正整数a和b中的一个整除，现给定a和b，如何计算出Q中的前N项？
### 33.如何判断一个整数 x 是否可以表示成 n（n >= 2）个连续正整数的和?
### 34.给一个由n-1个数组成的未经排序的数列，其元素都是1—n中的不同的整数。找出缺失的整数？
### 35.求两个数组的交集
### 36.如何判断一个数组中的数值是否连续相邻
### 37.找出数组中重复数字最多的数
### 38.将数组的后m个数移动为前m个数
### 39.找出数组中出现奇数次的元素：有一个整数数组arr，其中的元素只有一个元素出现奇数次，请找出这个元素。
### 40.数组a[N]，1-N-1这（N-1）个数存放在a[N]中，其中某个数重复一次，找出这个数。时间复杂度不超过
### 41.一个序列先增后减，求峰值
### 42.递归求数组的和
### 43.输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc
### 44.在两个数组中寻找两个数的和等于指定的数值
### 45.计算给定的日期是一年中的第多少天
### 46.求A的B次的后三位
### 47.最长公共子序列（不连续）时间复杂度O(m*n)
### 48.最长公共子字符串：类似最长子序列，只是公共子字符串要求必须是连续的
### 49.M进制与N进制的转换
### 50.等概率产生0和1
### 51.求一个序列的平衡点
# 算法解答
### 1.洗牌算法
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
### 2.完美洗牌算法
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
### 3.两个线程分别打印1-100，a线程打印偶数，b线程打印奇数
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
### 4.一个链表，奇数位升序偶数位降序，让链表变成升序的
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
### 5.IP转换成整数及整数转换成IP
```java
package algorithm;

import java.util.Scanner;

public class IpToInt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strIP = sc.nextLine();
            int intIP = ipToInt(strIP);
            System.out.println(intIP);
            System.out.println(intToIp(intIP));
        }
    }

    /*
        ip地址分为四段，每段都是0~255之间的数，每段可以用8位来装下它，4x8=32位，也就是可以将ip地址转为32位的整数
        将ip转为数字其实就是时间换空间的一种方式。String类型的ip占用7(如0.0.0.0)到15(如 255.255.255.255)个字节，而int只需要4个字节
        思路就是将ip的每一段数字转为8位二进制数，并将它们放在结果的适当位置上
     */
    public static int ipToInt(String ip) {
        //取IP的各段
        String[] ipSlices = ip.split("\\.");

        int res = 0;
        for (int i = 0; i < ipSlices.length; ++i) {
            // 将ip的每一段解析为int，并根据位置左移8位
            int intSlice = Integer.parseInt(ipSlices[i]) << 8 * i;
            // 或运算
            res = res | intSlice;
        }

        return res;
    }

    public static String intToIp(int ip) {
        String[] res = new String[4];
        for (int i = 3; i >= 0; --i) {
            int ipInt = (ip >> (8 * i)) & (0xff);
            res[i] = String.valueOf(ipInt);
        }

        return String.join(".", res);
    }
}
```
### 6.IP转换成长整数及长整数转换成IP
```java
package algorithm;

import java.util.Scanner;

public class IpToLong {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String strIp = sc.nextLine();
            long numIp = Long.valueOf(sc.nextLine());
            System.out.println(ipToNum(strIp));
            System.out.println(numToIp(numIp));
        }
    }

    public static long ipToNum(String ip) {
        String[] arr = ip.split("\\.");
        long n = Long.parseLong(arr[0]);

        for (int i = 1; i < arr.length; i++) {
            n = n << 8;
            n = n + Long.parseLong(arr[i]);
        }

        return n;
    }

    public static String numToIp(long num) {
        // 先把数字转化为32位的二进制串
        String binaryStr = num2binary(num, 32);    
        StringBuilder sb = new StringBuilder();
        // 每8个字符将二进制串转化为十进制数
        for (int i = 0; i < 32; i += 8) {
            String tempStr = binaryStr.substring(i, i + 8);
            int tempInt = 0;
            for (int j = tempStr.length() - 1; j >= 0; j--)
                tempInt += Math.pow(2, tempStr.length() - 1 - j) * (tempStr.charAt(j) - '0');
            sb.append(tempInt + ".");
        }
        return sb.deleteCharAt(sb.length() - 1).toString();
    }


    private static long ip2num(String[] ip) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ip.length; i++)
            sb.append(num2binary(Long.parseLong(ip[i]), 8));      // 将数字转化为8位二进制串
        long res = 0;
        String str = sb.toString();
        for (int i = str.length() - 1; i >= 0; i--)
            res += Math.pow(2, str.length() - 1 - i) * (str.charAt(i) - '0');
        return res;
    }

    // 除二取余法
    private static String num2binary(long num, int bit) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while (num > 0) {
            sb.append(num % 2);
            num /= 2;
            count++;
        }
        // 高位补0
        while (count < bit) {
            sb.append(0);
            count++;
        }
        return sb.reverse().toString();
    }
}
```
### 7.给一个字符串表示IP地址，检测是否合法
```java
package algorithm;

import java.util.Scanner;

public class IsValidIp {
    public static void main(String[] args) {
        IsValidIp isValidIp = new IsValidIp();
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String ip = sc.nextLine();
            System.out.println(isValidIp.isValidIp(ip));
        }
    }

    public boolean isValidIp(String ip) {
        int size = ip.length();
        if (ip.isEmpty() || size < 7 || size > 15) {
            return false;
        }

        String[] arr = ip.split("\\.");
        if (arr.length != 4) {
            return false;
        }

        for (int i = 0; i < arr.length; ++i) {
            if (arr[i].length() > 1 && arr[i].charAt(0) == '0') {
                return false;
            }

            for (int j = 0; j < arr[i].length(); ++j) {
                if (arr[i].charAt(j) < '0' || arr[j].charAt(j) > '9') {
                    return false;
                }
            }
        }

        for (int i = 0; i < arr.length; ++i) {
            int tmp = Integer.parseInt(arr[i]);
            if (i == 0) {
                if (tmp < 1 || tmp > 255) {
                    return false;
                }
            } else {
                if (tmp < 0 || tmp > 255) {
                    return false;
                }
            }
        }

        return true;
    }
}
```
### 8.杨辉三角
```java
package algorithm;

import java.util.Scanner;

public class YangHuiSanJiao {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] res = yangHuiSanJiao(sc.nextInt());
        printYangHuiSanJiao(res);
    }

    public static int[][] yangHuiSanJiao(int n) {
        int[][] res = new int[n][n];
        for (int i = 0; i < n; ++i) {
            res[i] = new int[i + 1];
        }

        for (int i = 0; i < n; ++i) {
            res[i][0] = 1;
            res[i][i] = 1;
            for (int j = 1; j < i; ++j) {
                res[i][j] = res[i - 1][j] + res[i - 1][j - 1];
            }
        }

        return res;
    }

    public static void printYangHuiSanJiao(int[][] res) {
        for(int i=0;i<res.length;++i){
            for(int k=0;k<res.length-i;++k){
                System.out.print(" ");
            }
            for(int j=0;j<res[i].length;++j){
                System.out.print(res[i][j]+" ");
            }
            System.out.println();
        }
    }
}
```
### 9.字符串翻转
```java
package algorithm;

public class StringReverse {
    public static void main(String[] args) {
        StringReverse stringReverse = new StringReverse();
        String str = stringReverse.reverseString("abcdefg");
        System.out.println(str);
    }

    public String reverseString(String str) {
        int n = str.length();
        if (n == 0 || str.isEmpty()) {
            return str;
        }

        char[] chars = str.toCharArray();
        for (int i = 0, j = n - 1; i < j; ++i, --j) {
            char c = chars[i];
            chars[i] = chars[j];
            chars[j] = c;
        }

        return new String(chars);
    }
}
```
### 10.判断两个日期之间相隔的天数
```java
package algorithm;

public class DiffDay {
    public static void main(String[] args) {
        int year1 = 2017, month1 = 4, day1 = 23;
        int year2 = 2018, month2 = 9, day2 = 25;
        DiffDay diffDay = new DiffDay();
        int diff = diffDay.getDiffDay(year1, month1, day1, year2, month2, day2);
        System.out.println(diff);
    }

    public int getDiffDay(int year1, int month1, int day1, int year2, int month2, int day2) {
        int d1 = getDay(year1, month1, day1);
        int d2 = getDay(year2, month2, day2);

        int res = 0;
        if (year1 == year2) {
            res = Math.abs(year1 - year2);
        } else if (year1 > year2) {
            res = getDaySum(year1, year2, d1, d2);
        } else {
            res = getDaySum(year2, year1, d2, d1);
        }

        return res;
    }

    public int getDaySum(int year1, int year2, int d1, int d2) {
        int res = 0;
        for (int i = year2 + 1; i < year1; ++i) {
            if (isLeap(i)) {
                res += 366;
            } else {
                res += 365;
            }
        }
        res += d1;
        if (isLeap(year2)) {
            res += (366 - d2);
        } else {
            res += (365 - d2);
        }

        return res;
    }

    private int getDay(int year, int month, int day) {
        int days = 0;
        int d = 0;
        for (int i = 1; i < month; ++i) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    d = 31;
                    days += d;
                    break;
                case 2:
                    if (isLeap(year)) {
                        d = 29;
                    } else {
                        d = 28;
                    }
                    days += d;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    d = 30;
                    days += d;
                    break;
            }
        }
        return days + day;
    }

    private boolean isLeap(int year) {
        if ((year % 4 == 0 && year % 100 == 0) || year % 400 == 0) {
            return true;
        }
        return false;
    }
}
```
### 11.给定A, B两个整数，不使用除法和取模运算，求A/B的商和余数
```java
package algorithm;

public class Divide {
    public static void main(String[] args) {
        divide(10, 3);
    }

    public static void divide(int a, int b) {
        for (int i = 2; i < a; ++i) {
            if (i * b > a) {
                System.out.println((i - 1) + " " + (a - (i - 1) * b));
                break;
            }
        }
    }
}
```
### 12.压缩驼峰字符串
```java
package algorithm;

public class CamelAndSnakeString {
    public static void main(String[] args) {
        String s = "get_set_where";
        System.out.println(camelString(s));
        String str = "getSetWhere";
        System.out.println(snakeString(str));
    }

    public static String camelString(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (str.charAt(i) == '_') {
                continue;
            }

            if (i != 0 && str.charAt(i - 1) == '_') {
                sb.append(new Character(str.charAt(i)).toString().toUpperCase());
            } else {
                sb.append(str.charAt(i));
            }
        }

        return new String(sb);
    }

    public static String snakeString(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return str;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            if (str.charAt(i) >= 'A' && str.charAt(i) <= 'Z') {
                sb.append('_' + new Character(str.charAt(i)).toString().toLowerCase());
            } else {
                sb.append(str.charAt(i));
            }
        }

        return new String(sb);
    }
}
```
### 13,除去s1中与s2中相同的字符
```java
package algorithm;

import java.util.HashMap;
import java.util.Map;

public class Squeeze {
    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        System.out.println(squeeze(str1, str2));
        System.out.println(squeeze2(str1, str2));
    }

    private static String squeeze(String str1, String str2) {
        int i = 0, j = 0;
        StringBuilder sb = null;
        while (j < str2.length()) {
            sb = new StringBuilder();
            while (i < str1.length()) {
                if (str1.charAt(i) != str2.charAt(j)) {
                    sb.append(str1.charAt(i));
                }
                ++i;
            }
            str1 = new String(sb);
            i = 0;
            ++j;
        }
        return str1;
    }

    private static String squeeze2(String str1, String str2) {
        Map<Character, Boolean> m = new HashMap<>();

        for (int i = 0; i < str2.length(); ++i) {
            if (!m.containsKey(str2.charAt(i))) {
                m.put(str2.charAt(i), true);
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str1.length(); ++i) {
            if (!m.containsKey(str1.charAt(i))) {
                sb.append(str1.charAt(i));
            }
        }

        return new String(sb);
    }
}
```
### 14.给定n个数，要求比较1.5n次同时找出最大值和最小值
```java
package algorithm;

/*
要求比较次数为1.5n，使用一般的逐个遍历每个元素然后判断其是否为最大最小值是需要2n次比较的。
现在考虑采用，每次从数组中取出两个元素，判断其大小，然后再分别判断其是否是最大或最小值，
这样一次处理两个元素，每一次比较3次，最终的比较次数就是n/2*3=1.5n。
 */
public class FindMaxMin {
    public static void main(String[] args) {
        int num[] = {2, 4, 5, 6, 8, 3, 7, 1, 9, 10};
        findMaxMin(num);
    }

    private static void findMaxMin(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = size - 1;
        int tmin, tmax;
        int count = 0;
        while (i < j) {
            if (arr[i] < arr[j]) {
                tmax = arr[j];
                tmin = arr[i];
                ++count;
            } else {
                tmax = arr[i];
                tmin = arr[j];
                ++count;
            }
            if (min > tmin) {
                min = tmin;
            }
            if (max < tmax) {
                max = tmax;
            }
            count += 2;
            ++i;
            --j;
        }
        System.out.println("The max number is " + max);
        System.out.println("The min number is " + min);
        System.out.println("Compare number is " + count);
    }
}
```
### 15.按照map的value进行排序，并按value有序输出
```java
package algorithm;

import java.util.*;

public class MapValueSort {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("three", 3);
        map.put("nine", 9);
        map.put("zero", 0);
        map.put("five", 5);
        map.put("two", 2);
        map.put("six", 6);
        MapValueSort m = new MapValueSort();
        Map<String, Integer> res = m.mapValueSort(map);
        for (String key : res.keySet()) {
            System.out.println(key + " " + res.get(key));
        }
    }
    
    public <T extends Comparable> Map<String, T> mapValueSort(Map<String, T> map) {
        int size = map.size();
        if (size == 0 || map == null) {
            return map;
        }
        List<Map.Entry<String, T>> list = new ArrayList<>();
        for (Map.Entry<String, T> entry : map.entrySet()) {
            list.add(entry);
        }
        Collections.sort(list, new Comparator<Map.Entry<String, T>>() {
            @Override
            public int compare(Map.Entry<String, T> o1, Map.Entry<String, T> o2) {
                return o1.getValue().compareTo(o2.getValue());
            }
        });

        LinkedHashMap<String, T> m = new LinkedHashMap<>();
        for (Map.Entry<String, T> entry : list) {
            m.put(entry.getKey(), entry.getValue());
        }
        return m;
    }
}
```
### 16.找出数组里出现次数超过总数1/3的数(可能存在一个也可能存在两个)
```java
package algorithm;

import java.util.ArrayList;
import java.util.List;

public class MajorityElement {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<Integer>();
        if (nums == null || nums.length == 0) {
            return res;
        }
        int a = nums[0], cnta = 0;
        int b = nums[0], cntb = 0;
        for (int num : nums) {
            if (num == a) {
                ++cnta;
            } else if (num == b) {
                ++cntb;
            } else if (cnta == 0) {
                a = num;
                cnta = 1;
            } else if (cntb == 0) {
                b = num;
                cntb = 1;
            } else {
                --cnta;
                --cntb;
            }
        }
        cnta = 0;
        cntb = 0;
        for (int num : nums) {
            if (num == a) {
                ++cnta;
            } else if (num == b) {
                ++cntb;
            }
        }
        if (cnta > nums.length / 3) {
            res.add(a);
        }
        if (cntb > nums.length / 3) {
            res.add(b);
        }
        return res;
    }
}
```
### 17.判断一个字符串是否是回文字符串
```java
package algorithm;

public class IsPalindrome {
    public static void main(String[] args) {
        String str = "abceda";
        String str2 = "";
        String str3 = "abdba";
        boolean flag = isPalindrome(str3);
        System.out.println(flag);
    }

    public static boolean isPalindrome(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return false;
        }
        int i = 0;
        while (i < size / 2) {
            if (str.charAt(i) != str.charAt(size - i - 1)) {
                return false;
            }
            ++i;
        }

        return true;
    }
}
```
### 18.不使用循环，判断一个数是否是2的N次方
```java
package algorithm;

//凡是2的N次方的整数，其二进制码只有一个1
public class Is2N {
    public static void main(String[] args) {
        boolean flag = is2N(34);
        System.out.println(flag);
    }

    public static boolean is2N(int n) {
        if (n > 0 && (n & (n - 1)) == 0) {
            return true;
        }

        return false;
    }
}
```
### 19.求1!+2!+3!+4!+...+n!的结果
```java
package algorithm;

public class JieChengHe {
    public static void main(String[] args) {
        System.out.println(jieChengHe(4));
        System.out.println(jieChengHeNoRec(4));
    }

    public static long jieChengHeNoRec(int n) {
        long sum = 0;
        long num = 1;
        for (int i = 1; i <= n; ++i) {
            num *= i;
            sum += num;
        }

        return sum;
    }


    public static long jieChengHe(int n) {
        if (n == 1) {
            return 1;
        }

        return jieChengHe(n - 1) + jieCheng(n);
    }

    public static int jieCheng(int n) {
        if (n == 1) {
            return 1;
        }

        return jieCheng(n - 1) * n;
    }
}
```
### 20.在字符串中求最长数字子序列的长度
```java
package algorithm;

public class LongestNumSubString {
    public static void main(String[] args) {
        String str = "ad3299adfa3239028903afd";
        System.out.println(longestNumSubString(str));
    }

    public static int longestNumSubString(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return 0;
        }

        int cnt = 0;
        int num = 0;
        for (int i = 0; i < size; ++i) {
            if (isNumber(str.charAt(i))) {
                ++cnt;
                if (cnt > num) {
                    num = cnt;
                }
            } else {
                cnt = 0;
            }
        }

        return num;
    }

    public static boolean isNumber(char c) {
        int n = c - 48;
        if (n >= 0 && n <= 9) {
            return true;
        }

        return false;
    }
}
```
### 21.打印最长递增子序列
```java
package algorithm;

/*

 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {0, 1, 0, 3, 2, 3};
        int[] res = longestIncreasingSubsequence(arr);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + " ");
        }
    }

    public static int[] longestIncreasingSubsequence(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return null;
        }

        // 记录当前各元素作为最大元素的最长递增序列长度
        int[] maxLen = new int[size];

        // 记录当前以该元素作为最大元素的递增序列中该元素的前驱节点，用于打印序列用
        int[] pre = new int[size];

        for (int i = 0; i < size; ++i) {
            maxLen[i] = 1;
            pre[i] = i;
        }

        int k = 0;
        int m = 1;
        for (int i = 0; i < size; ++i) {
            for (int j = 0; j < i; ++j) {
                if (arr[j] < arr[i] && maxLen[j] + 1 > maxLen[i]) {
                    maxLen[i] = maxLen[j] + 1;
                    pre[i] = j;
                }

                if (m < maxLen[i]) {
                    m = maxLen[i];
                    k = i;
                }
            }
        }

        int i = m - 1;
        int[] res = new int[m];
        while (pre[k] != k) {
            res[i--] = arr[k];
            k = pre[k];
        }

        res[i] = arr[k];

        return res;
    }
}
```
### 22.打印最长连续递增子序列
```java
package algorithm;

public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] arr = {4, 1, 2, 5, 0, 3, 6, 8};
        longestContinuousIncreasingSubsequence(arr);
    }

    public static void longestContinuousIncreasingSubsequence(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int curLen = 1;
        int maxLen = 1;
        int index = 0;
        for (int i = 1; i < size; ++i) {
            if (arr[i] > arr[i - 1]) {
                ++curLen;
                if (curLen > maxLen) {
                    maxLen = curLen;
                    index = i;
                }
            } else {
                curLen = 1;
            }
        }

        int i = index - maxLen + 1;
        while (maxLen != 0) {
            System.out.print(arr[i] + "\t");
            ++i;
            maxLen--;
        }
    }
}
```
### 22.没有优先级的"+","-","x"
```java
package algorithm;

import java.util.Scanner;

//没有优先级的"+","-","x"
public class NoPriority {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        int res = noPriority(str);
        System.out.println(res);
    }

    public static int noPriority(String str) {
        int size = str.length();
        if (size == 0 || str.isEmpty()) {
            return 0;
        }

        int res = str.charAt(0) - '0';
        for (int i = 1; i < size; ++i) {
            int cur = str.charAt(i) - '0';
            if (cur >= 0 && cur <= 9) {
                int pre = str.charAt(i - 1);
                if (pre == '+') {
                    res += cur;
                } else if (pre == '-') {
                    res -= cur;
                } else if (pre == '*') {
                    res *= cur;
                }
            }
        }

        return res;
    }
}
```
### 23.在不使用循环的条件下，如何计算出一个数其2的n次方的最大数字（这个比较绕，例如17-->16，31-- >16）
```java
package algorithm;

public class Max2N {
    public static void main(String[] args) {
        System.out.println(max2N(17));
        System.out.println(max2N(31));
    }

    public static int max2N(int n) {
        if ((n > 0) && (n & (n - 1)) == 0) {
            return n;
        }

        return max2N(n - 1);
    }
}
```
### 24.未排序数组中累加和为给定值的最长子数组的长度
```java
package algorithm;

import java.util.HashMap;

public class MaxLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        int target = 3;
        System.out.println(maxLength(arr, target));
        System.out.println(maxLength2(arr, target));
    }

    /**
     * 0到位置i的累加和我们用sum[0~i]，存在j使得sum[0~j] - sum[0~i] = k，则k = sum[i+1~j]
     * 补充题目1：给定一个无序数组 arr，其中元素可正、可负、可 0。
     * 求 arr 所有的子数组中正数与负数个数相等的最长子数组长度。
     * 要求：时间复杂度 O(N)
     * 分析：将数组中的正数变成1，负数变成-1,零仍然为零。然后求累加和为0的最长子数组，
     * 这样就将这个问题转化成未排序数组中累加和为给0的最长子数组问题了。
     * 补充题目2：给定一个无序数组 arr，其中元素只是 1 或 0。求 arr 所有的子数组中 0 和 1 个 数相等的最长子数组长度。
     * 要求：时间复杂度 O(N)
     * 分析：将数组中的0变成-1,1仍然为1，求累加和为0的最长子数组，可以求出1和-1个数相同，代表着0和1个数相同。
     * <p>
     * 方法一：
     */
    public static int maxLength(int[] arr, int target) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                len = (i - map.get(sum - target)) > len ? (i - map.get(sum - target)) : len;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }

    /**
     * 方法二：使用两个指针left和right,记录从left到right之间的元素的值得和，使用一个变量len记录长度。
     * 如果这个和大于目标，那么left加1，如果这个和小于目标，那么right加1,如果这个值等于目标，那么比较并更新len，
     * 同时left++。right超过最右边的时候结束循环。
     */
    public static int maxLength2(int[] arr, int target) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int len = 0;
        int sum = 0;
        while (right < size) {
            if (sum < target) {
                ++right;
                if (right == size) {
                    break;
                }
                sum += arr[right];
            } else if (sum > target) {
                sum += arr[left];
                ++left;
            } else {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            }
        }

        return len;
    }
}
```
### 25.N的阶乘二进制表示的最低位1的位置
```java
package algorithm;

public class PosOfOneBinary {
    public static void main(String[] args) {
        System.out.println(posOfOneBinary(3));
    }

    /*
        这个问题实际上等同于求N!含有质因数2的个数+1。即答案等于N!含有质因数2的个数加1。 
        如果一个质数是某个数的因数，那么就说这个质数是这个数的质因数。因为每存在一个2，则在数的最低位多1个0。
        实际上N！都为偶数，因为质因数里面都有一个2，除了1以外，因为1的阶乘是1，是个奇数，其他数的阶乘都是偶数。
     */
    public static int posOfOneBinary(int n) {
        if (n < 0) {
            return -1;
        }

        int res = 0;
        while (n != 0) {
            n >>= 1;
            res += n;
        }

        return (res + 1);
    }
}
```
### 26.输入一个正整数N，输出大于N且最接近这个数的素数
```java
package algorithm;

public class FindPrime {
    public static void main(String[] args) {
        FindPrime findPrime = new FindPrime();
        findPrime.findPrime(34);
        findPrime.findPrime(9);
    }

    private static void findPrime(int n) {
        if (n <= 1) {
            System.out.println(2);
        }
        while (n > 0) {
            if (!isPrime(n)) {
                ++n;
            } else {
                System.out.println(n);
                break;
            }
        }
    }

    private static boolean isPrime(int n) {
        if (n == 0 || n == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
```
### 27.字符串转换float
```java
package algorithm;

public class StringToFloat {
    public static void main(String[] args) {
        StringToFloat stf = new StringToFloat();
        float res = stf.stringToFloat("89.432");
        System.out.println(res);
    }

    public float stringToFloat(String str) {
        int size = str.length();
        if (str.isEmpty() || size == 0) {
            return Float.MIN_VALUE;
        }

        float res = 0;
        int sign = 1;
        if (str.charAt(0) == '+') {
            sign = 1;
        } else if (str.charAt(0) == '-') {
            sign = -1;
        } else if (str.charAt(0) >= '0' && str.charAt(0) <= '9') {
            res += str.charAt(0) - '0';
        } else {
            return Float.MIN_VALUE;
        }

        int index = str.indexOf('.');
        for (int i = 1; i < index; ++i) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return Float.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(i) - '0');
        }

        float total = 0;
        for (int i = index + 1; i < size; ++i) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                return Float.MIN_VALUE;
            }
            total = total * 10 + (str.charAt(i) - '0');
        }

        int pos = 1;
        for (int i = 0; i < (size - index - 1); ++i) {
            pos *= 10;
        }

        total = total / pos;

        return sign == 1 ? (res + total) : -(res + total);
    }
}
```
### 28.字符串数组的字符串是否都能首尾相接
```java
package algorithm;

import java.util.*;

public class StrOrgEnd {
    public static void main(String[] args) {
        String[] str = {"gj", "jl", "dg", "ad", "gg"};
        String[] str2 = {"aes", "dwewe", "ea", "sd"};
        String[] str3 = {"as", "st", "ta", "ar"};
        StrOrgEnd sre = new StrOrgEnd();
        System.out.println(sre.strOrgEnd(str));
        System.out.println(sre.strOrgEnd(str2));
        System.out.println(sre.strOrgEnd(str3));
        System.out.println("------------------");
        sre.strOrgEnd2(str);
    }

    public boolean strOrgEnd(String[] str) {
        //用于保存字符串的首尾字符
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < str.length; ++i) {
            char start = str[i].charAt(0);
            char end = str[i].charAt(str[i].length() - 1);
            sb.append(start).append(end);
        }

        char[] chars = sb.toString().toCharArray();
        //用于保存字符出现的个数
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; ++i) {
            char key = chars[i];
            if (map.containsKey(key)) {
                int value = map.get(key);
                map.put(key, ++value);
            } else {
                map.put(key, 1);
            }
        }

        Collection collection = map.values();
        Iterator<Integer> iter = collection.iterator();
        while (iter.hasNext()) {
            int count = iter.next();
            if (count % 2 != 0) {
                //如果有一个不是出现偶数次,则说明不能组成环
                return false;
            }
        }

        return true;
    }

    public void strOrgEnd2(String[] str) {
        int size = str.length;
        if (size == 0) {
            return;
        }

        strOrgEndhelper(str, 0);
    }

    public void strOrgEndhelper(String[] str, int k) {
        if (k == str.length) {
            System.out.println(Arrays.toString(str));
            return;
        }
        for (int i = k; i < str.length; ++i) {
            /**
             *  交换k+1和i
             *  k=0,表明为第一个字符串，必须和自己以及后面每一个交换
             *  k>0时，假设0-(k-1)是排序好的，需比较k-1和i的顺序
             */
            if ((k > 0 && judge(str[k - 1], str[i])) || k == 0) {
                swap(str, k, i);
                strOrgEndhelper(str, k + 1);
                swap(str, k, i);
            }
        }
    }

    private boolean judge(String str1, String str2) {
        if (str1.charAt(str1.length() - 1) == str2.charAt(0)) {
            return true;
        }
        return false;
    }

    private void swap(String[] str, int i, int j) {
        String tmp = str[i];
        str[i] = str[j];
        str[j] = tmp;
    }
}
```
### 29.递归求和
```java
package algorithm;

public class SumWithRecur {
    public static void main(String[] args) {
        SumWithRecur sumWithRecur = new SumWithRecur();
        int sum = sumWithRecur.sumWithRecur(5);
        System.out.println(sum);
    }

    public int sumWithRecur(int n) {
        if (n == 1) {
            return 1;
        }

        return sumWithRecur(n - 1) + n;
    }
}
```
### 30.递归算法判断一个数组是否是递增数组
```java
package algorithm;

public class ArrayIsIncrement {
    public static void main(String[] args) {
        ArrayIsIncrement main = new ArrayIsIncrement();
        int[] arr = {1, 2, 3, 4, 5, 6, 7};
        System.out.println(main.arrayIsIncrement(arr, arr.length));
        int[] ar = {0, 9, 4};
        System.out.println(main.arrayIsIncrement(ar, ar.length));
    }

    public boolean arrayIsIncrement(int[] arr, int size) {
        if (size == 1) {
            return true;
        }

        return arr[size - 1] >= arr[size - 2] && arrayIsIncrement(arr, size - 1);
    }
}
```
### 31.二分查找的递归与非递归实现
```java
package algorithm;

public class BinarySearch {
    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 5, 7, 9, 11};
        int target = 7;
        BinarySearch bs = new BinarySearch();
        int index = bs.binarySearchRecur(arr, 0, arr.length - 1, target);
        System.out.println(index);
        index=bs.binarySearch(arr,target);
        System.out.println(index);
    }

    public int binarySearch(int[] arr, int target) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return -1;
        }

        int start = 0;
        int end = size - 1;
        int mid = 0;
        while (start <= end) {
            mid = (start + end) >> 1;
            if (arr[mid] > target) {
                end = mid - 1;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                while (mid - 1 >= 0) {
                    if (arr[mid - 1] == target) {
                        --mid;
                    } else {
                        break;
                    }
                }

                return mid;
            }
        }

        return -1;
    }

    public int binarySearchRecur(int[] arr, int start, int end, int target) {
        if (start > end) {
            return -1;
        }

        int mid = (start + end) >> 1;
        if (arr[mid] == target) {
            return mid;
        } else if (arr[mid] > target) {
            return binarySearchRecur(arr, start, mid - 1, target);
        } else {
            return binarySearchRecur(arr, mid + 1, end, target);
        }
    }
}
```
### 32.正整数序列Q中的每个元素都至少能被正整数a和b中的一个整除，现给定a和b，如何计算出Q中的前N项？
```java
package algorithm;

/*
正整数序列Q中的每个元素都至少能被正整数a和b中的一个整除，现给定a和b，如何计算出Q中的前N项？
例如，当 a=3，b=5，N=6时，序列为3，5，6，9，10，12。

分析：可以和归并排序联系起来，给定两个数组 A、B，数组 A 存放：3 x 1，3 x 2，3 x 3，…
数组 B 存放 5 x 1，5 x 2，5 x 3，… 有两个指针 i、j，分别指向 A、B 的第一个元素，取 Min(A[ i ], B[ j ])，
并将较小值的指针前移，然后继续比较（即归并排序中的“合并两个有序序列“）。
当然，实现时没有必要申请两个数组，用两个变量即可
 */
public class CreateQArray {
    public static void main(String[] args) {
        CreateQArray createArray = new CreateQArray();
        int[] res = createArray.createArray(3, 5, 6);
        for (int i = 0; i < res.length; ++i) {
            System.out.print(res[i] + "\t");
        }
    }

    public int[] createArray(int a, int b, int n) {
        int[] res = new int[n];
        if (n <= 0) {
            return null;
        }

        int i = 1, j = 1;
        int k = 0;
        while (k < n) {
            if (i * a < j * b) {
                res[k++] = i * a;
                ++i;
            } else {
                res[k++] = j * b;
                ++j;
            }
        }

        return res;
    }
}
```
### 33.如何判断一个整数 x 是否可以表示成 n（n >= 2）个连续正整数的和?
```java
package algorithm;

/*
如何判断一个整数x是否可以表示成 n（n >= 2）个连续正整数的和。
分析：假设x可以表示成n（n >= 2）个连续正整数的和，那么x = m + (m + 1) + (m + 2) + … + (m + n - 1)，
其中m为分解成的连续整数中最小的那一个（且 m 是大于等于 1 的正整数），可推出 x = (2m + n - 1)*n/2，
变换之后 m = (2*x/n - n + 1)/2；由 m 的取值范围可知 (2*x/n - n + 1)/2 >= 1，又因为m是正整数，
所以(2*x/n - n + 1) 一定要为偶数；否则m = (2*x/n - n + 1)/2 就是小数，不符合要求；
（注意：(2*x/n - n + 1) 看成是 float 类型的）。给定一个 n，看 x 是否能分解成 n 个连续整数的和，
可以判断是否存在 m，也就是 (2*x/n - n + 1) 是否是偶数的问题。
 */
public class ContinuousSequence {
    public static void main(String[] args) {
        findContinuousSequence(32, 5);
    }

    public static void findContinuousSequence(int x, int n) {
        float tmp = (float) 2 * x / n - (float) (n - 1);
        int m = (int) tmp / 2;
        if ((int) tmp % 2 == 0 && m >= 1) {
            System.out.print("x可分解为: ");
            int start = m;
            int end = m + n - 1;
            while (start <= end) {
                System.out.print(start + "\t");
                ++start;
            }
            System.out.println();
        } else {
            System.out.println("x不可分解");
        }
    }
}
```
### 34.给一个由n-1个数组成的未经排序的数列，其元素都是1—n中的不同的整数。找出缺失的整数？
```java
package algorithm;

public class FindLost {
    public static void main(String[] args) {
        FindLost findLost = new FindLost();
        int arr[] = {1, 2, 3, 5, 9, 7, 8, 6, 4, 11};
        findLost.findLost(arr);
    }

    public void findLost(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int sum1 = 0;
        int sum2 = 0;
        for (int i = 0; i < size; ++i) {
            sum1 += arr[i];
            sum2 += i;
        }
        sum2 += size;

        System.out.println((sum2 - sum1 + size + 1));
    }
}
```
### 35.求两个数组的交集
```java
package algorithm;

import java.util.Arrays;

public class IntersectArray {
    public static void main(String[] args) {
        IntersectArray intersectArray = new IntersectArray();
        int[] arr1 = {9, 4, 3, 0, 2, 7, 6, 8};
        int[] arr2 = {5, 2, 8, 1, 0, 3};
        intersectArray.intersectArray(arr1, arr2);
    }

    public void intersectArray(int[] arr1, int[] arr2) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        if (arr1 == null || arr2 == null || size1 == 0 || size2 == 0) {
            return;
        }

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int i = 0;
        int j = 0;
        while (i < size1 && j < size2) {
            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + "\t");
                ++i;
                ++j;
            } else if (arr1[i] > arr2[j]) {
                ++j;
            } else {
                ++i;
            }
        }
    }
}
```
### 36.如何判断一个数组中的数值是否连续相邻
```java
package algorithm;

/*
如何判断一个数组中的数值是否连续相邻
一个整数数组，元素取值可能是0~65535中的任意一个数，相同数值不会重复出现；0是例外，可以反复出现。
设计一个算法，判断这个数组中的元素是否连续相邻。
需要注意以下4点：
（1）数值允许是乱序的，如 8 7 5 0 6。
（2）0可以通配任意数值，如8 7 5 0 6中的0可以通配成9或者4.
（3）0可以多次出现。
（4）全0算连续，只有一个非0算连续。
分析：如果没有0的存在，要组成连续的数列，最大值和最小值的差距必须是n-1；存在0的情况下，
只要最大值可最小值的差距小于n-1就可以了，缺失的数值可以用0通配。所以找出数列中非0的最大值和非0的最小值，
时间复杂度为O(n)。如果非0最大-非0最小+1<n，即非0最大-非0最小<=n-1，则这n个数值连续相邻。否则，不连续相邻。
因此，总体复杂度为O(n)。
 */
public class ArrayIsContinues {
    public static void main(String[] args) {
        ArrayIsContinues isContinues = new ArrayIsContinues();
        int[] arr = {8, 7, 5, 0, 6, 10, 12};
        System.out.println(isContinues.arrayIsContinues(arr));
    }

    public boolean arrayIsContinues(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return true;
        }

        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < size; ++i) {
            if (arr[i] != 0) {
                if (arr[i] > max) {
                    max = arr[i];
                }
                if (arr[i] < min) {
                    min = arr[i];
                }
            }
        }

        return (max - min) <= (size - 1) ? true : false;
    }
}
```
### 37.找出数组中重复数字最多的数
```java
package algorithm;

public class DuplicateMaxCount {
    public static void main(String[] args) {
        DuplicateMaxCount maxCount = new DuplicateMaxCount();
        int[] arr = {9, 3, 5, 2, 1, 6, 3, 1, 2, 4, 5, 3, 5};
        int res = maxCount.duplicateMaxCount(arr);
        System.out.println(res);
    }

    public int duplicateMaxCount(int[] arr) {
        int size = arr.length;
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < size; ++i) {
            if (max < arr[i]) {
                max = arr[i];
            }

            if (min > arr[i]) {
                min = arr[i];
            }
        }

        int[] helper = new int[max - min + 1];
        for (int i = 0; i < size; ++i) {
            ++helper[arr[i] - min];
        }

        int count = 0;
        int res = 0;
        for (int i = 0; i < size; ++i) {
            if (helper[arr[i] - min] > count) {
                count = helper[arr[i] - min];
                res = arr[i];
            }
        }

        return res;
    }
}
```
### 38.将数组的后m个数移动为前m个数
```java
package algorithm;

public class MoveArrayReverse {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8};
        MoveArrayReverse mr = new MoveArrayReverse();
        mr.printArray(arr);
        mr.moveArrayReverse(arr, 3);
        mr.printArray(arr);
    }

    public void moveArrayReverse(int[] arr, int n) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int m = size - n;
        reverse(arr, 0, m - 1);
        reverse(arr, m, size - 1);
        reverse(arr, 0, size - 1);
    }

    public void reverse(int[] arr, int i, int j) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int tmp = 0;
        while (i < j) {
            tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            ++i;
            --j;
        }
    }

    public void printArray(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 0; i < size; ++i) {
            System.out.print(arr[i] + "\t");
        }
        System.out.println(arr[size - 1]);
    }
}
```
### 39.找出数组中出现奇数次的元素：有一个整数数组arr，其中的元素只有一个元素出现奇数次，请找出这个元素。
```java
package algorithm;

/*
找出数组中出现奇数次的元素：有一个整数数组arr，其中的元素只有一个元素出现奇数次，请找出这个元素。
对于任意一个数k，有k^k = 0，k^0 = k，所以将arr中所有元素进行异或，那么出现次数为偶数的元素异或后都变成了0，出现次数为奇数的元素异或后得到元素本身。
 */
public class OddElement {
    public static void main(String[] args) {
        OddElement oe = new OddElement();
        int[] arr = {1, 2, 3, 4, 2, 1, 4, 3, 2};
        int res = oe.oddElement(arr);
        System.out.println(res);
    }

    public int oddElement(int[] arr) {
        int res = 0;
        for (int i = 0; i < arr.length; ++i) {
            res ^= arr[i];
        }

        return res;
    }
}
```
### 40.数组a[N]，1-N-1这（N-1）个数存放在a[N]中，其中某个数重复一次，找出这个数。时间复杂度不超过
```java
package algorithm;

public class OnlyRepeateOnce {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 3, 4, 5, 6, 7};
        OnlyRepeateOnce oto = new OnlyRepeateOnce();
        int rep = oto.onlyRepeateOnce(arr);
        System.out.println(rep);
        int res = oto.onlyRepeate(arr);
        System.out.println(res);
    }

    public int onlyRepeateOnce(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return -1;
        }

        int res = 0;
        for (int i = 0; i < size; ++i) {
            res ^= arr[i];
        }

        for (int i = 1; i < size; ++i) {
            res ^= i;
        }

        return res;
    }

    /*
        数学推导法: 不重复时sum=1+2+...+ d + (d+1)...+N；现在less=1+2+...+ d + d + (d+1)+...+(N-1)。
        sum和less都有N个数，由于less中只有一个重复的数字d，则必有1<=d<=(N-1)，sum>less。
        sum - less = 0+0+...+ 0 + (-d) + 0...0 + N =(N-d)。所以重复的d=N-(sum-less)。
     */
    public int onlyRepeate(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return -1;
        }
        int sum = 0;
        int less = 0;
        for (int i = 1; i <= size; ++i) {
            sum += i;
        }
        for (int i = 0; i < size; ++i) {
            less += arr[i];
        }
        int res = size - (sum - less);
        return res;
    }
}
```
### 41.一个序列先增后减，求峰值
```java
package algorithm;

public class GetPeek {
    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 6, 7, 6, 4, 1, 0};
        GetPeek gp = new GetPeek();
        gp.getPeek(arr);
    }

    public void getPeek(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        for (int i = 1; i < size; ++i) {
            if (arr[i] < arr[i - 1]) {
                System.out.println(arr[i - 1]);
                break;
            }
        }
    }
}
```
### 42.递归求数组的和
```java
package algorithm;

public class RecurSum {
    public static void main(String[] args) {
        RecurSum r = new RecurSum();
        int[] arr = {9, 3, 1, 5, 2};
        int sum = r.recurSum(arr, arr.length);
        System.out.println(sum);
    }

    public int recurSum(int[] arr, int n) {
        if (n == 0 || arr == null) {
            return 0;
        }

        return recurSum(arr, n - 1) + arr[n - 1];
    }
}
```
### 43.输入一个字符串，输出该字符串中字符的所有组合。举个例子，如果输入abc，它的组合有a、b、c、ab、ac、bc、abc
```java
package algorithm;

public class Combinations {
    public static void main(String[] args) {
        String str = "abc";
        Combinations cbs = new Combinations();
        cbs.combinations(str);
        System.out.println("-------------");
        cbs.printAllCombination(str);
    }

    /*
        假设想在长度为n的字符串中求m个字符的组合。 先从头扫描字符串的第一个字符。针对第一个字符，
        有两种选择：一是把这个字符放到组合中去，接下来需要在剩下的n-1个字符中选取m-1个字符；
        二是不把这个字符放到组合中去，接下来需要在剩下的n-1个字符中选择m个字符。
     */
    public void combinations(String str) {
        if (str.isEmpty()) {
            return;
        }

        int size = str.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; ++i) {
            helper(str, 0, i, sb);
        }
    }

    public void helper(String str, int index, int num, StringBuilder sb) {
        if (num == -1) {
            System.out.println(sb.toString());
            return;
        }
        if (index == str.length()) {
            return;
        }
        sb.append(str.charAt(index));
        helper(str, index + 1, num - 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        helper(str, index + 1, num, sb);
    }

    /*
        利用位操作来简化题目，即给所有输出方式进行编号（1 ~ 2^n-1）
        0 0 1 --> a
        0 1 0 --> b
        0 1 1 --> ab
        1 0 0 --> c
        1 0 1 --> ac
        1 1 0 --> bc
        1 1 1 --> abc
     */
    public void printAllCombination(String s) {
        int size = s.length();
        int comb_count = 1 << size;
        for (int i = 1; i < comb_count; ++i) {
            for (int j = 0; j < size; ++j) {
                if ((i & (1 << j)) != 0) {
                    System.out.print(s.charAt(j) + "\t");
                }
            }
            System.out.println();
        }
    }
}
```
### 44.在两个数组中寻找两个数的和等于指定的数值
```java
package algorithm;

import java.util.Arrays;

public class TargetInTwoArray {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 0, 9, 4, 7, 3};
        int[] arr2 = {9, 4, 3, 2, 1, 0, 8};
        TargetInTwoArray tns = new TargetInTwoArray();
        int target = 6;
        tns.twoNumSumInArray(arr1, arr2, target);
    }

    private void twoNumSumInArray(int[] arr1, int[] arr2, int target) {
        int size1 = arr1.length;
        int size2 = arr2.length;
        if (arr1 == null || size1 == 0 || arr2 == null || size2 == 0) {
            return;
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int i = 0;
        int j = size2 - 1;
        while (i < size1 && j >= 0) {
            if (arr1[i] + arr2[j] == target) {
                System.out.println(arr1[i] + "\t" + arr2[j]);
                ++i;
                --j;
            } else if (arr1[i] + arr2[j] > target) {
                --j;
            } else {
                ++i;
            }
        }
    }
}
```
### 45.计算给定的日期是一年中的第多少天
```java
package algorithm;

import java.util.Scanner;

public class GetDay {
    public static void main(String[] args) {
        GetDay gd = new GetDay();
        Scanner sc = new Scanner(System.in);
        int year = sc.nextInt();
        int month = sc.nextInt();
        int day = sc.nextInt();
        int days = gd.getDay(year, month, day);
        System.out.println(days);
    }

    public int getDay(int year, int month, int day) {
        int res = 0;
        int d = 0;
        for (int i = 1; i < month; ++i) {
            switch (i) {
                case 1:
                case 3:
                case 5:
                case 7:
                case 8:
                case 10:
                case 12:
                    d = 31;
                    res += d;
                    break;
                case 2:
                    if ((year % 4 == 0 && year % 100 == 0) || year % 400 == 0) {
                        d = 29;
                    } else {
                        d = 28;
                    }
                    res += d;
                    break;
                case 4:
                case 6:
                case 9:
                case 11:
                    d = 30;
                    res += d;
                    break;
            }
        }

        return res + day;
    }
}
```
### 46.求A的B次的后三位
```java
package algorithm;

public class LastThree {
    public static void main(String[] args) {
        LastThree lt = new LastThree();
        int res = lt.lastThree(23, 9);
        System.out.println(res);
    }

    private int lastThree(int n, int m) {
        int last = 1;
        for (int i = 1; i <= m; ++i) {
            last = (last * n) % 1000;
        }
        return last;
    }
}
```
### 47.最长公共子序列（不连续）时间复杂度O(m*n)
```java
package algorithm;

import java.util.Scanner;

public class LongestCommonSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter two string:");
        String s1 = sc.next();
        String s2 = sc.next();
        int m = s1.length();
        int n = s2.length();
        int[][] b = new int[m][n];
        LongestCommonSubsequence lcs = new LongestCommonSubsequence();
        System.out.println("Length of LCS is " + lcs.longestCommonSubsequence(s1, s2, b, m, n));
        System.out.println("打印其中的一个LCS:");
        lcs.printLongestCommonSubsequence(b, s1, m, n);
    }

    public int longestCommonSubsequence(String s1, String s2, int[][] b, int m, int n) {
        int[][] c = new int[m + 1][n + 1];
        for (int i = 0; i <= m; ++i) {
            for (int j = 0; j <= n; ++j) {
                if (i == 0 || j == 0) {
                    c[i][j] = 0;
                } else {
                    if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                        c[i][j] = c[i - 1][j - 1];
                        b[i - 1][j - 1] = 1;
                    } else {
                        if (c[i - 1][j] >= c[i][j - 1]) {
                            c[i][j] = c[i - 1][j];
                            b[i - 1][j - 1] = 0;
                        } else {
                            c[i][j] = c[i][j - 1];
                            b[i - 1][j - 1] = -1;
                        }
                    }
                }
            }
        }

        return c[m][n];
    }

    public void printLongestCommonSubsequence(int[][] b, String s, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }

        if (b[i - 1][j - 1] == 1) {
            printLongestCommonSubsequence(b, s, i - 1, j - 1);
            System.out.print(s.charAt(i - 1));
        } else if (b[i - 1][j - 1] == 0) {
            printLongestCommonSubsequence(b, s, i - 1, j);
        } else {
            printLongestCommonSubsequence(b, s, i, j - 1);
        }
    }
}
```
### 48.最长公共子字符串：类似最长子序列，只是公共子字符串要求必须是连续的
```java
package algorithm;

import java.util.Arrays;

public class LongestCommonSubstring {
    public static void main(String[] args) {
        LongestCommonSubstring ls = new LongestCommonSubstring();
        String str1 = "123456";
        String str2 = "14568";
        int[][] arr = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i <= str1.length(); ++i) {
            Arrays.fill(arr[i], -1);
        }
        int res = ls.longCommonSubstring(str1, str2, arr);
        System.out.println("result = " + res);
        ls.printLongCommonSubstring(arr, str1, str1.length(), str2.length());
    }

    private int longCommonSubstring(String str1, String str2, int[][] arr) {
        int size1 = str1.length();
        int size2 = str2.length();
        int max = 0;
        int[][] dp = new int[size1 + 1][size2 + 1];
        for (int i = 0; i <= size1; ++i) {
            for (int j = 0; j <= size2; ++j) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    arr[i][j] = 1;
                    max = dp[i][j] > max ? dp[i][j] : max;
                }
            }
        }
        return max;
    }

    private void printLongCommonSubstring(int[][] arr, String str, int i, int j) {
        if (i == 0 || j == 0) {
            return;
        }
        if (arr[i][j] == 1) {
            printLongCommonSubstring(arr, str, i - 1, j - 1);
            System.out.print(str.charAt(i - 1));
        } else if (arr[i][j] == 0) {
            printLongCommonSubstring(arr, str, i - 1, j);
        } else {
            printLongCommonSubstring(arr, str, i, j - 1);
        }
    }
}
```
### 49.M进制与N进制的转换
```java
package algorithm;

public class MtoN {
    public static void main(String[] args) {
        MtoN mn = new MtoN();
        String str = "9C";
        String res = mn.MToN(str, 16, 8);
        System.out.println(res);
    }

    public String MToN(String str, int m, int n) {
        int[] charToNum = new int[256];
        int[] numToChar = new int[256];

        for (int i = 0; i <= 9; ++i) {
            charToNum['0' + i] = i;
            numToChar[i] = '0' + i;
        }

        for (int i = 10; i <= 35; ++i) {
            charToNum['A' + i - 10] = i;
            numToChar[i] = 'A' + i - 10;
        }

        int realValue = 0;
        int maxChar = numToChar[m];
        for (int i = 0; i < str.length(); ++i) {
            if (str.charAt(i) >= maxChar) {
                return "Error Input";
            }

            realValue = realValue * m + charToNum[str.charAt(i)];
        }

        String s = "";
        while (realValue != 0) {
            char ch = (char) numToChar[realValue % n];
            s = ch + s;
            realValue = realValue / n;
        }

        return s;
    }
}
```
### 50.等概率产生0和1
```java
package algorithm;

/*
有一个随机数发生器，以概率P产生0，概率(1-P)产生1，请问能否利用这个随机数发生器，
构造出新的发生器，以1/2的概率产生0和1。请写明结论及推理过程。
 */
public class RandEqual {
    /*
        已知:产生0的概率为P，产生1的概率为（1-P）
        则:产生01的概率为P（1-P），产生10的概率为（1-P）P，两者相等
        新函数:产生01返回0，产生10返回1
     */
    public int getRand() {
        int i = rand();
        int j = rand();

        int res = -1;
        while (true) {
            if (i == 0 && j == 1) {
                res = 0;
                break;
            } else if (i == 1 && j == 0) {
                res = 1;
                break;
            }
        }

        return res;
    }
}
```
### 51.求一个序列的平衡点
```java
package algorithm;

public class FindBalance {
    public static void main(String[] args) {
        FindBalance fb = new FindBalance();
        int[] arr = {5, 1, -1, 3, 2, 7, -3, 0, 4};
        fb.findBalance(arr);
    }

    public void findBalance(int[] arr) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return;
        }

        int sum = 0;
        int subSum = 0;
        for (int i = 0; i < size; ++i) {
            sum += arr[i];
        }

        for (int i = 0; i < size; ++i) {
            if (subSum == (sum - subSum - arr[i])) {
                System.out.println("balance is " + arr[i]);
            } else {
                subSum += arr[i];
            }
        }
    }
}
```