package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/15.
 */
public class GameOfLife {
    public void gameOfLife(int[][] board) {
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int lives = 0;
                // 判断上边
                lives = up(board, i, j, lives);
                // 判断左边
                lives = left(board, i, j, lives);
                // 判断下边
                lives = down(board, m, i, j, lives);
                // 判断右边
                lives = right(board, n, i, j, lives);
                // 判断左上角
                lives = leftUp(board, i, j, lives);
                //判断右下角
                lives = rightDown(board, m, n, i, j, lives);
                // 判断右上角
                lives = rightUp(board, n, i, j, lives);
                // 判断左下角
                lives = leftDown(board, m, i, j, lives);
                // 根据周边存活数量更新当前点，结果是0和1的情况不用更新
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 3;
                } else if (board[i][j] == 1) {
                    if (lives < 2 || lives > 3) {
                        board[i][j] = 2;
                    }
                }
            }
        }
        // 解码
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = board[i][j] % 2;
            }
        }
    }

    private int leftDown(int[][] board, int m, int i, int j, int lives) {
        if (i < m - 1 && j > 0) {
            lives += board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 2 ? 1 : 0;
        }
        return lives;
    }

    private int rightUp(int[][] board, int n, int i, int j, int lives) {
        if (i > 0 && j < n - 1) {
            lives += board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2 ? 1 : 0;
        }
        return lives;
    }

    private int rightDown(int[][] board, int m, int n, int i, int j, int lives) {
        if (i < m - 1 && j < n - 1) {
            lives += board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2 ? 1 : 0;
        }
        return lives;
    }

    private int leftUp(int[][] board, int i, int j, int lives) {
        if (i > 0 && j > 0) {
            lives += board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2 ? 1 : 0;
        }
        return lives;
    }

    private int right(int[][] board, int n, int i, int j, int lives) {
        if (j < n - 1) {
            lives += board[i][j + 1] == 1 || board[i][j + 1] == 2 ? 1 : 0;
        }
        return lives;
    }

    private int down(int[][] board, int m, int i, int j, int lives) {
        if (i < m - 1) {
            lives += board[i + 1][j] == 1 || board[i + 1][j] == 2 ? 1 : 0;
        }
        return lives;
    }

    private int left(int[][] board, int i, int j, int lives) {
        if (j > 0) {
            lives += board[i][j - 1] == 1 || board[i][j - 1] == 2 ? 1 : 0;
        }
        return lives;
    }

    private int up(int[][] board, int i, int j, int lives) {
        if (i > 0) {
            lives += board[i - 1][j] == 1 || board[i - 1][j] == 2 ? 1 : 0;
        }
        return lives;
    }
}
