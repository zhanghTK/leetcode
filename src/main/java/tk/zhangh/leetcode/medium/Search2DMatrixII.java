package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class Search2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int i = 0, j = matrix[0].length - 1;
        while (i < matrix.length && j >= 0) {
            int x = matrix[i][j];
            if (target == x) {
                return true;
            } else if (target < x) {
                --j;
            } else {
                ++i;
            }
        }
        return false;
    }
}
