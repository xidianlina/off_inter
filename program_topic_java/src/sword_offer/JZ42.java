package sword_offer;

import java.util.ArrayList;

/**
 * 题目描述
 * 输入一个递增排序的数组和一个数字S，在数组中查找两个数，使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 * 返回值描述:
 * 对应每个测试案例，输出两个数，小的先输出。
 * 示例1
 * 输入
 * [1,2,4,7,11,15],15
 * 返回值
 * [4,11]
 */
public class JZ42 {
    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        int size = array.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || size < 2) {
            return res;
        }

        int i = 0;
        int j = size - 1;
        while (i < j) {
            if (array[i] + array[j] == sum) {
                res.add(array[i]);
                res.add(array[j]);
                return res;
            } else if (array[i] + array[j] > sum) {
                --j;
            } else {
                ++i;
            }
        }

        return res;
    }

    public ArrayList<Integer> FindNumbersWithSum2(int[] array, int sum) {
        int size = array.length;
        ArrayList<Integer> res = new ArrayList<>();
        if (array == null || size < 2) {
            return res;
        }

        for (int i = 0; i < size; i++) {
            for (int j = i; j < size; j++) {
                if (array[i] + array[j] == sum) {
                    res.add(array[i]);
                    res.add(array[j]);
                    return res;
                }
            }
        }

        return res;
    }
}