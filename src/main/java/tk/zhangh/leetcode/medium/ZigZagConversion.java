package tk.zhangh.leetcode.medium;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * Created by ZhangHao on 2017/4/5.
 */
public class ZigZagConversion {
    public String convert(String s, int nRows) {
        if (s.length() <= nRows || nRows == 1) {
            return s;
        }
        char[] chars = new char[s.length()];
        int step = 2 * (nRows - 1);
        int count = 0;
        for (int i = 0; i < nRows; i++) {
            int interval = step - 2 * i;
            for (int j = i; j < s.length(); j += step) {
                chars[count] = s.charAt(j);
                count++;
                if (interval < step && interval > 0 && j + interval < s.length() && count < s.length()) {
                    chars[count] = s.charAt(j + interval);
                    count++;
                }
            }
        }
        return new String(chars);
    }

    public static void main(String[] args) {
        new ZigZagConversion().convert("ABC", 2);
    }
}
