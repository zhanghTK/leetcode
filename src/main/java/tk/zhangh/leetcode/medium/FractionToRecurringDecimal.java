package tk.zhangh.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.
 * If the fractional part is repeating, enclose the repeating part in parentheses.
 * For example,
 * Given numerator = 1, denominator = 2, return "0.5".
 * Given numerator = 2, denominator = 1, return "2".
 * Given numerator = 2, denominator = 3, return "0.(6)".
 * Created by ZhangHao on 2017/5/2.
 */
public class FractionToRecurringDecimal {
    public static void main(String[] args) {
        new FractionToRecurringDecimal().fractionToDecimal(-1, -2147483648);
    }

    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0 || denominator == 0) {
            return "0";
        }
        boolean negative = (numerator > 0 && denominator < 0) || (numerator < 0 && denominator > 0);
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);
        String integ = (negative ? "-" : "") + String.valueOf(num / den);
        if (num % den != 0) {
            num %= den;
            Map<Long, Integer> map = new HashMap<>();
            int pos = 0;
            map.put(num, pos);
            StringBuilder frac = new StringBuilder();
            while (num != 0) {
                num *= 10;
                frac.append(num / den);
                num %= den;
                if (map.containsKey(num)) {
                    String pre = frac.substring(0, map.get(num));
                    String loop = frac.substring(map.get(num));
                    return integ + "." + pre + "(" + loop + ")";
                }
                pos++;
                map.put(num, pos);
            }
            return integ + "." + frac.toString();
        }
        return integ;
    }
}
