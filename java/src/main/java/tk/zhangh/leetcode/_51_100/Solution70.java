package tk.zhangh.leetcode._51_100;

/**
 * Climbing Stairs
 * Created by ZhangHao on 2017/9/18.
 */
public class Solution70 {
    public int climbStairs(int n) {
        if (n <= 1) {
            return 1;
        }

        // 初始情况
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;

        // DP
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + // 走一步
                    dp[i - 2];  // 走两步
        }
        return dp[n - 1];
    }
}
