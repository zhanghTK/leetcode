package tk.zhangh.leetcode._1_50;

import java.util.*;

/**
 * Group Anagrams
 * Created by ZhangHao on 2017/9/13.
 */
public class _49_Solution {
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
