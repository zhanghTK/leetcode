package tk.zhangh.leetcode.easy;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Created by ZhangHao on 2017/4/14.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0 || s.trim().equals("")) {
            return 0;
        }

        String[] strings = s.trim().split(" ");
        return strings[strings.length - 1].length();
    }
}
