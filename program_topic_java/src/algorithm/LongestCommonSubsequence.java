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
