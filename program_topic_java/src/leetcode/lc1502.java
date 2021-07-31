package leetcode;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
1502. 判断能否形成等差数列
给你一个数字数组 arr 。
如果一个数列中，任意相邻两项的差总等于同一个常数，那么这个数列就称为 等差数列 。
如果可以重新排列数组形成等差数列，请返回 true ；否则，返回 false 。

示例 1：
输入：arr = [3,5,1]
输出：true
解释：对数组重新排序得到 [1,3,5] 或者 [5,3,1] ，任意相邻两项的差分别为 2 或 -2 ，可以形成等差数列。

示例 2：
输入：arr = [1,2,4]
输出：false
解释：无法通过重新排序得到等差数列。

提示：
2 <= arr.length <= 1000
-10^6 <= arr[i] <= 10^6
 */
public class lc1502 {
    /*
        时间复杂度：O(nlogn)。排序的时间代价为O(n*logn)，遍历序列的时间代价是O(n)，
                  故渐进时间复杂度为 O(n*log n + n) = O(n*logn)。
        空间复杂度：O(logn)。快速排序中使用的栈空间期望是O(logn)。
     */
    public boolean canMakeArithmeticProgression(int[] arr) {
        Arrays.sort(arr);
        for (int i = 1; i < arr.length - 1; ++i) {
            if (arr[i] * 2 != arr[i - 1] + arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    /*
        时间复杂度：O(n)
        空间复杂度：O(n)
     */
    public boolean canMakeArithmeticProgression2(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<Integer> set = new HashSet<>();

        //对数组进行第一次遍历,找出数组中min ,max
        for (int i : arr) {
            max = Math.max(max, i);
            min = Math.min(min, i);
            set.add(i);
        }

        if ((max - min) % (arr.length - 1) != 0) {
            return false;
        }

        //求得公差
        int diff = (max - min) / (arr.length - 1);

        for (int i = min + diff; i < max; i += diff) {
            if (!set.contains(i)) {
                return false;
            }
        }
        return true;
    }
}
