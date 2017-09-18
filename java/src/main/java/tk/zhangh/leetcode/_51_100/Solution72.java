package tk.zhangh.leetcode._51_100;

/**
 * Edit Distance
 * Created by ZhangHao on 2017/9/18.
 */
public class Solution72 {
    // http://bangbingsyb.blogspot.com/2014/11/leetcode-edit-distance.html
    // http://fisherlei.blogspot.com/2012/12/leetcode-edit-distance.html
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i < m + 1; i++) {
            dp[0][i] = i;
        }
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = i;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    // 字符串1的i索引与字符串2的j索引字符一致，不需要修改
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 字符串1的i索引与字符串2的j索引不一致，需要修改
                    // 替换字符需要的操作：dp[i-1][j-1] + 1
                    // 添加字符需要的操作：dp[i][j-1] + 1
                    // 删除字符需要的操作：dp[i-1][j] + 1
                    dp[i][j] = 1 + Math.min(dp[i - 1][j - 1], Math.min(dp[i - 1][j], dp[i][j - 1]));
                }
            }
        }
        return dp[n][m];
    }
}
