package tk.zhangh.leetcode._51_100;

/**
 * Set Matrix Zeroes
 * Created by ZhangHao on 2017/9/18.
 */
public class Solution73 {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean isFistRowEmpty = false;
        boolean isFirstColEmpty = false;

        // 处理首行，首列
        for (int i = 0; i < cols; i++) {
            if (matrix[0][i] == 0) {
                isFistRowEmpty = true;
                break;
            }
        }
        for (int i = 0; i < rows; i++) {
            if (matrix[i][0] == 0) {
                isFirstColEmpty = true;
                break;
            }
        }

        // 遍历矩阵非首行，首列的其余部分
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // 如果元素为0，记录在行首，列首
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        // 历矩阵非首行，首列的其余部分
        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < cols; j++) {
                // 根据行首，列首再次重置
                if (matrix[0][j] == 0 || matrix[i][0] == 0)
                    matrix[i][j] = 0;
            }
        }

        // 处理行首，列首
        if (isFistRowEmpty) {
            for (int i = 0; i < cols; i++) {
                matrix[0][i] = 0;
            }
        }
        if (isFirstColEmpty) {
            for (int i = 0; i < rows; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
