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
