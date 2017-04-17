package tk.zhangh.leetcode.medium;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * Created by ZhangHao on 2017/4/17.
 */
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        if (word.length() == 0)
            return true;

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean rst = find(board, i, j, word, 0);
                    if (rst)
                        return true;
                }
            }
        }
        return false;
    }

    private boolean find(char[][] board, int i, int j, String word, int start) {
        if (start == word.length())
            return true;

        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)) {
            return false;
        }

        board[i][j] = '#';
        boolean rst = find(board, i - 1, j, word, start + 1)
                || find(board, i, j - 1, word, start + 1)
                || find(board, i + 1, j, word, start + 1)
                || find(board, i, j + 1, word, start + 1);
        board[i][j] = word.charAt(start);
        return rst;
    }
}
