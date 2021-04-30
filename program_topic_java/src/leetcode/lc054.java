package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
给你一个m行n列的矩阵matrix ，请按照顺时针螺旋顺序 ，返回矩阵中的所有元素。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[1,2,3,6,9,8,7,4,5]

示例 2：
输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
输出：[1,2,3,4,8,12,11,10,9,5,6,7]

提示：
m == matrix.length
n == matrix[i].length
1 <= m, n <= 10
-100 <= matrix[i][j] <= 100
 */
public class lc054 {
    public List<Integer> spiralOrder(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        List<Integer> result = new ArrayList<>();
        if (matrix == null || row == 0 || col == 0) {
            return result;
        }

        int top = 0;
        int bottom = row - 1;
        int left = 0;
        int right = col - 1;
        //螺旋曲线，运动轨迹总是一致的
        while (top <= bottom && left <= right) {
            //向右列递增遍历
            for (int j = left; j <= right; ++j) {
                result.add(matrix[top][j]);
            }

            //遍历后，去掉此行
            ++top;

            //向下行递增遍历
            for (int i = top; i <= bottom; ++i) {
                result.add(matrix[i][right]);
            }

            //遍历后，去掉此行
            --right;

            if (top <= bottom) {//重要判断，防止重复
                //向左列递减遍历
                for (int j = right; j >= left; --j) {
                    result.add(matrix[bottom][j]);
                }
            }

            //遍历后，去掉此行
            --bottom;

            if (left <= right) {//重要判断，防止重复
                //向上行递减遍历
                for (int i = bottom; i >= top; --i) {
                    result.add(matrix[i][left]);
                }
            }

            //遍历后，去掉此列
            ++left;
        }

        return result;
    }
}
