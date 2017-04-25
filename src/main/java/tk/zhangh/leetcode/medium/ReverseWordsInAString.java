package tk.zhangh.leetcode.medium;

/**
 * Created by ZhangHao on 2017/4/25.
 */
public class ReverseWordsInAString {
    public String reverseWords(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        String[] strings = s.split(" ");
        StringBuilder result = new StringBuilder();

        for (int i = strings.length - 1; i >= 0; --i) {
            if (!strings[i].equals("")) {
                result.append(strings[i]).append(" ");
            }
        }

        return result.length() == 0 ? "" : result.substring(0, result.length() - 1);
    }
}
