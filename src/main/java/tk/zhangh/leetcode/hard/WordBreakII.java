package tk.zhangh.leetcode.hard;

import java.util.*;

/**
 * https://segmentfault.com/a/1190000004236294
 * Created by ZhangHao on 2017/4/24.
 */
public class WordBreakII {
    public List<String> wordBreak(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        // 用来记录s.substring(i)这个字符串能否分解
        boolean[] possible = new boolean[s.length() + 1];
        Arrays.fill(possible, true);
        dfs(res, "", s, new HashSet<>(wordDict), 0, possible);
        return res;
    }

    private void dfs(List<String> res, String prefix, String s, Set<String> wordDict, int start, boolean[] possible) {
        if (start == s.length()) {
            res.add(prefix);
            return;
        }
        for (int i = start + 1; i <= s.length(); i++) {
            String str = s.substring(start, i);
            if (wordDict.contains(str) && possible[i]) {
                int prevSize = res.size();
                dfs(res, prefix + (prefix.equals("") ? "" : " ") + str, s, wordDict, i, possible);
                // DFS后面部分结果没有变化，说明后面是没有解的
                if (res.size() == prevSize) {
                    possible[i] = false;
                }
            }
        }
    }
}
