package tk.zhangh.leetcode._1_50;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Substring with Concatenation of All Words
 * Created by ZhangHao on 2017/9/7.
 */
public class _30_Solution {
    // TODO
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0)
            return result;
        int strLen = s.length();
        int wordLen = words[0].length();
        Map<String, Integer> toFind = getToFindMap(words);
        for (int i = 0; i < wordLen; i++) {
            Map<String, Integer> curFound = new HashMap<>();
            int count = 0, start = i;
            for (int j = i; j <= strLen - wordLen; j += wordLen) {
                String curStr = s.substring(j, j + wordLen);
                if (!toFind.containsKey(curStr)) {
                    curFound.clear();
                    count = 0;
                    start = j + wordLen;
                    continue;
                }

                if (curFound.containsKey(curStr)) {
                    curFound.put(curStr, curFound.get(curStr) + 1);
                } else {
                    curFound.put(curStr, 1);
                }
                if (curFound.get(curStr) <= toFind.get(curStr)) {
                    count++;
                } else {
                    while (true) {
                        String tmp = s.substring(start, start + wordLen);
                        curFound.put(tmp, curFound.get(tmp) - 1);
                        start += wordLen;
                        if (curStr.equals(tmp)) {
                            break;
                        } else {
                            count--;
                        }
                    }
                }
                if (count == words.length) {
                    result.add(start);
                    String tmp = s.substring(start, start + wordLen);
                    curFound.put(tmp, curFound.get(tmp) - 1);
                    start += wordLen;
                    count--;
                }

            }
        }
        return result;
    }

    private Map<String, Integer> getToFindMap(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            if (map.containsKey(word)) {
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        return map;
    }
}
