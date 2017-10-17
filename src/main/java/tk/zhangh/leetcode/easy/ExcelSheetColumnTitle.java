package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/2.
 */
public class ExcelSheetColumnTitle {
    public String convertToTitle(int n) {
        return n == 0 ? "" : convertToTitle((n - 1) / 26) + (char) ((n - 1) % 26 + 'A');
    }
}
