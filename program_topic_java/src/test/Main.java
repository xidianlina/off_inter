package test;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        int[] arr1 = {1, 2, 3, 3, 3, 5, 7, 8, 9};
        int[] arr2 = {3, 4, 4, 6, 9};

        int[] res = mergeArray(arr1, arr2);
        printArray(res);
    }

    //合并有序数组，需要去重
    public static int[] mergeArray(int[] a, int[] b) {
        int len1 = a.length;
        int len2 = b.length;

        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<Integer>();
        while (i < len1 && j < len2) {
            if (a[i] < b[j]) {
                res.add(a[i]);
                ++i;
                while (i < len1 - 1 && a[i] == a[i + 1]) {
                    ++i;
                }
            } else if (a[i] > b[j]) {
                res.add(b[j]);
                ++j;
                while (j < len2 - 1 && b[j] == b[j + 1]) {
                    ++j;
                }
            } else {
                res.add(b[j]);
                ++i;
                ++j;
                while (i < len1 - 1 && a[i] == a[i + 1]) {
                    ++i;
                }
                while (j < len2 - 1 && b[j] == b[j + 1]) {
                    ++j;
                }
            }
        }

        while (i < len1) {
            res.add(a[i]);
            ++i;
            while (i < len1 - 1 && a[i] == a[i + 1]) {
                ++i;
            }
        }

        while (j < len2) {
            res.add(b[j]);
            ++j;
            while (j < len2 - 1 && b[j] == b[j + 1]) {
                ++j;
            }
        }


        int[] arr = new int[res.size()];

        for (int k = 0; k < res.size(); ++k) {
            arr[k] = res.get(k);
        }

        return arr;
    }

    public static void printArray(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; ++i) {
            System.out.print(arr[i] + "\t");
        }

        System.out.println(arr[len - 1]);
    }
}
