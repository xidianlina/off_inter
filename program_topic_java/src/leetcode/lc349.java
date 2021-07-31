package leetcode;

import java.util.*;

/*
349. 两个数组的交集
给定两个数组，编写一个函数来计算它们的交集。

示例 1：
输入：nums1 = [1,2,2,1], nums2 = [2,2]
输出：[2]

示例 2：
输入：nums1 = [4,9,5], nums2 = [9,4,9,8,4]
输出：[9,4]

说明：
输出结果中的每个元素一定是唯一的。
我们可以不考虑输出结果的顺序
 */
public class lc349 {
    public static int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> nums = new HashSet<Integer>();
        Set<Integer> result = new HashSet<>();
        for (int i = 0; i < nums2.length; i++) {
            //放入时候去掉重复的
            nums.add(nums2[i]);
        }
        for (int i = 0; i < nums1.length; i++) {
            if (nums.contains(nums1[i])) {
                //放入交集
                result.add(nums1[i]);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            //集合变数组
            res[i++] = (int) iter.next();
        }
        return res;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        Map<Integer, Integer> m = new HashMap<Integer, Integer>();
        Set<Integer> result = new HashSet<>();
        for (int num : nums1) {
            m.put(num, 1);
        }
        for (int num : nums2) {
            if (m.containsKey(num)) {
                //放入交集
                result.add(num);
            }
        }
        int[] res = new int[result.size()];
        int i = 0;
        Iterator iter = result.iterator();
        while (iter.hasNext()) {
            //集合变数组
            res[i++] = (int) iter.next();
        }
        return res;
    }
}
