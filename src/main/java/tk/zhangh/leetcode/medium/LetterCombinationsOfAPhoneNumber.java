package tk.zhangh.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a digit string, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Created by ZhangHao on 2017/4/6.
 */
public class LetterCombinationsOfAPhoneNumber {
    private List<String> result;
    private static final String[] DIC = {" ", " ", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        result = new ArrayList<>();
        letterCombinations0(0, new StringBuilder(), digits);
        return result;
    }

    private void letterCombinations0(int index, StringBuilder tmp, String digits) {
        if (index == digits.length()) {
            if (tmp.length() != 0) {
                result.add(tmp.toString());
            }
        } else {
            String str = DIC[digits.charAt(index) - '0'];
            for (int i = 0; i < str.length(); i++) {
                tmp.append(str.charAt(i));
                letterCombinations0(index + 1, tmp, digits);
                tmp.deleteCharAt(tmp.length() - 1);
            }
        }
    }

    public static void main(String[] args) {
        new LetterCombinationsOfAPhoneNumber().letterCombinations("23");
    }
}
