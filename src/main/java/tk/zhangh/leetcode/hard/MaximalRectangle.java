package tk.zhangh.leetcode.hard;

import java.util.Stack;

/**
 * Given a 2D binary matrix filled with 0's and 1's
 * find the largest rectangle containing only 1's and return its area.
 * Created by ZhangHao on 2017/4/18.
 */
public class MaximalRectangle {
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

        int[][] height = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i == 0) {
                    height[i][j] = (matrix[i][j] == '1') ? 1 : 0;
                } else {
                    height[i][j] = (matrix[i][j] == '1') ? height[i - 1][j] + 1 : 0;
                }
            }
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            Stack<Integer> stack = new Stack<>();
            for (int j = 0; j < m; j++) {
                int curt = height[i][j];
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
