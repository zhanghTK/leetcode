package tk.zhangh.leetcode.medium;

import java.util.*;

/**
 * Created by ZhangHao on 2017/4/11.
 */
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            char[] carr = str.toCharArray();
            Arrays.sort(carr);
            String key = new String(carr);
            List<String> list = map.get(key);
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(str);
            map.put(key, list);
        }
        List<List<String>> result = new ArrayList<>();
        for (String key : map.keySet()) {
            List<String> curr = map.get(key);
            Collections.sort(curr);
            result.add(curr);
        }
        return result;
    }
}
