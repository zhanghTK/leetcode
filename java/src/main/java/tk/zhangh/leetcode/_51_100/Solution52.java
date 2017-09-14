package tk.zhangh.leetcode._51_100;

/**
 * N-Queens II
 * Created by ZhangHao on 2017/9/13.
 */
public class Solution52 {
    private static int sum;

    public int totalNQueens(int n) {
        sum = 0;
        int[] usedColumns = new int[n];
        for (int i = 0; i < usedColumns.length; i++) {
            usedColumns[i] = -1;
        }
        placeQueen(new int[n], 0);
        return sum;
    }

    private void placeQueen(int[] usedColumns, int row) {
        if (row == usedColumns.length) {
            sum++;
            return;
        }

        for (int i = 0; i < usedColumns.length; i++) {
            if (isValid(usedColumns, row, i)) {
                usedColumns[row] = i;
                placeQueen(usedColumns, row + 1);
                usedColumns[row] = -1;
            }
        }
    }

    private boolean isValid(int[] usedColumns, int row, int col) {
        for (int i = 0; i < row; i++) {
            if (usedColumns[i] == col) {
                return false;
            }
            if ((row - i) == Math.abs(col - usedColumns[i])) {
                return false;
            }
        }
        return true;
    }
}
