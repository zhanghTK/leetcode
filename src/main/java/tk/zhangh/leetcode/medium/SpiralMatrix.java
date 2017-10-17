package tk.zhangh.leetcode.medium;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by ZhangHao on 2017/4/11.
 */
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new LinkedList<>();
        if (matrix.length == 0) {
            return result;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < (Math.min(m, n) + 1) / 2; i++) {
            int lastRow = m - i - 1;
            int lastCol = n - i - 1;
            if (i == lastRow) {
                for (int j = i; j <= lastCol; j++) {
                    result.add(matrix[i][j]);
                }
            } else if (i == lastCol) {
                for (int j = i; j <= lastRow; j++) {
                    result.add(matrix[j][i]);
                }
            } else {
                for (int j = i; j < lastCol; j++) {
                    result.add(matrix[i][j]);
                }
                for (int j = i; j < lastRow; j++) {
                    result.add(matrix[j][lastCol]);
                }
                for (int j = lastCol; j > i; j--) {
                    result.add(matrix[lastRow][j]);
                }
                for (int j = lastRow; j > i; j--) {
                    result.add(matrix[j][i]);
                }
            }
        }
        return result;
    }
}
