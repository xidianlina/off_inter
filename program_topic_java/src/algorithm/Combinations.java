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
