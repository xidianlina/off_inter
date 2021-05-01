package leetcode;

/*
给定一个 m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用原地算法。

进阶：
一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
你能想出一个仅使用常量空间的解决方案吗？
 */
public class lc073 {
    /*
        先扫描第一行第一列，如果有0，则将各自的flag设置为true
        然后扫描除去第一行第一列的整个数组，如果有0，则将对应的第一行和第一列的数字赋0
        再次遍历除去第一行第一列的整个数组，如果对应的第一行和第一列的数字有一个为0，则将当前值赋0
        最后根据第一行第一列的flag来更新第一行第一列
     */
    public void setZeroes(int[][] matrix) {
        int m=matrix.length;
        int n=matrix[0].length;
        boolean rowZero=false;
        boolean colZero=false;
        for(int j=0;j<n;++j){
            if(matrix[0][j]==0){
                rowZero=true;
            }
        }
        for(int i=0;i<m;++i){
            if(matrix[i][0]==0){
                colZero=true;
            }
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(matrix[i][j]==0){
                    matrix[i][0]=0;
                    matrix[0][j]=0;
                }
            }
        }
        for(int i=1;i<m;++i){
            for(int j=1;j<n;++j){
                if(matrix[i][0]==0||matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }
        if(rowZero){
            for(int j=0;j<n;++j){
                matrix[0][j]=0;
            }
        }
        if(colZero){
            for(int i=0;i<m;++i){
                matrix[i][0]=0;
            }
        }
    }
}
