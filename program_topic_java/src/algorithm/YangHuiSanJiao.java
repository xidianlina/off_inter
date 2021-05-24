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
