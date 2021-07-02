package leetcode;

import java.util.Arrays;
import java.util.Comparator;

/*
给定一组非负整数 nums，重新排列每个数的顺序（每个数不可拆分）使之组成一个最大的整数。
注意：输出结果可能非常大，所以你需要返回一个字符串而不是整数。

示例 1：
输入：nums = [10,2]
输出："210"

示例 2：
输入：nums = [3,30,34,5,9]
输出："9534330"

示例 3：
输入：nums = [1]
输出："1"

示例 4：
输入：nums = [10]
输出："10"

提示：
1 <= nums.length <= 100
0 <= nums[i] <= 109
 */
public class lc179 {
    /*
        时间复杂度：O(nlognlogm)，其中n是给定序列的长度，m是32位整数的最大值，每个数转化为字符串后的长度是O(logm) 的数量级。
        排序比较函数的时间复杂度为O(logm)，共需要进行O(nlogn) 次比较。同时需要对字符串序列进行拼接，时间复杂度为O(nlogm)，
        在渐进意义上小于O(nlognlogm)。
        空间复杂度：O(logn)，排序需要O(logn) 的栈空间。
     */
    public String largestNumber(int[] nums) {
        int size = nums.length;
        if (size == 0) {
            return "";
        }

        String[] strs = new String[size];
        for (int i = 0; i < size; ++i) {
            strs[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                return (b + a).compareTo(a + b);
            }
        });

        return strs[0].equals("0") ? "0" : String.join("", strs);
    }
}
