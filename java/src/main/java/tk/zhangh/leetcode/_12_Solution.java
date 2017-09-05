package tk.zhangh.leetcode;

/**
 * Integer to Roman
 * Created by ZhangHao on 2017/9/5.
 */
public class _12_Solution {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        // 从高位向低位凑
        for (int i = 0; num != 0; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }
}
