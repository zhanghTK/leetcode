package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/2.
 */
public class ExcelSheetColumnNumber {
    public static void main(String[] args) {
        System.out.println(new ExcelSheetColumnNumber().titleToNumber("AA"));
    }

    public int titleToNumber(String s) {
        int num = 0;
        for (char c : s.toCharArray()) {
            num *= 26;
            num += (c - 'A' + 1);
        }
        return num;
    }
}
