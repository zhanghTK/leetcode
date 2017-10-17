package tk.zhangh.leetcode.medium;

/**
 * Given an integer n, generate all structurally unique BST's (binary search trees) that store values 1...n.
 * Created by ZhangHao on 2017/4/19.
 */
public class UniqueBinarySearchTrees {
    public int numTrees(int n) {
        if (n <= 0)
            return 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }
        return dp[n];
    }
}
