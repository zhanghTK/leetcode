package tk.zhangh.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a string, find the length of the longest substring without repeating characters.
 * Created by ZhangHao on 2017/3/31.
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        Map<Character, Integer> map = new HashMap<>();
        int leftBound = 0;
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            leftBound = Math.max(leftBound, (map.containsKey(c)) ? map.get(c) + 1 : 0);
            max = Math.max(max, i - leftBound + 1);
            map.put(c, i);
        }
        return max;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharacters solution = new LongestSubstringWithoutRepeatingCharacters();
        solution.lengthOfLongestSubstring("abcabcbb");
        solution.lengthOfLongestSubstring("bbbbb");
        solution.lengthOfLongestSubstring("pwwkew");
    }
}
