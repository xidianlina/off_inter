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
