package leetcode;

/**
 * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
 * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
 *
 * 示例 1:
 * 输入：heights = [2,1,5,6,2,3]
 * 输出：10
 * 解释：最大的矩形为图中红色区域，面积为10
 *
 * 示例 2：
 * 输入： heights = [2,4]
 * 输出： 4
 *
 * 提示：
 * 1 <= heights.length <=105
 * 0 <= heights[i] <= 104
 */
import java.util.ArrayDeque;
import java.util.Deque;
public class lc084 {
    /*
    方法一：暴力枚举高
    使用一重循环枚举某一根柱子，将其固定为矩形的高度h。随后从这跟柱子开始向两侧延伸，直到遇到高度小于h的柱子，
    就确定了矩形的左右边界。如果左右边界之间的宽度为w，那么对应的面积为w×h
    这种暴力方法的时间复杂度均为 O(N*N)，会超出时间限制
    */
    public int largestRectangleArea(int[] heights) {
        int size = heights.length;
        int ans = 0;
        for (int i = 0; i < size; i++) {
            int height = heights[i];
            int left = i;
            int right = i;
            while (left - 1 >= 0 && heights[left - 1] >= height) {
                --left;
            }
            while (right + 1 < size && heights[right + 1] >= height) {
                ++right;
            }
            ans = Math.max(ans, (right - left + 1) * height);
        }
        return ans;
    }

    /*
    方法二:单调栈
    时间复杂度：O(N)
    空间复杂度：O(N)
    */
    public int largestRectangleArea2(int[] heights) {
        int n = heights.length;
        int[] left = new int[n];
        int[] right = new int[n];

        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < n; ++i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            left[i] = (stack.isEmpty() ? -1 : stack.peek());
            stack.push(i);
        }

        stack.clear();
        for (int i = n - 1; i >= 0; --i) {
            while (!stack.isEmpty() && heights[stack.peek()] >= heights[i]) {
                stack.pop();
            }
            right[i] = (stack.isEmpty() ? n : stack.peek());
            stack.push(i);
        }

        int ans = 0;
        for (int i = 0; i < n; ++i) {
            ans = Math.max(ans, (right[i] - left[i] - 1) * heights[i]);
        }
        return ans;
    }
}
