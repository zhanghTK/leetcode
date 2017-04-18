package tk.zhangh.leetcode.medium;

/**
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * Created by ZhangHao on 2017/4/18.
 */
public class DecodeWays {
    public int numDecodings(String s) {
        if (s.length() == 0) {
            return s.length();
        }
        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 2; i <= s.length(); i++) {
            // 如果字符串的第i-1位和第i位能组成一个10到26的数字，说明我们可以在第i-2位的解码方法上继续解码
            if (Integer.parseInt(s.substring(i - 2, i)) <= 26 && Integer.parseInt(s.substring(i - 2, i)) >= 10) {
                dp[i] += dp[i - 2];
            }
            // 如果字符串的第i-1位和第i位不能组成有效二位数字，在第i-1位的解码方法上继续解码
            if (Integer.parseInt(s.substring(i - 1, i)) != 0) {
                dp[i] += dp[i - 1];
            }
        }
        return dp[s.length()];
    }
}
