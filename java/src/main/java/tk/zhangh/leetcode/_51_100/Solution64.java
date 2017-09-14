package tk.zhangh.leetcode._51_100;

/**
 * Minimum Path Sum
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution64 {

    // DP二维数组
    public int minPathSum1(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (m == 0) return 0;

        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int i = 1; i < n; i++) {
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }
        return dp[m - 1][n - 1];
    }

    // DP一维数组
    public int minPathSum2(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int[] res = new int[grid[0].length];
        res[0] = grid[0][0];
        for (int i = 1; i < grid[0].length; i++) {
            res[i] = res[i - 1] + grid[0][i];
        }
        for (int i = 1; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j == 0)
                    res[j] += grid[i][j];
                else
                    res[j] = Math.min(res[j - 1], res[j]) + grid[i][j];
            }
        }
        return res[grid[0].length - 1];
    }
}
