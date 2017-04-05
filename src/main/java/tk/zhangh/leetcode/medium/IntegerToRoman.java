package tk.zhangh.leetcode.medium;

/**
 * Given an integer, convert it to a roman numeral.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Created by ZhangHao on 2017/4/5.
 */
public class IntegerToRoman {
    public String intToRoman(int num) {
        int[] nums = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder result = new StringBuilder();
        for (int i = 0; num != 0; i++) {
            while (num >= nums[i]) {
                num -= nums[i];
                result.append(symbols[i]);
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        new IntegerToRoman().intToRoman(3999);
    }
}
