package tk.zhangh.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * Created by ZhangHao on 2017/4/5.
 */
public class RomanToInteger {
    public int romanToInt(String s) {
        Map<Character, Integer> dic = new HashMap<>();
        dic.put('I', 1);
        dic.put('V', 5);
        dic.put('X', 10);
        dic.put('L', 50);
        dic.put('C', 100);
        dic.put('D', 500);
        dic.put('M', 1000);

        int result = dic.get(s.charAt(s.length() - 1));
        for (int i = s.length() - 2; i >= 0; i--) {
            if (dic.get(s.charAt(i + 1)) <= dic.get(s.charAt(i))) {
                result += dic.get(s.charAt(i));
            } else {
                result -= dic.get(s.charAt(i));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        new RomanToInteger().romanToInt("MMMCMXCIX");
    }
}
