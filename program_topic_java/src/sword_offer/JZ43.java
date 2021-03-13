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
