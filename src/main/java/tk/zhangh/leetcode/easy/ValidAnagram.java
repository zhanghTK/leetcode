package tk.zhangh.leetcode.easy;

/**
 * Created by ZhangHao on 2017/5/10.
 */
public class ValidAnagram {
    public boolean isAnagram(String s, String t) {
        int[] sTables = new int[26];
        int[] tTables = new int[26];
        if (s.length() != t.length()) {
            return false;
        }
        for (int i = 0; i < s.length(); i++) {
            sTables[s.charAt(i) - 'a']++;
            tTables[t.charAt(i) - 'a']--;
        }
        for (int i = 0; i < 26; i++) {
            if (sTables[i] + tTables[i] != 0) return false;
        }
        return true;
    }
}
