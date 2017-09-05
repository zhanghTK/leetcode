package tk.zhangh.leetcode;

/**
 * String to Integer (atoi)
 * Created by ZhangHao on 2017/9/5.
 */
public class _08_Solution {
    public int myAtoi(String str) {
        // 判空
        if (str == null) {
            return 0;
        }
        str = str.trim();
        if (str.length() == 0) {
            return 0;
        }

        int sign = 1;
        int index = 0;
        // 符号
        if (str.charAt(index) == '+') {
            index++;
        } else if (str.charAt(index) == '-') {
            index++;
            sign = -1;
        }
        long num = 0;
        while (index < str.length()) {
            // 异常字符
            if (str.charAt(index) < '0' || str.charAt(index) > '9') {
                break;
            }
            num = num * 10 + (str.charAt(index) - '0');
            if (num > Integer.MAX_VALUE) {
                break;
            }
            index++;
        }
        // 溢出
        if (num * sign >= Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        if (num * sign <= Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        // 符号
        return (int) num * sign;
    }
}
