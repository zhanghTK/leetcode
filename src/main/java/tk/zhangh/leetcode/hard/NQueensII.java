package tk.zhangh.leetcode.hard;

/**
 * Created by ZhangHao on 2017/4/11.
 */
public class NQueensII {
    private static int sum;

    public int totalNQueens(int n) {
        sum = 0;
        int[] used = new int[n];
        placeQueen(used, 0);
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

    public static void main(String[] args) {
        new NQueensII().totalNQueens(4);
    }
}
