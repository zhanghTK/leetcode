package tk.zhangh.leetcode._51_100;

/**
 * Scramble String
 * Created by ZhangHao on 2017/9/21.
 */
public class Solution87 {
    public boolean isScramble(String s1, String s2) {
        // 三维 DP
        if (s1 == null || s2 == null || s1.length() != s2.length())
            return false;
        if (s1.length() == 0)
            return true;
        // res[i][j][len]表示的是以i和j分别为s1和s2起点的长度为len的字符串是不是互为scramble
        boolean[][][] res = new boolean[s1.length()][s2.length()][s1.length() + 1];
        for (int i = 0; i < s1.length(); i++) {
            for (int j = 0; j < s2.length(); j++) {
                res[i][j][1] = s1.charAt(i) == s2.charAt(j);
            }
        }
        for (int len = 2; len <= s1.length(); len++) {
            for (int i = 0; i < s1.length() - len + 1; i++) {
                for (int j = 0; j < s2.length() - len + 1; j++) {
                    for (int k = 1; k < len; k++) {
                        if ((res[i][j][k] && res[i + k][j + k][len - k]) ||
                                (res[i + k][j][len - k] && res[i][j + len - k][k])) {
                            res[i][j][len] = true;
                        }
                    }
                }
            }
        }
        return res[0][0][s1.length()];
    }
}
