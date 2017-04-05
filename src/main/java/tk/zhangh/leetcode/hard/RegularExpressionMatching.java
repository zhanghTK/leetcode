package tk.zhangh.leetcode.hard;

/**
 * Implement regular expression matching with support for '.' and '*'.
 * Created by ZhangHao on 2017/4/5.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return isMatch(s, p, 0, 0);
    }

    private boolean isMatch(String s, String p, int sIndex, int pIndex) {
        if (pIndex == p.length())
            return sIndex == s.length();

        if (pIndex == p.length() - 1 || p.charAt(pIndex + 1) != '*') {
            return !(sIndex == s.length() || s.charAt(sIndex) != p.charAt(pIndex) && p.charAt(pIndex) != '.') && isMatch(s, p, sIndex + 1, pIndex + 1);
        }
        while (sIndex < s.length() && (p.charAt(pIndex) == '.' || s.charAt(sIndex) == p.charAt(pIndex))) {
            if (isMatch(s, p, sIndex, pIndex + 2))
                return true;
            sIndex++;
        }
        return isMatch(s, p, sIndex, pIndex + 2);
    }
}
