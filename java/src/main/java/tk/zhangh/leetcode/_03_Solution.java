package tk.zhangh.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Substring Without Repeating Characters
 * Created by ZhangHao on 2017/9/4.
 */
public class _03_Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        // 可以使用双指针指向边界，必须重复判断字符
        // map缓存已遍历过的字符
        // key为已遍历的字符，value为使用该字符的子串的左边界
        Map<Character, Integer> map = new HashMap<>();
        int left = 0;  // 子串的左边界
        int max = 0;  // 子串长度

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // 如果是已存在字符，更新左边界
            left = Math.max(left, (map.containsKey(c)) ? map.get(c) + 1 : 0);
            // 计算新的子串长度
            max = Math.max(max, i - left + 1);
            map.put(c, i);
        }
        return max;
    }
}
