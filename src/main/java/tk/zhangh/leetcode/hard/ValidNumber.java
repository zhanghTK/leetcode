package tk.zhangh.leetcode.hard;

/**
 * Created by ZhangHao on 2017/4/14.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        int index = 0;
        int endIndex = s.length() - 1;
        while (index <= endIndex && Character.isWhitespace(s.charAt(index))) index++;
        if (index > s.length() - 1) {
            return false;
        }
        while (endIndex >= index && Character.isWhitespace(s.charAt(endIndex))) endIndex--;
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            index++;
        }
        boolean num = false; // is a digit
        boolean dot = false; // is a '.'
        boolean exp = false; // is a 'e'
        while (index <= endIndex) {
            char c = s.charAt(index);
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || dot) {
                    return false;
                }
                dot = true;
            } else if (c == 'e') {
                if (exp || !num) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(index - 1) != 'e') {
                    return false;
                }
            } else {
                return false;
            }
            index++;
        }
        return num;
    }
}
