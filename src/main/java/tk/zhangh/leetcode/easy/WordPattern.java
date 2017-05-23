package tk.zhangh.leetcode.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Created by ZhangHao on 2017/5/15.
 */
public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] pieces = str.split(" ");
        if (pieces.length != pattern.length()) {
            return false;
        }
        Map<Character, String> map = new HashMap<>();
        Set<String> set = new HashSet<>();

        int i = 0;
        for (String s : pieces) {
            char p = pattern.charAt(i);
            if (map.containsKey(p)) {
                if (!s.equals(map.get(p))) {
                    return false;
                }
            } else {
                if (set.contains(s)) {
                    return false;
                }
                map.put(p, s);
                set.add(s);
            }
            i++;
        }
        return true;
    }
}
