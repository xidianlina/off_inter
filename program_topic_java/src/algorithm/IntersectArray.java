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
