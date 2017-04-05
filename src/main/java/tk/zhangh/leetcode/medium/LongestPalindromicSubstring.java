package tk.zhangh.leetcode.medium;

/**
 * Given a string s, find the longest palindromic substring in s.
 * You may assume that the maximum length of s is 1000.
 * Created by ZhangHao on 2017/4/5.
 */
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        String result = "";
        s = insertSharp(s);
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

    public static void main(String[] args) {
        String babad = new LongestPalindromicSubstring().longestPalindrome("babad");
        System.out.println(babad);
    }
}
