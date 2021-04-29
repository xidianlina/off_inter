package leetcode;

/*
给定n个非负整数表示每个宽度为1的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。

示例 1：
输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
输出：6
解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。

示例 2：
输入：height = [4,2,0,3,2,5]
输出：9
 */
public class lc042 {
    /*
        方法一:先遍历一遍找到塔顶，然后分别从两边开始，往塔顶所在位置遍历，水位只会增高不会减小，
        且一直和最近遇到的最大高度持平，这样知道了实时水位，就可以边遍历边计算面积。
        时间复杂度:O(n)，其中n是数组height的长度。
        空间复杂度:O(1)。只需要使用常数的额外空间。
     */
    public int trap(int[] height) {
        int n = height.length;
        if (n <= 2) {
            return 0;
        }

        int top = -1;
        int topIndex = 0;
        for (int i = 0; i < n; ++i) {
            if (height[i] > top) {
                top = height[i];
                topIndex = i;
            }
        }

        int area = 0;
        int root = height[0];
        for (int i = 0; i < topIndex; ++i) {
            if (root < height[i]) {
                root = height[i];
            } else {
                area += (root - height[i]);
            }
        }

        root = height[n - 1];
        for (int i = n - 1; i > topIndex; --i) {
            if (root < height[i]) {
                root = height[i];
            } else {
                area += (root - height[i]);
            }
        }

        return area;
    }

    /*
        方法二:left和right两个指针分别指向数组的首尾位置，从两边向中间扫描，在当前两指针确定的范围内，
        先比较两头找出较小值，如果较小值是left指向的值，则从左向右扫描，如果较小值是right指向的值，则从右向左扫描，
        若遇到的值比当较小值小，则将差值存入结果，如遇到的值大，则重新确定新的窗口范围，以此类推直至left和right指针重合。
        时间复杂度:O(n)，其中n是数组height的长度。两个指针的移动总次数不超过n。
        空间复杂度:O(1)。只需要使用常数的额外空间。
     */
    public int trap2(int[] height) {
        int n = height.length;
        if (n < 2) {
            return 0;
        }
        int area = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int min = height[left] < height[right] ? height[left] : height[right];
            if (height[left] == min) {
                ++left;
                while (left < right && height[left] < min) {
                    area += min - height[left];
                    ++left;
                }
            } else {
                --right;
                while (left < right && height[right] < min) {
                    area += min - height[right];
                    --right;
                }
            }
        }
        return area;
    }
}
