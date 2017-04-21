package tk.zhangh.leetcode.hard;

/**
 * Given a string S and a string T, count the number of distinct subsequences of T in S.
 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).
 * Here is an example:
 * S = "rabbbit", T = "rabbit"
 * Return 3.
 * Created by ZhangHao on 2017/4/21.
 */
public class DistinctSubsequences {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        // dp[i][j]是从字符串s[0...j]中删除若干个字符得到字符串t[0...i]有几种方案
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // T是空串，S只有一种方案
        for (int i = 0; i <= s.length(); i++) {
            dp[i][0] = 1;
        }
        // S是空串，T不是空串，S没有子序列匹配，即dp[0][i] = 0，默认就是此情况

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                dp[i][j] = dp[i - 1][j];
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] += dp[i - 1][j - 1];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
