package tk.zhangh.leetcode._1_50;

/**
 * Longest Common Prefix
 * Created by ZhangHao on 2017/9/5.
 */
public class _14_Solution {
    public String longestCommonPrefix(String[] strs) {
        // 判空
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 使用第一个作为初始匹配
        String prefix = strs[0];
        // 遍历每个字符串
        for (int i = 1; i < strs.length; i++) {
            int j = 0;
            // 寻找最长匹配项索引
            while (j < strs[i].length() && j < prefix.length() && strs[i].charAt(j) == prefix.charAt(j)) {
                j++;
            }
            if (j == 0) {
                return "";
            }
            // 缩小匹配范围
            prefix = prefix.substring(0, j);
        }
        return prefix;
    }
}
