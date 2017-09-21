package tk.zhangh.leetcode._51_100;

import java.util.Stack;

/**
 * Maximal Rectangle
 * Created by ZhangHao on 2017/9/21.
 */
public class Solution85 {
    // TODO http://blog.csdn.net/linhuanmars/article/details/24444491
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length < 1) {
            return 0;
        }

        int n = matrix.length;
        if (n == 0) {
            return 0;
        }

        int m = matrix[0].length;
        if (m == 0) {
            return 0;
        }

        // 以每行为底，将自底面往上的矩阵看成一个直方图
        int[][] height = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    // 首行
                    height[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                } else {
                    // 非首行
                    height[i][j] = (matrix[i][j] == '1') ? height[i - 1][j] + 1 : 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            // 保存高的下标信息
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < m; j++) {
                int curt = height[i][j];  // 当前直方图列高
                // 遍历
                while (!stack.empty() && curt < height[i][stack.peek()]) {
                    int h = height[i][stack.pop()];
                    int w = (stack.empty() ? j : j - stack.peek() - 1);
                    result = Math.max(result, h * w);
                }
                stack.push(j);
            }
            while (!stack.empty()) {
                int pos = stack.peek();
                stack.pop();
                result = Math.max(result, height[i][pos] * (stack.empty() ? m : m - stack.peek() - 1));
            }
        }
        return result;
    }
}
