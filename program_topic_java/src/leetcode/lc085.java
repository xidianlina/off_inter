package leetcode;

/**
 * 给定一个仅包含0和1、大小为rows x cols的二维二进制矩阵，找出只包含1的最大矩形，并返回其面积。
 * 示例 1：
 * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * 输出：6
 * 解释：最大矩形如上图所示。
 *
 * 示例 2：
 * 输入：matrix = [["0"]]
 * 输出：0
 *
 * 示例 3：
 * 输入：matrix = [["1"]]
 * 输出：1
 *
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 */
import java.util.Deque;
import java.util.LinkedList;
public class lc085 {
    /**
     * 方法一: 使用柱状图的优化暴力方法
     * 首先计算出矩阵的每个元素的左边连续1的数量，使用二维数组left记录，其中left[i][j]为矩阵第i行第j列元素的左边连续1的数量。
     * 随后，对于矩阵中任意一个点枚举以该点为右下角的全1矩形。
     * 具体而言，当考察以matrix[i][j]为右下角的矩形时，枚举满足0≤k≤i的所有可能的k，此时矩阵的最大宽度就为
     * eft[i][j],left[i−1][j],…,left[k][j]的最小值。
     *
     * 时间复杂度：O(m*m*n)，其中m和n分别是矩阵的行数和列数。计算 left 矩阵需要 O(mn) 的时间。
     * 随后对于矩阵的每个点，需要 O(m) 的时间枚举高度。故总的时间复杂度为 O(mn)+O(mn)⋅O(m)=O(m*m*n)。
     * 空间复杂度：O(mn)，其中m和n分别是矩阵的行数和列数。分配了一个与给定矩阵等大的数组，用于存储每个元素的左边连续1的数量。
     */
    public int maximalRectangle(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }
        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '0') {
                    continue;
                }
                int width = left[i][j];
                int area = width;
                for (int k = i - 1; k >= 0; k--) {
                    width = Math.min(width, left[k][j]);
                    area = Math.max(area, (i - k + 1) * width);
                }
                res = Math.max(res, area);
            }
        }
        return res;
    }

    /**
     * 方法二：单调栈
     * 时间复杂度：O(mn)，其中 m 和 n 分别是矩阵的行数和列数。计算 left 矩阵需要 O(mn) 的时间；
     * 对每一列应用柱状图算法需要 O(m) 的时间，一共需要 O(mn) 的时间。
     * 空间复杂度：O(mn)，其中 m 和 n 分别是矩阵的行数和列数。我们分配了一个与给定矩阵等大的数组，用于存储每个元素的左边连续 1 的数量。
     */
    public int maximalRectangle2(char[][] matrix) {
        int m = matrix.length;
        if (m == 0) {
            return 0;
        }

        int n = matrix[0].length;
        int[][] left = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    left[i][j] = (j == 0 ? 0 : left[i][j - 1]) + 1;
                }
            }
        }

        int res = 0;
        for (int j = 0; j < n; j++) { // 对于每一列，使用基于柱状图的方法
            int[] up = new int[m];
            int[] down = new int[m];

            Deque<Integer> stack = new LinkedList<Integer>();
            for (int i = 0; i < m; i++) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                up[i] = stack.isEmpty() ? -1 : stack.peek();
                stack.push(i);
            }

            stack.clear();
            for (int i = m - 1; i >= 0; i--) {
                while (!stack.isEmpty() && left[stack.peek()][j] >= left[i][j]) {
                    stack.pop();
                }
                down[i] = stack.isEmpty() ? m : stack.peek();
                stack.push(i);
            }

            for (int i = 0; i < m; i++) {
                int height = down[i] - up[i] - 1;
                int area = height * left[i][j];
                res = Math.max(res, area);
            }
        }
        return res;
    }
}
