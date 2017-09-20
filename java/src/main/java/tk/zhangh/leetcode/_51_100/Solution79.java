package tk.zhangh.leetcode._51_100;

/**
 * Word Search
 * Created by ZhangHao on 2017/9/19.
 */
public class Solution79 {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        if (word.length() == 0)
            return true;

        // 遍历所有可能的入口
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
        // 不可多次使用
        board[i][j] = '#';

        boolean rst = find(board, i - 1, j, word, start + 1)  // 下
                || find(board, i, j - 1, word, start + 1)  // 左
                || find(board, i + 1, j, word, start + 1)  // 上
                || find(board, i, j + 1, word, start + 1);  // 右
        board[i][j] = word.charAt(start);
        return rst;
    }
}
