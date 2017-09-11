package tk.zhangh.leetcode;

/**
 * Valid Sudoku
 * Created by ZhangHao on 2017/9/11.
 */
public class _36_Solution {
    public boolean isValidSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9)
            return false;
        // 验证格列满足
        for (int i = 0; i < 9; i++) {
            boolean[] map = new boolean[9];
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    if (map[board[i][j] - '1']) {
                        return false;
                    }
                    map[board[i][j] - '1'] = true;
                }
            }
        }
        // 验证各行满足
        for (int j = 0; j < 9; j++) {
            boolean[] map = new boolean[9];
            for (int i = 0; i < 9; i++) {
                if (board[i][j] != '.') {
                    if (map[board[i][j] - '1']) {
                        return false;
                    }
                    map[board[i][j] - '1'] = true;
                }
            }
        }
        // 验证各 3 x 3 方格满足
        for (int block = 0; block < 9; block++) {
            boolean[] map = new boolean[9];
            for (int i = block / 3 * 3; i < block / 3 * 3 + 3; i++) {
                for (int j = block % 3 * 3; j < block % 3 * 3 + 3; j++) {
                    if (board[i][j] != '.') {
                        if (map[board[i][j] - '1']) {
                            return false;
                        }
                        map[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        return true;
    }
}
