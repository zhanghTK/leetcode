package tk.zhangh.leetcode._1_50;

import java.util.ArrayList;
import java.util.List;

/**
 * Letter Combinations of a Phone Number
 * Created by ZhangHao on 2017/9/6.
 */
public class _17_Solution {

    private static final String[] DIC = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private List<String> result;

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        letterCombinations0(0, new StringBuilder(), digits);
        return result;
    }

    private void letterCombinations0(int index, StringBuilder tmp, String digits) {
        // 遍历结束
        if (index == digits.length()) {
            // 有解
            if (tmp.length() != 0) {
                result.add(tmp.toString());
            }
        } else {
            // 该数字可能的字符
            String str = DIC[digits.charAt(index) - '0'];
            // 深搜、回溯
            for (int i = 0; i < str.length(); i++) {
                tmp.append(str.charAt(i));
                letterCombinations0(index + 1, tmp, digits);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }
}
