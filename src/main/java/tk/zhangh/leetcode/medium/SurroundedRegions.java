package tk.zhangh.leetcode.medium;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 将所有以O组成、但不连通到网格边缘的区域变为X。
 * 先在四边上寻找连通到边缘的区域，将它们的O都变成#。
 * 剩余的所有O一定无法连通到边缘，所以可以全部变为X。
 * 最后再将所有Y变回O。
 * Created by ZhangHao on 17/4/23.
 */
public class SurroundedRegions {
    public static void main(String[] args) {
        new SurroundedRegions().solve(new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}});
    }

    public void solve(char[][] board) {
        if (board == null || board.length <= 1 || board[0].length <= 1)
            return;

        for (int i = 0; i < board[0].length; i++) {
            fill(board, 0, i);
            fill(board, board.length - 1, i);
        }
        for (int i = 0; i < board.length; i++) {
            fill(board, i, 0);
            fill(board, i, board[0].length - 1);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'O')
                    board[i][j] = 'X';
                else if (board[i][j] == '#')
                    board[i][j] = 'O';
            }
        }
    }

    private void fill(char[][] board, int i, int j) {
        if (board[i][j] != 'O') {
            return;
        }
        board[i][j] = '#';
        Queue<Integer> queue = new LinkedList<>();
        int code = i * board[0].length + j;
        queue.offer(code);
        while (!queue.isEmpty()) {
            code = queue.poll();
            int row = code / board[0].length;
            int col = code % board[0].length;
            // 不是首行,上面的元素是O
            if (row > 0 && board[row - 1][col] == 'O') {
                queue.offer((row - 1) * board[0].length + col);
                board[row - 1][col] = '#';
            }
            // 不是末行,下面的元素是0
            if (row < board.length - 1 && board[row + 1][col] == 'O') {
                queue.offer((row + 1) * board[0].length + col);
                board[row + 1][col] = '#';
            }
            // 不是首列,且前面的元素是O
            if (col > 0 && board[row][col - 1] == 'O') {
                queue.offer(row * board[0].length + col - 1);
                board[row][col - 1] = '#';
            }
            // 是不末列,且后面的元素是O
            if (col < board[0].length - 1 && board[row][col + 1] == 'O') {
                queue.offer(row * board[0].length + col + 1);
                board[row][col + 1] = '#';
            }
        }
    }
}
