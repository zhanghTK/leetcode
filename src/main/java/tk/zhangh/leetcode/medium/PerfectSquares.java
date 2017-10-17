package tk.zhangh.leetcode.medium;

import java.util.Arrays;

/**
 * Created by ZhangHao on 2017/5/11.
 */
public class PerfectSquares {
    // dp [i] 表示凑成i所需的平方和数字的最小个数，并且 x + y * y <= n
    // dp[x + y * y] = min(dp[x + y * y], dp[x] + 1)
    public int numSquares(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for (int i = 0; i * i <= n; i++) {
            dp[i * i] = 1;
        }
        // 从小到大找任意数a
        for (int a = 0; a <= n; a++) {
            // 从小到大找平方数bｘb
            for (int b = 0; a + b * b <= n; b++) {
                // 因为a+b*b可能本身就是平方数，所以我们要取两个中较小的
                dp[a + b * b] = Math.min(dp[a] + 1, dp[a + b * b]);
            }
        }
        return dp[n];
    }
}
