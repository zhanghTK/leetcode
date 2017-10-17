package tk.zhangh.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZhangHao on 2017/5/3.
 */
public class IsomorphicStrings {
    public boolean isIsomorphic(String s, String t) {
        // s字符到t字符的映射关系
        Map<Character, Character> map = new HashMap<>();
        // 已被映射的字符
        Set<Character> set = new HashSet<>();
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            if (map.containsKey(sc)) {
                // 如果已经给s中的字符建立了映射，检查该映射是否和当前t中字符相同
                if (tc != map.get(sc)) {
                    return false;
                }
            } else {
                // 如果已经给t中的字符建立了映射，就返回假，因为出现了多对一映射
                if (set.contains(tc)) {
                    return false;
                }
                map.put(sc, tc);
                set.add(tc);
            }
        }
        return true;
    }
}
