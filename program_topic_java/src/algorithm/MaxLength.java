package algorithm;

import java.util.HashMap;

public class MaxLength {
    public static void main(String[] args) {
        int[] arr = {1, 2, 1, 1, 1};
        int target = 3;
        System.out.println(maxLength(arr, target));
        System.out.println(maxLength2(arr, target));
    }

    /**
     * 0到位置i的累加和我们用sum[0~i]，存在j使得sum[0~j] - sum[0~i] = k，则k = sum[i+1~j]
     * 补充题目1：给定一个无序数组 arr，其中元素可正、可负、可 0。
     * 求 arr 所有的子数组中正数与负数个数相等的最长子数组长度。
     * 要求：时间复杂度 O(N)
     * 分析：将数组中的正数变成1，负数变成-1,零仍然为零。然后求累加和为0的最长子数组，
     * 这样就将这个问题转化成未排序数组中累加和为给0的最长子数组问题了。
     * 补充题目2：给定一个无序数组 arr，其中元素只是 1 或 0。求 arr 所有的子数组中 0 和 1 个 数相等的最长子数组长度。
     * 要求：时间复杂度 O(N)
     * 分析：将数组中的0变成-1,1仍然为1，求累加和为0的最长子数组，可以求出1和-1个数相同，代表着0和1个数相同。
     * <p>
     * 方法一：
     */
    public static int maxLength(int[] arr, int target) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return 0;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int len = 0;
        int sum = 0;
        for (int i = 0; i < size; ++i) {
            sum += arr[i];
            if (map.containsKey(sum - target)) {
                len = (i - map.get(sum - target)) > len ? (i - map.get(sum - target)) : len;
            }
            if (!map.containsKey(sum)) {
                map.put(sum, i);
            }
        }

        return len;
    }

    /**
     * 方法二：使用两个指针left和right,记录从left到right之间的元素的值得和，使用一个变量len记录长度。
     * 如果这个和大于目标，那么left加1，如果这个和小于目标，那么right加1,如果这个值等于目标，那么比较并更新len，
     * 同时left++。right超过最右边的时候结束循环。
     */
    public static int maxLength2(int[] arr, int target) {
        int size = arr.length;
        if (size == 0 || arr == null) {
            return 0;
        }

        int left = 0;
        int right = 0;
        int len = 0;
        int sum = 0;
        while (right < size) {
            if (sum < target) {
                ++right;
                if (right == size) {
                    break;
                }
                sum += arr[right];
            } else if (sum > target) {
                sum += arr[left];
                ++left;
            } else {
                len = Math.max(len, right - left + 1);
                sum -= arr[left++];
            }
        }

        return len;
    }
}
