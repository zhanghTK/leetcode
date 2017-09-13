package tk.zhangh.leetcode._1_50;

/**
 * Multiply Strings
 * Created by ZhangHao on 2017/9/12.
 */
public class _43_Solution {
    public String multiply(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return null;
        }
        int[] res = new int[num1.length() + num2.length()];
        int i, j;
        // 乘法运算
        for (i = num1.length() - 1; i >= 0; i--) {
            int carry = 0;
            for (j = num2.length() - 1; j >= 0; j--) {
                int num = carry + res[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                res[i + j + 1] = num % 10;
                carry = num / 10;
            }
            res[i + j + 1] = carry;
        }
        StringBuilder result = new StringBuilder();
        // 找到非0的下标
        for (i = 0; i < res.length - 1 && res[i] == 0; i++) ;
        for (; i < num1.length() + num2.length(); i++) {
            result.append(res[i]);
        }
        return result.toString();
    }
}
