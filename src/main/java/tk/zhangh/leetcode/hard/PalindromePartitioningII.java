package tk.zhangh.leetcode.hard;

/**
 * 两个动态规划:
 * dp[i]:区间[0,i]之间最小的cut数,dp[i] = min(1+dp[j+1]),0<=j<i
 * P[i][j]:字符串str[i,j]是否回文,P[i][j] = str[i] == str[j] && P[i+1][j-1];
 * Created by ZhangHao on 17/4/23.
 */
public class PalindromePartitioningII {

    public int minCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        boolean[][] isPalindrome = getIsPalindrome(s);
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 1; i <= s.length(); i++) {
            dp[i] = Integer.MAX_VALUE; // or f[i] = i
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1]) {
                    dp[i] = Math.min(dp[i], dp[j] + 1);
                }
            }
        }
        return dp[s.length()] - 1;
    }

    private boolean[][] getIsPalindrome(String s) {
        boolean[][] isPalindrome = new boolean[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            isPalindrome[i][i] = true;
        }
        for (int i = 0; i < s.length() - 1; i++) {
            isPalindrome[i][i + 1] = (s.charAt(i) == s.charAt(i + 1));
        }
        for (int length = 2; length < s.length(); length++) {
            for (int start = 0; start + length < s.length(); start++) {
                isPalindrome[start][start + length]
                        = isPalindrome[start + 1][start + length - 1] && s.charAt(start) == s.charAt(start + length);
            }
        }
        return isPalindrome;
    }
}
