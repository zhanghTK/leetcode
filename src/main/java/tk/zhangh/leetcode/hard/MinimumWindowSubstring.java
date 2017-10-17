package tk.zhangh.leetcode.hard;

/**
 * Created by ZhangHao on 2017/4/15.
 */
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] srcHash = new int[255];
        for (int i = 0; i < t.length(); i++) {
            srcHash[t.charAt(i)]++;
        }
        int start;
        int i;
        int[] destHash = new int[255];
        int found = 0;
        int begin = -1;
        int end = s.length();
        int minLength = s.length();
        for (start = i = 0; i < s.length(); i++) {
            destHash[s.charAt(i)]++;
            if (destHash[s.charAt(i)] <= srcHash[s.charAt(i)]) {
                found++;
            }
            if (found == t.length()) {
                while (start < i && destHash[s.charAt(start)] > srcHash[s.charAt(start)]) {
                    destHash[s.charAt(start)]--;
                    start++;
                }
                if (i - start < minLength) {
                    minLength = i - start;
                    begin = start;
                    end = i;
                }
                destHash[s.charAt(start)]--;
                found--;
                start++;
            }
        }
        return begin == -1 ? "" : s.substring(begin, end + 1);
    }
}
