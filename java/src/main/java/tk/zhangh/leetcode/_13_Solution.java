package tk.zhangh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Roman to Integer
 * Created by ZhangHao on 2017/9/5.
 */
public class _13_Solution {
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
        // 从前向后遍历罗马数字
        for (int i = s.length() - 2; i >= 0; i--) {
            if (dic.get(s.charAt(i + 1)) <= dic.get(s.charAt(i))) {
                // 如果某个数比前一个数小，则加上该数
                result += dic.get(s.charAt(i));
            } else {
                // 反之，减去前一个数的两倍然后加上该数
                result -= dic.get(s.charAt(i));
            }
        }
        return result;
    }
}
