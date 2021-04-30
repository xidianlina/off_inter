package leetcode;

/*
给你一个正整数n，生成一个包含1到n^2所有元素，且元素按顺时针顺序螺旋排列的n x n正方形矩阵matrix 。

示例 1：
输入：n = 3
输出：[[1,2,3],[8,9,4],[7,6,5]]

示例 2：
输入：n = 1
输出：[[1]]

提示：
1 <= n <= 20
 */
public class lc059 {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        if (n == 0) {
            return result;
        }

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;
        int num = 1;
        while (top <= bottom && left <= right) {
            if (num <= n * n) {
                for (int j = left; j <= right; ++j) {
                    result[top][j] = num;
                    ++num;
                }
            }

            ++top;

            if (num <= n * n) {
                for (int i = top; i <= bottom; ++i) {
                    result[i][right] = num;
                    ++num;
                }
            }

            --right;

            if (num <= n * n) {
                for (int j = right; j >= left; --j) {
                    result[bottom][j] = num;
                    ++num;
                }
            }

            --bottom;

            if (num <= n * n) {
                for (int i = bottom; i >= top; --i) {
                    result[i][left] = num;
                    ++num;
                }
            }

            ++left;
        }

        return result;
    }
}
