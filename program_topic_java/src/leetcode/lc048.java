package leetcode;

/*
给定一个n×n的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转90度。
你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。

示例 1：
输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
输出：[[7,4,1],[8,5,2],[9,6,3]]

示例 2：
输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]

示例 3：
输入：matrix = [[1]]
输出：[[1]]

示例 4：
输入：matrix = [[1,2],[3,4]]
输出：[[3,1],[4,2]]
 */
public class lc048 {
    /*
        时间复杂度：O(N^2)，其中N是matrix的边长。对于每一次翻转操作都需要枚举矩阵中一半的元素。
        空间复杂度：O(1)。为原地翻转得到的原地旋转。
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;

        //沿左上至右下对角线翻转
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < i; ++j) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //水平翻转每一行
        for (int i = 0; i < n; ++i) {
            for (int j = 0; j < n / 2; ++j) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = tmp;
            }
        }
    }
}
