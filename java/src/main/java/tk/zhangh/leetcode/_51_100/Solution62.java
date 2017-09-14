package tk.zhangh.leetcode._51_100;

/**
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution62 {
    // 递归暴力解
    public int uniquePaths1(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        return helper(1, 1, m, n);
    }

    private int helper(int row, int col, int m, int n) {
        if (row == m && col == n) {
            return 1;
        }
        if (row > m || col > n) {
            return 0;
        }
        return helper(row + 1, col, m, n) +
                helper(row, col + 1, m, n);
    }

    // 二维数组DP，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
    public int uniquePaths2(int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    // 一维数组DP
    public int uniquePaths3(int m, int n) {
        if (m <= 0 || n <= 0) {
            return 0;
        }
        int[] res = new int[n];
        res[0] = 1;
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                res[j] = res[j] + res[j - 1];
            }
        }
        return res[n - 1];
    }
}
