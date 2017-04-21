package tk.zhangh.leetcode.hard;

/**
 * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.
 * Created by ZhangHao on 2017/4/19.
 */
public class InterleavingString {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // dp[i][j] 表示 s2 的前 i 个字符和 s1 的前 j 个字符是否匹配 s3 的前 i+j 个字符
        boolean[][] dp = new boolean[s2.length() + 1][s1.length() + 1];
        dp[0][0] = true;

        for (int j = 1; j <= s1.length(); j++) {
            dp[0][j] = dp[0][j - 1] && (s1.charAt(j - 1) == s3.charAt(j - 1));
        }

        for (int i = 1; i <= s2.length(); i++) {
            dp[i][0] = dp[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }

        for (int i = 1; i <= s2.length(); i++) {
            for (int j = 1; j <= s1.length(); j++) {
                dp[i][j] = dp[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1)) || dp[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }

        return dp[s2.length()][s1.length()];
    }
}
