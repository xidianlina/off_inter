package leetcode;

/*
79. 单词搜索
给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word存在于网格中，返回true ；否则，返回 false 。
单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
同一个单元格内的字母不允许被重复使用。

示例 1：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
输出：true

示例 2：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
输出：true

示例 3：
输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
输出：false

提示：
m == board.length
n = board[i].length
1 <= m, n <= 6
1 <= word.length <= 15
board 和 word 仅由大小写英文字母组成
 */
public class lc079 {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, 0, i, j, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, String word, int index, int rowindex, int colindex, boolean[][] visited) {
        if (index == word.length()) {
            return true;
        }

        if (rowindex < 0 || colindex < 0 || rowindex >= board.length || colindex >= board[0].length) {
            return false;
        }

        if (visited[rowindex][colindex]) {
            return false;
        }

        if (board[rowindex][colindex] != word.charAt(index)) {
            return false;
        }

        visited[rowindex][colindex] = true;

        boolean res =
                dfs(board, word, index + 1, rowindex - 1, colindex, visited)
                        || dfs(board, word, index + 1, rowindex + 1, colindex, visited)
                        || dfs(board, word, index + 1, rowindex, colindex + 1, visited)
                        || dfs(board, word, index + 1, rowindex, colindex - 1, visited);

        visited[rowindex][colindex] = false;

        return res;
    }
}
