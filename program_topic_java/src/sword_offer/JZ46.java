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
