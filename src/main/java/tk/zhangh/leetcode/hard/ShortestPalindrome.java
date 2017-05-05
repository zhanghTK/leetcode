package tk.zhangh.leetcode.hard;

/**
 * Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it.
 * Find and return the shortest palindrome you can find by performing this transformation.
 * For example:
 * Given "aacecaaa", return "aaacecaaa".
 * Given "abcd", return "dcbabcd".
 * Created by ZhangHao on 2017/5/5.
 */
public class ShortestPalindrome {
    public static void main(String[] args) {
        System.out.println(new ShortestPalindrome().shortestPalindrome("aacecaaa"));
    }

    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0 || s.length() == 1) {
            return s;
        }
        int len = s.length(), tail = len;
        StringBuilder builder = new StringBuilder();
        while (tail > 1) {
            if (isPalindrome(s.substring(0, tail))) {
                builder = builder.append(s.substring(tail, len)).reverse();
                break;
            }
            tail--;
        }
        if (builder.length() == 0) {
            builder = builder.append(s.substring(tail, len)).reverse();
        }
        return builder.append(s).toString();
    }

    private boolean isPalindrome(String str) {
        int len = str.length();
        for (int i = 0; i < len / 2; i++) {
            if (str.charAt(i) != str.charAt(len - i - 1))
                return false;
        }
        return true;
    }
}
