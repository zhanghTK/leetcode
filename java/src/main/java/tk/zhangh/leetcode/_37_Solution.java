package tk.zhangh.leetcode;

/**
 * Sudoku Solver
 * Created by ZhangHao on 2017/9/12.
 */
public class _37_Solution {
    public void solveSudoku(char[][] board) {
        solve(board, 0, 0);
    }

    private boolean solve(char[][] board, int i, int j) {
        if (j >= 9) {
            // 下一行
            return solve(board, i + 1, 0);
        }
        if (i == 9) {
            // 最后一行，结束
            return true;
        }

        if (board[i][j] == '.') {
            // 依此尝试 1-9
            for (int k = 1; k <= 9; k++) {
                // 尝试 k
                board[i][j] = (char) (k + '0');
                if (isValid(board, i, j)) {
                    // 满足数独
                    if (solve(board, i, j + 1)) {
                        // 下一列
                        return true;
                    }
                }
                // 回滚
                board[i][j] = '.';
            }
        } else {
            return solve(board, i, j + 1);
        }
        return false;
    }

    private boolean isValid(char[][] board, int i, int j) {
        // 行内唯一
        for (int k = 0; k < 9; k++) {
            if (k != j && board[i][k] == board[i][j])
                return false;
        }
        // 列内唯一
        for (int k = 0; k < 9; k++) {
            if (k != i && board[k][j] == board[i][j])
                return false;
        }
        // 3 X 3 内唯一
        for (int row = i / 3 * 3; row < i / 3 * 3 + 3; row++) {
            for (int col = j / 3 * 3; col < j / 3 * 3 + 3; col++) {
                if ((row != i || col != j) && board[row][col] == board[i][j])
                    return false;
            }
        }
        return true;
    }
}
