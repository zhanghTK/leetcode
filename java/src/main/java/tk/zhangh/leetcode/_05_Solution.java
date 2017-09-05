package tk.zhangh.leetcode;

/**
 * Longest Palindromic Substring
 * Created by ZhangHao on 2017/9/5.
 */
public class _05_Solution {
    public String longestPalindrome(String s) {
        String result = "";
        // 插入 # 字符，abcd -> #a#b#c#d#
        s = insertSharp(s);
        // 遍历插入后的字符串，以遍历到的字符为回文中心找最长回文
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; (i - j) >= 0 && (i + j) < s.length(); j++) {
                if ((s.charAt(i + j) == s.charAt(i - j))) {
                    if (j * 2 + 1 > result.length()) {
                        result = s.substring(i - j, i + j + 1);
                    }
                } else {
                    break;
                }
            }
        }
        return result.replace("#", "");
    }

    private String insertSharp(String s) {
        StringBuilder str = new StringBuilder("#");
        for (int i = 0; i < s.length(); i++) {
            str.append(s.charAt(i)).append("#");
        }
        return str.toString();
    }
}
