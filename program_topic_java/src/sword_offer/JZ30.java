package sword_offer;

/**
 * 题目描述
 * 输入一个整型数组，数组里有正数也有负数。数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为 O(n).
 * 示例1
 * 输入
 * [1,-2,3,10,-4,7,2,-5]
 * 返回值
 * 18
 * 说明
 * 输入的数组为{1,-2,3,10,—4,7,2,一5}，和最大的子数组为{3,10,一4,7,2}，因此输出为该子数组的和 18。
 */
public class JZ30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return -1;
        }

        int maxSum = array[0];
        for (int i = 0; i < size; i++) {
            int curSum = 0;
            for (int j = i; j < size; j++) {
                curSum += array[j];
                if (curSum > maxSum) {
                    maxSum = curSum;
                }
            }
        }

        return maxSum;
    }

    public int FindGreatestSumOfSubArray2(int[] array) {
        int size = array.length;
        if (size == 0 || array == null) {
            return -1;
        }

        int maxSum = array[0];
        int curSum = array[0];
        for (int i = 1; i < size; i++) {
            if (curSum <= 0) {
                curSum = array[i];
            } else {
                curSum += array[i];
            }

            if (curSum > maxSum) {
                maxSum = curSum;
            }
        }

        return maxSum;
    }
}
