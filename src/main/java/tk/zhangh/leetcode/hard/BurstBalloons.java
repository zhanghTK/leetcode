package tk.zhangh.leetcode.hard;

/**
 * Created by ZhangHao on 2017/5/19.
 */
public class BurstBalloons {
    public static void main(String[] args) {
        new BurstBalloons().maxCoins(new int[]{3, 1, 5, 8});
    }

    public int maxCoins(int[] nums) {
        int n = nums.length + 2;
        int[] newNums = new int[n];
        System.arraycopy(nums, 0, newNums, 1, n - 2);
        newNums[0] = newNums[n - 1] = 1;

        // dp[k][h]：nums[k...h]能戳破气球的最大值
        int[][] dp = new int[n][n];
        for (int len = 2; len < n; ++len)
            for (int left = 0; left < n - len; ++left) {
                int right = left + len;
                for (int target = left + 1; target < right; ++target)
                    dp[left][right] = Math.max(dp[left][right],
                            lastScore(newNums, left, target, right) + dp[left][target] + dp[target][right]);
            }

        return dp[0][n - 1];
    }

    private int lastScore(int[] nums, int left, int target, int right) {
        return nums[left] * nums[target] * nums[right];
    }
}
