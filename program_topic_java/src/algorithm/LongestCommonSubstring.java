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
