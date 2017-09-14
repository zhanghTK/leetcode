package tk.zhangh.leetcode._51_100;

/**
 * Length of Last Word
 * Created by ZhangHao on 2017/9/14.
 */
public class Solution58 {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.trim().equals("")) {
            return 0;
        }

        String[] strings = s.trim().split(" ");
        return strings[strings.length - 1].length();
    }
}
